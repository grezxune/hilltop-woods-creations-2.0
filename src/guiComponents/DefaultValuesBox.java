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

import java.awt.Font;
import newDoorSystem.CabinetOpening;
import windows.Driver;
import customJComponents.TommysLabel;
import customJComponents.TommysTextField;
import doorComponents.*;
import miscellaneous.*;

public class DefaultValuesBox extends DoorValuesBox
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Label constants
   public static final int LABEL_WIDTH   = 285;
   public static final int LABEL_HEIGHT  = 20;
   public static final int LABEL_SPACING = 5;
   public static final int LABEL_X_LOCATION = 5;
   public static final int LABEL_Y_LOCATION = 5;
   
      // Text Field constants
   public static final int TEXT_FIELD_WIDTH   = 125;
   public static final int TEXT_FIELD_HEIGHT  = 22;
   public static final int TEXT_FIELD_SPACING = 2;
   public static final int TEXT_FIELD_X_LOCATION = LABEL_X_LOCATION + LABEL_WIDTH + LABEL_SPACING;
   public static final int TEXT_FIELD_Y_LOCATION = LABEL_Y_LOCATION;
   
   public static  final int MINIMUM_TEXT_FIELD_LENGTH = 1;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Project specific values
   private TommysLabel lblLeftStileWidth;
   private TommysLabel lblRightStileWidth;
   private TommysLabel lblTopRailWidth;
   private TommysLabel lblBottomRailWidth;
   private TommysLabel lblLeftOverlay;
   private TommysLabel lblRightOverlay;
   private TommysLabel lblTopOverlay;
   private TommysLabel lblBottomOverlay;
   private TommysLabel lblPanelGap;
   private TommysLabel lblTennonLength;
   
   private TommysTextField txfLeftStileWidth;
   private TommysTextField txfRightStileWidth;
   private TommysTextField txfTopRailWidth;
   private TommysTextField txfBottomRailWidth;
   private TommysTextField txfLeftOverlay;
   private TommysTextField txfRightOverlay;
   private TommysTextField txfTopOverlay;
   private TommysTextField txfBottomOverlay;
   private TommysTextField txfPanelGap;
   private TommysTextField txfTennonLength;
   
      // Panel locations
   private int xLocation;
   private int yLocation;
   
   private CabinetProject currentProject;
   
   private boolean freshProjectLoaded;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DefaultValuesBox( CabinetProject pCurrentProject, int pXLocation, 
                            int pYLocation )
   {
      currentProject = pCurrentProject;
      
      xLocation = pXLocation;
      yLocation = pYLocation;
      
      createLabels();
      createTextFields();
      createPanel();
      addAllComponentsToPanel();
      
      freshProjectLoaded = pCurrentProject.getProjectSpecificValues() == null;
      
      if( !freshProjectLoaded )
      {
         fillTextFields();
      }
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public TommysTextField getTxfLeftStileWidth()
   {
      return txfLeftStileWidth;
   }
   
   public TommysTextField getTxfRightStileWidth()
   {
      return txfRightStileWidth;
   }
   
   public TommysTextField getTxfTopRailWidth()
   {
      return txfTopRailWidth;
   }
   
   public TommysTextField getTxfBottomRailWidth()
   {
      return txfBottomRailWidth;
   }
   
   public TommysTextField getTxfLeftOverlay()
   {
      return txfLeftOverlay;
   }
   
   public TommysTextField getTxfRightOverlay()
   {
      return txfRightOverlay;
   }
   
   public TommysTextField getTxfTopOverlay()
   {
      return txfTopOverlay;
   }
   
   public TommysTextField getTxfBottomOverlay()
   {
      return txfBottomOverlay;
   }
   
   public TommysTextField getTxfPanelGap()
   {
      return txfPanelGap;
   }
   
   public TommysTextField getTxfTennonLength()
   {
      return txfTennonLength;
   }
   
   public TommysLabel getLblTennonLength()
   {
      return lblTennonLength;
   }
   
   /***
    * return: True if every text field in this box contains a double ( or fraction )
    */
   public boolean checkAllFields()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean allFieldsValid = true;
      
      if( ( ( txfLeftStileWidth      .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfRightStileWidth     .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfTopRailWidth        .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) ||
            ( txfBottomRailWidth     .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfLeftOverlay         .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfRightOverlay        .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfTopOverlay          .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfBottomOverlay       .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfPanelGap            .getText().length() < MINIMUM_TEXT_FIELD_LENGTH ) || 
            ( txfTennonLength        .getText().length() < MINIMUM_TEXT_FIELD_LENGTH )  ) /*||
          ( !txfLeftStileWidth .containsDouble() || 
            !txfRightStileWidth.containsDouble() || 
            !txfTopRailWidth   .containsDouble() ||
            !txfBottomRailWidth.containsDouble() ||
            !txfLeftOverlay    .containsDouble() ||
            !txfRightOverlay   .containsDouble() ||
            !txfTopOverlay     .containsDouble() ||
            !txfBottomOverlay  .containsDouble() ||
            !txfPanelGap       .containsDouble() ||
            !txfTennonLength   .containsDouble() ) */)
      {
         allFieldsValid = false;
      }
      
      return allFieldsValid;
   }
   
   /*** 
    * pre: Every text field in this box must contain a double value ( or fraction )
    * 
    * result: A double array containing the values in each text field
    */
   
   public double[] getValuesInArray()
   {
      /*** Local Variables ***/
      /***********************/
      
      double[] valuesInArray = new double[ 10 ];
      
      if( checkAllFields() )
      {
         valuesInArray[ 0 ] = txfLeftStileWidth .getTextFieldDouble();
         valuesInArray[ 1 ] = txfRightStileWidth.getTextFieldDouble();
         valuesInArray[ 2 ] = txfTopRailWidth   .getTextFieldDouble(); 
         valuesInArray[ 3 ] = txfBottomRailWidth.getTextFieldDouble();
         valuesInArray[ 4 ] = txfLeftOverlay    .getTextFieldDouble();
         valuesInArray[ 5 ] = txfRightOverlay   .getTextFieldDouble(); 
         valuesInArray[ 6 ] = txfTopOverlay     .getTextFieldDouble();
         valuesInArray[ 7 ] = txfBottomOverlay  .getTextFieldDouble();
         valuesInArray[ 8 ] = txfPanelGap       .getTextFieldDouble(); 
         valuesInArray[ 9 ] = txfTennonLength   .getTextFieldDouble(); 
      }
      
      return valuesInArray;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   /***
    * post: All labels for this box except lblProjectNameDisplayed are instantiated
    */
   
   private void createLabels()
   {
      lblLeftStileWidth  = new TommysLabel( "Left Stile Width: ", DefaultValuesBox.LABEL_X_LOCATION,
                                            DefaultValuesBox.LABEL_Y_LOCATION, LABEL_WIDTH, LABEL_HEIGHT );
      lblRightStileWidth = new TommysLabel( "Right Stile Width: ", lblLeftStileWidth.getX(),
                                            lblLeftStileWidth.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblTopRailWidth    = new TommysLabel( "Top Rail Width: ", lblRightStileWidth.getX(),
                                            lblRightStileWidth.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblBottomRailWidth = new TommysLabel( "Bottom Rail Width: ", lblTopRailWidth.getX(),
                                            lblTopRailWidth.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblLeftOverlay     = new TommysLabel( "Left Overlay: ", lblBottomRailWidth.getX(),
                                            lblBottomRailWidth.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblRightOverlay    = new TommysLabel( "Right Overlay: ", lblLeftOverlay.getX(),
                                            lblLeftOverlay.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblTopOverlay      = new TommysLabel( "Top Overlay: ", lblRightOverlay.getX(),
                                            lblRightOverlay.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblBottomOverlay   = new TommysLabel( "Bottom Overlay: ", lblTopOverlay.getX(),
                                            lblTopOverlay.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblPanelGap        = new TommysLabel( "Panel Gap: ", lblBottomOverlay.getX(),
                                            lblBottomOverlay.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
      lblTennonLength    = new TommysLabel( "Tennon Length: ", lblPanelGap.getX(),
                                            lblPanelGap.getY() + LABEL_SPACING + LABEL_HEIGHT,
                                            LABEL_WIDTH, LABEL_HEIGHT );
   }
   
   /***
    * post: lblProjectNameDisplayed is instantiated along with every text field for this
    *       box.
    */
   
   private void createTextFields()
   {
      txfLeftStileWidth  = new TommysTextField( DefaultValuesBox.TEXT_FIELD_X_LOCATION, lblLeftStileWidth .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfRightStileWidth = new TommysTextField( txfLeftStileWidth              .getX(), lblRightStileWidth.getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfTopRailWidth    = new TommysTextField( txfRightStileWidth             .getX(), lblTopRailWidth   .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfBottomRailWidth = new TommysTextField( txfTopRailWidth                .getX(), lblBottomRailWidth.getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfLeftOverlay     = new TommysTextField( txfBottomRailWidth             .getX(), lblLeftOverlay    .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfRightOverlay    = new TommysTextField( txfLeftOverlay                 .getX(), lblRightOverlay   .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfTopOverlay      = new TommysTextField( txfRightOverlay                .getX(), lblTopOverlay     .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfBottomOverlay   = new TommysTextField( txfTopOverlay                  .getX(), lblBottomOverlay  .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfPanelGap        = new TommysTextField( txfBottomOverlay               .getX(), lblPanelGap       .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
      txfTennonLength    = new TommysTextField( txfPanelGap                    .getX(), lblTennonLength   .getY(), TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT );
   }
   
   private void createPanel()
   {
      setLayout( null );
      setBounds( xLocation, yLocation, 
                 DefaultValuesBox.LABEL_WIDTH + ( DefaultValuesBox.TEXT_FIELD_WIDTH ) + ( DefaultValuesBox.LABEL_SPACING * 3 ),
                 ( DefaultValuesBox.LABEL_HEIGHT * 10 ) + ( DefaultValuesBox.LABEL_SPACING * 11 ) );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
   }
   
   /***
    * post: All text fields in this box are filled with corresponding values
    *       from the projectSpecificComponents variable located in currentProject
    */
   private void fillTextFields()
   {
      ProjectSpecificValues components = currentProject.getProjectSpecificValues();
      
      txfLeftStileWidth .setText( String.valueOf( components.getLeftStileWidth()  ) );
      txfRightStileWidth.setText( String.valueOf( components.getRightStileWidth() ) );
      txfTopRailWidth   .setText( String.valueOf( components.getTopRailWidth()    ) );
      txfBottomRailWidth.setText( String.valueOf( components.getBottomRailWidth() ) );
      txfLeftOverlay    .setText( String.valueOf( components.getLeftOverlay()     ) );
      txfRightOverlay   .setText( String.valueOf( components.getRightOverlay()    ) );
      txfTopOverlay     .setText( String.valueOf( components.getTopOverlay()      ) );
      txfBottomOverlay  .setText( String.valueOf( components.getBottomOverlay()   ) );
      txfPanelGap       .setText( String.valueOf( components.getPanelGap()        ) );
      txfTennonLength   .setText( String.valueOf( components.getTennonLength()    ) );
   }
   
   /***
    * post: All text fields in this box are filled with corresponding values
    *       from pCabinetDoor
    */
   
   public void fillTextFields( CabinetOpening pCabinetDoor )
   {
      CabinetOpening cabinetDoor = pCabinetDoor;
      
      txfLeftStileWidth .setText( String.valueOf( cabinetDoor.getLeftStileWidth()  ) );
      txfRightStileWidth.setText( String.valueOf( cabinetDoor.getRightStileWidth() ) );
      txfTopRailWidth   .setText( String.valueOf( cabinetDoor.getTopRailWidth()    ) );
      txfBottomRailWidth.setText( String.valueOf( cabinetDoor.getBottomRailWidth() ) );
      txfLeftOverlay    .setText( String.valueOf( cabinetDoor.getLeftOverlay()     ) );
      txfRightOverlay   .setText( String.valueOf( cabinetDoor.getRightOverlay()    ) );
      txfTopOverlay     .setText( String.valueOf( cabinetDoor.getTopOverlay()      ) );
      txfBottomOverlay  .setText( String.valueOf( cabinetDoor.getBottomOverlay()   ) );
      txfPanelGap       .setText( String.valueOf( cabinetDoor.getPanelGap()        ) );
      txfTennonLength   .setText( String.valueOf( cabinetDoor.getTennonLength()    ) );
   }
   
   /***
    * post: All text fields in this box are empty
    */
   
   public void clearAllFields()
   {
      txfLeftStileWidth .setText( "" );
      txfRightStileWidth.setText( "" );
      txfTopRailWidth   .setText( "" );
      txfBottomRailWidth.setText( "" );
      txfLeftOverlay    .setText( "" );
      txfRightOverlay   .setText( "" );
      txfTopOverlay     .setText( "" );
      txfBottomOverlay  .setText( "" );
      txfPanelGap       .setText( "" );
      txfTennonLength   .setText( "" );
   }
   
   /*** 
    * post: All text fields are editable or not based on @param pEditable
    */
   public void setEditable( boolean pEditable )
   {
      txfLeftStileWidth .setEditable( pEditable );
      txfRightStileWidth.setEditable( pEditable );
      txfTopRailWidth   .setEditable( pEditable );
      txfBottomRailWidth.setEditable( pEditable );
      txfLeftOverlay    .setEditable( pEditable );
      txfRightOverlay   .setEditable( pEditable );
      txfTopOverlay     .setEditable( pEditable );
      txfBottomOverlay  .setEditable( pEditable );
      txfPanelGap       .setEditable( pEditable );
      txfTennonLength   .setEditable( pEditable );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   /***
    * post: All GUI components from this box are added to pPanelToAddTo
    */
   
   public void addAllComponentsToPanel()
   {
      add( lblLeftStileWidth  );
      add( lblRightStileWidth );
      add( lblTopRailWidth    );
      add( lblBottomRailWidth );
      add( lblLeftOverlay     );
      add( lblRightOverlay    );
      add( lblTopOverlay      );
      add( lblBottomOverlay   );
      add( lblPanelGap        );
      add( lblTennonLength    );
      
      add( txfLeftStileWidth  );
      add( txfRightStileWidth );
      add( txfTopRailWidth    );
      add( txfBottomRailWidth );
      add( txfLeftOverlay     );
      add( txfRightOverlay    );
      add( txfTopOverlay      );
      add( txfBottomOverlay   );
      add( txfPanelGap        );
      add( txfTennonLength    );
      
      repaint();
   }
   
   /***
    * post: All GUI components of this box are removed from pPanelToRemoveFrom
    */
   
   public void removeAllComponentsFromPanel()
   {
      remove( lblLeftStileWidth  );
      remove( lblRightStileWidth );
      remove( lblTopRailWidth    );
      remove( lblBottomRailWidth );
      remove( lblLeftOverlay     );
      remove( lblRightOverlay    );
      remove( lblTopOverlay      );
      remove( lblBottomOverlay   );
      remove( lblPanelGap        );
      remove( lblTennonLength    );
      
      remove( txfLeftStileWidth  );
      remove( txfRightStileWidth );
      remove( txfTopRailWidth    );
      remove( txfBottomRailWidth );
      remove( txfLeftOverlay     );
      remove( txfRightOverlay    );
      remove( txfTopOverlay      );
      remove( txfBottomOverlay   );
      remove( txfPanelGap        );
      remove( txfTennonLength    );
      
      repaint();
   }
   
   public void showBox()
   {
      setVisible( true );
      
      /*lblProjectName     .setVisible( true );
      lblLeftStileWidth  .setVisible( true );
      lblRightStileWidth .setVisible( true );
      lblTopRailWidth    .setVisible( true );
      lblBottomRailWidth .setVisible( true );
      lblLeftOverlay     .setVisible( true );
      lblRightOverlay    .setVisible( true );
      lblTopOverlay      .setVisible( true );
      lblBottomOverlay   .setVisible( true );
      lblPanelGap        .setVisible( true );
      lblTennonLength    .setVisible( true );
      
      lblProjectNameDisplayed .setVisible( true );
      
      txfLeftStileWidth  .setVisible( true );
      txfRightStileWidth .setVisible( true );
      txfTopRailWidth    .setVisible( true );
      txfBottomRailWidth .setVisible( true );
      txfLeftOverlay     .setVisible( true );
      txfRightOverlay    .setVisible( true );
      txfTopOverlay      .setVisible( true );
      txfBottomOverlay   .setVisible( true );
      txfPanelGap        .setVisible( true );
      txfTennonLength    .setVisible( true );*/
   }
   
   public void hideBox()
   {
      setVisible( false );
      
      /*lblProjectName     .setVisible( false );
      lblLeftStileWidth  .setVisible( false );
      lblRightStileWidth .setVisible( false );
      lblTopRailWidth    .setVisible( false );
      lblBottomRailWidth .setVisible( false );
      lblLeftOverlay     .setVisible( false );
      lblRightOverlay    .setVisible( false );
      lblTopOverlay      .setVisible( false );
      lblBottomOverlay   .setVisible( false );
      lblPanelGap        .setVisible( false );
      lblTennonLength    .setVisible( false );
      
      lblProjectNameDisplayed .setVisible( false );
      
      txfLeftStileWidth  .setVisible( false );
      txfRightStileWidth .setVisible( false );
      txfTopRailWidth    .setVisible( false );
      txfBottomRailWidth .setVisible( false );
      txfLeftOverlay     .setVisible( false );
      txfRightOverlay    .setVisible( false );
      txfTopOverlay      .setVisible( false );
      txfBottomOverlay   .setVisible( false );
      txfPanelGap        .setVisible( false );
      txfTennonLength    .setVisible( false );*/
   }
}
