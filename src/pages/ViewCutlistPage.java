/*****************************
***************************** 
*
* File: ViewCutlistPage.java
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

package pages;

import java.awt.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import windows.Driver;
import miscellaneous.*;
import guiComponents.*;

public class ViewCutlistPage extends JPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Top menu constants
   public static final int TOP_MENU_WIDTH  = Driver.pnlCanvas.getWidth();
   public static final int TOP_MENU_HEIGHT = 40;
   public static final int TOP_MENU_X_LOCATION = 20;
   public static final int TOP_MENU_Y_LOCATION = TOP_MENU_HEIGHT / 2;
   
      // First cutlist panel constants
   public static final int FIRST_CUTLIST_X_LOCATION = 0;
   public static final int FIRST_CUTLIST_Y_LOCATION = TOP_MENU_HEIGHT;
   
      // Scrollpane constants
   public static final int VERTICAL_SCROLL_BAR_WIDTH = 25;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   CabinetProject currentProject;
   
   JScrollPane pageScroll;
   
   JPanel       parentCutlistPanel;
   CutlistPanel doorCutlist;
   CutlistPanel stileCutlist;
   CutlistPanel railCutlist;
   CutlistPanel panelCutlist;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public ViewCutlistPage( CabinetProject pCurrentProject )
   {
      currentProject = pCurrentProject;
      
      createChildCutlistPanels();
      disableMenuOptionsOnCutlists();
      createParentCutlistPanel(); 
      createPageScroll();
      createPage();      
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public JScrollPane getPageScroll()
   {
      return pageScroll;
   }
   
   public JPanel getParentCutlistPanel()
   {
      return parentCutlistPanel;
   }
   
   public CutlistPanel getDoorCutlist()
   {
      return doorCutlist;
   }
   
   public CutlistPanel getStileCutlist()
   {
      return stileCutlist;
   }
   
   public CutlistPanel getRailCutlist()
   {
      return railCutlist;
   }
   
   public CutlistPanel getPanelCutlist()
   {
      return panelCutlist;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createPage()
   {
         // Creating page
      setBounds( 0, 0, Driver.pnlCanvas.getWidth(), Driver.pnlCanvas.getHeight() );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( new BorderLayout() );
      add( pageScroll, BorderLayout.CENTER );
   }
   
   private void createPageScroll()
   {
         // Creating scrollpane
      pageScroll = new JScrollPane();
      pageScroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
      pageScroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
      pageScroll.setViewportView( parentCutlistPanel );
      pageScroll.getVerticalScrollBar().setUnitIncrement( 20 );
      pageScroll.setWheelScrollingEnabled( true );
   }
   
   private void createParentCutlistPanel()
   {
         // Creating parent cutlist panel
      parentCutlistPanel = new JPanel();
      parentCutlistPanel.setBackground( new Color( 50, 100, 150 ) );
      parentCutlistPanel.setLayout( new GridLayout( 4, 1 ) );
      
         // Add cutlist panels to parent cutlist panel
      parentCutlistPanel.add( doorCutlist  );
      parentCutlistPanel.add( stileCutlist );
      parentCutlistPanel.add( railCutlist  );
      parentCutlistPanel.add( panelCutlist );
   }
   
   private void createChildCutlistPanels()
   {
         // Creating cutlist panels
      doorCutlist  = new DoorCutlist ( currentProject, "Door Cutlist"  );
      stileCutlist = new StileCutlist( currentProject, "Stile Cutlist" );
      railCutlist  = new RailCutlist ( currentProject, "Rail Cutlist"  );
      panelCutlist = new PanelCutlist( currentProject, "Panel Cutlist" );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   private void disableMenuOptionsOnCutlists()
   {
         // doorCutlist disabilities
      doorCutlist.getMenuBar().disablePanelDimensionMenu();
      doorCutlist.getMenuBar().disableStileDimensionMenu();
      doorCutlist.getMenuBar().disableRailDimensionMenu();
      
         // stileCutlist disabilities
      stileCutlist.getMenuBar().disablePanelGap();
      stileCutlist.getMenuBar().disableTennonLength();
      stileCutlist.getMenuBar().disableDoorDimensionMenu();
      stileCutlist.getMenuBar().disablePanelDimensionMenu();
      stileCutlist.getMenuBar().disableOpeningDimensionMenu();
      stileCutlist.getMenuBar().disableRailDimensionMenu();
      stileCutlist.getMenuBar().disableOverlayDimensionMenu();
      
         // railCutlist disabilities
      railCutlist.getMenuBar().disablePanelGap();
      railCutlist.getMenuBar().disableTennonLength();
      railCutlist.getMenuBar().disableDoorDimensionMenu();
      railCutlist.getMenuBar().disablePanelDimensionMenu();
      railCutlist.getMenuBar().disableOpeningDimensionMenu();
      railCutlist.getMenuBar().disableStileDimensionMenu();
      railCutlist.getMenuBar().disableOverlayDimensionMenu();
      
         // panelCutlist disabilities
      panelCutlist.getMenuBar().disablePanelGap();
      panelCutlist.getMenuBar().disableTennonLength();
      panelCutlist.getMenuBar().disableDoorDimensionMenu();
      panelCutlist.getMenuBar().disableStileDimensionMenu();
      panelCutlist.getMenuBar().disableRailDimensionMenu();
   }
   
   public void repopulateCutlists()
   {
      doorCutlist.populateCutlist();
      stileCutlist.populateCutlist();
      railCutlist.populateCutlist();
      panelCutlist.populateCutlist();
   }
}
