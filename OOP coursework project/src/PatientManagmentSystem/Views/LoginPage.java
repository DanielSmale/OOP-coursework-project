package PatientManagmentSystem.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.DataModel.AdministratorSystem.Administrator;
import PatientManagmentSystem.Views.AdminUI.AdminMainPage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField givenNameTxt;
	private JTextField surnameTxt;
	private JTextField uniqueIDTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(28, 30, 56, 16);
		contentPane.add(lblWelcome);

		JLabel lblGivenName = new JLabel("Given name");
		lblGivenName.setBounds(47, 75, 86, 16);
		contentPane.add(lblGivenName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(47, 104, 56, 16);
		contentPane.add(lblSurname);

		JLabel lblUniqueId = new JLabel("Unique ID");
		lblUniqueId.setBounds(47, 133, 56, 16);
		contentPane.add(lblUniqueId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(47, 162, 86, 16);
		contentPane.add(lblPassword);

		givenNameTxt = new JTextField();
		givenNameTxt.setBounds(128, 72, 303, 22);
		contentPane.add(givenNameTxt);
		givenNameTxt.setColumns(10);

		surnameTxt = new JTextField();
		surnameTxt.setColumns(10);
		surnameTxt.setBounds(128, 104, 303, 22);
		contentPane.add(surnameTxt);

		uniqueIDTxt = new JTextField();
		uniqueIDTxt.setColumns(10);
		uniqueIDTxt.setBounds(128, 133, 303, 22);
		contentPane.add(uniqueIDTxt);

		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(128, 162, 303, 22);
		contentPane.add(passwordTxt);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String uniqueIDValue = uniqueIDTxt.getText();
				System.out.println(uniqueIDValue);

				Administrator administrator = new Administrator();
				AdminMainPage adminMainPage = new AdminMainPage();
				if (uniqueIDValue.equals(uniqueIDValue)) {
					System.out.println("if statement true");
					dispose();
					adminMainPage.setVisible(true);
				}
			}
		});
		btnEnter.setBounds(138, 209, 97, 25);
		contentPane.add(btnEnter);

	}
}
