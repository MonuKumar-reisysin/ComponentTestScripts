package com.framework.customApp;

import java.util.ArrayList;
import java.util.List;

import com.force.service.ForceDelegate;
import com.framework.vo.CustomAppVO;

public class TestCreationOfCustApp {
	@SuppressWarnings({ "unchecked" })
	public static void main (String phaseName){
		ForceDelegate gate = com.framework.utils.GGUtils.getForceDelegate();
		
		List<CustomAppVO> customapp = null;
		customapp = gate.queryAllMultiple("create.app", new Object[]{phaseName});
		
		/*ArrayList<String> arraylistExpectedApp =  new ArrayList<String>();
		for(CustomAppVO f:customapp){
			arraylistExpectedApp.add(f.getName());			
		}
		String[] strarraylistExpectedApp = new String[ arraylistExpectedApp.size()];
		arraylistExpectedApp.toArray(strarraylistExpectedApp);
		return strarraylistExpectedApp;*/
		
		}

}
