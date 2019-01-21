package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.MemberVo;

public class MemberDao extends AbstractDao{
	public boolean insert(MemberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql ="insert into member values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPhone());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPassword());
			
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
	
	
	public MemberVo getMember(long no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = new MemberVo();
		try {
			conn = getConnection();
			

			String sql = "select * from member where no= ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setPassword(rs.getString(5));
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
		return vo;
	}
	
	
	
	public List<MemberVo> getList(){
		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from member order by no asc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				MemberVo vo = new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setPassword(rs.getString(5));
				
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
	
	
}
