package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Bundle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int bundle_Id;
	private BigDecimal cost;
	private int nurse_Id;
	private boolean assigned;
	//only create
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="Bundle_Request",
				joinColumns = @JoinColumn(name="bundle_Id"),
				inverseJoinColumns = @JoinColumn(name = "request_Id")
	)
	private Collection <Request> patientRequestList = new ArrayList<Request>();

	
	public Collection<Request> getPatientRequestList() {
		return patientRequestList;
	}
	public void setPatientRequestList(Collection<Request> patientRequestList) {
		this.patientRequestList = patientRequestList;
	}
	
/*	public void addPatientRequest (Request r){
		patientRequestList.add(r);
		//r.addAssociatedBundle(this);
	}*/
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost2) {
		this.cost = cost2;
	}
	public int getNurseID() {
		return nurse_Id;
	}
	public void setNurseID(int nurseID) {
		this.nurse_Id = nurseID;
	}
	public boolean isAssigned() {
		return assigned;
	}
	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
	public int getBundleID() {
		return bundle_Id;
	}
	public void setBundleID(int bundleID) {
		this.bundle_Id = bundleID;
	}
}
