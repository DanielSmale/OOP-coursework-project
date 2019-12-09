/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataModel;

/**
 *
 * @author Student
 */
public class Appointment {
    
    private String doctorID;
    private String patientID;
        private String date;

    public Appointment(String date, String doctorID,String patientID){
        this.date = date;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }
    

}
