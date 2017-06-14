/*****************************
******************************
*
* File: DoorLabel.java
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
import newDoorSystem.CabinetOpening;
import javax.swing.*;
import customJComponents.TommysLabel;

public class DoorLabel extends JPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Panel constants
   public static final Color DOOR_LABEL_PANEL_COLOR = new Color( 245, 94, 12 );
   
   public static final int FIRST_LABEL_X_LOCATION = 5;
   public static final int FIRST_LABEL_Y_LOCATION = 8;
   
   public static final int FIRST_LABEL_WIDTH  = 170;
   public static final int FIRST_LABEL_HEIGHT = 15;
   
   public static final int SECOND_LABEL_WIDTH  = 50;
   public static final int SECOND_LABEL_HEIGHT = 15;
   
   public static final int LABEL_SPACING = 3;
   
   public static final Font DOOR_LABEL_FONT = new Font( "Algerian", Font.PLAIN, 15 );
   
   public static final int DOOR_LABEL_WIDTH  = 300;
   public static final int DOOR_LABEL_HEIGHT = ( FIRST_LABEL_HEIGHT * 3 ) + ( LABEL_SPACING * 5 );
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private TommysLabel lblDoorsInProject;
   private TommysLabel lblNumberOfDoors;
   
   private TommysLabel lblCurrentDoorNumber;
   private TommysLabel lblDoorNumber;
   
   private TommysLabel lblCurrentDoorType;
   private TommysLabel lblDoorType;
   
   private CabinetProject currentProject;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public DoorLabel( CabinetProject pCurrentProject, int xLocation, int yLocation )
   {
      currentProject = pCurrentProject;
      
      setBounds( xLocation, yLocation, DOOR_LABEL_WIDTH, DOOR_LABEL_HEIGHT );
      setLayout( null );
      setBackground( DOOR_LABEL_PANEL_COLOR );
      setBorder( BorderFactory.createLoweredBevelBorder() );
      setVisible( true );
      
      createLabels();
      update( pCurrentProject.getNumberOfOpeningsInProject() );
      addLabelsToPanel();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setCurrentProject( CabinetProject pProject )
   {
      currentProject = pProject;
   }
   
   public void setDoorType( String pDoorType )
   {
      lblDoorType.setText( pDoorType );
      setVisible( true );
   }
   
   public void setDoorType( CabinetOpening pCabinetDoor )
   {
      //lblDoorType.setText( pCabinetDoor.getDoorType() );
      setVisible( true );
   }
   
   private void createLabels()
   {
      lblDoorsInProject = new TommysLabel( "Total Doors: ", FIRST_LABEL_X_LOCATION, FIRST_LABEL_Y_LOCATION,
                                           FIRST_LABEL_WIDTH     , FIRST_LABEL_HEIGHT    );
      lblDoorsInProject.setFont( DOOR_LABEL_FONT );
      
      lblNumberOfDoors = new TommysLabel( lblDoorsInProject.getX() + lblDoorsInProject.getWidth() + 5,
                                          FIRST_LABEL_Y_LOCATION, SECOND_LABEL_WIDTH, SECOND_LABEL_HEIGHT );
      lblNumberOfDoors.setFont( DOOR_LABEL_FONT );
      
      lblCurrentDoorNumber = new TommysLabel( "Current Door: ", FIRST_LABEL_X_LOCATION, lblDoorsInProject.getY() + FIRST_LABEL_HEIGHT,
                                              FIRST_LABEL_WIDTH, FIRST_LABEL_HEIGHT );
      lblCurrentDoorNumber.setFont( DOOR_LABEL_FONT );
      
      lblDoorNumber = new TommysLabel( lblNumberOfDoors.getX(), lblCurrentDoorNumber.getY(),
                                       SECOND_LABEL_WIDTH, SECOND_LABEL_HEIGHT );
      lblDoorNumber.setFont( DOOR_LABEL_FONT );
      
      lblCurrentDoorType = new TommysLabel( "Door Type: ", FIRST_LABEL_X_LOCATION, lblCurrentDoorNumber.getY() + FIRST_LABEL_HEIGHT, 
                                            95, FIRST_LABEL_HEIGHT );
      lblCurrentDoorType.setFont( DOOR_LABEL_FONT );
      
      lblDoorType = new TommysLabel( lblCurrentDoorType.getX() + lblCurrentDoorType.getWidth() + LABEL_SPACING, 
                                     lblCurrentDoorType.getY(), 
                                     FIRST_LABEL_WIDTH + 30, SECOND_LABEL_HEIGHT );   
      lblDoorType.setFont( DOOR_LABEL_FONT );
   }
   
   public void update( int pCurrentDoor )
   {
      lblNumberOfDoors.setText( String.valueOf( currentProject.getNumberOfOpeningsInProject() ) );
      lblDoorNumber   .setText( String.valueOf( pCurrentDoor ) );
      lblDoorType     .setText( "" );
   }
   
   /*public void update( int pOpeningNumber )
   {
      lblNumberOfDoors.setText( String.valueOf( currentProject.getNumberOfOpeningsInProject() ) );
      lblDoorNumber   .setText( String.valueOf( pOpeningNumber ) );
   }*/
   
   public void update( String pDoorType )
   {
      lblNumberOfDoors.setText( String.valueOf( currentProject.getNumberOfOpeningsInProject() ) );
      lblDoorNumber   .setText( String.valueOf( currentProject.getNumberOfOpeningsInProject() + 1 ) );
      lblDoorType     .setText( pDoorType );
   }
   
   private void addLabelsToPanel()
   {
      add( lblDoorsInProject );
      add( lblNumberOfDoors  );
      
      add( lblCurrentDoorNumber );
      add( lblDoorNumber        );
      
      add( lblCurrentDoorType );
      add( lblDoorType        );
      
      repaint();
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
