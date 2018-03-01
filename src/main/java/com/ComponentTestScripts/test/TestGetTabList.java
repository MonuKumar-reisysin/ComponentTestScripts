package com.ComponentTestScripts.test;

import java.util.List;

import com.ComponentTestScripts.vo.TabNameVO;
import com.ComponentTestScripts.vo.UserPreferenceVO;
import com.force.service.ForceDelegate;

public class TestGetTabList {
	
	@SuppressWarnings({ "unchecked" })
	public static List<TabNameVO> main() {
		 
//		 ForceDelegate gate=null;
	  ForceDelegate gate = com.ComponentTestScripts.utility.GGUtils.getForceDelegate();
	//  System.out.println(gate.getSessionId());
	//  System.out.println("Username-----" +gate.getUsername());
		String UserID = null;
	//UserVO
		List<UserPreferenceVO> user = gate.queryMultiple("select.user.id",new Object[]{ gate.getUsername()});
//	    UserPreferenceSingleton.getInstance();
		//  List<UserPreferenceVO> user = gate.queryMultiple("select.user.id",new Object[]{ gate.getUsername()});
		List<UserPreferenceVO> userpref = gate.queryMultiple("select.userpref.list",new Object[]{user.get(0).getId() });
		List<TabNameVO> phaselist = gate.queryMultiple("select.phaselist.list",new Object[]{ userpref.get(0).getGNT__ActiveAppName__c() });		
		return phaselist;   
	 }

}
