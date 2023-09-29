package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician (int id) {
		super();
		
	} 
    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
//		if (pin >= 1000 && pin <= 9999) { // Check if the pin is 4 digits or more
//	        // Assign the pin to the user
//	        return true;
//	    } else {
//	     
//		return false;}
		return (pin>=1000 && pin <= 9999);
		}
	
	
	@Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// TODO Auto-generated method stub
//		System.out.println(this.getId());
    	if (confirmedAuthID.equals(this.getId())) {
    		return true;
	    } else {
	        return false;
	    }
    }
	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	// TO DO: Setters & Getters
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


	
}
