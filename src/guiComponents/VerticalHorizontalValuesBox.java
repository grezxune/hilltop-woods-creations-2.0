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

public class VerticalHorizontalValuesBox extends DoorValuesBox
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Non project specific values
   private TommysLabel lblCenterRailWidth;
   private TommysLabel lblNumberOfPanels;
   
   private TommysTextField txfCenterRailWidth;
   private TommysTextField txfNumberOfPanels;
   
      // Panel locations
   private int xLocation;
   private int yLocation;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public VerticalHorizontalValuesBox( int pXLocation, int pYLocation )
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

   public TommysTextField getTxfCenterRailWidth()
   {
      return txfCenterRailWidth;
   }
   
   public TommysTextField getTxfNumberOfPanels()
   {
      return txfNumberOfPanels;
   }
   
   public TommysLabel getLblNumberOfPanels()
   {
      return lblNumberOfPanels;   
   }
   
   public boolean checkAllFields()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean allFieldsValid = true;
      
      if( ( ( txfCenterRailWidth.getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfNumberOfPanels .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) )/* || 
          ( !txfCenterRailWidth.containsDouble() ||
            !txfNumberOfPanels.containsInt()     )*/ )
      {
         allFieldsValid = false;
      }
      
      return allFieldsValid;
   }
   
   public double[] getValuesInArray()
   {
      /*** Local Variables ***/
      /***********************/
      
      double[] valuesInArray = new double[ 2 ];
      
      if( checkAllFields() )
      {
         valuesInArray[ 0 ] = txfCenterRailWidth.getTextFieldDouble();
         valuesInArray[ 1 ] = txfNumberOfPanels .getTextFieldInt();
      }
      
      return valuesInArray;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createLabels()
   {  
      lblCenterRailWidth = new TommysLabel( "Center Rail Width: ", DefaultValuesBox.LABEL_X_LOCATION,
                                            DefaultValuesBox.LABEL_Y_LOCATION,
                                            DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblNumberOfPanels  = new TommysLabel( "Number of Panels: ", lblCenterRailWidth.getX(),
                                            lblCenterRailWidth.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                            DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
   }
   
   private void createTextFields()
   {
      txfCenterRailWidth = new TommysTextField( DefaultValuesBox.TEXT_FIELD_X_LOCATION, lblCenterRailWidth.getY(),
                                                DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfNumberOfPanels  = new TommysTextField( txfCenterRailWidth.getX(), lblNumberOfPanels.getY(),
                                                DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
   }
   
   private void createPanel()
   {
      setLayout( null );
      setBounds( xLocation, yLocation, 
                 DefaultValuesBox.LABEL_WIDTH + DefaultValuesBox.TEXT_FIELD_WIDTH + ( DefaultValuesBox.LABEL_SPACING * 3 ),
                 ( DefaultValuesBox.LABEL_HEIGHT * 2 ) + ( DefaultValuesBox.LABEL_SPACING * 3 ) );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
   }
   
   public void fillTextFields( CabinetOpening pCabinetDoor )
   {
      //txfCenterRailWidth.setText( String.valueOf( pCabinetDoor.getCenterRail().getWidth() ) );
      //txfNumberOfPanels .setText( String.valueOf( pCabinetDoor.getNumberOfPanels()        ) );
   }
   
   public void clearAllFields()
   {
      txfCenterRailWidth.setText( "" );
      txfNumberOfPanels .setText( "" );
   }
   
   public void setEditable( boolean pEditable )
   {
      txfCenterRailWidth.setEditable( pEditable );
      txfNumberOfPanels .setEditable( pEditable );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public void addAllComponentsToPanel()
   {
      add( lblCenterRailWidth );
      add( lblNumberOfPanels  );
      
      add( txfCenterRailWidth );
      add( txfNumberOfPanels  );
      
      repaint();
   }
   
   public void removeAllComponentsFromPanel()
   {
      remove( lblCenterRailWidth );
      remove( lblNumberOfPanels  );
      
      remove( txfCenterRailWidth );
      remove( txfNumberOfPanels  );
      
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
