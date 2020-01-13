package PatientManagmentSystem.Views.SecretaryUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.Medicine;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderMedicines extends JFrame {
	SecretaryController secretaryController = new SecretaryController();

	private JPanel contentPane;
	private JTextField medcineNameTxt;
	private JTextField quantityTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMedicines frame = new OrderMedicines();
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
	public OrderMedicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOrderMedicines = new JLabel("Order Medicines");
		lblOrderMedicines.setBounds(12, 13, 100, 16);
		contentPane.add(lblOrderMedicines);

		JLabel lblMedicineName = new JLabel("Medicine name");
		lblMedicineName.setBounds(12, 74, 100, 16);
		contentPane.add(lblMedicineName);

		medcineNameTxt = new JTextField();
		medcineNameTxt.setBounds(105, 71, 259, 22);
		contentPane.add(medcineNameTxt);
		medcineNameTxt.setColumns(10);

		JLabel lblMedicineQuantity = new JLabel("Quantity");
		lblMedicineQuantity.setBounds(12, 106, 100, 16);
		contentPane.add(lblMedicineQuantity);

		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(105, 103, 259, 22);
		contentPane.add(quantityTxt);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Medicine newMedicine = new Medicine(medcineNameTxt.getText(), Integer.parseInt(quantityTxt.getText()));

				secretaryController.StoreMedicineDetails(newMedicine, true);

				// clear the text boxes
				medcineNameTxt.setText("");
				quantityTxt.setText("");
			}
		});
		btnEnter.setBounds(12, 163, 97, 25);
		contentPane.add(btnEnter);
	}
}
