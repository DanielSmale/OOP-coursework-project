/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author dsmale
 */
public class Prescription {    

           private String doctorID;
        private String patientID;
        private String doctorNotes;
        private Medicines medicine;
        private int quantity;
        private float dosage;
    
    public Prescription(String doctorID, String patientID, String doctorNotes, Medicines medicine, int quantity, float dosage) {
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.doctorNotes = doctorNotes;
        this.medicine = medicine;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public Medicines getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicines medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }
          
 
        
}
