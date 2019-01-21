package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.MemberVo;

public class CartDao {
	public boolean insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql ="insert into cart values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, cartVo.getCount());
			pstmt.setLong(2, cartVo.getMember().getNo());
			pstmt.setLong(3, cartVo.getBook().getNo());
			
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
	
	
	
	
	
	public List<CartVo> getList(){
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from cart order by no asc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long no=rs.getLong(1);
				long count = rs.getLong(2);
				MemberVo member=new MemberDao().getMember(rs.getLong(3));
				BookVo book=new BookDao().getBook(rs.getLong(4));
				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setCount(count);
				vo.setMember(member);
				vo.setBook(book);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
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
	public List<CartVo> getList(long no){
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from cart where member_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				CartVo vo = new CartVo();
				vo.setNo(rs.getLong(1));
				vo.setCount(rs.getLong(2));
				vo.setMember(new MemberDao().getMember(rs.getLong(3)));
				vo.setBook(new BookDao().getBook(rs.getLong(4)));
				
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
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/bookmall?autoReconnect=true&useSSL=false";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
}
