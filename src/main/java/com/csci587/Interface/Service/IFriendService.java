package com.csci587.Interface.Service;

import java.util.List;

import com.csci587.entity.Location;
import com.csci587.entity.User;

public interface IFriendService {

	public List<User> getFriendByUserId(String username);
	public boolean addFriend(String username);
}
