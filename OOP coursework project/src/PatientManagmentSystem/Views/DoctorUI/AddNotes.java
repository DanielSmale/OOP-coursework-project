package PatientManagmentSystem.Views.DoctorUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import PatientManagmentSystem.Controllers.DoctorController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNotes {
DoctorController doctorController = new DoctorController();
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotes window = new AddNotes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNotes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea notesTextArea = new JTextArea();
		notesTextArea.setBounds(42, 47, 396, 246);
		frame.getContentPane().add(notesTextArea);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SendNotesString(notesTextArea.getText());
				
			}
		});
		btnSave.setBounds(52, 318, 97, 25);
		frame.getContentPane().add(btnSave);
	}
	
	
	private void SendNotesString(String notes) {
		doctorController.SendNotes(notes);


	}
}
