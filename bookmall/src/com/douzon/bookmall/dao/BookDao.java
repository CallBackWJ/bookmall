package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CategoryVo;

public class BookDao extends AbstractDao {
	public boolean insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into book values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getName());
			pstmt.setLong(2, bookVo.getPrice());
			pstmt.setLong(3, bookVo.getCategory().getNo());

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

	public BookVo getBook(long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVo vo = new BookVo();
		try {
			conn = getConnection();

			String sql = "select * from book where no= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getLong(3));
				vo.setCategory(new CategoryDao().getCategory((rs.getLong(4))));

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

	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from book order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				long price = rs.getLong(3);
				CategoryVo category = new CategoryDao().getCategory(rs.getLong(4));

				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setCategory(category);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
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
