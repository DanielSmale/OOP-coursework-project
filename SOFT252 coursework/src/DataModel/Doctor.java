package DataModel;

public class Doctor extends User implements IObserver{

public Doctor(IObservable observable){
observable.registerObserver(this);
}

public void update(int data){
System.out.Println("Successfully notified " + data);
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