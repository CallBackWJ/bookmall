package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderVo;

public class OrderDao extends AbstractDao {

	public boolean insert(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into user_order values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderVo.getMoney());
			pstmt.setString(2, orderVo.getAddress());
			pstmt.setLong(3, orderVo.getMember().getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public OrderVo getOrder(long order_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVo vo = new OrderVo();
		try {
			conn = getConnection();

			String sql = "select * from user_order where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, order_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setNo(rs.getLong(1));
				vo.setMoney(rs.getLong(2));
				vo.setAddress(rs.getString(3));
				vo.setMember(new MemberDao().getMember(rs.getLong(4)));

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	public List<OrderVo> getList(long no) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from user_order where member_no=? order by no asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setNo(rs.getLong(1));
				vo.setMoney(rs.getLong(2));
				vo.setAddress(rs.getString(3));
				vo.setMember(new MemberDao().getMember(rs.getLong(4)));

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
