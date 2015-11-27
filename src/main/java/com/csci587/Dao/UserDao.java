package com.csci587.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.csci587.DBUtil.DBUtils;
import com.csci587.entity.User;


public class UserDao {

	/**
	 * this function is to check whethera username has been used 
	 * @param name
	 * @return true or false
	 */
	public boolean checkExist(String name){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql="SELECT * FROM user where username= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;

			}else{
				return false;
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return true;
	
	}
	/**
	 * add new user into the user table 
	 * @param name
	 * @param password
	 * @param email
	 * @return
	 */
	
	public boolean addUser(String name,String password,String email){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql="insert into User values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3,email);
			ps.executeQuery();
			
		}  catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return true;
	}
	public User login(String name,String password){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				User user = new User();
				//this iss still need to be valid here 
				user.setEmail(rs.getString(0));
				user.setId(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setUsername(rs.getString(3));
				
				return user;
			}else{
				return null;
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return null;
	}
	
	/**
	 * add new friend into friend table 
	 */
	public boolean addFriend(String userId,String user2Id){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql="insert into Friend values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, user2Id);
			ps.executeQuery();
			
			sql="insert into Friend values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user2Id);
			ps.setString(2, userId);
			ps.executeQuery();
			
		}  catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return true;
	}
}
