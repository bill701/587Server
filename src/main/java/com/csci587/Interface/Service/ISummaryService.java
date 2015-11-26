package com.csci587.Interface.Service;

import java.util.List;

public interface ISummaryService {

	public List<String> getSummaryForOneDay();
	public List<String> getSummaryForCertainDay();
	public List<String> getSummaryForCurrentMonth();
}
