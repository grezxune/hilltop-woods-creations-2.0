/*****************************
******************************
*
* File: TommysMenu.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 
* 
***************************** 
*****************************/

package customJComponents;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import windows.Driver;

public class TommysMenuBar extends JMenuBar implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color MENU_BAR_BACKGROUND_COLOR = Driver.PAGE_HEADER_BACKGROUND_COLOR;
   public static final Color MENU_BAR_FOREGROUND_COLOR = Color.WHITE;
   
      // Menu items string constants
   public static final String QUANTITY       = "Quantity";
   public static final String LINEAR_FEET    = "Linear Feet";
   public static final String DOOR_NUMBER    = "Door Number";
   public static final String DOOR_TYPE      = "Door Type";
   public static final String PANEL_GAP      = "Panel Gap";
   public static final String TENNON_LENGTH  = "Tennon Length";
   public static final String DOOR_WIDTH     = "Door Width";
   public static final String DOOR_HEIGHT    = "Door Height";
   public static final String PANEL_WIDTH    = "Panel Width";
   public static final String PANEL_HEIGHT   = "Panel Height";
   public static final String OPENING_WIDTH  = "Opening Width";
   public static final String OPENING_HEIGHT = "Opening Height";
   public static final String STILE_WIDTH    = "Stile Width";
   public static final String STILE_HEIGHT   = "Stile Height";
   public static final String RAIL_WIDTH     = "Rail Width";
   public static final String RAIL_HEIGHT    = "Rail Height";
   public static final String LEFT_OVERLAY   = "Left Overlay";
   public static final String RIGHT_OVERLAY  = "Right Overlay";
   public static final String TOP_OVERLAY    = "Top Overlay";
   public static final String BOTTOM_OVERLAY = "Bottom Overlay";
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

      // Sub menus
   private TommysMenu[] menus;
   
      // Radio button menu items
   private TommysRadioButtonMenuItem[] radioButtonMenuItems;
   
      // Group of buttons
   private ButtonGroup radioButtonGroup;
   
      // Print menu item
   private JMenuItem print;
   
   private JComponent selectedItem;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public TommysMenuBar()
   {
      createMenuBar();
      createMenus();
      createRadioButtonMenuItems();
      createPrintMenuItem();
      addRadioButtonmenuItemsToMenus();
      addMenusToBar();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public ButtonGroup getRadioButtonGroup()
   {
      return radioButtonGroup;
   }
   
   public JComponent getSelectedItem()
   {
      return selectedItem;
   }
   
   public TommysMenu[] getMenus()
   {
      return menus;
   }
   
   public TommysRadioButtonMenuItem[] getRadioButtons()
   {
      return radioButtonMenuItems;
   }
   
   public JMenuItem getPrintMenuItem()
   {
      return print;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createMenuBar()
   {
      setBackground( MENU_BAR_BACKGROUND_COLOR );
   }
   
   private void createMenus()
   {  
      menus = new TommysMenu[ 8 ];
      
      menus[ 0 ] = new TommysMenu( "File"               );
      menus[ 1 ] = new TommysMenu( "Sort By"            );
      menus[ 2 ] = new TommysMenu( "Door Dimensions"    );
      menus[ 3 ] = new TommysMenu( "Panel Dimensions"   );
      menus[ 4 ] = new TommysMenu( "Opening Dimensions" );
      menus[ 5 ] = new TommysMenu( "Stile Dimensions"   );
      menus[ 6 ] = new TommysMenu( "Rail Dimensions"    );
      menus[ 7 ] = new TommysMenu( "Overlay Dimensions" );
   }
   
   private void createRadioButtonMenuItems()
   {
      radioButtonMenuItems = new TommysRadioButtonMenuItem[ 20 ];
      
      radioButtonMenuItems[ 0 ]  = new TommysRadioButtonMenuItem( QUANTITY       );
      radioButtonMenuItems[ 1 ]  = new TommysRadioButtonMenuItem( LINEAR_FEET    );
      radioButtonMenuItems[ 2 ]  = new TommysRadioButtonMenuItem( DOOR_NUMBER    );
      radioButtonMenuItems[ 3 ]  = new TommysRadioButtonMenuItem( DOOR_TYPE      );
      radioButtonMenuItems[ 4 ]  = new TommysRadioButtonMenuItem( PANEL_GAP      );
      radioButtonMenuItems[ 5 ]  = new TommysRadioButtonMenuItem( TENNON_LENGTH  );
      radioButtonMenuItems[ 6 ]  = new TommysRadioButtonMenuItem( DOOR_WIDTH     );
      radioButtonMenuItems[ 7 ]  = new TommysRadioButtonMenuItem( DOOR_HEIGHT    );
      radioButtonMenuItems[ 8 ]  = new TommysRadioButtonMenuItem( PANEL_WIDTH    );
      radioButtonMenuItems[ 9 ]  = new TommysRadioButtonMenuItem( PANEL_HEIGHT   );
      radioButtonMenuItems[ 10 ] = new TommysRadioButtonMenuItem( OPENING_WIDTH  );
      radioButtonMenuItems[ 11 ] = new TommysRadioButtonMenuItem( OPENING_HEIGHT );
      radioButtonMenuItems[ 12 ] = new TommysRadioButtonMenuItem( STILE_WIDTH    );
      radioButtonMenuItems[ 13 ] = new TommysRadioButtonMenuItem( STILE_HEIGHT   );
      radioButtonMenuItems[ 14 ] = new TommysRadioButtonMenuItem( RAIL_WIDTH     );
      radioButtonMenuItems[ 15 ] = new TommysRadioButtonMenuItem( RAIL_HEIGHT    );
      radioButtonMenuItems[ 16 ] = new TommysRadioButtonMenuItem( LEFT_OVERLAY   );
      radioButtonMenuItems[ 17 ] = new TommysRadioButtonMenuItem( RIGHT_OVERLAY  );
      radioButtonMenuItems[ 18 ] = new TommysRadioButtonMenuItem( TOP_OVERLAY    );
      radioButtonMenuItems[ 19 ] = new TommysRadioButtonMenuItem( BOTTOM_OVERLAY );
      
      radioButtonGroup = new ButtonGroup();
      
      for( int i = 0; i < radioButtonMenuItems.length; i++ )
      {
         radioButtonGroup.add( radioButtonMenuItems[ i ] );
         radioButtonMenuItems[ i ].addActionListener( this );
      }
   }
   
   private void createPrintMenuItem()
   {
      print = new JMenuItem( "Print" );
      print.setBackground( TommysMenu.MENU_BACKGROUND_COLOR );
      print.setForeground( MENU_BAR_FOREGROUND_COLOR );
      print.setFont( new Font( "Algerian", Font.PLAIN, 12 ) );
   }
   
   private void addRadioButtonmenuItemsToMenus()
   {
      menus[ 2 ].add( radioButtonMenuItems[ 6 ]  );
      menus[ 2 ].add( radioButtonMenuItems[ 7 ]  );
      menus[ 3 ].add( radioButtonMenuItems[ 8 ]  );
      menus[ 3 ].add( radioButtonMenuItems[ 9 ]  );
      menus[ 4 ].add( radioButtonMenuItems[ 10 ] );
      menus[ 4 ].add( radioButtonMenuItems[ 11 ] );
      menus[ 5 ].add( radioButtonMenuItems[ 12 ] );
      menus[ 5 ].add( radioButtonMenuItems[ 13 ] );
      menus[ 6 ].add( radioButtonMenuItems[ 14 ] );
      menus[ 6 ].add( radioButtonMenuItems[ 15 ] );
      menus[ 7 ].add( radioButtonMenuItems[ 16 ] );
      menus[ 7 ].add( radioButtonMenuItems[ 17 ] );
      menus[ 7 ].add( radioButtonMenuItems[ 18 ] );
      menus[ 7 ].add( radioButtonMenuItems[ 19 ] );
   }
   
   private void addMenusToBar()
   {
         // Add "File" / "Sort" menus to bar
      add( menus[ 0 ] );
      add( menus[ 1 ] );
      
         // Add menu items to "File" menu
      menus[ 0 ].add( print );
      
         // Add sub menus to "Sort" menu
      menus[ 1 ].add( radioButtonMenuItems[ 0 ] );
      menus[ 1 ].add( radioButtonMenuItems[ 1 ] );
      menus[ 1 ].add( radioButtonMenuItems[ 2 ] );
      menus[ 1 ].add( radioButtonMenuItems[ 3 ] );
      menus[ 1 ].add( radioButtonMenuItems[ 4 ] );
      menus[ 1 ].add( radioButtonMenuItems[ 5 ] );
      menus[ 1 ].add( menus[ 2 ] );
      menus[ 1 ].add( menus[ 3 ] );
      menus[ 1 ].add( menus[ 4 ] );
      menus[ 1 ].add( menus[ 5 ] );
      menus[ 1 ].add( menus[ 6 ] );
      menus[ 1 ].add( menus[ 7 ] );
   }
   
   private void setSelectedItem( JComponent pSelectedItem )
   {
      selectedItem = pSelectedItem;
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   /*** Disable menu options methods ***/
   public void disableQuantity()
   {
      radioButtonMenuItems[ 0 ].setEnabled( false );
   }
   
   public void disableLinearFeet()
   {
      radioButtonMenuItems[ 1 ].setEnabled( false );
   }
   
   public void disableDoorNumber()
   {
      radioButtonMenuItems[ 2 ].setEnabled( false );
   }
   
   public void disableDoorType()
   {
      radioButtonMenuItems[ 3 ].setEnabled( false );
   }
   
   public void disablePanelGap()
   {
      radioButtonMenuItems[ 4 ].setEnabled( false );
   }
   
   public void disableTennonLength()
   {
      radioButtonMenuItems[ 5 ].setEnabled( false );
   }
   
   public void disableDoorDimensionMenu()
   {
      menus[ 2 ].setEnabled( false );
   }
   
   public void disablePanelDimensionMenu()
   {
      menus[ 3 ].setEnabled( false );
   }
   
   public void disableOpeningDimensionMenu()
   {
      menus[ 4 ].setEnabled( false );
   }
   
   public void disableStileDimensionMenu()
   {
      menus[ 5 ].setEnabled( false );
   }
   
   public void disableRailDimensionMenu()
   {
      menus[ 6 ].setEnabled( false );
   }
   
   public void disableOverlayDimensionMenu()
   {
      menus[ 7 ].setEnabled( false );
   }
   
   public void actionPerformed( ActionEvent e )
   {
      
   }
}
