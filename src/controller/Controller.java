package controller;

import java.sql.Connection;
import java.util.*;

import model.Bundle;
import service.BundleDAO;
import service.RequestDAO;
import service.Scheduler;
import view.View;


public class Controller {
static View view;
Scheduler scheduler = null;
///BundleHandler handler = null;
BundleDAO bundleService = new BundleDAO();
RequestDAO requestService = new RequestDAO();
public void addView(View view){
	this.view = view;
}
	public void actionScheduling(){
		List <Bundle> bundles = scheduler.assignBundles();
		int cost = scheduler.calculateCost();
		view.displaySchedule(bundles, cost);
	}
	public void actionDisplayNurseBundle(){
		//List <Bundle> bundles = handler.getAllBundles();
		//view.displayNurseBundle(bundles);
	}
	public Connection actionConnectToDB(){
		return null;
		}
}
