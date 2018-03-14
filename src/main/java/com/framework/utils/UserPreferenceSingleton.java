package com.framework.utils;

import com.force.service.ForceDelegate;

import java.util.HashMap;
import java.util.List;

import com.framework.vo.UserPreferenceVO;

public class UserPreferenceSingleton {

	ForceDelegate SFInstance = null;

	private static UserPreferenceSingleton singletonInstance = null;

	public static HashMap<String, String> cachedObjects;
	public String activeAppName;
	public String userID;

	private ForceDelegate UserPreferenceSingleton()
	    {
	    	cachedObjects = new HashMap<String, String>();
	    	ForceDelegate gate = com.framework.utils.GGUtils.getForceDelegate();
	    	System.out.println(gate.getSessionId());
	    	
	    	@SuppressWarnings({ "unchecked" })
	    	
	    	List<UserPreferenceVO> user = gate.queryMultiple("select.user.id",new Object[]{ gate.getUsername()});
	    	cachedObjects.put(userID, user.get(0).getId());
	    	
//	    	List<UserPreferenceVO> userpref = gate.queryMultiple("select.userpref.list",new Object[]{ user.get(0).getId()});
//	    	cachedObjects.put(activeAppName, userpref.get(0).getGNT__ActiveAppName__c());
	    	
	    	return gate;
	    }

	public static UserPreferenceSingleton getInstance() {
		singletonInstance = singletonInstance == null ? new UserPreferenceSingleton()
				: singletonInstance;
		return singletonInstance;
	}

	public String getValUserID(String UserID) {
		return cachedObjects.get(UserID);
	}

	// public String getValAppName(String activeAppName) {
	// return cachedObjects.get(activeAppName);
	// }
}