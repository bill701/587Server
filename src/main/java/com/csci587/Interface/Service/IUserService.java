package com.csci587.Interface.Service;

import com.csci587.entity.User;

public interface IUserService {

	public boolean register(String name,String password);
	public User login(String name,String password);
	
}
