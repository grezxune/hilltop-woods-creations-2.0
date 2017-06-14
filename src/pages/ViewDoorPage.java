/*****************************
***************************** 
*
* File: ViewDoorPage.java
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
import javax.swing.*;
import windows.Driver;
import miscellaneous.*;
import guiComponents.*;

public class ViewDoorPage extends JPanel
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private CabinetProject currentProject;
   
   private DoorViewingKit doorKit;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public ViewDoorPage( CabinetProject pCurrentProject )
   {
      setBounds( 0, 0, Driver.pnlCanvas.getWidth(), Driver.pnlCanvas.getHeight() );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( null );
      
      currentProject = pCurrentProject;
      
      doorKit = new DoorViewingKit( currentProject );
      
      doorKit.enableBoxEditing( false );
      doorKit.hideDoorSelector();
      doorKit.hideBtnSaveOpening();
      doorKit.showBtnLoadProject();
      
      add( doorKit );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public DoorViewingKit getDoorKit()
   {
      return doorKit;
   }
}
