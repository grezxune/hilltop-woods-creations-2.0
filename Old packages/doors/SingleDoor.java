/*************************************************************************************************** 
 *
 * File:        SingleDoor.java
 * 
 * Project:     Hilltop Woods Creations 2.0
 * 
 * Author:      Tommy Trzebiatowski
 * 
 * Description: Contains all the information needed for a single door
 * 
 * Comments:    Instance variables needed in subclasses: N.A.
 *        
 *              Calculations for this class: doorWidth  , doorHeight , panelWidth,  
 *                                           panelHeight, stileLength, railLength
 *                                           
 *              Class constants needed in subclasses: DOOR_TYPE
 *  
 ***************************************************************************************************/

package doors;

import java.io.Serializable;
import newDoorSystem.CabinetOpening;
import newDoorSystem.DoorPanel;
import miscellaneous.*;

public class SingleDoor extends    CabinetOpening
                        implements Serializable
{      
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final String DOOR_TYPE = "Single Door";
   
   private static final int BOX_NUMBER = 0;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public SingleDoor( double[] projectSpecificComponents, 
                      double[] singleDoorComponents     ,
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
         
         setLeftStileHeight ( getLeftStileHeight()  );
         setRightStileHeight( getRightStileHeight() );
         setTopRailWidth    ( getTopRailHeight()    );
         setBottomRailWidth ( getBottomRailHeight() );
         
         createPanels();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public double getDoorWidth()
   {
      return /*getDoorOpening().getWidth() + */
             getDoorComponents().getLeftOverlay() .getWidth() + 
             getDoorComponents().getRightOverlay().getWidth();
   }

   public double getDoorHeight()
   {
      return /*getDoorOpening().getHeight() +*/ 
             getDoorComponents().getTopOverlay()   .getWidth() + 
             getDoorComponents().getBottomOverlay().getWidth();
   }

   public double getPanelWidth()
   {
      return getDoorWidth() - 
             getDoorComponents().getLeftStile() .getWidth() - 
             getDoorComponents().getRightStile().getWidth() +
             tennonLengthMinusPanelGapTwice();
   }
   
   public double getPanelHeight()
   {
      return ( getDoorHeight() - 
               getDoorComponents().getTopRail()   .getWidth() - 
               getDoorComponents().getBottomRail().getWidth() ) + 
               tennonLengthMinusPanelGapTwice();
   }
   
   public void createPanels()
   {
      getDoorComponents().addPanel( getPanelWidth(), getPanelHeight() );
   }

   public int calculateNumberOfPanels()
   {
      return getNumberOfOpenings();
   }
   
   public int getBoxNumber()
   {
      return BOX_NUMBER;
   }
   
   public int getNumberOfDoors()
   {
      return getNumberOfOpenings();
   }
   
   public int getNumberOfStiles()
   {
      return getNumberOfDoors() * 2;
   }
   
   public int getNumberOfRails()
   {
      return getNumberOfDoors() * 2;
   }
   
   public int getNumberOfPanels()
   {
      return getDoorComponents().getPanels().size() * getNumberOfOpenings();
   }
   
   public double getDoorLinearFeet()
   {
      return getStileLinearFeet() + getRailLinearFeet() + getPanelLinearFeet();
   }

   public double getStileLinearFeet()
   {
      return getDoorComponents().getLeftStile().getHeight() + getDoorComponents().getRightStile().getHeight();
   }

   public double getRailLinearFeet()
   {
      return getDoorComponents().getTopRail().getWidth() + getDoorComponents().getBottomRail().getWidth();
   }

   public double getPanelLinearFeet()
   {
      DoorPanel currentPanel = getDoorComponents().getPanels().get( 0 );
      
      return currentPanel.getHeight() * getNumberOfPanels();
   }
   
   public String getCutlistEntryString()
   {
      String cutlistEntry = "";
      
      return cutlistEntry;
   }

   public double getLeftStileWidth()
   {
      return getDoorComponents().getLeftStileWidth();
   }
   
   public double getLeftStileHeight()
   {
      return getDoorHeight();
   }

   public double getRightStileWidth()
   {
      return getDoorComponents().getRightStileWidth();
   }

   public double getRightStileHeight()
   {
      return getDoorHeight();
   }

   public double getTopRailWidth()
   {
      return getDoorWidth() - getRightStileWidth() - getLeftStileWidth();
   }

   public double getTopRailHeight()
   {
      return getDoorComponents().getTopRailHeight();
   }

   public double getBottomRailWidth()
   {
      return getDoorWidth() - getRightStileWidth() - getLeftStileWidth();
   }

   public double getBottomRailHeight()
   {
      return getDoorComponents().getBottomRailHeight();
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
}
