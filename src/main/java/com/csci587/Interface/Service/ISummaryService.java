package com.csci587.Interface.Service;

import java.util.List;

public interface ISummaryService {

	List<String> getSummaryForOneDay(String date,String username);
	//public List<String> getSummaryForCertainDay();
	//public List<String> getSummaryForCurrentMonth();
}
