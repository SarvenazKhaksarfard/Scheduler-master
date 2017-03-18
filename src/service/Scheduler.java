package service;

import java.util.ArrayList;
import java.util.List;

import model.Bundle;
import model.Request;

public class Scheduler {


	List <Integer> nurseList;
	List <Bundle> bundleList;
	//BundleHandler handler = null;
	Request r = null ;
	
	public Scheduler (){
		nurseList = new ArrayList <Integer>();
		bundleList = new ArrayList <Bundle>();

	}
	public List <Bundle> assignBundles(){
		
		/////bundleList = handler.getAllBundles();
		//algorithm initial phase		
		//////List <Integer> allRequests = r.getPatientIDList();
		/////nurseList = s.getBackupNurse();
		//algorithm : the rest
		return null;
		
	}
	public int calculateCost(){
		return 0;
		}
}
