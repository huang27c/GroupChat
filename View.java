import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class View {

	private JFrame frmGroupChat;
	JTextArea displayA, displayB, displayC;
	private JTextField inputA;
	private JTextField inputB;
	private JTextField inputC;
	private JButton sendA;
	private JButton sendB;
	private JButton sendC;
	private Sender senderA, senderB, senderC;
	private JLabel lblUserA;
	private JLabel lblUserB;
	private JLabel lblUserC;
	private JComboBox menuA, menuC;
	private JTextArea infoTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frmGroupChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
		groups();
	}
	
	private void groups() {
		senderA = new Sender("A");
		new Receiver(1,senderA, displayB);
		new Receiver(1,senderA, displayC);
		
		senderB = new Sender("B");
		new Receiver(1,senderB, displayA);
		new Receiver(1,senderB, displayC);
		
		senderC = new Sender("C");
		new Receiver(1,senderC, displayA);
		new Receiver(1,senderC, displayB);
		//AC
		new Receiver(2,senderA, displayC);
		new Receiver(2,senderC, displayA);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGroupChat = new JFrame();
		frmGroupChat.setTitle("Group Chat");
		frmGroupChat.setBounds(100, 100, 780, 600);
		frmGroupChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroupChat.getContentPane().setLayout(null);

		display();
		input();
		send();
		lables();
		menus();
		information();
	}

	private void display() {
		displayA = new JTextArea();
		displayA.setEditable(false);
		displayA.setBounds(23, 40, 323, 191);
		frmGroupChat.getContentPane().add(displayA);

		displayB = new JTextArea();
		displayB.setEditable(false);
		displayB.setBounds(419, 40, 323, 191);
		frmGroupChat.getContentPane().add(displayB);

		displayC = new JTextArea();
		displayC.setEditable(false);
		displayC.setBounds(23, 305, 323, 191);
		frmGroupChat.getContentPane().add(displayC);
		
	}
	
	private void input() {
		inputA = new JTextField();
		inputA.setBounds(23, 243, 130, 26);
		frmGroupChat.getContentPane().add(inputA);
		inputA.setColumns(10);
		
		inputB = new JTextField();
		inputB.setBounds(419, 243, 130, 26);
		frmGroupChat.getContentPane().add(inputB);
		inputB.setColumns(10);
		
		inputC = new JTextField();
		inputC.setBounds(23, 508, 130, 26);
		frmGroupChat.getContentPane().add(inputC);
		inputC.setColumns(10);
	}

	private void send() {
		sendA = new JButton("Send");
		sendA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = inputA.getText();
				if(menuA.getSelectedItem().equals("Group1")) {
					senderA.sendMsg(1, msg, displayA);
				} else {
					senderA.sendMsg(2, msg, displayA);
				}
				inputA.setText("");
				
			}
		});
		sendA.setBounds(268, 243, 78, 29);
		frmGroupChat.getContentPane().add(sendA);
		
		sendB = new JButton("Send");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderB.sendMsg(1,inputB.getText(), displayB);
				inputB.setText("");
			}
		});
		sendB.setBounds(561, 243, 67, 29);
		frmGroupChat.getContentPane().add(sendB);
		
		sendC = new JButton("Send");
		sendC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(menuC.getSelectedItem().equals("Group1")) {
					senderC.sendMsg(1,inputC.getText(), displayC);
				} else {
					senderC.sendMsg(2,inputC.getText(), displayC);
				}
				inputC.setText("");
				
			}
		});
		sendC.setBounds(269, 508, 77, 29);
		frmGroupChat.getContentPane().add(sendC);
	}
	
	private void menus() {
		menuA = new JComboBox();
		menuA.setModel(new DefaultComboBoxModel(new String[] {"Group1", "Group2"}));
		menuA.setBounds(164, 244, 102, 27);
		frmGroupChat.getContentPane().add(menuA);
		
		menuC = new JComboBox();
		menuC.setModel(new DefaultComboBoxModel(new String[] {"Group1", "Group2"}));
		menuC.setBounds(165, 509, 101, 27);
		frmGroupChat.getContentPane().add(menuC);
	}
	
	private void lables() {
		lblUserA = new JLabel("User A");
		lblUserA.setBounds(23, 12, 61, 16);
		frmGroupChat.getContentPane().add(lblUserA);
		
		lblUserB = new JLabel("User B");
		lblUserB.setBounds(419, 12, 61, 16);
		frmGroupChat.getContentPane().add(lblUserB);
		
		lblUserC = new JLabel("User C");
		lblUserC.setBounds(23, 277, 61, 16);
		frmGroupChat.getContentPane().add(lblUserC);
	}
	
	private void information() {
		infoTA = new JTextArea();
		infoTA.setText(" Group 1: User A, User B, User C\n Group 2: User A, User C");
		infoTA.setEditable(false);
		infoTA.setBounds(470, 385, 204, 40);
		frmGroupChat.getContentPane().add(infoTA);
	}
}
