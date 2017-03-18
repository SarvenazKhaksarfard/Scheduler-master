package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Request {
	@Id 	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int request_Id;
	@Column(name = "cost", precision = 4, scale = 2)
	private BigDecimal cost;

public int getRequestID() {
	return request_Id;
}
public void setRequestID(int patientID) {
	this.request_Id = patientID;
}
public BigDecimal getCost() {
	return cost;
}
public void setCost(BigDecimal cost) {
	this.cost = cost;
}


}


//@ManyToMany(mappedBy="patientRequestList", cascade=CascadeType.PERSIST)
/*private Collection <Bundle> associatedBundleList = new ArrayList<Bundle>();
public Collection<Bundle> getAssociatedBundleList() {
	return associatedBundleList;
}
public void setAssociatedBundleList(Collection<Bundle> associatedBundleList) {
	this.associatedBundleList = associatedBundleList;
}

public void addAssociatedBundle(Bundle b){
	associatedBundleList.add(b);
}*/