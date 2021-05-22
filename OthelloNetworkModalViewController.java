/********************************
* Class OthelloNetworkModalViewController stub
* for Assignment 2 part 1.
* by Daniel Cormier (fall 2020)
* Don't forget to include all the Javadocs!
* And your name, of course.  Update this block too.
*********************************/

package othello;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class OthelloNetworkModalViewController extends JDialog
{

    /** Whether the user pressed the Connect button. */
    private Boolean hasConnected=false;
    
    /** A reference to the private inner Controller class for use by the two buttons. */
    private Controller handler = new Controller();
    
    /** The CombobBox you will need to create.*/
    //NOTE:  You're free to rename it, but as there are some references to it in this stub,
    //you'll need to be consistent when renaming them all.
    private JComboBox portInput;
    
    /** The text field where the user will enter the hostname to connect to.*/
    //As above, you're free to rename this.  But be careful.
    private JTextField addressInput;

    //These are suggested implementations.  You're free to tackle it differently of course.


public OthelloNetworkModalViewController (JFrame mainView)
    {
        //In Swing, it's ideal if we provide reference frame this will sit atop.
        //The title isn't relevant since we want this to be an undecorated dialog.
        super(mainView,"Enter Network Address",true);
        
        //Important note!  Uncomment this line ONLY when you're nearly ready.
        //It'll be a lot harder to get rid of the modal when it's undecorated.
        //So save uncommenting this for nearly last, when you've debugged everything
        //and you're doing your final testing.
        
        //setUndecorated(true); 
        
        //This will hold your UI.  You may rename it if you want to.
        Container networkPanel = getContentPane();

        //Now you're on your own!  Put your own UI in here.
        //Stick to GridLayout, BorderLayout and FlowLayout this
        //time around.

        
        
        
        
        //This statement should be the last one.
        pack();
    }
        



    /** This method returns the value the user has entered.
        @return The actual value, unless there was an error or the user pressed the cancel button.
    */

    public String getAddress()
    {
        if (hasConnected)
        {
            return (addressInput.getText());
        }
        else
        {
            //You can return whatever error message you like.  This isn't cast in stone.
            return ("Error:  Invalid Address or attempt cancelled.");
        }
    }

    /** This method returns the port the user has selected OR ENTERED in the Combo Box.
    @return The port selected.  Returns -1 on invalid port or cancel pressed.
    */
    
    public int getPort()
    {
        int portnum;
        if (hasConnected)
        {
            //Ensure the user has entered digits.
            //You should probably also ensure the port numbers are in the correct range.
            //I did not.  That's from 0 to 65535, by the way.  Treat it like invalid input.
            try
            {
                portnum = Integer.parseInt((String)portInput.getSelectedItem());
            }
                catch(NumberFormatException nfe)
            {
                //I've been using a negative portnum as an error state in my main code.
                portnum = -1;
            }

            return portnum;
        }
        return -1;
    }
    
    /** Responsible for final cleanup and hiding the modal. Does not do much at the moment.*/
    public void hideModal()
    {
        //Add any code that you may want to do after the user input has been processed
        //and you're figuratively closing up the shop.
        setVisible(false);
        
    }
    
    /** Returns whether or not the user had pressed connect.
    @return True if the user pressed Connect, false if the user backed out with cancel.
    */
    public boolean pressedConnect()
    {
        return hasConnected;
    }
    
    /** The Controller for managing user input in the network dialogue.
    @author Daniel Cormier
    @version 1.3
    @since 1.8.0_261
    @see OthelloViewController
    */
    
    private class Controller implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            String s = evt.getActionCommand();
            
            //I set the action command on my connect button to "C".
            if ("C".equals(s))
            {
                //In Assignment 2-2, we will be making revisions here.
                //This would be a great place to update the "Status" portion of the UI.
                hasConnected=true;
            }
            else //My "Cancel" button has an action command of "X" and gets called here.
            {
                hasConnected=false;
            }
            //Hide the modal. For part 2, we may not want to hide the modal right away.
            hideModal();
        }
        
    }
}
        

        

