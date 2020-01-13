package PatientManagmentSystem.Views.SecretaryUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.Medicine;

import javax.swing.JLabel;
import javax.swing.JList;

public class ViewMedicineStock extends JFrame {
	SecretaryController secretaryController = new SecretaryController();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMedicineStock frame = new ViewMedicineStock();
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
	public ViewMedicineStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblViewStock = new JLabel("View Stock");
		lblViewStock.setBounds(29, 13, 88, 16);
		contentPane.add(lblViewStock);

		JList medicineStocklist = new JList();
		medicineStocklist.setBounds(25, 55, 380, 338);
		contentPane.add(medicineStocklist);

		DefaultListModel<String> model = SetListsData();
		medicineStocklist.setModel(model);
	}

	private DefaultListModel<String> SetListsData() {

		DefaultListModel<String> medcinesDataListModel = new DefaultListModel<String>();

		Medicine[] medincinesList = secretaryController.ReturnMedicines();

		for (int i = 0; i < medincinesList.length; i++) {

			String medcineInfo = medincinesList[i].getMedicineName() + " " + medincinesList[i].getStock();

			medcinesDataListModel.addElement(medcineInfo);
		}
		return medcinesDataListModel;
	}
}
