package com.csci587.service;

import com.csci587.Interface.Service.IUserService;
import com.csci587.entity.Location;
import com.csci587.entity.User;

public class UserService implements IUserService{

	@Override
	public boolean register(String name, String password,String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Location getLocation(String username){
		return null;
	}

}
