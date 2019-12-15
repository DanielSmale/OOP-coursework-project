package PatientManagmentSystem.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

import PatientManagmentSystem.Controllers.DoctorController;
import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DoctorCreateAppointment {

	DoctorController doctorController = new DoctorController();
	
	private JFrame frame;
	private JTextField AppointmentDateTxt;
	private JTextField doctorIDTxt;
	private JTextField patientIDTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorCreateAppointment window = new DoctorCreateAppointment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoctorCreateAppointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDoctors = new JLabel("Doctors create appointment");
		lblDoctors.setBounds(22, 17, 616, 16);
		frame.getContentPane().add(lblDoctors);
		
		JButton btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				CreateAppointment appointment = doctorController.SendAppointmentDetails(AppointmentDateTxt.getText(), patientIDTxt.getText(), doctorIDTxt.getText());
				
				System.out.println(appointment.date + " " + appointment.doctorID + " " + appointment.patientID);
				
			}
		});
		btnCreateAppointment.setBounds(97, 46, 181, 25);
		frame.getContentPane().add(btnCreateAppointment);
		
		AppointmentDateTxt = new JTextField();
		AppointmentDateTxt.setBounds(162, 84, 116, 22);
		frame.getContentPane().add(AppointmentDateTxt);
		AppointmentDateTxt.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(107, 84, 56, 16);
		frame.getContentPane().add(lblDate);
		
		doctorIDTxt = new JTextField();
		doctorIDTxt.setBounds(162, 151, 116, 22);
		frame.getContentPane().add(doctorIDTxt);
		doctorIDTxt.setColumns(10);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(94, 154, 56, 16);
		frame.getContentPane().add(lblDoctorId);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(97, 122, 56, 16);
		frame.getContentPane().add(lblPatientId);
		
		patientIDTxt = new JTextField();
		patientIDTxt.setBounds(162, 119, 116, 22);
		frame.getContentPane().add(patientIDTxt);
		patientIDTxt.setColumns(10);
	}
}
