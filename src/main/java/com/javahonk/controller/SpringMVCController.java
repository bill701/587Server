package com.javahonk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class SpringMVCController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String printWelcome(@ModelAttribute("person") Person person, BindingResult result,ModelMap model, HttpServletRequest 
	    request, HttpServletResponse response) {
   

	    List<String> test=new ArrayList<String>();
	   String name ="byan@AMAZON.COM";
	   System.out.println(name);
	   int index=name.lastIndexOf("@");
	   System.out.println("==="+name.substring(0, index));
	    test.add("Prime Acs");
	    test.add("Prime ACX");
	    test.add(name.substring(0, index));
    	ModelAndView modelandview=new ModelAndView();
    	modelandview.setViewName("helloWorld");
    	
    	modelandview.addObject("group",test);
    	
    	return "";
    	

    }
    @RequestMapping(value = "/helloWorld1.web", method = 
    	    RequestMethod.GET)
        public String printWelcome1(String newTag,String ticketId, String[] tag,ModelMap model, HttpServletRequest 
    	    request, HttpServletResponse response) {
    	 String haha ="byan@AMAZON.COM";
  	   System.out.println(haha);
  	   int index=haha.lastIndexOf("@");
  	   System.out.println("==="+haha.substring(0, index));
    	
    	//System.out.println(tag);	
    	
        	return "redirect:/helloWorld.web";

        }

    @RequestMapping(value = "/springPaginationDataTables.web", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String springPaginationDataTables(HttpServletRequest  request) throws IOException {
		
    
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;		
    	
    	
    	String searchParameter = request.getParameter("sSearch");
    	
    
    	List<Person> personsList = createPaginationData(20);
		
		
		
		
		PersonJsonObject personJsonObject = new PersonJsonObject();
		
		personJsonObject.setiTotalDisplayRecords(500);
	
		personJsonObject.setiTotalRecords(500);
		personJsonObject.setAaData(personsList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(personJsonObject);
	
		return json2;
    }

    @RequestMapping(value = "/testSpringPaginationDataTables.web", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String testSpringPaginationDataTables(HttpServletRequest  request) throws IOException {
		
    
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;		
    	
    	
    	String searchParameter = request.getParameter("sSearch");
    	
    
    	List<Person> personsList = createPaginationData(20);
		
		
		
		
		PersonJsonObject personJsonObject = new PersonJsonObject();
		
		personJsonObject.setiTotalDisplayRecords(500);
	
		personJsonObject.setiTotalRecords(500);
		personJsonObject.setAaData(personsList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(personJsonObject);
	
		return json2;
    }
	private List<Person> getListBasedOnSearchParameter(String searchParameter,List<Person> personsList) {
		
		if (null != searchParameter && !searchParameter.equals("")) {
			List<Person> personsListForSearch = new ArrayList<Person>();
			searchParameter = searchParameter.toUpperCase();
			for (Person person : personsList) {
				if (person.getName().toUpperCase().indexOf(searchParameter)!= -1 || person.getOffice().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getPhone().toUpperCase().indexOf(searchParameter)!= -1 || person.getPosition().toUpperCase().indexOf(searchParameter)!= -1
						|| person.getSalary().toUpperCase().indexOf(searchParameter)!= -1 || person.getStart_date().toUpperCase().indexOf(searchParameter)!= -1) {
					personsListForSearch.add(person);					
				}
				
			}
			personsList = personsListForSearch;
			personsListForSearch = null;
		}
		return personsList;
	}

	private List<Person> createPaginationData(Integer pageDisplayLength) {
		List<Person> personsList = new ArrayList<Person>();
		for (int i = 0; i < 1; i++) {
		    Person person2 = new Person();
		        person2.setTag("hehehe,gegegeg");
	            person2.setName("John Landy");
	            person2.setPosition("Medium");
	            person2.setSalary("$320,800");
	            person2.setOffice("NY");
	            person2.setPhone("999999999");
	            person2.setStart_date("2015-06-15 19:34:46");
	            personsList.add(person2);  
	            
	            person2 = new Person();
	            person2.setTag("hehehe,gegegeg");
	            person2.setName("Igor Vornovitsky");
	            person2.setPosition("Highest");
	            person2.setSalary("$340,800");
	            person2.setOffice("NY");
	            person2.setPhone("987897899");
	            person2.setStart_date("2015-06-15 19:34:46");
	            personsList.add(person2); 
	            
	            person2 = new Person();
	            person2.setTag("hehehe,gegegeg");
	            person2.setName("Java Honk");
	            person2.setPosition("Medium");
	            person2.setSalary("$380,800");
	            person2.setOffice("NY");
	            person2.setPhone("1234567890");
	            person2.setStart_date("2015-06-15 19:34:46");
	            personsList.add(person2); 
	            
	            person2 = new Person();
	            person2.setTag("hehehe,gegegeg");
	            person2.setName("Ramesh Arrepu");
	            person2.setPosition("High");
	            person2.setSalary("$310,800");
	            person2.setOffice("NY");
	            person2.setPhone("4654321234");
	            person2.setStart_date("2015-06-16 15:27:46");
	            personsList.add(person2); 
	            
	            person2 = new Person();
	            person2.setTag("hehehe,gegegeg");
	            person2.setName("Bob Sidebottom");
	            person2.setPosition("Low");
	            person2.setSalary("$300,800");
	            person2.setOffice("NJ");
	            person2.setPhone("9876543212");
	            person2.setStart_date("2015-06-16 11:34:46");
	            personsList.add(person2); 
	
		}
		
		for (int i = 0; i < pageDisplayLength-5; i++) {
		    Person person2 = new Person();
		        person2.setTag("hehehe,gegegeg");
	            person2.setName("Zuke Torres");
	            person2.setPosition("Medium");
	            person2.setSalary("$320,800");
	            person2.setOffice("NY");
	            person2.setPhone("999999999");
	            person2.setStart_date("2015-06-16 11:34:46");
	            personsList.add(person2);  
		}
		return personsList;
	}
}