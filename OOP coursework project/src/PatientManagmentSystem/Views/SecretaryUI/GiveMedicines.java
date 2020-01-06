package PatientManagmentSystem.Views.SecretaryUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiveMedicines extends JFrame {

	private JPanel contentPane;
	private JTextField medicineNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveMedicines frame = new GiveMedicines();
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
	public GiveMedicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGiveMedicines = new JLabel("Give medicines");
		lblGiveMedicines.setBounds(12, 13, 85, 16);
		contentPane.add(lblGiveMedicines);

		JLabel lblMedicineName = new JLabel("Medicine name");
		lblMedicineName.setBounds(29, 66, 99, 16);
		contentPane.add(lblMedicineName);

		medicineNameTxt = new JTextField();
		medicineNameTxt.setBounds(127, 63, 264, 22);
		contentPane.add(medicineNameTxt);
		medicineNameTxt.setColumns(10);

		JButton btnPrescribe = new JButton("Prescribe");
		btnPrescribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		btnPrescribe.setBounds(31, 124, 97, 25);
		contentPane.add(btnPrescribe);
	}
}
