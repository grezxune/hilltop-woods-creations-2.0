/*****************************
******************************
*
* File: DoorValuesBox.java
* 
* Project: 
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: This class will be used to generate the text fields used in editing doors as well
*           as creating them. Something to try to keep in mind is the ability to pass in a 
*           door to the constructor for the editing purposes so it can fill in all the current
*           values. Another thing is to pass in a ProjectSpecifics object to fill in those for the
*           loaded project page.
* 
***************************** 
*****************************/

package guiComponents;

import newDoorSystem.CabinetOpening;
import windows.Driver;
import customJComponents.TommysLabel;
import customJComponents.TommysTextField;
import miscellaneous.*;

public class DoubleDoorValuesBox extends DoorValuesBox
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Non project specific values
   private TommysLabel lblMiddleGap;
   
   private TommysTextField txfMiddleGap;
   
      // Panel locations
   private int xLocation;
   private int yLocation;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DoubleDoorValuesBox( int pXLocation, int pYLocation )
   {
      xLocation = pXLocation;
      yLocation = pYLocation;
      
      createLabels();
      createTextFields();
      createPanel();
      addAllComponentsToPanel();
   }

   /*****************/
   /*** Accessors ***/
   /*****************/

   public TommysTextField getTxfMiddleGap()
   {
      return txfMiddleGap;
   }
   
   public TommysLabel getLblMiddleGap()
   {
      return lblMiddleGap;   
   }
   
   public boolean checkAllFields()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean allFieldsValid = true;
      
      if( ( txfMiddleGap.getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) /*||
          ( !txfMiddleGap.containsDouble() )*/ )
      {
         allFieldsValid = false;
      }
      
      return allFieldsValid;
   }
   
   public double[] getValuesInArray()
   {
      /*** Local Variables ***/
      /***********************/
      
      double[] valuesInArray = new double[ 1 ];
      
      if( checkAllFields() )
      {
         valuesInArray[ 0 ] = txfMiddleGap.getTextFieldDouble();
      }
      
      return valuesInArray;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createLabels()
   {
       lblMiddleGap = new TommysLabel( "Middle Gap: ", DefaultValuesBox.LABEL_X_LOCATION,
                                                       DefaultValuesBox.LABEL_Y_LOCATION,
                                                       DefaultValuesBox.LABEL_WIDTH,
                                                       DefaultValuesBox.LABEL_HEIGHT );
   }
   
   private void createTextFields()
   {
      txfMiddleGap = new TommysTextField( DefaultValuesBox.TEXT_FIELD_X_LOCATION, 
                                          lblMiddleGap.getY(), 
                                          DefaultValuesBox.TEXT_FIELD_WIDTH, 
                                          DefaultValuesBox.TEXT_FIELD_HEIGHT );
   }
   
   private void createPanel()
   {
      setLayout( null );
      setBounds( xLocation, yLocation, 
                 DefaultValuesBox.LABEL_WIDTH + DefaultValuesBox.TEXT_FIELD_WIDTH + ( DefaultValuesBox.LABEL_SPACING * 3 ),
                 ( DefaultValuesBox.LABEL_HEIGHT * 1 ) + ( DefaultValuesBox.LABEL_SPACING * 2 ) );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
   }
   
   /*public void fillTextFields( DoubleDoor pCabinetDoor ) // Deprecated -- delete after new iplementation finished.
   {
      txfMiddleGap.setText( String.valueOf( pCabinetDoor.getMiddleGap().getWidth() ) );
   }*/
   
   public void fillTextFields( CabinetOpening pCabinetDoor )
   {
      //txfMiddleGap.setText( String.valueOf( ( ( DoubleDoor ) pCabinetDoor ).getMiddleGap().getWidth() ) );
   }
   
   public void clearAllFields()
   {
      txfMiddleGap.setText( "" );   
   }
   
   public void setEditable( boolean pEditable )
   {
      txfMiddleGap.setEditable( pEditable );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public void addAllComponentsToPanel()
   {
      add( lblMiddleGap );
      
      add( txfMiddleGap );
      
      repaint();
   }
   
   public void removeAllComponentsFromPanel()
   {
      remove( lblMiddleGap );
      
      remove( txfMiddleGap );
      
      repaint();
   }
   
   public void showBox()
   {
      setVisible( true );
   }
   
   public void hideBox()
   {
      setVisible( false );
   }
}
