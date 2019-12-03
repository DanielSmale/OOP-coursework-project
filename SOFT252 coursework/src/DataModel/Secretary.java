package DataModel;

public class Secretary extends User implements IObserver {

    @Override
    public void update(String appointmentDate) {
        System.out.println("Successfully notified " + appointmentDate);
    }

    private void ApprovePatientAccount() {

    }

    private void ReceiveAppointmentRequest() {

    }

    private void CreateAppointment() //Create an appointment between a patient and a free doctor. 
    {

    }

    private void GiveMedicines() {

    }

    private void OrderMedicines() {

    }

    private void RemovePatients() {

    }

    private void ApproveAccountRemoval() {

    }

}
