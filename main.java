import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.lang.String;
import java.io.*;

import java.awt.FlowLayout;
import java.awt.Font;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;

public class main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 889, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{21, 28, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		String[] options = {"Select one", "Business", "Address", "Customer", "CheckIn", "Review", "Parking", "Tip"};
		String[] command = {"Select one", "FOR", "WHEN", "FROM"};
		
		JTextPane txtpnBusinessSearcher = new JTextPane();
		txtpnBusinessSearcher.setEditable(false);
		txtpnBusinessSearcher.setBackground(SystemColor.control);
		txtpnBusinessSearcher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnBusinessSearcher.setText("Business Searcher");
		GridBagConstraints gbc_txtpnBusinessSearcher = new GridBagConstraints();
		gbc_txtpnBusinessSearcher.anchor = GridBagConstraints.NORTH;
		gbc_txtpnBusinessSearcher.gridwidth = 5;
		gbc_txtpnBusinessSearcher.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnBusinessSearcher.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnBusinessSearcher.gridx = 7;
		gbc_txtpnBusinessSearcher.gridy = 0;
		frame.getContentPane().add(txtpnBusinessSearcher, gbc_txtpnBusinessSearcher);
		
		JTextPane txtpnPleaseEnterKeyword = new JTextPane();
		txtpnPleaseEnterKeyword.setEditable(false);
		txtpnPleaseEnterKeyword.setBackground(SystemColor.control);
		txtpnPleaseEnterKeyword.setText("Please enter keyword");
		txtpnPleaseEnterKeyword.setToolTipText("");
		GridBagConstraints gbc_txtpnPleaseEnterKeyword = new GridBagConstraints();
		gbc_txtpnPleaseEnterKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnPleaseEnterKeyword.fill = GridBagConstraints.BOTH;
		gbc_txtpnPleaseEnterKeyword.gridx = 2;
		gbc_txtpnPleaseEnterKeyword.gridy = 1;
		frame.getContentPane().add(txtpnPleaseEnterKeyword, gbc_txtpnPleaseEnterKeyword);
		
		JTextPane txtpnCommand = new JTextPane();
		txtpnCommand.setEditable(false);
		txtpnCommand.setBackground(SystemColor.control);
		txtpnCommand.setText("Command");
		GridBagConstraints gbc_txtpnCommand = new GridBagConstraints();
		gbc_txtpnCommand.gridwidth = 2;
		gbc_txtpnCommand.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnCommand.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnCommand.gridx = 4;
		gbc_txtpnCommand.gridy = 1;
		frame.getContentPane().add(txtpnCommand, gbc_txtpnCommand);
		
		JTextPane txtpnParameter = new JTextPane();
		txtpnParameter.setEditable(false);
		txtpnParameter.setBackground(SystemColor.control);
		txtpnParameter.setText("Parameter");
		GridBagConstraints gbc_txtpnParameter = new GridBagConstraints();
		gbc_txtpnParameter.anchor = GridBagConstraints.NORTH;
		gbc_txtpnParameter.gridwidth = 3;
		gbc_txtpnParameter.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnParameter.gridx = 8;
		gbc_txtpnParameter.gridy = 1;
		frame.getContentPane().add(txtpnParameter, gbc_txtpnParameter);
		
		JTextPane txtpnPleaseSpecifyType = new JTextPane();
		txtpnPleaseSpecifyType.setEditable(false);
		txtpnPleaseSpecifyType.setText("Please specify type");
		txtpnPleaseSpecifyType.setBackground(SystemColor.control);
		GridBagConstraints gbc_txtpnPleaseSpecifyType = new GridBagConstraints();
		gbc_txtpnPleaseSpecifyType.gridwidth = 3;
		gbc_txtpnPleaseSpecifyType.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnPleaseSpecifyType.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnPleaseSpecifyType.gridx = 14;
		gbc_txtpnPleaseSpecifyType.gridy = 1;
		frame.getContentPane().add(txtpnPleaseSpecifyType, gbc_txtpnPleaseSpecifyType);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setColumns(10);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(textField, popupMenu_1);
		

		
		JComboBox comboBox_1 = new JComboBox(command);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 2;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 2;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		

		JComboBox comboBox = new JComboBox(options);
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 14;
		gbc_comboBox.gridy = 2;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		comboBox.setSelectedIndex(0);
		comboBox.setSelectedIndex(0);
		
		JTextPane textPane = new JTextPane();
		textPane.setText( "Hello" );
		StyledDocument doc = textPane.getStyledDocument();
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 9;
		gbc_button.gridy = 6;
		JButton button = new JButton("Search");
		
		frame.getContentPane().add(button, gbc_button);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Download to File");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 14;
		gbc_rdbtnNewRadioButton.gridy = 8;
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.gridwidth = 14;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 2;
		gbc_textPane.gridy = 12;
		frame.getContentPane().add(textPane, gbc_textPane);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) comboBox.getEditor().getItem();
				String command = (String) comboBox_1.getEditor().getItem();
				String keyword = (String) textField.getText();
				String parameter = (String) textField_2.getText();
				String combine = "SELECT " + keyword + " " + command + " " + type + " " + parameter + ";";
				String query = "not develop";
				String output = "";
				
				dbSetup my = new dbSetup();
			    //Building the connection
			     Connection conn = null;
			     try {
			        Class.forName("org.postgresql.Driver");
			        conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
			           my.user, my.pswd);
			     } catch (Exception e1) {
			        e1.printStackTrace();
			        System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			        System.exit(0);
			     }//end try catch
			     
			     try{
			     //create a statement object
			    	 Statement stmt = conn.createStatement();
			         //create an SQL statement
			       String sqlStatement = combine;
			       System.err.println(sqlStatement);
			       ResultSet result = stmt.executeQuery(sqlStatement);;
			       //System.out.println("______________________________________");
			       
			       ResultSetMetaData rsmd = result.getMetaData();
			       //System.out.println("querying" + combine);
			       int columnsNumber = rsmd.getColumnCount();
			       if (rdbtnNewRadioButton.isSelected())
			       {
			    	   try
			    	   {
			    		   BufferedWriter out = new BufferedWriter(new FileWriter("output.csv"));
			    		   for (int i =1; i <= columnsNumber; i++) {
			    			   out.write(rsmd.getColumnName(i));
			    			   out.write(',');
			    		   }
			    		   out.write("\n");

			    		   while (result.next()) {
			    				
					    	   for (int i = 1; i <= columnsNumber; i++) {
					               out.write("\"" + result.getString(i) + "\"");
					               out.write(',');
					           }
					           out.write("\n");
					       }
			    		   out.close();
			    	   }
			    	   
			    	   catch(IOException e4){
			    		  
			    	   }
			       }
			       while (result.next()) {
		
			    	   for (int i = 1; i <= columnsNumber; i++) {
			               String columnValue = result.getString(i);
			               output += rsmd.getColumnName(i) + " " + columnValue + " ";

			           }
			    	   output += "\n";
			           //System.out.println("");
			       }	
			       if (!rdbtnNewRadioButton.isSelected())
			       {
			    	   textPane.setText(output);
			       }

			   } catch (Exception e1){
				   try {
					doc.insertString(doc.getLength(), "Problem\n", null );
				} catch (BadLocationException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			   }
				
				
				
			}
		});
		
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}