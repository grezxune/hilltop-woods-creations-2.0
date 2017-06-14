/*****************************
******************************
*
* File: .java
* 
* Project: 
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 
* 
***************************** 
*****************************/

package guiComponents;

import java.awt.*;
import miscellaneous.*;
import javax.swing.*;
import windows.Driver;
import customJComponents.TommysPanel;
import customJComponents.TommysRadioButton;

public class DoorSelectionBox extends TommysPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Panel constants
   public static final Color DOOR_SELECTIONS_PANEL_COLOR = Driver.PAGE_HEADER_BACKGROUND_COLOR;
   
   public static final int DOOR_SELECTIONS_PANEL_WIDTH  = 170;
   public static final int DOOR_SELECTIONS_PANEL_HEIGHT = ( TommysRadioButton.RADIO_BUTTON_HEIGHT * 6 ) + 61;
   
      // Radio button constants
   public static final int FIRST_RADIO_BUTTON_X_LOCATION = 5;
   public static final int FIRST_RADIO_BUTTON_Y_LOCATION = 5;
   
   public static final int RADIO_BUTTON_SPACING = TommysRadioButton.RADIO_BUTTON_HEIGHT + 10;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private TommysRadioButton[] radDoorSelections;
   
   private String selectedDoor;
   
   private ButtonGroup groupOfButtons;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public DoorSelectionBox( int xLocation, int yLocation )
   {
      super( xLocation, yLocation, 
             DOOR_SELECTIONS_PANEL_WIDTH,
             DOOR_SELECTIONS_PANEL_HEIGHT, 
             DOOR_SELECTIONS_PANEL_COLOR );
      
      createRadDoorSelections();
      
      addRadioButtonsToPanel();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public TommysRadioButton[] getRadioButtons()
   {
      return radDoorSelections;
   }
   
   public String getSelectedDoor()
   {
      return selectedDoor;
   }
   
   public ButtonGroup getGroupOfButtons()
   {
      return groupOfButtons;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createRadDoorSelections()
   {
      radDoorSelections = new TommysRadioButton[ 6 ];
      
      radDoorSelections[ 0 ] = new TommysRadioButton( "Single Door", 
                                                      FIRST_RADIO_BUTTON_X_LOCATION, 
                                                      FIRST_RADIO_BUTTON_Y_LOCATION );
      
      radDoorSelections[ 1 ] = new TommysRadioButton( "Double Door", 
                                                      radDoorSelections[ 0 ].getX(), 
                                                      radDoorSelections[ 0 ].getY() + RADIO_BUTTON_SPACING );
      
      radDoorSelections[ 2 ] = new TommysRadioButton( "Single Vertical Door", 
                                                      radDoorSelections[ 1 ].getX(), 
                                                      radDoorSelections[ 1 ].getY() + RADIO_BUTTON_SPACING );
      
      radDoorSelections[ 3 ] = new TommysRadioButton( "Double Vertical Door",
                                                      radDoorSelections[ 2 ].getX(), 
                                                      radDoorSelections[ 2 ].getY() + RADIO_BUTTON_SPACING );
      
      radDoorSelections[ 4 ] = new TommysRadioButton( "Single Horizontal Door", 
                                                      radDoorSelections[ 3 ].getX(), 
                                                      radDoorSelections[ 3 ].getY() + RADIO_BUTTON_SPACING );
      
      radDoorSelections[ 5 ] = new TommysRadioButton( "Double Horizontal Door", 
                                                      radDoorSelections[ 4 ].getX(), 
                                                      radDoorSelections[ 4 ].getY() + RADIO_BUTTON_SPACING );
   }
   
   public void setSelectedDoor( String pSelectedDoor )
   {
      selectedDoor = pSelectedDoor;
   }
   
   public void selectRadioButton()
   {
      for( int i = 0; i < radDoorSelections.length; i++ )
      {
         if( selectedDoor.equals( radDoorSelections[ i ].getText() ) )
         {
            radDoorSelections[ i ].setSelected( true );
         }
      }
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   private void addRadioButtonsToPanel()
   {
      groupOfButtons = new ButtonGroup();
      
      for( int i = 0; i < radDoorSelections.length; i++ )
      {
         groupOfButtons.add( radDoorSelections[ i ] );
         add( radDoorSelections[ i ] );
      }
   }
}
