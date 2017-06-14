/*****************************
******************************
*
* File: DoorCutlist.java
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

import java.awt.event.*;
import newDoorSystem.CabinetOpening;
import comparators.*;
import miscellaneous.*;

public class DoorCutlist extends CutlistPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/

   public DoorCutlist( CabinetProject pCurrentProject, String pTitle )
   {
      super( pTitle );
      setCurrentProject( pCurrentProject );
      populateCutlist();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public DoorQuantityComparator getQuantityComparator()
   {
      return new DoorQuantityComparator();
   }
   
   public DoorLinearFeetComparator getLinearFeetComparator()
   {
      return new DoorLinearFeetComparator();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public void createEntry( CabinetOpening pDoor )
   {
      /*createEntry( pDoor.getDoorNumber(), pDoor.getNumberOfDoors(),
                   pDoor.getDoorWidth() , pDoor.getDoorHeight()   ,
                   pDoor.getDoorType()  , pDoor.getDoorLinearFeet() );*/
   }

	@Override
	public void populateCutlist() {
		// TODO Auto-generated method stub
		
	}
}
