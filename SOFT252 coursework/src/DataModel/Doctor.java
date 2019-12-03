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

    }

    private void PrescribeMedicine(){
        
    }
    
    private void CreateNewMedicine(){
        
        
    }
    
}