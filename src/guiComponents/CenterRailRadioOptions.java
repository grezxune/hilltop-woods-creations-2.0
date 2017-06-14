/*****************************
******************************
*
* File: CenterRailRadioOptions.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 2/26/2013
* 
***************************** 
*****************************/

package guiComponents;

import windows.Driver;
import customJComponents.*;
import java.awt.*;
import javax.swing.*;

public class CenterRailRadioOptions extends TommysPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final int PANEL_WIDTH = 170;
   public static final int PANEL_HEIGHT = 75;
   
   public static final Color PANEL_COLOR = Driver.PAGE_HEADER_BACKGROUND_COLOR;
   
   public static final int FIRST_BUTTON_X_LOCATION = 5;
   public static final int FIRST_BUTTON_Y_LOCATION = 5;
   public static final int RADIO_BUTTON_SPACING    = 5;
   
   public static final String DEFAULT_SELECTED = "Default";
   public static final String CUSTOM_SELECTED  = "Custom";
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private TommysRadioButton rbnDefault;
   private TommysRadioButton rbnCustom;
   
   private ButtonGroup buttonGroup;
   
   private String selectedRadioButton;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public CenterRailRadioOptions( int xLocation, int yLocation )
   {
      super( xLocation, yLocation, PANEL_WIDTH, PANEL_HEIGHT, PANEL_COLOR );
      
      createRadioButtons();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public TommysRadioButton getRbnDefault()
   {
      return rbnDefault;
   }
   
   public TommysRadioButton getRbnCustom()
   {
      return rbnCustom;
   }
   
   public ButtonGroup getButtonGroup()
   {
      return buttonGroup;
   }
   
   public String getSelectedRadioButton()
   {
      return selectedRadioButton;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createRadioButtons()
   {
      rbnDefault = new TommysRadioButton( "Default", FIRST_BUTTON_X_LOCATION, FIRST_BUTTON_Y_LOCATION );
      rbnCustom  = new TommysRadioButton( "Custom" , FIRST_BUTTON_X_LOCATION, rbnDefault.getY() + rbnDefault.getHeight() + RADIO_BUTTON_SPACING );
      
      buttonGroup = new ButtonGroup();
      
      buttonGroup.add( rbnDefault );
      buttonGroup.add( rbnCustom  );
      
      add( rbnDefault );
      add( rbnCustom  );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public void showRadioButtonDefault()
   {
      rbnDefault.setVisible( true );
   }
   
   public void showRadioButtonCustom()
   {
      rbnCustom.setVisible( true );
   }
   
   public void hideRadioButtonDefault()
   {
      rbnDefault.setVisible( false );
   }
   
   public void hideRadioButtonCustom()
   {
      rbnCustom.setVisible( false );
   }
}
