package PatientManagmentSystem.Views.PatientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.PatientController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppointmentRequest extends JFrame {

	private PatientController patientController = new PatientController();

	private JPanel contentPane;
	private JTextField PreferredDoctor;
	private JTextField PossibleDate1Txt;
	private JTextField PossibleDate2Txt;
	private JTextField PossibleDate3Txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentRequest frame = new AppointmentRequest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppointmentRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PreferredDoctor = new JTextField();
		PreferredDoctor.setBounds(61, 71, 436, 22);
		contentPane.add(PreferredDoctor);
		PreferredDoctor.setColumns(10);

		JLabel lblPreferedDoctor = new JLabel("Prefered Doctor");
		lblPreferedDoctor.setBounds(61, 42, 106, 16);
		contentPane.add(lblPreferedDoctor);

		JLabel lblPossibleDate = new JLabel("Possible date 1");
		lblPossibleDate.setBounds(61, 116, 106, 16);
		contentPane.add(lblPossibleDate);

		PossibleDate1Txt = new JTextField();
		PossibleDate1Txt.setBounds(61, 145, 222, 22);
		contentPane.add(PossibleDate1Txt);
		PossibleDate1Txt.setColumns(10);

		JLabel lblPossibleDate2 = new JLabel("Possible date 2");
		lblPossibleDate2.setBounds(61, 190, 106, 16);
		contentPane.add(lblPossibleDate2);

		PossibleDate2Txt = new JTextField();
		PossibleDate2Txt.setColumns(10);
		PossibleDate2Txt.setBounds(61, 219, 222, 22);
		contentPane.add(PossibleDate2Txt);

		JLabel lblPossibleDate3 = new JLabel("Possible date 3");
		lblPossibleDate3.setBounds(61, 270, 106, 16);
		contentPane.add(lblPossibleDate3);

		PossibleDate3Txt = new JTextField();
		PossibleDate3Txt.setColumns(10);
		PossibleDate3Txt.setBounds(61, 299, 222, 22);
		contentPane.add(PossibleDate3Txt);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] preferedDates = { PossibleDate1Txt.getText(), PossibleDate2Txt.getText(), PossibleDate3Txt.getText() };

				SendAppointmentRequest(PreferredDoctor.getText(), preferedDates);

			}
		});
		btnSubmit.setBounds(61, 350, 97, 25);
		contentPane.add(btnSubmit);

	}

	private void SendAppointmentRequest(String preferedDoctorID, String[] preferedDates) {

		patientController.CreateAppointmentRequest(preferedDoctorID, preferedDates);

	}
}
