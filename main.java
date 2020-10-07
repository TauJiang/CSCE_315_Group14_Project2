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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

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
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 7;
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Download to File");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 14;
		gbc_rdbtnNewRadioButton.gridy = 6;
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setText( "Hello" );
		StyledDocument doc = textPane.getStyledDocument();
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 7;
		gbc_button.gridy = 5;
		JButton button = new JButton("Search");
		
		frame.getContentPane().add(button, gbc_button);
		
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
		
		
		
		JButton qbutton1 = new JButton("Question 1");
		GridBagConstraints gbc_qbutton1 = new GridBagConstraints();
		gbc_qbutton1.insets = new Insets(0, 0, 5, 5);
		gbc_qbutton1.gridx = 2;
		gbc_qbutton1.gridy = 8;
		frame.getContentPane().add(qbutton1, gbc_qbutton1);
		qbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q1r1 = JOptionPane.showInputDialog(frame, "please input first restaurant");
				String q1r2 = JOptionPane.showInputDialog(frame, "please input second restaurant");
				//call function with given city values
				ArrayList<String> q1 = question1(q1r1, q1r2);
				System.err.println(question1(q1r1, q1r2));
				String output = "Patrons: ";
				for (String temp: q1){
					output += temp+ " ";
				}
				textPane.setText(output);
			}
		});
		
		JButton qbutton2 = new JButton("Question 2");
		GridBagConstraints gbc_qbutton2 = new GridBagConstraints();
		gbc_qbutton2.insets = new Insets(0, 0, 5, 5);
		gbc_qbutton2.gridx = 4;
		gbc_qbutton2.gridy = 8;
		frame.getContentPane().add(qbutton2, gbc_qbutton2);
		qbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q2user = JOptionPane.showInputDialog(frame, "please input user");
				//String q2query = ("SELECT * FROM review WHERE user_id=\'"+ q2user +"\'");
				System.err.println(q2user);
				textPane.setText(question2(q2user));
			}
		});
		
		JButton qbutton3 = new JButton("Question 3");
		GridBagConstraints gbc_qbutton3 = new GridBagConstraints();
		gbc_qbutton3.insets = new Insets(0, 0, 5, 5);
		gbc_qbutton3.gridx = 7;
		gbc_qbutton3.gridy = 8;
		frame.getContentPane().add(qbutton3, gbc_qbutton3);
		qbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q3state = JOptionPane.showInputDialog(frame, "please input state");
				textPane.setText(question3(q3state));
			}
		});
		
		JButton qbutton4 = new JButton("Question 4");
		GridBagConstraints gbc_qbutton4 = new GridBagConstraints();
		gbc_qbutton4.insets = new Insets(0, 0, 5, 5);
		gbc_qbutton4.gridx = 10;
		gbc_qbutton4.gridy = 8;
		frame.getContentPane().add(qbutton4, gbc_qbutton4);
		qbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q4city = JOptionPane.showInputDialog(frame, "please input city");
				//call function with given city values
				textPane.setText(question4(q4city));
			}
		});
		
		JButton qbutton5 = new JButton("Question 5");
		GridBagConstraints gbc_qbutton5 = new GridBagConstraints();
		gbc_qbutton5.insets = new Insets(0, 0, 5, 5);
		gbc_qbutton5.gridx = 14;
		gbc_qbutton5.gridy = 8;
		frame.getContentPane().add(qbutton5, gbc_qbutton5);
		qbutton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q5code = JOptionPane.showInputDialog(frame, "please input zip code");
				//call function with given city values
				textPane.setText(question5(q5code));
			}
		});
		
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.gridwidth = 14;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 2;
		gbc_textPane.gridy = 12;
		frame.getContentPane().add(textPane, gbc_textPane);
		
		
		
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
	public static Connection Conn(){
        Connection conn = null;
        dbSetup my = new dbSetup();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
                my.user, my.pswd);
            } catch (Exception e1) {
            e1.printStackTrace();
            System.err.println(e1.getClass().getName()+": "+e1.getMessage());
            System.exit(0);
            }//end try catch
        return conn;
    }
    public static ArrayList<String> query(String sqlStatement, Connection conn){
		ArrayList<String> data = new ArrayList<String>();
		try{
		//create a statement object
			Statement stmt = conn.createStatement();
			//create an SQL statement
		//System.err.println(sqlStatement);
		ResultSet result = stmt.executeQuery(sqlStatement);;
		//System.out.println("______________________________________");
		
		ResultSetMetaData rsmd = result.getMetaData();
		//System.out.println("querying" );
		int columnsNumber = rsmd.getColumnCount();
		
		while (result.next()) {
			//System.out.println(result.getString("cus_lname"));
			//output += result.getString(keyword)+"\n";
			//System.err.println(output);
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1) System.out.print(",  ");
				String columnValue = result.getString(i);
				data.add(columnValue);
			}
			//System.out.println("");
		}
		} catch (Exception e1){
		}
		return data;
	}

	//get all the users that comments for the restaurant
	public static ArrayList<String> getBus(String user_id, Connection conn){
		String sqlStatement = "SELECT business_id FROM review where user_id=\'" + user_id
		+ '\'';
		return query(sqlStatement, conn);
	}
	public static ArrayList<String> getUser(String business_id, Connection conn){
		String sqlStatement = "SELECT user_id FROM review where business_id=\'" + business_id
		+ '\'';
		return query(sqlStatement, conn);
    }
    
	public static ArrayList<String> question1 (String rest1, String rest2){
        ArrayList<Hashtable<String, ArrayList<String>>> level 
        = new ArrayList<Hashtable<String, ArrayList<String>>>();

        Connection conn = Conn();
		String rest1_id = query("SELECT business_id FROM business WHERE name=\'" + rest1
		+ "\';", conn).get(0);
		String rest2_id = query("SELECT business_id FROM business WHERE name=\'" + rest2
        + "\';", conn).get(0);
        System.err.println(rest2_id);
		ArrayList<String> rest1_user = getUser(rest1_id, conn);
		ArrayList<String> rest1_bus = new ArrayList<String>();
		//ArrayList<String> rest2_user = getUser(rest2_id);
		//ArrayList<String> used_rest = new ArrayList<String>();
		//ArrayList<String> used_user = new ArrayList<String>();
		Hashtable<String, Integer> userdict = new Hashtable<String, Integer>();
		Hashtable<String, Integer> busdict = new Hashtable<String, Integer>();
		for (int i = 0; i < 100; i++){
            level.add(new Hashtable<String, ArrayList<String>>());
            //level.get(i);
			rest1_bus = new ArrayList<String>();
			for (String uid : rest1_user){
                //System.err.println("UID");
				if (!userdict.containsKey(uid)){
                    userdict.put(uid, 1);
                    ArrayList<String> bustemp = getBus(uid, conn);
                    level.get(2*i).put(uid, bustemp);
					rest1_bus.addAll(0, bustemp);
				}
            }
            level.add(new Hashtable<String, ArrayList<String>>());
			rest1_user = new ArrayList<String>();
			for (String bid: rest1_bus){
                //System.err.println("BID");
                //System.err.println(bid);
                //System.err.println(bid.equals(rest2_id));
                if (bid.equals(rest2_id)){
                    System.err.println("found");
                    ArrayList<String> found = new ArrayList<String>();
                    System.err.println(rest2_id);
                    found.add(rest2_id);
                    String child = rest2_id;
                    for (int j = 2*i; j >=0; j--){
                        Enumeration<String> level2 = level.get(j).keys();
                        for (String l2: Collections.list(level2)){
                            if (level.get(j).get(l2).contains(child)){
                                System.err.println(l2);
                                found.add(l2);
                                child = l2;
                            }
                        }
                    }
                    ArrayList<String> names = new ArrayList<String>();
                    for (String name: found){
                        try{
                            String nametmp = query("SELECT name FROM customer WHERE user_id = \'" + name + "\'", conn).get(0);
                            names.add(nametmp);
                        }
                        catch(Exception e1){
                            System.err.println("no such user name");
                        }
                    }
                    return names;
                }
				if (!busdict.containsKey(bid)){
                    busdict.put(bid, 1);
                    ArrayList<String> usetemp = getBus(bid, conn);
                    level.get(2*i+1).put(bid, usetemp);
					rest1_user.addAll(0, usetemp);
				}
			}
		}
		return null;
	}
	public static String question2(String user_id) {
		dbSetup my = new dbSetup();
    //Building the connection
     Connection conn = null;
     try {
        //Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
          "jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
           my.user, my.pswd);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }//end try catch
     System.out.println("Opened database successfully");
     String output = "";
     try{
     //create a statement object
       Statement stmt = conn.createStatement();
	   //create an SQL statement
	   //System.err.println("got resul3");
	   String sqlStatement = "SELECT * FROM review1 WHERE user_id=\'"+ user_id +"\';";
	   //System.err.println("got result2");
       //String sqlStatement2 = "SELECT * FROM customer WHERE user_id=\'"+ user_id +"\';";
       //send statement to DBMS
	   ResultSet result = stmt.executeQuery(sqlStatement);
	   System.err.println("got result");
	   //ResultSet result2 = stmt.executeQuery(sqlStatement2);
	   System.err.println("got result");
       ResultSetMetaData rsmd = result.getMetaData();
	   //ResultSetMetaData rsmd2 = result2.getMetaData();
	   System.err.println("got result");
       
       String user_name;
       double avg = 0;
       int funny = 0;
       int cool = 0;
       int useful = 0;
       String summary;
       System.err.println("got result5");
       //OUTPUT
       while (result.next()) {
		System.err.println(result.getString(7));
		System.err.println("got result7");
    	useful = useful + Integer.parseInt(result.getString(7));
    	funny = funny + Integer.parseInt(result.getString(8));
		cool = cool + Integer.parseInt(result.getString(9));
		System.err.println(useful);
	   }
	   System.err.println("got result1");
	   
       
       if ((funny > cool) & (funny > useful))
       {
    	   summary = "funny";
       }
       else if (cool > useful)
       {
    	   summary = "cool";
       }
       else
       {
    	   summary = "useful";
       }
	   String sqlStatement2 = "SELECT * FROM customer WHERE user_id=\'"+ user_id +"\';";
	   ResultSet result2 = stmt.executeQuery(sqlStatement2);
	   ResultSetMetaData rsmd2 = result2.getMetaData();
	   result2.next();
       user_name = result2.getString(2);
       avg = Double.parseDouble(result2.getString(8));
       output = "user: " + user_name+  "\n average stars: " + avg + "\n summary: " + summary + "\n";
       return output;
   } catch (Exception e){
     System.out.println("Error accessing Database.");
   }
    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
      System.out.println("Connection NOT Closed.");
    }//end try catch
    return output;
  }//end main

  public static String question3(String state) {
    dbSetupExample my = new dbSetupExample();
    //Building the connection
     Connection conn = null;
     try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
           my.user, my.pswd);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }//end try catch
     System.out.println("Opened database successfully");
     String outputs = "";
     try{
     //create a statement object
       Statement stmt = conn.createStatement();
       Statement stmt2 = conn.createStatement();
       //create an SQL statement
       String sqlStatement = "SELECT * FROM business WHERE business_id IN (SELECT business_id FROM address WHERE state='" + state + "') AND name IN (SELECT name FROM business GROUP BY name HAVING COUNT(*)>1) ORDER BY name;";
       //send statement to DBMS
       ResultSet result = stmt.executeQuery(sqlStatement);
       ResultSet result2;
	   
	   result.next();
       String franchise = result.getString(2);
	   //String franchiseMax;
	 
       String curFranMax;
       double currentMax=0;
       double distanceMax=0;
       double avg = 0;
       Vector<Double> latitudes = new Vector<Double>();
       Vector<Double> longitudes = new Vector<Double>();
       Vector<Double> stars = new Vector<Double>();
   
       Vector<String> franchiseMax = new Vector<String>();
       Vector<Double> maxValues = new Vector<Double>();
       //System.out.println("______________________________________");
       while (result.next()) {
		System.err.println(result.getString(2));
		System.err.println(franchise);
	
    	   if (!result.getString(2).equals(franchise))
    	   {
    		   for (int i = 0; i < latitudes.size(); ++i)
    		   {
				
				   avg=avg+stars.get(i);
				  
    			   for (int j = i; j < latitudes.size(); ++j)
    			   {
					
					double temp = ((latitudes.get(i) - latitudes.get(j))*(latitudes.get(i) - latitudes.get(j)) + (longitudes.get(i) - longitudes.get(j))*(longitudes.get(i) - longitudes.get(j)));
					System.err.println(temp);
    				   if (temp >= currentMax)
    				   {
    					   currentMax = temp;
    				   }
    			   }
			   }
			 
    		   if ((currentMax >= distanceMax) & ((avg/stars.size()) >= 3.5 ));
    		   {
			
    			   distanceMax = currentMax;
    			   maxValues.add(distanceMax);
    			   franchiseMax.add(franchise);
    		   }
    		   stars.clear();
    		   latitudes.clear();
    		   longitudes.clear();
    		   currentMax = 0;
    		   avg = 0;
    		   franchise = result.getString(2);
    		  
		   }
	
		   result2 = stmt2.executeQuery("Select * from address WHERE business_id='" + result.getString(1) + "';");
		   result2.next();
		
			latitudes.add(result2.getDouble(6));
			longitudes.add(result2.getDouble(7));
			System.err.println("latiutude");
			System.err.println(latitudes);
			System.err.println("longitudes");
			System.err.println(longitudes);
		   
		stars.add(result.getDouble(3));

       }
       
       for (int i = maxValues.size()-6; i < maxValues.size(); ++i)
       {
    	   outputs = outputs + "franchise: " + franchiseMax.get(i) + " distance: " + maxValues.get(i) + "\n";
       }
	   //System.err.println(outputs);

       return outputs;
   } catch (Exception e){
	System.out.println("Error accessing Database.");
   }
   //JOptionPane.showMessageDialog(null,outputs);
    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
		System.out.println("Connection NOT Closed.");
    }//end try catch
    return outputs;
  }//end main
  public static int max(int tipA, int tipB) {
	if(tipA > tipB) {
		return tipA;
	}
	else
		return tipB;
}
  public static String question4(String _city) {
    dbSetup my = new dbSetup();
    //Building the connection
     Connection conn = null;
     try {
        //Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
          "jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
           "ol2109", "827003841");
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }//end try catch
     System.out.println("Opened database successfully");
     String output = "";
     String bus_id = "";
     try{
     //create a statement object
	   Statement stmt = conn.createStatement();
	   Statement stmt2 = conn.createStatement();
	   Statement stmt3 = conn.createStatement();
	   Statement stmt4 = conn.createStatement();
       //create an SQL statement
       String sqlStatement = "SELECT * FROM business WHERE business_id IN (SELECT business_id FROM address WHERE city='"+ _city+"') AND name IN (SELECT DISTINCT name FROM business) INTERSECT SELECT * FROM business WHERE name IN (SELECT name FROM business GROUP BY name HAVING COUNT(*) = '1');"; //Gets distinct values from business
       ResultSet result = stmt.executeQuery(sqlStatement);
	   System.out.println("gotresult1");
       //ResultSetMetaData rsmd = result.getMetaData();

       String business_id ="";
       int tipCount = -1; //Will save biggest value
       String MaxBusiness = "";
       while (result.next()) { //Determines best restaurant
    	business_id = result.getString(1);
        ResultSet result2 = stmt2.executeQuery("SELECT COUNT(business_id) FROM tip WHERE business_id='"+business_id+"\';");
	   // ResultSetMetaData rsmd2 = result2.getMetaData();
	   
	   result2.next();
	
		tipCount = max(tipCount,result2.getInt(1)); //Set tip count to the max
		
		if(result2.getInt(1) == tipCount) { //Determine who receives the most tips
		
        	MaxBusiness = business_id;
		}

       }
	   //Run 3 queries or another while loop + if statement

	   ResultSet result_final = stmt3.executeQuery("SELECT name FROM business WHERE business_id='"+MaxBusiness+"\';");

	   result_final.next();
       String name = result_final.getString(1);
       String text ="";
       int tipCount_temp = tipCount;
       output = name +" number of tips: " + tipCount+"\n"; 
	   /***If getting Actual text of tip****/
	
       ResultSet resultTip = stmt4.executeQuery("SELECT text FROM tip WHERE business_id='"+MaxBusiness+"';");
       while(resultTip.next()) {
    	   text = resultTip.getString(1);
    	   output += "Tip #"+tipCount_temp+" "+text+"\n";
    	   tipCount_temp--;
       }

   } catch (Exception e){
     System.out.println("Error accessing Database.");
   }
    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
      System.out.println("Connection NOT Closed.");
    }//end try catch
    return output;
  }//end main


  public static String question5(String code) {
    dbSetupExample my = new dbSetupExample();
    //Building the connection
     Connection conn = null;
     try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/project2_group14",
           my.user, my.pswd);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }//end try catch
     System.out.println("Opened database successfully");
     String outputs = "";
     try{
     //create a statement object
       Statement stmt = conn.createStatement();
       Statement stmt2 = conn.createStatement();
       //create an SQL statement
       String sqlStatement = "SELECT * FROM business WHERE business_id IN (SELECT business_id FROM address WHERE postal_code='" + code + "') AND name IN (SELECT DISTINCT name FROM business) INTERSECT SELECT * FROM business WHERE name IN (SELECT name FROM business GROUP BY name HAVING COUNT(*)>1) ORDER BY name;";
       //send statement to DBMS
       ResultSet result = stmt.executeQuery(sqlStatement);
       ResultSet result2;
		result.next();
       String franchise = result.getString(2);
       //String franchiseMax;
       String franchiseMax = "";
       double currentMax=0;
       double distanceMax=0;
       double reviews = 0;
      
       Vector<Double> latitudes = new Vector<Double>();
       Vector<Double> longitudes = new Vector<Double>();
       Vector<Double> tips = new Vector<Double>();
	   //System.out.println("______________________________________");
	   //System.out.println("1");
       while (result.next()) {
		//System.out.println("2");
    	   if (!result.getString(2).equals(franchise))
    	   {
				System.out.println(result.getString(2));
				System.out.println(franchise);
    		   for (int i = 0; i < latitudes.size(); ++i)
    		   {
    			   reviews=reviews+tips.get(i);
    			   for (int j = i; j < latitudes.size(); ++j)
    			   {
    				   if (((latitudes.get(i) - latitudes.get(j))*(latitudes.get(i) - latitudes.get(j)) + (longitudes.get(i) - longitudes.get(j))*(longitudes.get(i) - longitudes.get(j))) >= currentMax)
    				   {
    					   currentMax = ((latitudes.get(i) - latitudes.get(j))*(latitudes.get(i) - latitudes.get(j)) + (longitudes.get(i) - longitudes.get(j))*(longitudes.get(i) - longitudes.get(j)));
    				   }
    			   }
    		   }System.out.println("3");
    		   if ((currentMax >= distanceMax) & ((reviews) >= 50 ) & (latitudes.size() >= 3));
    		   {
    			   distanceMax = currentMax;
    			   franchiseMax = franchise;
    		   }
    		   tips.clear();
    		   latitudes.clear();
    		   longitudes.clear();
    		   currentMax = 0;
    		   reviews = 0;
    		   franchise = result.getString(2);
    		  
    	   }//System.out.println("4");
		   result2 = stmt2.executeQuery("Select * from address WHERE business_id='" + result.getString(1) + "';");
		   result2.next();
    	   latitudes.add(result2.getDouble(6));
    	   longitudes.add(result2.getDouble(7));
    	   tips.add(result.getDouble(3));
       }
       System.out.println("5");
       outputs = "franchiseMax "+ franchiseMax;
       System.err.println(outputs);
       return outputs;
   } catch (Exception e){
	System.out.println("Error accessing Database.");
   }
   //JOptionPane.showMessageDialog(null,outputs);
    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
		System.out.println("Connection NOT Closed.");
    }//end try catch
    return outputs;
  }//end main
}