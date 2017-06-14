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

public class DefaultDoorValuesBox extends DoorValuesBox
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Non project specific values
   private TommysLabel lblOpeningWidth;
   private TommysLabel lblOpeningHeight;
   private TommysLabel lblNumberOfOpenings;
   private TommysLabel lblNumberOfDoorsPerOpening;
   private TommysLabel lblNumberOfPanelsPerDoor;
   private TommysLabel lblCenterRailWidth;
   private TommysLabel lblMiddleGap;
   
   private TommysTextField txfOpeningWidth;
   private TommysTextField txfOpeningHeight;
   private TommysTextField txfNumberOfOpenings;
   private TommysTextField txfNumberOfDoorsPerOpening;
   private TommysTextField txfNumberOfPanelsPerDoor;
   private TommysTextField txfCenterRailWidth;
   private TommysTextField txfMiddleGap;
   
      // Panel locations
   private int xLocation;
   private int yLocation;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DefaultDoorValuesBox( int pXPosition, int pYPosition )
   {
      xLocation = pXPosition;
      yLocation = pYPosition;
      
      createLabels();
      createTextFields();
      createPanel();
      addAllComponentsToPanel();
   }

   /*****************/
   /*** Accessors ***/
   /*****************/

   public TommysTextField getTxfOpeningWidth()
   {
      return txfOpeningWidth;
   }
   
   public TommysTextField getTxfOpeningHeight()
   {
      return txfOpeningHeight;
   }
   
   public TommysTextField getTxfNumberOfOpenings()
   {
      return txfNumberOfOpenings;
   }
   
   public TommysTextField getTxfNumberOfDoorsPerOpening()
   {
      return txfNumberOfDoorsPerOpening;
   }
   
   public TommysTextField getTxfNumberOfPanelsPerDoor()
   {
      return txfNumberOfPanelsPerDoor;
   }
   
   public TommysTextField getTxfCenterRailWidth()
   {
      return txfCenterRailWidth;
   }
   
   public TommysTextField getTxfMiddleGap()
   {
      return txfMiddleGap;
   }
   
   public TommysLabel getLblNumberOfOpenings()
   {
      return lblNumberOfOpenings;   
   }
   
   public boolean checkAllFields()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean allFieldsValid = true;
      
      if( ( ( txfOpeningWidth           .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfOpeningHeight          .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfNumberOfOpenings       .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfNumberOfDoorsPerOpening.getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfNumberOfPanelsPerDoor  .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfCenterRailWidth        .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfMiddleGap              .getText().length() < DefaultValuesBox.MINIMUM_TEXT_FIELD_LENGTH ) ) )
      {
         allFieldsValid = false;
      }
      
      return allFieldsValid;
   }
   
   public double[] getValuesInArray()
   {
      /*** Local Variables ***/
      /***********************/
      
      double[] valuesInArray = new double[ 7 ];
      
      if( checkAllFields() )
      {
         valuesInArray[ 0 ] = txfOpeningWidth           .getTextFieldDouble();
         valuesInArray[ 1 ] = txfOpeningHeight          .getTextFieldDouble();
         valuesInArray[ 2 ] = txfNumberOfOpenings       .getTextFieldInt();
         valuesInArray[ 3 ] = txfNumberOfDoorsPerOpening.getTextFieldInt();
         valuesInArray[ 4 ] = txfNumberOfPanelsPerDoor  .getTextFieldInt();
         valuesInArray[ 5 ] = txfCenterRailWidth        .getTextFieldDouble();
         valuesInArray[ 6 ] = txfMiddleGap              .getTextFieldDouble();
      }
      
      return valuesInArray;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createLabels()
   {
      lblOpeningWidth            = new TommysLabel( "Opening Width: ", DefaultValuesBox.LABEL_X_LOCATION,
                                                    DefaultValuesBox.LABEL_Y_LOCATION,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblOpeningHeight           = new TommysLabel( "Opening Height: ", lblOpeningWidth.getX(),
                                                    lblOpeningWidth.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblNumberOfOpenings        = new TommysLabel( "Number of Openings: ", lblOpeningHeight.getX(),
                                                    lblOpeningHeight.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblNumberOfDoorsPerOpening = new TommysLabel( "Number of Doors per Opening: ", lblNumberOfOpenings.getX(),
                                                    lblNumberOfOpenings.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblNumberOfPanelsPerDoor   = new TommysLabel( "Number of Panels per Door: ", lblNumberOfDoorsPerOpening.getX(),
                                                    lblNumberOfDoorsPerOpening.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblCenterRailWidth         = new TommysLabel( "Center Rail Width: ", lblNumberOfPanelsPerDoor.getX(),
                                                    lblNumberOfPanelsPerDoor.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
      lblMiddleGap               = new TommysLabel( "Middle Gap: ", lblCenterRailWidth.getX(),
                                                    lblCenterRailWidth.getY() + DefaultValuesBox.LABEL_SPACING + DefaultValuesBox.LABEL_HEIGHT,
                                                    DefaultValuesBox.LABEL_WIDTH, DefaultValuesBox.LABEL_HEIGHT );
   }
   
   private void createTextFields()
   {
      txfOpeningWidth            = new TommysTextField( DefaultValuesBox.TEXT_FIELD_X_LOCATION, DefaultValuesBox.TEXT_FIELD_Y_LOCATION,
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfOpeningHeight           = new TommysTextField( txfOpeningWidth.getX(), lblOpeningHeight.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfNumberOfOpenings        = new TommysTextField( txfOpeningHeight.getX(), lblNumberOfOpenings.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfNumberOfDoorsPerOpening = new TommysTextField( txfNumberOfOpenings.getX(), lblNumberOfDoorsPerOpening.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfNumberOfPanelsPerDoor   = new TommysTextField( txfNumberOfDoorsPerOpening.getX(), lblNumberOfPanelsPerDoor.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfCenterRailWidth         = new TommysTextField( txfNumberOfPanelsPerDoor.getX(), lblCenterRailWidth.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
      txfMiddleGap               = new TommysTextField( txfCenterRailWidth.getX(), lblMiddleGap.getY(), 
                                                        DefaultValuesBox.TEXT_FIELD_WIDTH, DefaultValuesBox.TEXT_FIELD_HEIGHT );
   }
   
   private void createPanel()
   {
      setLayout( null );
      setBounds( xLocation, yLocation,
                 DefaultValuesBox.LABEL_WIDTH + DefaultValuesBox.TEXT_FIELD_WIDTH + ( DefaultValuesBox.LABEL_SPACING * 3 ),
                 ( DefaultValuesBox.LABEL_HEIGHT * 7 ) + ( DefaultValuesBox.LABEL_SPACING * 8 ) );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
   }
   
   public void fillTextFields( CabinetOpening pCabinetDoor )
   {
      txfOpeningWidth.setText( String.valueOf( pCabinetDoor.getOpeningWidth() ) );
      txfOpeningHeight.setText( String.valueOf( pCabinetDoor.getOpeningHeight() ) );
      txfNumberOfOpenings.setText( String.valueOf( pCabinetDoor.getNumberOfOpenings() ) );
      txfNumberOfDoorsPerOpening.setText( String.valueOf( pCabinetDoor.getNumberOfDoors() ) );
      txfNumberOfPanelsPerDoor.setText( String.valueOf( pCabinetDoor.getNumberOfPanelsPerDoor() ) );
      txfCenterRailWidth.setText( String.valueOf( pCabinetDoor.getCenterRailWidth() ) );
      txfMiddleGap.setText( String.valueOf( pCabinetDoor.getMiddleGap() ) );
   }
   
   public void clearAllFields()
   {
      txfOpeningWidth           .setText( "" );
      txfOpeningHeight          .setText( "" );
      txfNumberOfOpenings       .setText( "" );
      txfNumberOfDoorsPerOpening.setText( "" );
      txfNumberOfPanelsPerDoor  .setText( "" );
      txfCenterRailWidth        .setText( "" );
      txfMiddleGap              .setText( "" );
   }
   
   public void setEditable( boolean pEditable )
   {
      txfOpeningWidth           .setEditable( pEditable );
      txfOpeningHeight          .setEditable( pEditable );
      txfNumberOfOpenings       .setEditable( pEditable );
      txfNumberOfDoorsPerOpening.setEditable( pEditable );
      txfNumberOfPanelsPerDoor  .setEditable( pEditable );
      txfCenterRailWidth        .setEditable( pEditable );
      txfMiddleGap              .setEditable( pEditable );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public void addAllComponentsToPanel()
   {
      add( lblOpeningWidth            );
      add( lblOpeningHeight           );
      add( lblNumberOfOpenings        );
      add( lblNumberOfDoorsPerOpening );
      add( lblNumberOfPanelsPerDoor   );
      add( lblCenterRailWidth         );
      add( lblMiddleGap               );
      
      add( txfOpeningWidth            );
      add( txfOpeningHeight           );
      add( txfNumberOfOpenings        );
      add( txfNumberOfDoorsPerOpening );
      add( txfNumberOfPanelsPerDoor   );
      add( txfCenterRailWidth         );
      add( txfMiddleGap               );
      
      repaint();
   }
   
   public void removeAllComponentsFromPanel()
   {
      remove( lblOpeningWidth            );
      remove( lblOpeningHeight           );
      remove( lblNumberOfOpenings        );
      remove( lblNumberOfDoorsPerOpening );
      remove( lblNumberOfPanelsPerDoor   );
      remove( lblCenterRailWidth         );
      remove( lblMiddleGap               );
      
      remove( txfOpeningWidth            );
      remove( txfOpeningHeight           );
      remove( txfNumberOfOpenings        );
      remove( txfNumberOfDoorsPerOpening );
      remove( txfNumberOfPanelsPerDoor   );
      remove( txfCenterRailWidth         );
      remove( txfMiddleGap               );
      
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
