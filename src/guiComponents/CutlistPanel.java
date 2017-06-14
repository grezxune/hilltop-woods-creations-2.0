/*****************************
******************************
*
* File: CutlistPanel.java
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

package guiComponents;

import miscellaneous.*;
import newDoorSystem.CabinetOpening;
import javax.swing.*;
import windows.Driver;
import comparators.*;
import customJComponents.*;
import dataStructures.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class CutlistPanel extends JPanel 
                                   implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Panel constants
   public static final Color CUTLIST_BACKGROUND_COLOR = Driver.CANVAS_BACKGROUND_COLOR;
   
   public static final int PANEL_WIDTH  = Driver.pnlCanvas.getWidth();
   
      // btnPrint constants
   public static final int PRINT_BUTTON_X_LOCATION = 50;
   public static final int PRINT_BUTTON_Y_LOCATION = 10;
   public static final int PRINT_BUTTON_WIDTH  = TommysButton.BUTTON_X_PIXELS;
   public static final int PRINT_BUTTON_HEIGHT = TommysButton.BUTTON_Y_PIXELS;
   
      // txaCutlist constants
   public static final int FIRST_ENTRY_X_POSITION = 0;
   public static final int FIRST_ENTRY_Y_POSITION = 50;
   
      // Entry constants
   public static final int ENTRY_HEIGHT = 24;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private String         panelTitle;
   private CabinetProject currentProject;
   private TommysMenuBar  menuBar;
   private int            numberOfEntries;
   
   private JMenuItem printMenuItem;
   private TommysRadioButtonMenuItem[] radioButtonMenuItems;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CutlistPanel( String pPanelTitle )
   {
         // Setup cutlist panel
      setupCutlistPanel();
      
         // Add all components to panel
      addComponentsToPanel();
      
      createMenuBar();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public String getPanelTitle()
   {
      return panelTitle;
   }
   
   public CabinetProject getCurrentProject()
   {
      return currentProject;
   }
   
   public TommysMenuBar getMenuBar()
   {
      return menuBar;
   }
   
   public int getNumberOfEntries()
   {
      return numberOfEntries;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void setupCutlistPanel()
   {
      setLayout( new BorderLayout() );
      resizePanel();
      setBackground( CUTLIST_BACKGROUND_COLOR );
      //setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, Driver.PAGE_HEADER_BACKGROUND_COLOR, Color.WHITE ) );
   }
   
   private void resizePanel()
   {
      setPreferredSize( new Dimension( 0, ( ( ENTRY_HEIGHT * 5 ) + ( ENTRY_HEIGHT * numberOfEntries ) ) ) );
   }
   
   public void setCurrentProject( CabinetProject pCurrentProject )
   {
      currentProject = pCurrentProject;
   }
   
   private void createMenuBar()
   {
      menuBar = new TommysMenuBar();
      
      printMenuItem        = menuBar.getPrintMenuItem();
      radioButtonMenuItems = menuBar.getRadioButtons();
      
      printMenuItem.addActionListener( this );
      
      for( int i = 0; i < radioButtonMenuItems.length; i++ )
      {
         radioButtonMenuItems[ i ].addActionListener( this );
      }
      
      add( menuBar, BorderLayout.NORTH );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   private void createCutlistHeader()
   {
      
   }
   
   private void addComponentsToPanel()
   {
      
   }
   
   /*public void populateCutlist()
   {
      numberOfEntries = 0;
      createCutlistHeader();
      
      for( int i = 1; i <= currentProject.getNumberOfOpeningsInProject(); i++ )
      {
         createEntry( currentProject.getOpening( i ) );
      }
   }*/

   public void actionPerformed( ActionEvent e )
   {
      for( int i = 0; i < radioButtonMenuItems.length; i++ )
      {
         if( e.getSource() == radioButtonMenuItems[ i ] )
         {
            processSortByMenuItem( radioButtonMenuItems[ i ].getText() );
         }
      }
      
      if( e.getSource() == printMenuItem )
      {
         System.out.println( "Print..." );
      }
   }
   
   private void processSortByMenuItem( String pSortByChosen )
   {
      // TODO -- > Fix my CabinetList so it is iterable. ( I was forced to use LinkedList< CabinetDoor > )
      numberOfEntries = 0;
      createCutlistHeader();
      LinkedList< CabinetOpening > copyOfOpenings = new LinkedList<>();
      
      for( int i = 1; i <= currentProject.getNumberOfOpeningsInProject(); i++ )
      {
         copyOfOpenings.add( currentProject.getOpening( i ) );
      }
      
      switch( pSortByChosen )
      {
      case TommysMenuBar.QUANTITY:
         Collections.sort( copyOfOpenings, getQuantityComparator() );
         break;
      case TommysMenuBar.LINEAR_FEET:
         Collections.sort( copyOfOpenings, getLinearFeetComparator() );
         break;
      case TommysMenuBar.DOOR_NUMBER:
         Collections.sort( copyOfOpenings, new DoorNumberComparator() );
         break;
      case TommysMenuBar.DOOR_TYPE:
         Collections.sort( copyOfOpenings, new DoorTypeComparator() );
         break;
      case TommysMenuBar.PANEL_GAP:
         Collections.sort( copyOfOpenings, new PanelGapComparator() );
         break;
      case TommysMenuBar.TENNON_LENGTH:
         Collections.sort( copyOfOpenings, new TennonLengthComparator() );
         break;
      case TommysMenuBar.DOOR_WIDTH:
         Collections.sort( copyOfOpenings, new DoorWidthComparator() );
         break;
      case TommysMenuBar.DOOR_HEIGHT:
         Collections.sort( copyOfOpenings, new DoorHeightComparator() );
         break;
      case TommysMenuBar.PANEL_WIDTH:
         Collections.sort( copyOfOpenings, new PanelWidthComparator() );
         break;
      case TommysMenuBar.PANEL_HEIGHT:
         Collections.sort( copyOfOpenings, new PanelHeightComparator() );
         break;
      case TommysMenuBar.OPENING_WIDTH:
         Collections.sort( copyOfOpenings, new OpeningWidthComparator() );
         break;
      case TommysMenuBar.OPENING_HEIGHT:
         Collections.sort( copyOfOpenings, new OpeningHeightComparator() );
         break;
      case TommysMenuBar.STILE_WIDTH:
         Collections.sort( copyOfOpenings, new StileWidthComparator() );
         break;
      case TommysMenuBar.STILE_HEIGHT:
         Collections.sort( copyOfOpenings, new StileHeightComparator() );
         break;
      case TommysMenuBar.RAIL_WIDTH:
         Collections.sort( copyOfOpenings, new RailWidthComparator() );
         break;
      case TommysMenuBar.RAIL_HEIGHT:
         Collections.sort( copyOfOpenings, new RailHeightComparator() );
         break;
      case TommysMenuBar.LEFT_OVERLAY:
         Collections.sort( copyOfOpenings, new LeftOverlayComparator() );
         break;
      case TommysMenuBar.RIGHT_OVERLAY:
         Collections.sort( copyOfOpenings, new RightOverlayComparator() );
         break;
      case TommysMenuBar.TOP_OVERLAY:
         Collections.sort( copyOfOpenings, new TopOverlayComparator() );
         break;
      case TommysMenuBar.BOTTOM_OVERLAY:
         Collections.sort( copyOfOpenings, new BottomOverlayComparator() );
         break;
      }
      
      //populateCutlist( copyOfOpenings );
   }
   
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
   public abstract Comparator< CabinetOpening > getQuantityComparator();
   public abstract Comparator< CabinetOpening > getLinearFeetComparator();
   
   public abstract void populateCutlist();//( LinkedList < CabinetOpening > pListToPopulateFrom );
}