package PatientManagmentSystem.Views.AdminUI;

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

public class RemoveUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField userIDtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveUserUI frame = new RemoveUserUI();
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
	public RemoveUserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveUsers = new JLabel("Remove Users");
		lblRemoveUsers.setBounds(12, 13, 101, 16);
		contentPane.add(lblRemoveUsers);
		
		userIDtextField = new JTextField();
		userIDtextField.setBounds(156, 73, 116, 22);
		contentPane.add(userIDtextField);
		userIDtextField.setColumns(10);
		
		JLabel lblUserToRemoves = new JLabel("User to remove's ID");
		lblUserToRemoves.setBounds(27, 76, 129, 16);
		contentPane.add(lblUserToRemoves);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnRemoveUser.setBounds(46, 122, 139, 25);
		contentPane.add(btnRemoveUser);
	}
}
