package PatientManagmentSystem.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.PotentialUser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class AccountRequestGUI extends JFrame {
	SecretaryController secretaryController = new SecretaryController();

	private JPanel contentPane;
	private JTextField givenNametextField;
	private JTextField surnameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountRequestGUI frame = new AccountRequestGUI();
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
	public AccountRequestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccountRequestGui = new JLabel("Account request GUI");
		lblAccountRequestGui.setBounds(12, 13, 116, 16);
		contentPane.add(lblAccountRequestGui);

		JLabel lblGivenName = new JLabel("Given name");
		lblGivenName.setBounds(12, 45, 86, 16);
		contentPane.add(lblGivenName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(12, 74, 56, 16);
		contentPane.add(lblSurname);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 112, 86, 16);
		contentPane.add(lblPassword);

		givenNametextField = new JTextField();
		givenNametextField.setColumns(10);
		givenNametextField.setBounds(93, 42, 303, 22);
		contentPane.add(givenNametextField);

		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(93, 74, 303, 22);
		contentPane.add(surnameTextField);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(93, 112, 303, 22);
		contentPane.add(passwordTextField);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Random uniqueIDNumberGenerator = new Random();

				String givenName = "";
				String surname = "";
				String password = "";

				if (givenNametextField.getText() != null || givenNametextField.getText() != "") {
					givenName = givenNametextField.getText();
				}

				if (surnameTextField.getText() != null || surnameTextField.getText() != "") {
					surname = surnameTextField.getText();
				}

				if (passwordTextField.getText() != null || passwordTextField.getText() != "") {
					password = passwordTextField.getText();
				}

				String uniqueIDValue = "P" + uniqueIDNumberGenerator.nextInt(1000);

				secretaryController.ReceiveAccountRequest(givenName, surname, uniqueIDValue, password, "Patient");
			}
		});
		btnEnter.setBounds(103, 159, 97, 25);
		contentPane.add(btnEnter);
	}
}
