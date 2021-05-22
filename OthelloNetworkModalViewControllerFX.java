/********************************
* Class OthelloNetworkModalViewController stub
* for Assignment 2 part 1.
* by Daniel Cormier (fall 2020)
* Don't forget to include all the Javadocs!
* And your name, of course.  Update this block too.
*********************************/

package othello;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

//While you don't strictly HAVE to rename this class to "OthelloNetworkModalViewController",
//I am kind of expecting you to.
public class OthelloNetworkModalViewControllerFX extends Stage

{
     /** Whether the user pressed the Connect button. */
    Boolean hasConnected=false;
    
     /** A reference to the private inner Controller class for use by the two buttons. */
    Controller handler = new Controller();
    
    /** The CombobBox you will need to create.*/
    //NOTE:  You're free to rename it, but as there are some references to it in this stub,
    //you'll need to be consistent when renaming them all.
    ComboBox<String> portInput;
    
    /** The text field where the user will enter the hostname to connect to.*/
    //As above, you're free to rename this.  But be careful.
    TextField addressInput;
    
    //These implementation details are only suggestions.
    
    OthelloNetworkModalViewControllerFX()
    {
    
        //Important note!  Uncomment this line ONLY when you're nearly ready.
        //It'll be a lot harder to get rid of the modal when it's undecorated.
        //So save uncommenting this for nearly last.
        
        //initStyle(StageStyle.UNDECORATED  );

        //Now you're on your own!  Put your own UI in here.
        //Stick to GridPane, BorderPane and FlowPane this
        //time around.








        //Finally, I put my UI inside a Scene I called rootPane and then connected it up.

        initModality(Modality.APPLICATION_MODAL);
        setScene(new Scene(rootPane));
 
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
    
    /** This method returns the port the user has selected or typed in the Combo Box.
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
                portnum = Integer.parseInt((String)portInput.getValue());
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
        hide();
        
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
    
     public class Controller implements EventHandler<ActionEvent>
     {
        @Override
        public void handle(ActionEvent event)
        {
            Node n = (Node) event.getSource();
            String s = (String) n.getUserData();
            //Check the two buttons.

            if ("C".equals(s)) //Connect option.
            {
                hasConnected=true;
            }
            else //My "Cancel" button has an action command of "X" and gets called here.
            {
                hasConnected=false;
            }
            hideModal(); //Hide the modal.  For part 2, we may not want to hide the modal right away.
        }
    }
}

