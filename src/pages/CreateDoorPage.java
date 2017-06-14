/*****************************
****************************** 
*
* File: CreateDoorPage.java
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
import java.awt.event.*;
import guiComponents.*;
import miscellaneous.*;
import javax.swing.*;
import windows.Driver;

public class CreateDoorPage extends JPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Door selection box constants
   public static final int DOOR_SELECTION_BOX_X_LOCATION = 30;
   public static final int DOOR_SELECTION_BOX_Y_LOCATION = 100;
   
      // Door values boxes constants
   public static final int PROJECT_SPECIFIC_BOX_X_LOCATION = 375;
   public static final int PROJECT_SPECIFIC_BOX_Y_LOCATION = 20;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private DoorViewingKit doorKit;
   
   private CabinetProject currentProject;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CreateDoorPage( CabinetProject pCurrentProject )
   {
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( null );
      currentProject = pCurrentProject;
      
      doorKit = new DoorViewingKit( currentProject );
      
      doorKit.hideBtnNext();
      doorKit.hideBtnPrevious();
      doorKit.hideDoorSearch();
      doorKit.hideBtnEdit();
      doorKit.hideBtnDelete();
      doorKit.showBtnLoadProject();
      
      add( doorKit );
      
      repaint();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public CabinetProject getCurrentProject()
   {
      return currentProject;
   }
   
   public DoorViewingKit getDoorKit()
   {
      return doorKit;
   }
}
