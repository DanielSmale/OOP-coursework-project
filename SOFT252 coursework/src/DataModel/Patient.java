package DataModel;

public class Patient extends User implements IObserver{

    private int age;
    private String gender;
    private String prescriptions;
    private Note notes;

private ArrayList<IObserver> observers;
private int data =0;

@Override
public void registerObserver(IObserver observer) {
observers.add(observer);
}

@Override
public void removeObserver(IObserver observer){
observers.remove(observer);
}

@Override
public void notifyObservers(){
for(int i = 0; i < observers.size(); i++){
observers.get(i).update(data);
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


