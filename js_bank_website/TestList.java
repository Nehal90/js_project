import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ListPanel extends JPanel
   implements ListSelectionListener
{
   public ListPanel()
   {
      selectedSwingComponentTextField = new JTextField(14);
      JLabel textFieldLabel = new JLabel("Selected Component:");
      JPanel p1 = new JPanel();
      p1.add(textFieldLabel);
      p1.add(selectedSwingComponentTextField);
 //initializing a list
      swingComponentList = new JList( new String []
          {"JApplet", "JButton", "JCheckBox", "JCheckBoxMenuItem",
           "JColorChooser", "JComboBox", "JComponent",
           "JDesktopPane", "JDialog", "JFrame", "JLabel",
           "JList", "JMenu", "JMenuBar", "JMenuItem",
           "JOptionPane", "JPanel", "JPasswordField",
           "JPopupMenu", "JPopupMenu.Separator", "JProgressBar",
           "JRadioButton", "JRadioButtonMenuItem", "JScrollBar",
           "JScrollPane", "JTabbedPane", "JTable",
           "JTextArea", "JTextField", "JTextPane"});

swingComponentList.setVisibleRowCount(5); //set the visible rows
      swingComponentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JLabel listLabel = new JLabel("Component List:");
      JPanel p2 = new JPanel();
      p2.add(listLabel);
      p2.add(swingComponentList);

      //declare and initialize a SCROLL PANE
      JScrollPane listScroll = new JScrollPane(swingComponentList);
      p2.add(listScroll);

      Box b = Box.createVerticalBox();
      b.add(p1);
      b.add(p2);
      add(b);
      swingComponentList.addListSelectionListener(this);
   }

   //method for ListSelectionEvent handling
      public void valueChanged(ListSelectionEvent evt)
      {
         JList source = (JList)evt.getSource();
         String tempString = (String)source.getSelectedValue();
         selectedSwingComponentTextField.setText(tempString);
      }

      private JTextField selectedSwingComponentTextField;
      private JList swingComponentList;
}

class ListFrame extends JFrame
{
   public ListFrame()
   {
      setTitle("Test List");
      setSize(360, 180);
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 2 - 180, screenHeight / 4);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });
     JPanel testListPanel = new ListPanel();
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(testListPanel);
   }
  }

public class TestList  //main class of this program
{  public static void main(String [] args)
   { JFrame frame = new ListFrame(); //initialize a JFrame object
     frame.show(); //display the frame
   }
}
