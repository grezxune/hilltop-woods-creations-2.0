/*****************************
******************************
*
* File: CenterRailLocations.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 3/19/2013
* 
***************************** 
*****************************/

package windows;

import java.awt.*;
import customJComponents.*;
import guiComponents.*;
import javax.swing.*;
import newDoorSystem.CabinetOpening;

public class CenterRailLocations
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final String WINDOW_TITLE = "Center Rail Locations";
   
   public static final int WINDOW_WIDTH  = Driver.CANVAS_WIDTH / 3;
   public static final int WINDOW_HEIGHT = 200;
   public static final int ENTRY_HEIGHT  = 35;
   
   public static final int RAIL_LOCATIONS_X_LOCATION = 20;
   public static final int RAIL_LOCATIONS_Y_LOCATION = 20;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private JFrame window;
   
   private JMenuBar menuBar;
   private TommysMenu mnuOrientation;
   
   private TommysRadioButtonMenuItem[] verticalCenterRailOptions;
   private TommysRadioButtonMenuItem[] horizontalCenterRailOptions;
   
   private JPanel pnlMain;
   
   private TommysLabel lblCurrentDoor;
   
   private TommysButton btnDone;
   
   private int numberOfCenterRails;
   private int typeOfDoor;
   private boolean windowOpen;
   
   private CenterRailLocationsPanel pnlRailLocations;
   private CabinetOpening currentDoor;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CenterRailLocations( CabinetOpening pCurrentDoor )
   {
      //numberOfCenterRails = pCurrentDoor.;
      currentDoor = pCurrentDoor;
      
      showVerticalCenterRailOptions();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public void showVerticalCenterRailOptions()
   {
      typeOfDoor = 1;
      
      createWindow();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createWindow()
   {
      window = new JFrame( WINDOW_TITLE );
      window.setVisible( true );
      window.setLayout( new BorderLayout() );
      window.setLocationRelativeTo( null );
      window.setPreferredSize( new Dimension( WINDOW_WIDTH, WINDOW_HEIGHT + ( ENTRY_HEIGHT * numberOfCenterRails ) ) );
      window.setAlwaysOnTop( true );
      window.setFocusable( true );
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      createPnlMain();
      
      window.getContentPane().add( pnlMain );
      window.pack();
   }
   
   private void createPnlMain()
   {
      pnlMain = new JPanel();
      pnlMain.setPreferredSize( new Dimension( window.getWidth(), window.getHeight() ) );
      pnlMain.setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      pnlMain.setLayout( null );
      
      createMenu();
      createRailLocationsPanel();
      
      pnlMain.add( menuBar );
      pnlMain.add( pnlRailLocations );
   }
   
   private void createMenu()
   {
      menuBar = new JMenuBar();
      menuBar.setBackground( TommysMenuBar.MENU_BAR_BACKGROUND_COLOR );
      menuBar.setForeground( TommysMenuBar.MENU_BAR_FOREGROUND_COLOR );
      menuBar.setBounds( 0, 0, WINDOW_WIDTH, 30 );
      
      createMenuItems();
      mnuOrientation = new TommysMenu( "Orientation" );
      
         // Adding radio button options to menu
      if( typeOfDoor == 1 )
      {
         for( int j = 0; j < verticalCenterRailOptions.length; j++ )
         {
            mnuOrientation.add( verticalCenterRailOptions[ j ] );
         }
      }
      else if( typeOfDoor == 2 )
      {
         for( int j = 0; j < horizontalCenterRailOptions.length; j++ )
         {
            mnuOrientation.add( horizontalCenterRailOptions[ j ] );
         }
      }
      
      menuBar.add( mnuOrientation );
   }
   
   private void createMenuItems()
   {  
         // Instantiate first group of objects
      ButtonGroup verticalGroup = new ButtonGroup();
      verticalCenterRailOptions = new TommysRadioButtonMenuItem[ 3 ];
      
      verticalCenterRailOptions[ 0 ] = new TommysRadioButtonMenuItem( "Left"   );
      verticalCenterRailOptions[ 1 ] = new TommysRadioButtonMenuItem( "Center" );
      verticalCenterRailOptions[ 2 ] = new TommysRadioButtonMenuItem( "Right"  );
      
         // Add options to button group
      verticalGroup.add( verticalCenterRailOptions[ 0 ] );
      verticalGroup.add( verticalCenterRailOptions[ 1 ] );
      verticalGroup.add( verticalCenterRailOptions[ 2 ] );
      
         // Instantiate second group of objects
      ButtonGroup horizontalGroup = new ButtonGroup();
      horizontalCenterRailOptions = new TommysRadioButtonMenuItem[ 3 ];
      
      horizontalCenterRailOptions[ 0 ] = new TommysRadioButtonMenuItem( "Top"    );
      horizontalCenterRailOptions[ 1 ] = new TommysRadioButtonMenuItem( "Center" );
      horizontalCenterRailOptions[ 2 ] = new TommysRadioButtonMenuItem( "Bottom" );
      
         // Add options to button group 
      horizontalGroup.add( verticalCenterRailOptions[ 0 ] );
      horizontalGroup.add( verticalCenterRailOptions[ 1 ] );
      horizontalGroup.add( verticalCenterRailOptions[ 2 ] );
   }
   
   private void createRailLocationsPanel()
   {
      /*pnlRailLocations = new CenterRailLocationsPanel( RAIL_LOCATIONS_X_LOCATION, RAIL_LOCATIONS_Y_LOCATION, 
                                                       numberOfCenterRails, currentDoor.getDoorWidth() );*/
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
