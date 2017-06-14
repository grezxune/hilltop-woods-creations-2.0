/*****************************
******************************
*
* File: RailCutlistEntry.java
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

public class RailCutlistEntry extends CutlistEntry
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

   public RailCutlistEntry( CabinetOpening pOpening )
   {
      super( pOpening, pOpening.getNumberOfRailsPerOpening() );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setLabelTexts( CabinetOpening pOpening )
   {
      setLblQuantityText( pOpening.getNumberOfRailsPerOpening() );
      setLblWidthXHeightText( pOpening.getDoors().getTopRail().getWidth(), pOpening.getDoors().getTopRail().getHeight() );
      setLblLinearFeetText( pOpening.getDoors().getTopRail().getLinearFeet() * 2 * pOpening.getDoors().getQuantity() );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
