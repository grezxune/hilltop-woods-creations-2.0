/*****************************
******************************
*
* File: PanelCutlistEntry.java
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

public class PanelCutlistEntry extends CutlistEntry
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

   public PanelCutlistEntry( CabinetOpening pOpening )
   {
      super( pOpening, pOpening.getNumberOfPanelsPerOpening() );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setLabelTexts( CabinetOpening pOpening )
   {
      int[] quantity = new int[pOpening.getNumberOfPanelsPerOpening()];
      
      double[] widths     = new double[quantity.length];
      double[] heights    = new double[quantity.length];
      double[] linearFeet = new double[quantity.length];
      
      for(int i = 0; i < quantity.length; i++)
      {
         quantity[i] = pOpening.getDoors().getPanels().get( i ).getQuantity(); 
      }
      
      for(int i = 0; i < widths.length; i++)
      {
         widths[i] = pOpening.getDoors().getPanels().get( i ).getWidth(); 
      }
      
      for(int i = 0; i < heights.length; i++)
      {
         heights[i] = pOpening.getDoors().getPanels().get( i ).getHeight();
      }
      
      for(int i = 0; i < linearFeet.length; i++)
      {
         linearFeet[i] = pOpening.getDoors().getPanels().get( i ).getLinearFeet();
      }
      
      setLblQuantityText( quantity );
      setLblWidthXHeightText( widths, heights );
      setLblLinearFeetText( linearFeet );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
