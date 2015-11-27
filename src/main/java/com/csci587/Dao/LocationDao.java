package com.csci587.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csci587.DBUtil.DBUtils;
import com.csci587.entity.Location;
import com.csci587.entity.User;

public class LocationDao {
	
	public Location getCurrentLocationByUserId(int userId){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql="select c.location from  currentLocation c where c.userId=? descend by startTime";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				int locationId=rs.getInt(0);
				sql="select * from location where locationId=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(0, locationId);
				rs=ps.executeQuery();
				Location location =new Location();
				//
				return location;
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return null;
	}

	/**
	 * get All the location in USC
	 * @return
	 */
	public List<Location> getAllLocation(){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		List<Location> res =new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from location";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Location location = new Location();
				location.setLatitude(rs.getDouble(0));
				location.setLocationId(rs.getInt(1));
				location.setLocationName(rs.getString(2));
				location.setLongtitude(rs.getDouble(4));
				location.setRadius(rs.getInt(4));
				res.add(location);
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return res;
	}
	/**
	 * delete the expire record from the 5 minute table
	 * @param current
	 * @return
	 */
	public boolean deleteExpireLocation(Date current){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		List<Location> res =new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="n";
		
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return true;
	}
	/**
	 * add the currnt location into the current table and then return this user's in the 5 minute all the location
	 * @param curr
	 * @param location
	 * @param userId
	 * @return
	 */
	public List<Integer> addLocationAndGetListOfLocation(Date curr,Location location,int userId){
		ResultSet rs = null;
		Connection conn=null;
		PreparedStatement ps = null;
		List<Integer> res =new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="inset into Current values(?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setDate(0, curr);
			ps.setInt(1, userId);
			ps.setInt(2, location.getLocationId());
			
			rs=ps.executeQuery();
			sql="select * from currentLocation where userId=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(0, userId);
			rs=ps.executeQuery();
			while(rs.next()){
				res.add(rs.getInt(2));//store all the locationId here 
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return res;
	}

}

