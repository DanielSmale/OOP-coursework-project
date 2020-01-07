package PatientManagmentSystem.Views;

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

public class AccountRequestGUI extends JFrame {

	private JPanel contentPane;
	private JTextField givenNametextField;
	private JTextField surnameTextField;
	private JTextField uniqueIDTextField;
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

		JLabel lblUniqueId = new JLabel("Unique ID");
		lblUniqueId.setBounds(12, 103, 56, 16);
		contentPane.add(lblUniqueId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 132, 86, 16);
		contentPane.add(lblPassword);

		givenNametextField = new JTextField();
		givenNametextField.setColumns(10);
		givenNametextField.setBounds(93, 42, 303, 22);
		contentPane.add(givenNametextField);

		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(93, 74, 303, 22);
		contentPane.add(surnameTextField);

		uniqueIDTextField = new JTextField();
		uniqueIDTextField.setColumns(10);
		uniqueIDTextField.setBounds(93, 103, 303, 22);
		contentPane.add(uniqueIDTextField);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(93, 132, 303, 22);
		contentPane.add(passwordTextField);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String givenName = givenNametextField.getText();
				String surname = surnameTextField.getText();
				String uniqueIDValue = uniqueIDTextField.getText();
				String password = passwordTextField.getText();

			}
		});
		btnEnter.setBounds(103, 179, 97, 25);
		contentPane.add(btnEnter);
	}
}
