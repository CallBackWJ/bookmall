package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderBookVo;

public class OrderBookDao extends AbstractDao{
	public boolean insert(OrderBookVo orderBookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql ="insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, orderBookVo.getOrder().getNo());
			pstmt.setLong(2, orderBookVo.getBook().getNo());
			pstmt.setLong(3, orderBookVo.getCount());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<OrderBookVo> getList(long no){
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from order_book where order_no=? order by order_no asc";
			pstmt=conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderBookVo vo = new OrderBookVo();
				vo.setOrder(new OrderDao().getOrder(rs.getLong(1)));
				vo.setBook(new BookDao().getBook(rs.getLong(2)));
				vo.setCount(rs.getLong(3));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
}
