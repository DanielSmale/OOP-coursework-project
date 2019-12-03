package DataModel;

public class Doctor extends User implements IObserver{

public Doctor(IObservable observable){
observable.RegisterObserver(this);
}

@Override
public void update(String appointmentDate){
System.out.println("Successfully notified " + appointmentDate);
}

    private void ViewAppointments() {

    }

    private void MakeNotes() {

    }

    private void InspectPatientHistory() {

    }

    private void CreateAppointment() {

        Appointment newAppointment = new Appointment("9/9/2020", "d01","p01");
        
    }

    private void PrescribeMedicine(){
        Medicines paracetimal = new Medicines();
        Prescription newPrescription = new Prescription("d01", "p01", "Swallow through bottom", paracetimal, 10, 5.5f);
    }
    
    private void CreateNewMedicine(){
        
        
    }
    
}