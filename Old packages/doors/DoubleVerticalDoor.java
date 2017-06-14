/*****************************
******************************
*
* File: DoubleVerticalDoor.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 3/18/2013
* 
***************************** 
*****************************/

package doors;

import java.io.Serializable;
import javax.swing.JFormattedTextField;
import newDoorSystem.CabinetOpening;

public class DoubleVerticalDoor extends CabinetOpening implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final String DOOR_TYPE = "Double Vertical Door";
   
   private static final int BOX_NUMBER = 3;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/
   
   public DoubleVerticalDoor( double[] projectSpecificComponents,
                              double[] singleDoorComponents     ,
                              //double[] verticalDoorComponents   ,
                              int      pDoorNumber              )
   {
      super(projectSpecificComponents[ 0 ]  ,   // leftStileWidth
            projectSpecificComponents[ 1 ]  ,   // rightStileWidth
            projectSpecificComponents[ 2 ]  ,   // topRailWidth
            projectSpecificComponents[ 3 ]  ,   // bottomRailWidth
            projectSpecificComponents[ 4 ]  ,   // leftOverlay
            projectSpecificComponents[ 5 ]  ,   // rightOverlay
            projectSpecificComponents[ 6 ]  ,   // topOverlay
            projectSpecificComponents[ 7 ]  ,   // bottomOverlay
            projectSpecificComponents[ 8 ]  ,   // panelGap
            projectSpecificComponents[ 9 ]  ,   // tennonLength
            singleDoorComponents[ 0 ]       ,   // openingWidth
            singleDoorComponents[ 1 ]       ,   // openingHeight
            ( int ) singleDoorComponents[ 2 ],  // numberOfOpenings
            pDoorNumber );                      // doorNumber
   }

   @Override
   public String getDoorType()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getDoorWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getDoorHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getPanelWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getPanelHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getLeftStileWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getLeftStileHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getRightStileWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getRightStileHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getTopRailWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getTopRailHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getBottomRailWidths()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public double [] getBottomRailHeights()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int getNumberOfDoors()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int getNumberOfPanels()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int getNumberOfStiles()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int getNumberOfRails()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getDoorLinearFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getPanelLinearFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getStileLinearFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getRailLinearFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getDoorBoardFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getPanelBoardFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getStileBoardFeet()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public double getRailBoardFeet()
   {
      // TODO Auto-generated method stub
      return 0;
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
   
   
}
