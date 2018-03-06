package com.framework.vo;

import com.force.service.vo.CustomVO;

@SuppressWarnings("serial")

public class UserPreferenceVO extends CustomVO { 
	private String Id;
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	private String GNT__ActiveAppName__c;

	public String getGNT__ActiveAppName__c() {
		return GNT__ActiveAppName__c;
	}

	public void setGNT__ActiveAppName__c(String gNT__ActiveAppName__c) {
		GNT__ActiveAppName__c = gNT__ActiveAppName__c;
	}
	}


