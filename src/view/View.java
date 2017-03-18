package view;

import java.util.List;

import controller.Controller;
import model.Bundle;

public class View {
Controller controller;
	public void addController(Controller controller){
		this.controller = controller;
	}
	public void displaySchedule(List <Bundle> assignedBundles, int cost){

		controller.actionScheduling();
	}
	public void displayNurseBundle(List <Bundle> bundles){
		controller.actionDisplayNurseBundle();
	}
}
