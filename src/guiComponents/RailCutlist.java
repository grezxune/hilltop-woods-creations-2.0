/*****************************
******************************
*
* File: RailCutlist.java
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

public class RailCutlist extends CutlistPanel
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

   public RailCutlist( CabinetProject pCurrentProject, String pTitle )
   {
      super( pTitle );
      setCurrentProject( pCurrentProject );
      //populateCutlist();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public RailQuantityComparator getQuantityComparator()
   {
      return new RailQuantityComparator();
   }
   
   public RailLinearFeetComparator getLinearFeetComparator()
   {
      return new RailLinearFeetComparator();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public void createEntry( CabinetOpening pDoor )
   {
      /*createEntry( pDoor.getDoorNumber()  , pDoor.getNumberOfRails(),
                   pDoor.getTopRailWidth(), pDoor.getTopRailHeight(),
                   pDoor.getDoorType()    , pDoor.getRailLinearFeet() );*/
   }

	@Override
	public void populateCutlist() {
		// TODO Auto-generated method stub
		
	}
}
