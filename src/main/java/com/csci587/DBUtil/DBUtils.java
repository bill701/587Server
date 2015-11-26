package com.csci587.DBUtil;

import java.sql.*;
/**
 * ��ȡ���ر����ݿ���Դ�Ĺ�����
 * @author JMM
 * 
 */
public class DBUtils {
	/**
	 * ���ܣ���ȡ���ݿ�����
	 * @return ���ػ�ȡ�������ݿ�����
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@JMM:1521:orcl";
		String username = "scott";
		String password = "tiger";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * ���ܣ��ͷ��������ݿ���Դ
	 * @param conn ���Ӷ���
	 * @param st ������
	 * @param rs ���������
	 */
	public static void closeAll(Connection conn, Statement st, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

