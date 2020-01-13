package PatientManagmentSystem.Views.SecretaryUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.Medicine;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResupplyStock extends JFrame {
	SecretaryController secretaryController = new SecretaryController();
	private JPanel contentPane;
	private JTextField orderAmountTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResupplyStock frame = new ResupplyStock();
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
	public ResupplyStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList medicineStocklist = new JList();
		medicineStocklist.setBounds(12, 94, 380, 299);
		contentPane.add(medicineStocklist);

		JLabel lblResupplyMedicines = new JLabel("Resupply medicines");
		lblResupplyMedicines.setBounds(22, 13, 112, 16);
		contentPane.add(lblResupplyMedicines);

		JLabel lblSelectAMedicine = new JLabel("Select a medicine");
		lblSelectAMedicine.setBounds(12, 65, 112, 16);
		contentPane.add(lblSelectAMedicine);

		JLabel lblAmountToOrder = new JLabel("Amount to order");
		lblAmountToOrder.setBounds(404, 95, 112, 16);
		contentPane.add(lblAmountToOrder);

		orderAmountTxt = new JTextField();
		orderAmountTxt.setBounds(400, 116, 116, 22);
		contentPane.add(orderAmountTxt);
		orderAmountTxt.setColumns(10);

		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Medicine[] medicinesList = secretaryController.ReturnMedicines();

				int i;
				for (i = 0; i < medicinesList.length; i++) {
					System.out.println(medicineStocklist.getSelectedValue());
					if (medicineStocklist.getSelectedValue() == medicinesList[i].getMedicineName() + " "
							+ medicinesList[i].getStock()) {

						System.out.println(medicinesList[i].getMedicineName() + " " + medicinesList[i].getStock());
						int stock = medicinesList[i].getStock() + Integer.parseInt(orderAmountTxt.getText());
						medicinesList[i].setStock(stock);
						secretaryController.StoreMedicineDetails(medicinesList[i], true);
					}
				}
			}
		});
		btnOrder.setBounds(404, 169, 97, 25);
		contentPane.add(btnOrder);

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
