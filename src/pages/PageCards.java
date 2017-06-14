/*****************************
****************************** 
*
* File: PageCards.java
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

import miscellaneous.*;
import javax.swing.*;
import javax.swing.event.*;
import windows.Driver;
import customJComponents.TommysButton;
import java.awt.*;

public class PageCards extends JTabbedPane
                       implements ChangeListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color TAB_BACKGROUND_COLOR = TommysButton.BUTTON_FOREGROUND_COLOR;
   public static final Color TAB_FOREGROUND_COLOR = Color.BLACK;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private CabinetProject currentProject;
   
   private CreateDoorPage  createDoorPage;
   private ViewDoorPage    viewDoorPage;
   private ViewCutlistPage viewCutlistPage;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public PageCards( CabinetProject pCurrentProject )
   {
      setBounds( 0, 0, Driver.pnlCanvas.getWidth(), Driver.pnlCanvas.getHeight() );
      addChangeListener( this );
      currentProject = pCurrentProject;
      
      Driver.pnlCanvas.removeAll();
      
      createDoorPage  = new CreateDoorPage ( currentProject );
      viewDoorPage    = new ViewDoorPage   ( currentProject );
      viewCutlistPage = new ViewCutlistPage( currentProject );
      
      add( createDoorPage , "Create Door"  );
      add( viewDoorPage   , "View Door"    );
      add( viewCutlistPage, "View Cutlist" );
      setBackgroundAt( 0, TAB_BACKGROUND_COLOR );
      setBackgroundAt( 1, TAB_BACKGROUND_COLOR );
      setBackgroundAt( 2, TAB_BACKGROUND_COLOR );
      
      setForegroundAt( 0, TAB_FOREGROUND_COLOR );
      setForegroundAt( 1, TAB_FOREGROUND_COLOR );
      setForegroundAt( 2, TAB_FOREGROUND_COLOR );
      
      Driver.pnlCanvas.add( this );
      Driver.pnlCanvas.repaint();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public void stateChanged( ChangeEvent e )
   {
      if( getSelectedIndex() == 0 ) // CreateDoorPage selected
      {
         if( createDoorPage.getDoorKit().getDoorSelectionBox().getGroupOfButtons().getSelection() != null )
         {
               // update label to have that doors name for door type
            createDoorPage.getDoorKit().getDoorLabel().update( createDoorPage.getDoorKit().getDoorSelectionBox().getSelectedDoor() );
         }
         else
         {
               // update label to have nothing for door type
            createDoorPage.getDoorKit().getDoorLabel().update( currentProject.getNumberOfOpeningsInProject() + 1 );
         }
      }
      else if( getSelectedIndex() == 1 ) // ViewDoorPage selected
      {
         currentProject = createDoorPage.getCurrentProject();
         viewDoorPage.getDoorKit().disableEditing();
         
         if( currentProject.getNumberOfOpeningsInProject() >= 1 )
         {
            int currentDoor = viewDoorPage.getDoorKit().getCurrentOpeningNumber();
            viewDoorPage.getDoorKit().getDoorLabel().update( currentDoor >= 1 ? currentDoor : 1 );
            viewDoorPage.getDoorKit().loadOpeningByNumber( currentDoor >= 1 ? currentDoor : 1 );
         }
         else
         {
            viewDoorPage.getDoorKit().updateLabel();
         }
      }
      else if( getSelectedIndex() == 2 ) // ViewCutlistPage selected
      {
         viewCutlistPage.repopulateCutlists();
         
         
         // TODO -- > This line doesn't work...!
         viewCutlistPage.getPageScroll().setViewportView( viewCutlistPage.getParentCutlistPanel() );
      }
   }
}
