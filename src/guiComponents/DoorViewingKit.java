/*****************************
******************************
*
* File: DoorViewingKit.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: Displays a window to the user with components filled with information about a door.
*              Depending on which screen in program the user is at different components will be 
*              available for use.
* 
* Comments: Things to finish: 
*              - Finish placing try/catches in processBtnSaveOpening() once all Door classes are finished.
* 
***************************** 
*****************************/

package guiComponents;

import java.awt.*;
import java.awt.event.*;
import miscellaneous.*;
import newDoorSystem.CabinetOpening;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import customJComponents.*;
import pages.*;
import windows.*;
import fileIO.*;
import java.util.*;

public class DoorViewingKit extends JPanel
                            implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Door viewing kit constants
   public static final int DOOR_VIEWING_KIT_WIDTH  = Driver.pnlCanvas.getWidth();
   public static final int DOOR_VIEWING_KIT_HEIGHT = Driver.pnlCanvas.getHeight();
   public static final int MINIMUM_DOOR_NUMBER     = 1;
   
      // Door values boxes constants
   public static final int PROJECT_SPECIFIC_BOX_X_LOCATION = 375;
   public static final int PROJECT_SPECIFIC_BOX_Y_LOCATION = 20;
   
      // Door label constants
   public static final int DOOR_LABEL_X_LOCATION = 50;
   public static final int DOOR_LABEL_Y_LOCATION = 35;
   
      // Door selection box constants
   public static final int DOOR_SELECTION_BOX_X_LOCATION = DOOR_LABEL_X_LOCATION; 
   public static final int DOOR_SELECTION_BOX_Y_LOCATION = 140;
   
      // Checkbox constants
   public static final int CENTER_RAIL_LOCATION_CHECKBOX_WIDTH = 215;
   public static final int CENTER_RAIL_LOCATION_CHECKBOX_HEIGHT = 30;
   public static final int CENTER_RAIL_LOCATION_CHECKBOX_X_LOCATION = PROJECT_SPECIFIC_BOX_X_LOCATION;
   public static final int CENTER_RAIL_LOCATION_CHECKBOX_Y_LOCATION = DOOR_VIEWING_KIT_HEIGHT - CENTER_RAIL_LOCATION_CHECKBOX_HEIGHT - 40;
   public static final Color CENTER_RAIL_LOCATION_CHECKBOX_BACKGROUND_COLOR = Color.BLACK;//Driver.PAGE_HEADER_BACKGROUND_COLOR;
   public static final Color CENTER_RAIL_LOCATION_CHECKBOX_FOREGROUND_COLOR = Color.WHITE;
   
   
      // Door search constants
   public static final int DOOR_SEARCH_LABEL_WIDTH       = 70;
   public static final int DOOR_SEARCH_LABEL_HEIGHT      = DefaultValuesBox.LABEL_HEIGHT;
   public static final int DOOR_SEARCH_TEXT_FIELD_WIDTH  = 50;
   public static final int DOOR_SEARCH_TEXT_FIELD_HEIGHT = DefaultValuesBox.TEXT_FIELD_HEIGHT;
   public static final int DOOR_SEARCH_BUTTON_WIDTH      = 50;
   public static final int DOOR_SEARCH_BUTTON_HEIGHT     = DefaultValuesBox.TEXT_FIELD_HEIGHT;
   public static final int DOOR_SEARCH_LABEL_X_LOCATION  = ( ( DOOR_LABEL_X_LOCATION + ( DoorLabel.DOOR_LABEL_WIDTH / 2 ) ) ) -
                                                           ( ( DOOR_SEARCH_LABEL_WIDTH + DOOR_SEARCH_TEXT_FIELD_WIDTH + 
                                                               DOOR_SEARCH_BUTTON_WIDTH ) / 2 );
   public static final int DOOR_SEARCH_LABEL_Y_LOCATION  = 10;
   
      // Save button constants
   public static final int BUTTON_WIDTH                = 110;
   public static final int BUTTON_HEIGHT               = TommysButton.BUTTON_Y_PIXELS;
   public static final int SAVE_DOOR_BUTTON_X_LOCATION = DOOR_SELECTION_BOX_X_LOCATION + DoorSelectionBox.DOOR_SELECTIONS_PANEL_WIDTH + 10;
   public static final int SAVE_DOOR_BUTTON_Y_LOCATION = ( DOOR_SELECTION_BOX_Y_LOCATION + 
                                                           ( DoorSelectionBox.DOOR_SELECTIONS_PANEL_HEIGHT / 2 ) ) - 
                                                         ( BUTTON_HEIGHT / 2 ) - BUTTON_HEIGHT - 5;
   public static final int CREATE_A_NEW_DOOR           = 0;
   
      // Edit button constants
   public static final int EDIT_BUTTON_X_LOCATION = SAVE_DOOR_BUTTON_X_LOCATION;
   public static final int EDIT_BUTTON_Y_LOCATION = SAVE_DOOR_BUTTON_Y_LOCATION + BUTTON_HEIGHT + 5;
   
      // Integer values representing door box number
   public static final int SINGLE_DOOR                     = 0;
   public static final int DOUBLE_DOOR                     = 1;
   public static final int VERTICAL_HORIZONTAL_DOOR        = 2;
   public static final int DOUBLE_VERTICAL_HORIZONTAL_DOOR = 3;
   
      // Load project button constants
   public static final int LOAD_PROJECT_BUTTON_WIDTH  = 110;
   public static final int LOAD_PROJECT_BUTTON_HEIGHT = TommysButton.BUTTON_Y_PIXELS;
   public static final int LOAD_PROJECT_BUTTON_X_LOCATION = DOOR_VIEWING_KIT_WIDTH - LOAD_PROJECT_BUTTON_WIDTH - 40;
   public static final int LOAD_PROJECT_BUTTON_Y_LOCATION = DOOR_VIEWING_KIT_HEIGHT - LOAD_PROJECT_BUTTON_HEIGHT - 40;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private CabinetProject currentProject;
   
      // Radio button panel
   private DoorSelectionBox    doorSelections;
   private TommysRadioButton[] radDoorSelections;
   
      // Checkboxes
   private JCheckBox cbxCustomizeCenterRailLocations;
   
      // Door values boxes
   private DefaultValuesBox            defaultValues;
   private DefaultDoorValuesBox        defaultDoorValues;
   //private DoubleDoorValuesBox         doubleDoorValues;
   //private VerticalHorizontalValuesBox verticalHorizontalValues;
   
   private DoorLabel doorLabel;
   
      // Door search components
   private TommysLabel     lblDoorSearch;
   private TommysTextField txfDoorSearch;
   private TommysButton    btnDoorSearch;
   
      // Other buttons
   private TommysButton btnSaveOpening;
   private TommysButton btnPrevious;
   private TommysButton btnNext;
   private TommysButton btnEdit;
   private TommysButton btnDelete;
   private TommysButton btnLoadProject;
   
      // Coordinates for first door values box
   private int firstLabelXLocation;
   private int firstLabelYLocation;
   
      // Width/height of this object
   private int kitWidth;
   private int kitHeight;
   
   private int currentOpeningNumber;
   
   private boolean editingAnOpening = false;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DoorViewingKit( CabinetProject pCurrentProject )
   {
      currentProject = pCurrentProject;
      
         // Default location/dimensions
      firstLabelXLocation = PROJECT_SPECIFIC_BOX_X_LOCATION;
      firstLabelYLocation = PROJECT_SPECIFIC_BOX_Y_LOCATION;
      kitWidth  = DOOR_VIEWING_KIT_WIDTH;
      kitHeight = DOOR_VIEWING_KIT_HEIGHT;
      
      setupViewingKit();
      
         // Create components of class
      createDoorSearch();
      createDoorSelections();
      createDoorValuesBoxes();
      createDoorLabel();
      createCheckboxes();
      
         // Create buttons
      createBtnSaveOpening();
      createBtnPrevious();
      createBtnNext();
      createBtnEdit();
      createBtnDelete();
      createBtnLoadProject();
      
         // Set defaultValuesBox to visible
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
   }
   
   public DoorViewingKit( CabinetProject pCurrentProject,
                          int pFirstLabelXLocation , int pFirstLabelYLocation,
                          int pKitWidth, int pKitHeight )
   {
      currentProject = pCurrentProject;

         // Parameterized location/dimensions
      firstLabelXLocation = pFirstLabelXLocation;
      firstLabelYLocation = pFirstLabelYLocation;
      kitWidth  = pKitWidth;
      kitHeight = pKitHeight;

      setupViewingKit();

      // Create components of class
      createDoorSearch();
      createDoorSelections();
      createDoorValuesBoxes();
      createDoorLabel();
      createCheckboxes();

      // Create buttons
      createBtnSaveOpening();
      createBtnPrevious();
      createBtnNext();
      createBtnEdit();
      createBtnDelete();
      createBtnLoadProject();
      
         // Set defaultValuesBox to visible
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public CabinetProject getCurrentProject()
   {
      return currentProject;
   }
   
   public DoorSelectionBox getDoorSelectionBox()
   {
      return doorSelections;
   }
   
   public DefaultValuesBox getDefaultValues()
   {
      return defaultValues;
   }
   
   public DefaultDoorValuesBox getDefaultDoorValues()
   {
      return defaultDoorValues;
   }
   
   public JCheckBox getCustomizeCenterRailLocationsCheckbox()
   {
      return cbxCustomizeCenterRailLocations;
   }
   
   /*public DoubleDoorValuesBox getDoubleDoorValues()
   {
      return doubleDoorValues;
   }
   
   public VerticalHorizontalValuesBox getVerticalHorizontalValues()
   {
      return verticalHorizontalValues;
   }*/
   
   public DoorLabel getDoorLabel()
   {
      return doorLabel;
   }
   
   public TommysTextField getTxfDoorSearch()
   {
      return txfDoorSearch;
   }
   
   public int getCurrentOpeningNumber()
   {
      return currentOpeningNumber;
   }
   
   /**
    * @param pDoorNumber
    * @return true if pDoorNumber is between 1 and number of doors in project
    */
   public boolean validateDoorNumber( int pDoorNumber )
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean doorValidated = false;
      
      if( pDoorNumber >= MINIMUM_DOOR_NUMBER && 
          pDoorNumber <= currentProject.getNumberOfOpeningsInProject() )
      {
         doorValidated = true;
      }
    
      return doorValidated;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void setupViewingKit()
   {
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( null );
      setBounds( 0, 0, kitWidth, kitHeight );
   }
   
   private void createDoorSelections()
   {
      doorSelections = new DoorSelectionBox( DOOR_SELECTION_BOX_X_LOCATION, DOOR_SELECTION_BOX_Y_LOCATION );
      
      radDoorSelections = doorSelections.getRadioButtons();
      
      for( int i = 0; i < radDoorSelections.length; i++ )
      {
         radDoorSelections[ i ].addActionListener( this );
      }
      
      add( doorSelections );
   }
   
   private void createDefaultValuesBox()
   {
      defaultValues = new DefaultValuesBox( currentProject, 
                                            firstLabelXLocation,
                                            firstLabelYLocation );
      add( defaultValues );
   }
   
   private void createDefaultDoorValuesBox()
   {
      defaultDoorValues = new DefaultDoorValuesBox( defaultValues.getX(), 
                                                    defaultValues.getY() + defaultValues.getHeight() +
                                                    DefaultValuesBox.LABEL_SPACING );
      add( defaultDoorValues );
   }
   
   /*private void createDoubleDoorValuesBox()
   {      
      doubleDoorValues = new DoubleDoorValuesBox( defaultDoorValues.getX(),
                                                  defaultDoorValues.getY() + defaultDoorValues.getHeight() +
                                                  DefaultValuesBox.LABEL_SPACING );
      add( doubleDoorValues );
   }
   
   private void createVerticalHorizontalValuesBox()
   {      
      verticalHorizontalValues = new VerticalHorizontalValuesBox( doubleDoorValues.getX(),
                                                                  doubleDoorValues.getY() + doubleDoorValues.getHeight() +
                                                                  DefaultValuesBox.LABEL_SPACING );
      add( verticalHorizontalValues );
   }*/
   
   private void createDoorValuesBoxes()
   {
      createDefaultValuesBox();
      
      createDefaultDoorValuesBox();
      
      /*createDoubleDoorValuesBox();
      
      createVerticalHorizontalValuesBox();*/
   }
   
   private void createDoorLabel()
   {
      doorLabel = new DoorLabel( currentProject, DOOR_LABEL_X_LOCATION, DOOR_LABEL_Y_LOCATION );
      doorLabel.update( currentProject.getNumberOfOpeningsInProject() + 1 );
      add( doorLabel );
   }
   
   private void createCheckboxes()
   {
      cbxCustomizeCenterRailLocations = new JCheckBox("Customize Center Rail Locations");
      cbxCustomizeCenterRailLocations.setBounds( CENTER_RAIL_LOCATION_CHECKBOX_X_LOCATION, CENTER_RAIL_LOCATION_CHECKBOX_Y_LOCATION, 
                                            CENTER_RAIL_LOCATION_CHECKBOX_WIDTH, CENTER_RAIL_LOCATION_CHECKBOX_HEIGHT );
      cbxCustomizeCenterRailLocations.setBackground( CENTER_RAIL_LOCATION_CHECKBOX_BACKGROUND_COLOR );
      cbxCustomizeCenterRailLocations.setForeground( CENTER_RAIL_LOCATION_CHECKBOX_FOREGROUND_COLOR );
      cbxCustomizeCenterRailLocations.setBorder( BorderFactory.createSoftBevelBorder( BevelBorder.RAISED ) );
      
      add( cbxCustomizeCenterRailLocations );
   }
   
   private void createDoorSearch()
   {
      lblDoorSearch = new TommysLabel( "Search: ", DOOR_SEARCH_LABEL_X_LOCATION, DOOR_SEARCH_LABEL_Y_LOCATION,
                                                   DOOR_SEARCH_LABEL_WIDTH, DOOR_SEARCH_LABEL_HEIGHT );
      lblDoorSearch.setFont( new Font( "Algerian", Font.BOLD, 14 ) );
      
      txfDoorSearch = new TommysTextField( ( lblDoorSearch.getX() + lblDoorSearch.getWidth() + 3 ), lblDoorSearch.getY(),
                                             DOOR_SEARCH_TEXT_FIELD_WIDTH, DOOR_SEARCH_TEXT_FIELD_HEIGHT );
      txfDoorSearch.addActionListener( this );
      
      btnDoorSearch = new TommysButton( ">>", txfDoorSearch.getX() + txfDoorSearch.getWidth() + 3, lblDoorSearch.getY(),
                                              DOOR_SEARCH_BUTTON_WIDTH, DOOR_SEARCH_BUTTON_HEIGHT);
      btnDoorSearch.setFont( new Font( "Algerian", Font.BOLD, 13 ) );
      btnDoorSearch.addActionListener( this );
      
      add( lblDoorSearch );
      add( txfDoorSearch );
      add( btnDoorSearch );
   }
   
   private void createBtnSaveOpening()
   {
      btnSaveOpening = new TommysButton( "Save Door", SAVE_DOOR_BUTTON_X_LOCATION, SAVE_DOOR_BUTTON_Y_LOCATION,
                                                   BUTTON_WIDTH, BUTTON_HEIGHT    );
      
      btnSaveOpening.addActionListener( this );
      
      add( btnSaveOpening );
   }
   
   private void createBtnPrevious()
   {
      btnPrevious = new TommysButton( "Previous", DOOR_LABEL_X_LOCATION + ( DoorLabel.DOOR_LABEL_WIDTH / 2 ) - BUTTON_WIDTH, 
                                                  DOOR_LABEL_Y_LOCATION + DoorLabel.DOOR_LABEL_HEIGHT + 5, 
                                                  BUTTON_WIDTH, BUTTON_HEIGHT );
      
      btnPrevious.addActionListener( this );
      
      add( btnPrevious );
   }
   
   private void createBtnNext()
   {
      btnNext = new TommysButton( "Next", btnPrevious.getX() + btnPrevious.getWidth() + 5, 
                                          DOOR_LABEL_Y_LOCATION + DoorLabel.DOOR_LABEL_HEIGHT + 5, BUTTON_WIDTH, BUTTON_HEIGHT );
      
      btnNext.addActionListener( this );
      
      add( btnNext );
   }
   
   private void createBtnEdit()
   {
      btnEdit = new TommysButton( "Edit", EDIT_BUTTON_X_LOCATION, EDIT_BUTTON_Y_LOCATION, 
                                          BUTTON_WIDTH, BUTTON_HEIGHT );
      btnEdit.addActionListener( this );
      
      add( btnEdit );
   }
   
   private void createBtnDelete()
   {
      btnDelete = new TommysButton( "Delete", btnEdit.getX(), btnEdit.getY() + btnEdit.getHeight() + 5,
                                              BUTTON_WIDTH, BUTTON_HEIGHT );
      btnDelete.addActionListener( this );
      
      add( btnDelete );
   }
   
   private void createBtnLoadProject()
   {
      btnLoadProject = new TommysButton( "Load Project", LOAD_PROJECT_BUTTON_X_LOCATION, 
                                                         LOAD_PROJECT_BUTTON_Y_LOCATION, 
                                                         LOAD_PROJECT_BUTTON_WIDTH, 
                                                         LOAD_PROJECT_BUTTON_HEIGHT );
      btnLoadProject.addActionListener( this );
      
      add( btnLoadProject );
   }
   
   public void setCurrentOpening( int pCurrentOpening )
   {
      if( validateDoorNumber( pCurrentOpening ) )
      {
         currentOpeningNumber = pCurrentOpening;
      }
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   /*** Show component methods ***/
   public void showDoorSelector()
   {
      doorSelections.setVisible( true );
   }
   
   public void showDefaultValuesBox()
   {
      //hideAllDoorValuesBoxes();
      defaultValues.addAllComponentsToPanel();
      defaultValues.showBox();
   }
   
   public void showDefaultDoorValuesBox()
   {
      defaultValues.addAllComponentsToPanel();
      defaultValues.showBox();
      
      defaultDoorValues.addAllComponentsToPanel();
      defaultDoorValues.showBox();
   }
   
   /*public void showDoubleDoorValuesBox()
   {
      showDefaultDoorValuesBox();
      doubleDoorValues.addAllComponentsToPanel();
      doubleDoorValues.showBox();
   }
   
   public void showVerticalHorizontalDoorValuesBox()
   {
      showDefaultDoorValuesBox();
      verticalHorizontalValues.showBox();
   }*/
   
   public void showAllDoorBoxes()
   {
      showDefaultDoorValuesBox();
      /*showDoubleDoorValuesBox();
      showVerticalHorizontalDoorValuesBox();*/
   }
   
   /***
    * post: The correct boxes are displayed for @param pDoor &&
    *       filled with pDoor's values as well.
    */
   /*public void showDoorsBoxes( CabinetOpening pDoor )
   {
         // Boxes used in every door
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
      defaultValues.fillTextFields( pDoor );
      defaultDoorValues.fillTextFields( pDoor );
      
      // TODO -- > Check if this setCurrentProject method call is necessary
      doorLabel.setCurrentProject( currentProject );
      //doorLabel.update( pDoor );
   }*/
   
   public void showDoorLabel()
   {
      doorLabel.setVisible( true );
   }
   
   public void showDoorSearch()
   {
      lblDoorSearch.setVisible( true );
      txfDoorSearch.setVisible( true );
      btnDoorSearch.setVisible( true );
   }
   
   public void showBtnSaveOpening()
   {
      btnSaveOpening.setVisible( true );
   }
   
   public void showBtnPrevious()
   {
      btnPrevious.setVisible( true );
   }
   
   public void showBtnNext()
   {
      btnNext.setVisible( true );
   }
   
   public void showBtnEdit()
   {
      btnEdit.setVisible( true );
   }
   
   public void showBtnDelete()
   {
      btnDelete.setVisible( true );
   }
   
   public void showBtnLoadProject()
   {
      btnLoadProject.setVisible( true );
   }
   
   /*** Hide component methods ***/
   public void hideDoorSelector()
   {
      doorSelections.setVisible( false );
   }
   
   public void hideDefaultDoorValuesBox()
   {
      defaultDoorValues.hideBox();
      
      if( !editingAnOpening )
      {
         defaultDoorValues.clearAllFields();
      }
   }
   
   /*public void hideDoubleDoorValuesBox()
   {
      doubleDoorValues.hideBox();
      
      if( !editingADoor )
      {
         doubleDoorValues.clearAllFields();
      }
   }
   
   public void hideVerticalHorizontalDoorValuesBox()
   {
      verticalHorizontalValues.hideBox();
      
      if( !editingADoor )
      {
         verticalHorizontalValues.clearAllFields();
      }
   }*/
   
   public void hideAllDoorValuesBoxes()
   {
      hideDefaultDoorValuesBox();
      /*hideDoubleDoorValuesBox();
      hideVerticalHorizontalDoorValuesBox();*/
   }
   
   public void hideDoorLabel()
   {
      doorLabel.setVisible( false );
   }
   
   public void hideDoorSearch()
   {
      lblDoorSearch.setVisible( false );
      txfDoorSearch.setVisible( false );
      btnDoorSearch.setVisible( false );
   }
   
   public void hideBtnSaveOpening()
   {
      btnSaveOpening.setVisible( false );
   }
   
   public void hideBtnPrevious()
   {
      btnPrevious.setVisible( false );
   }
   
   public void hideBtnNext()
   {
      btnNext.setVisible( false );
   }
   
   public void hideBtnEdit()
   {
      btnEdit.setVisible( false );
   }
   
   public void hideBtnDelete()
   {
      btnDelete.setVisible( false );
   }
   
   public void hideBtnLoadProject()
   {
      btnLoadProject.setVisible( false );
   }
   
   /*** Updating components methods ***/
   public void clearAllFields()
   {
      if( !editingAnOpening )
      {
         defaultDoorValues       .clearAllFields();
         /*doubleDoorValues        .clearAllFields();
         verticalHorizontalValues.clearAllFields();*/
      }
   }
   
   public void enableBoxEditing( boolean pEditable )
   {
      defaultValues           .setEditable( pEditable );
      defaultDoorValues       .setEditable( pEditable );
      /*doubleDoorValues        .setEditable( pEditable );
      verticalHorizontalValues.setEditable( pEditable );*/
   }
   
   public void updateLabel()
   {
      doorLabel.update( currentOpeningNumber );
      updateDoorSearch();
   }
   
   /*public void updateLabel( CabinetOpening pDoor )
   {
      doorLabel.update( pDoor );
   }*/
   
   
   public void loadFirstOpening()
   {
      if( currentProject.getNumberOfOpeningsInProject() >= MINIMUM_DOOR_NUMBER )
      {
         currentOpeningNumber = 1;
         //showDoorsBoxes( currentProject.getOpening( currentOpeningNumber ) );
         updateDoorSearch();
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "No doors in project" );
      }
   }
   
   
   public void loadOpeningByNumber( int pOpeningNumber )
   {
      if( validateDoorNumber( pOpeningNumber ) )
      {
         currentOpeningNumber = pOpeningNumber;
         //showDoorsBoxes( currentProject.getOpening( currentOpeningNumber ) );
         updateDoorSearch();
         defaultValues.fillTextFields( currentProject.getOpening( currentOpeningNumber ) );
         defaultDoorValues.fillTextFields( currentProject.getOpening( currentOpeningNumber ) );
         doorLabel.update( currentOpeningNumber );
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "Door " + pOpeningNumber + " does not exist in project" );
         updateDoorSearch();
      }
   }
   
   
   public void disableEditing()
   {
      hideDoorSelector();
      hideBtnSaveOpening();
      enableBoxEditing( false );
      editingAnOpening = false;
   }
   
   
   private void updateDoorSearch()
   {
      txfDoorSearch.setText( String.valueOf( currentOpeningNumber ) );
   }
   
   
   private void showCenterRailWindow( CabinetOpening pDoor )
   {
      new CenterRailLocations( pDoor );
   }
   
   
   /***
    * post: An action is performed if e.getSource() == a component listed
    */
   public void actionPerformed( ActionEvent e )
   {
      if( e.getSource() == radDoorSelections[ 0 ] )
      {
         singleDoorSelected();
      }
      else if( e.getSource() == radDoorSelections[ 1 ] )
      {
         doubleDoorSelected();
      }
      else if( e.getSource() == radDoorSelections[ 2 ] )
      {
         singleVerticalDoorSelected();
      }
      else if( e.getSource() == radDoorSelections[ 3 ] )
      {
         doubleVerticalDoorSelected();
      }
      else if( e.getSource() == radDoorSelections[ 4 ] )
      {
         singleHorizontalDoorSelected();
      }
      else if( e.getSource() == radDoorSelections[ 5 ] )
      {
         doubleHorizontalDoorSelected();
      }
      else if( e.getSource() == btnDoorSearch ||
               e.getSource() == txfDoorSearch )
      {
         processBtnDoorSearch();
      }
      else if( e.getSource() == btnSaveOpening )
      {
         processBtnSaveOpening();
      }
      else if( e.getSource() == btnPrevious )
      {
         processBtnPrevious();
      }
      else if( e.getSource() == btnNext )
      {
         processBtnNext();
      }
      else if( e.getSource() == btnEdit )
      {
         processBtnEdit();
      }
      else if( e.getSource() == btnDelete )
      {
         processBtnDelete();
      }
      else if( e.getSource() == btnLoadProject )
      {
         processBtnLoadProject();
      }
   }
   
   /*** Radio button action methods ***/
   private void singleDoorSelected()
   {
      showDefaultDoorValuesBox();
      /*hideDoubleDoorValuesBox();
      hideVerticalHorizontalDoorValuesBox();*/
      //doorLabel.setDoorType( SingleDoor.DOOR_TYPE );
      //doorSelections.setSelectedDoor( SingleDoor.DOOR_TYPE );
   }
   
   private void doubleDoorSelected()
   {
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
      //showDoubleDoorValuesBox();
      //doorLabel.setDoorType( DoubleDoor.DOOR_TYPE );
      //doorSelections.setSelectedDoor( DoubleDoor.DOOR_TYPE );
   }
   
   private void singleVerticalDoorSelected()
   {
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
      //showVerticalHorizontalDoorValuesBox();
      doorLabel.setDoorType( "Single Vertical Door" );
      doorSelections.setSelectedDoor( "Single Vertical Door" );
   }
   
   private void doubleVerticalDoorSelected()
   {
      showDefaultValuesBox();
      showDefaultDoorValuesBox();
      //showDoubleDoorValuesBox();
      //showVerticalHorizontalDoorValuesBox();
      doorLabel.setDoorType( "Double Vertical Door" );
      doorSelections.setSelectedDoor( "Double Vertical Door" );
   }
   
   private void singleHorizontalDoorSelected()
   {
      showDefaultDoorValuesBox();
      //hideDoubleDoorValuesBox();
      //showVerticalHorizontalDoorValuesBox();
      doorLabel.setDoorType( "Single Horizontal Door" );                        // ADD THIS DOOR
      doorSelections.setSelectedDoor( "Single Horizontal Door" );
   }
   
   private void doubleHorizontalDoorSelected()
   {
      showDefaultValuesBox();
      //showDoubleDoorValuesBox();
      //showVerticalHorizontalDoorValuesBox();
      doorLabel.setDoorType( "Double Horizontal Door" );                         // ADD THIS DOOR
      doorSelections.setSelectedDoor( "Double Horizontal Door" );
   }
   
   /*** Button action methods ***/
   private void processBtnDoorSearch()
   {
      int openingNumberToSearch;
      
      if( txfDoorSearch.containsInt() )
      {
         openingNumberToSearch = Integer.parseInt( txfDoorSearch.getText() );
         
         if( validateDoorNumber( openingNumberToSearch ) )
         {
            hideDoorSelector();
            hideBtnSaveOpening();
            enableBoxEditing( false );
            editingAnOpening = false;

            currentOpeningNumber = openingNumberToSearch;
            loadOpeningByNumber( currentOpeningNumber );
         }
         else
         {
            JOptionPane.showMessageDialog( Driver.pnlCanvas, "That door does not exist in this project" );
            updateDoorSearch();
         }
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "Invalid door number" );
      }
   }
   
   private void processBtnSaveOpening()
   {

      /*** Local Variables ***/
      /***********************/
      
      boolean successCreatingDoor = false;
      
      double[] projectSpecificValuesArr = defaultValues    .getValuesInArray();
      double[] defaultDoorValuesArr     = defaultDoorValues.getValuesInArray();
      
      int openingNumberToSave = ( editingAnOpening ? currentOpeningNumber : CREATE_A_NEW_DOOR );
      int newOpeningNumber    = ( editingAnOpening ? currentOpeningNumber : ( currentProject.getNumberOfOpeningsInProject() + 1 ) );
      
      LinkedList<Double> centerRailLocations = new LinkedList<>();
      
         // Show center rails window or not
      if( ( cbxCustomizeCenterRailLocations.isSelected() ) && 
          ( Integer.parseInt( defaultDoorValues.getTxfNumberOfPanelsPerDoor().getText() ) > 1 ) )
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "Custom Center Rail Locations!" );
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "Default Center Rail Locations!" );
      }
      
         // Add CabinetOpening to list in project
      currentProject.addOpening( new CabinetOpening( ( ( int ) defaultDoorValuesArr[3] ), // numberOfDoorsPerOpening
                                                     ( ( int ) defaultDoorValuesArr[4] ), // numberOfPanelsPerDoor
                                                     ( ( int ) defaultDoorValuesArr[2] ), // numberOfOpenings
                                                     newOpeningNumber, // openingNumber
                                                     defaultDoorValuesArr[0], // openingWidth
                                                     defaultDoorValuesArr[1], // openingHeight
                                                     projectSpecificValuesArr[2], // topRailWidth
                                                     projectSpecificValuesArr[3], // bottomRailWidth
                                                     projectSpecificValuesArr[0], // leftStileWidth
                                                     projectSpecificValuesArr[1], // rightStileWidth
                                                     projectSpecificValuesArr[6], // topOverlay
                                                     projectSpecificValuesArr[7], // bottomOverlay
                                                     projectSpecificValuesArr[4], // leftOverlay
                                                     projectSpecificValuesArr[5], // rightOverlay
                                                     projectSpecificValuesArr[8], // panelGap
                                                     projectSpecificValuesArr[9], // tennonLength
                                                     defaultDoorValuesArr[6], // middleGap
                                                     defaultDoorValuesArr[5], // centerRailWidth
                                                     new LinkedList<Double>() ), // centerRailLocations
                                                     openingNumberToSave );
      
      if( editingAnOpening )
      {
         disableEditing();
         //updateLabel();
         //loadOpeningByNumber( currentProject.getNumberOfOpeningsInProject() + 1 );
      }
      else
      {
         doorLabel.update( currentProject.getNumberOfOpeningsInProject() + 1 );
         //showDefaultValuesBox();
         clearAllFields();
      }
      
         // Clear door selection
      doorSelections.getGroupOfButtons().clearSelection();
      
         // Save project
      FileOutput.writeCabinetProjectObject( currentProject );
   }
   
   private void processBtnPrevious()
   {
      if( validateDoorNumber( currentOpeningNumber - 1 ) )
      {
         disableEditing();
         
         currentOpeningNumber--;
         loadOpeningByNumber( currentOpeningNumber );
         updateDoorSearch();
      }
      else
      {
         if( currentProject.getNumberOfOpeningsInProject() >= 1 )
         {
            JOptionPane.showMessageDialog( Driver.pnlCanvas, "Currently showing first door" );
         }
         else
         {
            JOptionPane.showMessageDialog( Driver.pnlCanvas, "No doors currently exist in this project" );
         }
      }
   }
   
   private void processBtnNext()
   {
      if( validateDoorNumber( currentOpeningNumber + 1 ) )
      {
         disableEditing();
         
         currentOpeningNumber++;
         loadOpeningByNumber( currentOpeningNumber );
         
         updateDoorSearch();
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "No more doors in project" );
      }
   }
   
   private void processBtnEdit()
   {
      if( currentOpeningNumber >= MINIMUM_DOOR_NUMBER )
      {
         showDoorSelector();
         //doorSelections.setSelectedDoor( currentProject.get( currentDoor ).getDoorType() );
         //doorSelections.selectRadioButton();
         showBtnSaveOpening();
         enableBoxEditing( true );
         editingAnOpening = true;
      }
   }
   
   private void processBtnDelete()
   {
      int deleteConfirmation = JOptionPane.showConfirmDialog( Driver.pnlCanvas, 
                                                              "Are you sure you want to delete this door?",
                                                              "You are about to delete a door", 
                                                              JOptionPane.YES_NO_OPTION );
      
      if( deleteConfirmation == JOptionPane.YES_OPTION )
      {
         if( currentOpeningNumber >= 1 )
         {
            currentProject.removeOpening( currentOpeningNumber );
            FileOutput.writeCabinetProjectObject( currentProject );
            currentOpeningNumber--;
            if( currentOpeningNumber >= 1 )
            {
               loadOpeningByNumber( currentOpeningNumber );
               doorLabel.update( currentOpeningNumber );
            }
            else if( currentOpeningNumber < 1 &&
                     currentProject.getNumberOfOpeningsInProject() > currentOpeningNumber )
            {
               currentOpeningNumber = 1;
               loadOpeningByNumber( currentOpeningNumber );
               doorLabel.update( currentOpeningNumber );
            }
            else
            {
               JOptionPane.showMessageDialog( Driver.pnlCanvas, "That was the last door in the project" );
               currentOpeningNumber = 0;
               doorLabel.update( currentOpeningNumber );
               showDefaultValuesBox();
               clearAllFields();
            }
            updateDoorSearch();
            
            if( editingAnOpening )
            {
               disableEditing();
            }
         }
      }
   }
   
   private void processBtnLoadProject()
   {
      new CreateProjectPage();
   }
}