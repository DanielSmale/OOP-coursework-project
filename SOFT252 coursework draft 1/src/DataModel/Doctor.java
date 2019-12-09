package DataModel;

public class Doctor extends User implements IObserver{

   public CreateAppointment appointmentCreator;
    public MakesNotes makeNotes;
    
public Doctor(IObservable observable){
observable.RegisterObserver(this);
}


public Doctor(){
    appointmentCreator = new CreateAppointment();
    makeNotes = new MakesNotes();
}

@Override
public void update(String appointmentDate){
System.out.println("Successfully notified " + appointmentDate);
}


    public void ViewAppointments() {
        appointmentCreator.CreateAppointment();
    }

    private void MakeNotes() {
        
    }

    private void InspectPatientHistory() {

    }

    public void CreateAppointment() {

        Appointment newAppointment = new Appointment("9/9/2020", "d01","p01");
        
    }

    private void PrescribeMedicine(){
        Medicines paracetimal = new Medicines();
        Prescription newPrescription = new Prescription("d01", "p01", "Swallow through bottom", paracetimal, 10, 5.5f);
    }
    
    private void CreateNewMedicine(){
        
        
    }
    
}