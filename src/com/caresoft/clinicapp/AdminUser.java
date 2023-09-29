package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id, String role) {
		super();
		this.id = id;
		this.role = role;
		securityIncidents = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
    
    // TO DO: Implement HIPAACompliantUser!
        
    @Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin >= 100000) { // Check if the pin is 6 digits or more
	        // Assign the pin to the user
	        return true;
	    } else {
	     
		return false;}
		}
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// TODO Auto-generated method stub
    	if (confirmedAuthID.equals(this.getId())) {
    		return true;
	    } else {
	        authIncident();
	        return false;
	    }
    }
    // TO DO: Implement HIPAACompliantAdmin!

    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	// TODO Auto-generated method stub
    	return securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	// TO DO: Setters & Getters

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	
	
}
