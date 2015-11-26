package com.csci587.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.csci587.DBUtil.DBUtils;
import com.csci587.entity.User;


public class UserDao {

	
	public User addUser(String mail,String pass){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		boolean flag=false;
		try {
			conn = DBUtils.getConnection();
			String sql="SELECT * FROM sys_employee_t where emp_id=" +
					"(select emp_id from sys_account_t where account_email=? and account_pass=?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			if(rs.next()){
				
			}else{
				System.out.println("no user exist ");
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return null;
	}
}
