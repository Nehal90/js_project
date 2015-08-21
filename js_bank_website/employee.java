import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.sql.*;
import java.net.*;

class employeePanel extends JPanel
   implements ActionListener
{
   public employeePanel(Connection connection)  //constructor for this class
   {
      con=connection; //accept database connection created in employeeFrame class
      nameLabel = new JLabel("Name:");  //initializing the LABELS and add them to panels
      JPanel namePanel = new JPanel();
      namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      namePanel.add(nameLabel);

      idLabel = new JLabel("ID Number:");
      JPanel idPanel = new JPanel();
      idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      idPanel.add(idLabel);

      addressLabel = new JLabel("Address:");
      JPanel addressPanel = new JPanel();
      addressPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      addressPanel.add(addressLabel);

      city_state_zipLabel = new JLabel("City/State/Zip:");
      JPanel city_state_zipPanel = new JPanel();
      city_state_zipPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      city_state_zipPanel.add(city_state_zipLabel);

      hireDateLabel = new JLabel("Hire Date:");
      JPanel hireDatePanel = new JPanel();
      hireDatePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      hireDatePanel.add(hireDateLabel);

      jobTitleLabel = new JLabel("Job Title:");
      JPanel jobTitlePanel = new JPanel();
      jobTitlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      jobTitlePanel.add(jobTitleLabel);

      nameText = new JTextField(30);  //initializing the Textfields and add them to panels
      JPanel namePanel1 = new JPanel();
      namePanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      namePanel1.add(nameText);

      idText = new JTextField(30);
      JPanel idPanel1 = new JPanel();
      idPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      idPanel1.add(idText);

      addressText = new JTextField(30);
      JPanel addressPanel1 = new JPanel();
      addressPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      addressPanel1.add(addressText);

      hireDateText = new JTextField(30);
      JPanel hireDatePanel1 = new JPanel();
      hireDatePanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      hireDatePanel1.add(hireDateText);

      jobTitleText = new JTextField(30);
      JPanel jobTitlePanel1 = new JPanel();
      jobTitlePanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      jobTitlePanel1.add(jobTitleText);

      cityText = new JTextField(10);
      zipText = new JTextField(8);
      stateComboBox = new JComboBox(); //initializing the ComboBox
      stateComboBox.setEditable (true);
      stateComboBox.addItem("Choose a State");
      stateComboBox.addItem("AL");
      stateComboBox.addItem("AK");
      stateComboBox.addItem("AZ");
      stateComboBox.addItem("AR");
      stateComboBox.addItem("CA");
      stateComboBox.addItem("CO");
      stateComboBox.addItem("CT");
      stateComboBox.addItem("DE");
      stateComboBox.addItem("FL");
      stateComboBox.addItem("GA");
      stateComboBox.addItem("HI");
      stateComboBox.addItem("ID");
      stateComboBox.addItem("IL");
      stateComboBox.addItem("IN");
      stateComboBox.addItem("IA");
      stateComboBox.addItem("KS");
      stateComboBox.addItem("KY");
      stateComboBox.addItem("LA");
      stateComboBox.addItem("ME");
      stateComboBox.addItem("MD");
      stateComboBox.addItem("MA");
      stateComboBox.addItem("MI");
      stateComboBox.addItem("MN");
      stateComboBox.addItem("MS");
      stateComboBox.addItem("MO");
      stateComboBox.addItem("MT");
      stateComboBox.addItem("NE");
      stateComboBox.addItem("NV");
      stateComboBox.addItem("NH");
      stateComboBox.addItem("NJ");
      stateComboBox.addItem("NM");
      stateComboBox.addItem("NY");
      stateComboBox.addItem("NC");
      stateComboBox.addItem("ND");
      stateComboBox.addItem("OH");
      stateComboBox.addItem("OK");
      stateComboBox.addItem("OR");
      stateComboBox.addItem("PA");
      stateComboBox.addItem("RI");
      stateComboBox.addItem("SC");
      stateComboBox.addItem("SD");
      stateComboBox.addItem("TN");
      stateComboBox.addItem("TX");
      stateComboBox.addItem("UT");
      stateComboBox.addItem("VT");
      stateComboBox.addItem("VA");
      stateComboBox.addItem("WA");
      stateComboBox.addItem("WV");
      stateComboBox.addItem("WI");
      stateComboBox.addItem("WY");
   
      Box vb1 = Box.createVerticalBox();  //add the label panels to a vertical box
      vb1.add(namePanel);
      vb1.add(idPanel);
      vb1.add(addressPanel);
      vb1.add(city_state_zipPanel);
      vb1.add(hireDatePanel);
      vb1.add(jobTitlePanel);

      JPanel q = new JPanel();  //add cityText, stateComboBox and zipText to one panel
      q.setLayout(new FlowLayout(FlowLayout.LEFT));
      q.add(cityText);
      q.add(stateComboBox);
      q.add(zipText);

      Box vb2 = Box.createVerticalBox(); //add the textfield panels to a vertical box
      vb2.add(namePanel1);
      vb2.add(idPanel1);
      vb2.add(addressPanel1);
      vb2.add(q);
      vb2.add(hireDatePanel1);
      vb2.add(jobTitlePanel1);

      Box b = Box.createHorizontalBox(); //add the label box and textfield box to a
      b.add(vb1);                        //horizontal box
      b.add(vb2);

      newButton = new JButton("New");  //initializing buttons and setting their mnemonics
      newButton.setMnemonic('N');
      searchButton = new JButton("Search");
      searchButton.setMnemonic('S');
      saveButton = new JButton("Save");
      saveButton.setMnemonic('a');
      cancelButton = new JButton("Cancel");
      cancelButton.setMnemonic('C');
      exitButton = new JButton("Exit");
      exitButton.setMnemonic('E');

      JPanel buttonPanel = new JPanel(); //add the buttons to a panel
      buttonPanel.add(newButton);
      buttonPanel.add(searchButton);
      buttonPanel.add(saveButton);
      buttonPanel.add(cancelButton);
      buttonPanel.add(exitButton);

      //create an etched and titled border for the buttonPanel
      Border etched = BorderFactory.createEtchedBorder();
      Border titled = BorderFactory.createTitledBorder(etched, "Operations");
      buttonPanel.setBorder(titled);

      newButton.addActionListener(this); //register the objects of this class as 
      searchButton.addActionListener(this); //event listeners to these buttons
      saveButton.addActionListener(this);
      cancelButton.addActionListener(this);
      exitButton.addActionListener(this);

      add(b);  //add label and text box and button panel to this panel
      add(buttonPanel); 

      //set a raised border for this employeePanel
      Border raised = BorderFactory.createRaisedBevelBorder();
      setBorder(raised);  
   }

   public void actionPerformed(ActionEvent evt)  //event handling method
   {
      //Object source = evt.getSource();
      String arg = evt.getActionCommand(); //an event could be from a button click or
      if (arg.equals("New")) clean();     //a menu item selection
      else if (arg.equals("Search"))
           {
               JFrame parent = new employeeFrame();
               JDialog dialog = new searchDialog(parent);
               dialog.show();
           }
           else if (arg.equals("Save")) save();
                else if (arg.equals("Cancel")) clean();
                     else if (arg.equals("Exit"))
                          {   
                             try  //close database connection
                             {   con.close();
                             } 
                             catch (java.sql.SQLException e)
                             {   System.out.println("Cannot close connection");       
                             }
                             System.exit(0);
                          };

   }

   public void save()
   {   try 
        {   Statement stmt = con.createStatement();  
            String command = "INSERT INTO EMPLOYEE "+ //prepare a SQL statement
                             " VALUES ('" + idText.getText() + "', '" + 
                                          nameText.getText() + "', '" +
                                          addressText.getText() + "', '" +
                                          cityText.getText() + "', '" +
                                          stateComboBox.getSelectedItem() + "', '" +
                                          zipText.getText() + "', '" + 
                                          hireDateText.getText() + "', '" + 
                                          jobTitleText.getText() + "')"; 
           stmt.executeUpdate(command);  //execute the SQL statement
           stmt.close();  //close SQL statement
       }
       catch(java.sql.SQLException e) //handle exceptions 
	 {  System.out.println("SQLException:");
            while (e != null)
            {   System.out.println("SQLState: " + e.getSQLState());
               System.out.println("Message: " + e.getMessage());
               System.out.println("Vendor: " + e.getErrorCode());
               e = e.getNextException();
               System.out.println("");
            }
       }
       catch (java.lang.Exception e)
       {   System.out.println("Exception: " + e);
           e.printStackTrace ();
       } 
   }

   public void clean()
   {   idText.setText("");
       nameText.setText("");
       addressText.setText("");
       cityText.setText("");
       stateComboBox.setSelectedItem("Choose a State");
       zipText.setText("");
       hireDateText.setText("");
       jobTitleText.setText("");
   }  

   public void search(String c, String v)
   {   clean();
       String condition = c + "='" + v +"'";
       try 
       {   Statement stmt = con.createStatement();
           String command = "SELECT * FROM EMPLOYEE WHERE " + condition;
           ResultSet results = stmt.executeQuery(command);
           int number = 0;
           while(results.next())
           {   idText.setText(results.getString(1));
               nameText.setText(results.getString(2));
               addressText.setText(results.getString(3));
               cityText.setText(results.getString(4));
               stateComboBox.setSelectedItem(results.getString(5));
               zipText.setText(results.getString(6));
               hireDateText.setText(results.getString(7)); 
               jobTitleText.setText(results.getString(8));
               number++;
            }
            if (number == 0) 
               JOptionPane.showMessageDialog(this, "Data Not Found!", 
                   "Search Report", JOptionPane.INFORMATION_MESSAGE);
            results.close();
            stmt.close();
        }
        catch(java.sql.SQLException e)
	  {   System.out.println("SQLException:");
            while (e != null)
            {   System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }
        catch (java.lang.Exception e)
        {   System.out.println("Exception: " + e);
            e.printStackTrace ();
        } 
    }

   //define an inner class searchDialog in order to get search value
   //this class demonstrates how to define a dialog
   private class searchDialog extends JDialog
      implements ActionListener
   {
      public searchDialog(JFrame parent)  //constructor
      {
         super(parent, "Search Dialog", true);
         setSize(360, 150);
         setLocation( 332, 250);

         searchValueText = new JTextField(20);
         searchKeyLabel = new JLabel("Search Key:");
         JPanel p1 = new JPanel();
         p1.add(searchKeyLabel);
         p1.add(searchValueText);

         ButtonGroup group = new ButtonGroup();  //declare and initialize a button group

         rb1 = new JRadioButton("ID No."); //initializing 4 radiobuttons
         rb1.setActionCommand("ID No.");
         rb1.setSelected(true);
         rb2 = new JRadioButton("Name");
         rb2.setActionCommand("Name");
         rb3 = new JRadioButton("Hire Date");
         rb3.setActionCommand("Hire Date");
         rb4 = new JRadioButton("Title");
         rb4.setActionCommand("Title");

         group.add(rb1);  //add these radiobuttons to the button group
         group.add(rb2);
         group.add(rb3);
         group.add(rb4);

         JPanel p2 = new JPanel(); //add these radiobuttons to the panel
         p2.add(rb1);
         p2.add(rb2);
         p2.add(rb3);
         p2.add(rb4);

         okButton = new JButton("Ok");
         cancelButton = new JButton("Cancel");
         JPanel p3 = new JPanel();
         p3.add(okButton);
         p3.add(cancelButton);

         Box b = Box.createVerticalBox();
         b.add(p1);
         b.add(p2);
         b.add(p3);
 
         rb1.addActionListener(this);
         rb2.addActionListener(this);
         rb3.addActionListener(this);
         rb4.addActionListener(this);
         okButton.addActionListener(this);
         cancelButton.addActionListener(this);

         Container contentPane = getContentPane(); //add a component to a dialog 
         contentPane.add(b);
      }

      public void actionPerformed(ActionEvent evt)
      {
         String arg = evt.getActionCommand();
         if (arg.equals("ID No.")) condition_item = "id_number";
         if (arg.equals("Name")) condition_item = "name";
         if (arg.equals("Hire Date")) condition_item = "hire_date";
         if (arg.equals("Title")) condition_item = "title";
         if (arg.equals("Ok")) 
         {   search(condition_item, searchValueText.getText().trim());
             this.setVisible(false);
         }
         else if (arg.equals("Cancel")) this.setVisible(false);
      } 

      private JLabel searchKeyLabel;  //instance variables of this class
      private JTextField searchValueText;
      private JRadioButton rb1, rb2, rb3, rb4;
      private JButton okButton, cancelButton;
      private String condition_item = "id_number";
   }

   //instance variables for class: employeePanel
   private Connection con;
   private JLabel nameLabel, idLabel, addressLabel, city_state_zipLabel,
                  hireDateLabel, jobTitleLabel;
   private JTextField nameText, idText, addressText, cityText, zipText, 
                      hireDateText, jobTitleText;
   private JComboBox stateComboBox;
   private JButton newButton, searchButton, saveButton, cancelButton, exitButton;
}

class employeeFrame extends JFrame  //this class serves as main window of the program
{
   public employeeFrame()
   {
      setTitle("Employee Info");
      setSize(500, 320);
      try  //change Look and Feel to MS Window style 
      {  UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         SwingUtilities.updateComponentTreeUI(this);
      }
      catch(Exception e){} //exception handling statement
      
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 2 - 250, screenHeight / 4);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent we)
            { 
               try
               {   con_test.close(); //close a database connection 
               } 
               catch (java.sql.SQLException e)
               {   System.out.println("Cannot close connection");       
               }
               System.exit(0);
            }
         });

      //try-catch is a Java exception handling pattern.
      //try statement throws exceptions if any.
      //catch statement handles the exceptions thrown in try block.
      try
      {   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //force loading of DB driver
          String url = "jdbc:odbc:MyDatabase";  //define DB URL
          String user = "anonymous";  
          String password = "guest";
          con_test = DriverManager.getConnection(url, user, password); //connecting to DB
      }
      catch (java.lang.ClassNotFoundException e)
      {   System.out.println("Cannot find driver class");
      }
      catch (java.sql.SQLException e)
      {   System.out.println("Cannot get connection");
      }

      empMenuBar = new JMenuBar();  //initializing a menu bar
      operationMenu = new JMenu("Operation");  //initializing menus
      operationMenu.setMnemonic('O');
      helpMenu = new JMenu("Help");
      helpMenu.setMnemonic('H');
      empMenuBar.add(operationMenu); //add menus to a menu bar
      empMenuBar.add(helpMenu);

      newMenuItem = new JMenuItem("New", 'N');  //initializing menu items
      searchMenuItem = new JMenuItem("Search", 'S');
      saveMenuItem = new JMenuItem("Save", 'a');
      cancelMenuItem = new JMenuItem("Cancel", 'C');
      exitMenuItem = new JMenuItem("Exit", 'E');

      operationMenu.add(newMenuItem);  //add menu items to menus
      operationMenu.addSeparator();
      operationMenu.add(searchMenuItem);
      operationMenu.addSeparator();
      operationMenu.add(saveMenuItem);
      operationMenu.add(cancelMenuItem);
      operationMenu.addSeparator();
      operationMenu.add(exitMenuItem);

      indexMenuItem = new JMenuItem("Index", 'I');
      aboutMenuItem = new JMenuItem("About", 'A');
      helpMenu.add(indexMenuItem);
      helpMenu.add(aboutMenuItem);

      setJMenuBar(empMenuBar); //add a menu bar to a window
  
      employeePanel empPanel = new employeePanel(con_test);
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(empPanel);

      //register an object of employeePanel to events of the menu items
      newMenuItem.addActionListener(empPanel);
      searchMenuItem.addActionListener(empPanel);
      saveMenuItem.addActionListener(empPanel);
      cancelMenuItem.addActionListener(empPanel);
      exitMenuItem.addActionListener(empPanel);
      indexMenuItem.addActionListener(empPanel);
      aboutMenuItem.addActionListener(empPanel);


    }

    //instance variables of this frame class
    private Connection con_test;
    private JMenuBar empMenuBar;
    private JMenu operationMenu, helpMenu;
    private JMenuItem newMenuItem, searchMenuItem, saveMenuItem, cancelMenuItem,
                      exitMenuItem, indexMenuItem, aboutMenuItem;
}

public class employee  //main class of this program
{  public static void main(String [] args)
   { JFrame frame = new employeeFrame(); //initialize a JFrame object
     frame.show(); //display the frame
   }
}