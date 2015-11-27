package com.csci587.service;

import java.util.List;

import com.csci587.Interface.Service.ILocationService;
import com.csci587.entity.Location;


public class LocationService implements ILocationService{

	@Override
	public Location getCurrentLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getListLocationNearMe() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int[] currentLocationUpdate(Double latitude,Double longtitude,String username){
		//int[] contain 2 attribute,first one show if it update success,second shows if it need send notification.
		return null;
	}

}
