/*****************************
******************************
*
* File: StileCutlistEntry.java
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

public class StileCutlistEntry extends CutlistEntry
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

   public StileCutlistEntry( CabinetOpening pOpening )
   {
      super( pOpening, pOpening.getNumberOfStilesPerOpening() );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setLabelTexts( CabinetOpening pOpening )
   {
      setLblQuantityText( pOpening.getNumberOfStilesPerOpening() );
      setLblWidthXHeightText( pOpening.getDoors().getLeftStile().getWidth(), pOpening.getDoors().getLeftStile().getHeight() );
      setLblLinearFeetText( pOpening.getDoors().getLeftStile().getLinearFeet() * 2 * pOpening.getDoors().getQuantity() );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
