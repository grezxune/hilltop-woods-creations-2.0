/*****************************
******************************
*
* File: StileCutlist.java
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

import newDoorSystem.CabinetOpening;
import comparators.*;
import miscellaneous.*;

public class StileCutlist extends CutlistPanel
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

   public StileCutlist( CabinetProject pCurrentProject, String pTitle )
   {
      super( pTitle );
      setCurrentProject( pCurrentProject );
      populateCutlist();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public StileQuantityComparator getQuantityComparator()
   {
      return new StileQuantityComparator();
   }
   
   public StileLinearFeetComparator getLinearFeetComparator()
   {
      return new StileLinearFeetComparator();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public void createEntry( CabinetOpening pDoor )
   {
      /*createEntry( pDoor.getDoorNumber()    , pDoor.getNumberOfStiles(),
                   pDoor.getLeftStileWidth(), pDoor.getLeftStileHeight(),
                   pDoor.getDoorType()      , pDoor.getStileLinearFeet() );*/
   }

	@Override
	public void populateCutlist() {
		// TODO Auto-generated method stub
		
	}
}
