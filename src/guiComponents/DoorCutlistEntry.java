/*****************************
******************************
*
* File: DoorCutlistEntry.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 12/20/2013
* 
***************************** 
*****************************/

package guiComponents;

import newDoorSystem.CabinetOpening;

public class DoorCutlistEntry extends CutlistEntry
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

   public DoorCutlistEntry( CabinetOpening pOpening )
   {
      super( pOpening, pOpening.getNumberOfDoors() );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setLabelTexts( CabinetOpening pOpening )
   {
      setLblQuantityText( pOpening.getDoors().getQuantity() );
      setLblWidthXHeightText( pOpening.getDoors().getWidth(), pOpening.getDoors().getHeight() );
      setLblLinearFeetText( pOpening.getDoors().getLinearFeet() * pOpening.getDoors().getQuantity() );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
