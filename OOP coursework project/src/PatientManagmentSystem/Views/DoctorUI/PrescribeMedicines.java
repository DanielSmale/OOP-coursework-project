package PatientManagmentSystem.Views.DoctorUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PrescribeMedicines extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescribeMedicines frame = new PrescribeMedicines();
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
	public PrescribeMedicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorPrescribeMedicines = new JLabel("Doctor prescribe medicines");
		lblDoctorPrescribeMedicines.setBounds(12, 26, 194, 16);
		contentPane.add(lblDoctorPrescribeMedicines);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(26, 87, 56, 16);
		contentPane.add(lblDoctorId);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(26, 116, 56, 16);
		contentPane.add(lblPatientId);
	}
}
