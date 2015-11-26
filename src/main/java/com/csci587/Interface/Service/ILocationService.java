package com.csci587.Interface.Service;

import java.util.List;

import com.csci587.entity.Location;

public interface ILocationService {
	public Location getCurrentLocation();
	public List<Location> getListLocationNearMe();
	
}
