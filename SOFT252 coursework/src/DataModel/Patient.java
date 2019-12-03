package DataModel;

import java.util.ArrayList;

public class Patient extends User implements IObservable{

    private int age;
    private String gender;
    private String prescriptions;
    private Note notes;

private ArrayList<IObserver> observers;
private String date;

@Override
public void RegisterObserver(IObserver observer) {
observers.add(observer);
}

@Override
public void RemoveObserver(IObserver observer){
observers.remove(observer);
}

@Override
public void NotifiyObservers(){
for(int i = 0; i < observers.size(); i++){
observers.get(i).update(date);
}
}


    private void RequestAccountCreation() {

    }

    private void RateDoctor() {

    }

    private void ViewDoctorRating() {

    }

    private void RequestAppointment() {

    }

    private void ViewHistory(){
        
    }
    
    private void ViewAppointments(){
        
    }
    
    private void ViewPrescription(){
    
    }
    
    private void RequestAccountTerimination(){
                
    }
    



}


