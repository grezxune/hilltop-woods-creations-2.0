/***************************************************************************************************
 *
 * File:        DoubleDoor.java
 * 
 * Project:     Hilltop Woods Creations 2.0
 * 
 * Author:      Tommy Trzebiatowski
 * 
 * Description: Contains all the information needed for a double door
 * 
 * Comments:    Instance variables needed in subclasses: doorWidth, doorHeight, panelWidth, panelHeight, 
 *                                                       stileLength, railLength, middleGap ( double doors only )
 *                                                    
 *              Class constants needed in subclasses: DOOR_TYPE
 * 
 ***************************************************************************************************/

package doors;

import java.io.Serializable;
import newDoorSystem.CabinetOpening;
import newDoorSystem.DoorPanel;
import newDoorSystem.MiddleGap;
import doorComponents.*;
import miscellaneous.*;

public class DoubleDoor extends CabinetOpening
                        implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final String DOOR_TYPE = "Double Door";
   
   private static final int BOX_NUMBER = 1;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private MiddleGap middleGap;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DoubleDoor( double[] projectSpecificComponents,
                      double[] singleDoorComponents     ,
                      double[] doubleDoorComponents     ,
                      int      pDoorNumber              )
   {
      super( projectSpecificComponents[ 0 ]  ,   // leftStileWidth
             projectSpecificComponents[ 1 ]  ,   // rightStileWidth
             projectSpecificComponents[ 2 ]  ,   // topRailHeight
             projectSpecificComponents[ 3 ]  ,   // bottomRailHeight
             projectSpecificComponents[ 4 ]  ,   // leftOverlay
             projectSpecificComponents[ 5 ]  ,   // rightOverlay
             projectSpecificComponents[ 6 ]  ,   // topOverlay
             projectSpecificComponents[ 7 ]  ,   // bottomOverlay
             projectSpecificComponents[ 8 ]  ,   // panelGap
             projectSpecificComponents[ 9 ]  ,   // tennonLength
             singleDoorComponents[ 0 ]       ,   // openingWidth
             singleDoorComponents[ 1 ]       ,   // openingHeight
             ( int ) singleDoorComponents[ 2 ],  // numberOfOpenings
             pDoorNumber                      ); // doorNumber
      
      setMiddleGap( doubleDoorComponents[ 0 ] );
      setLeftStileHeight ( getLeftStileHeight()  );
      setRightStileHeight( getRightStileHeight() );
      setTopRailWidth    ( getTopRailHeight()    );
      setBottomRailWidth ( getBottomRailHeight() );
      
      createPanels();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public MiddleGap getMiddleGap()
   {
      return middleGap;
   }
   
   public double getDoorWidth()
   {
      return ( ( ( /*getDoorOpening()  .getWidth() + */
                   getDoorComponents().getLeftOverlay().getWidth() +
                   getDoorComponents().getRightOverlay().getWidth() ) / 2 ) -
                  ( getMiddleGap().getWidth() * .5 ) );
   }

   public double getDoorHeight()
   {
      return /*getDoorOpening() .getHeight() + */
             getDoorComponents().getTopOverlay()   .getWidth() + 
             getDoorComponents().getBottomOverlay().getWidth();
   }

   public double getPanelWidth()
   {
      return ( ( ( getDoorWidth() - 
                 ( getDoorComponents().getRightStile()   .getWidth() * 2 ) ) +
               ( getDoorComponents()  .getTennonLength() .getWidth() * 2 ) - 
               ( getDoorComponents()  .getPanelGap()     .getWidth() * 2 ) ) );
   }

   public double getPanelHeight()
   {
      return ( ( ( getDoorHeight() - 
                 ( getDoorComponents().getTopRail()     .getWidth() * 2 ) ) + 
               ( getDoorComponents()  .getTennonLength().getWidth() * 2 ) ) - 
             getDoorComponents()      .getPanelGap()    .getWidth() * 2 );
   }
   
   public void createPanels()
   {
      getDoorComponents().addPanel( getPanelWidth(), getPanelHeight() );
      getDoorComponents().getPanels().get( 0 ).incrementQuantity();
   }
   
   public int calculateNumberOfPanels()
   {
      return getNumberOfOpenings() * 2;
   }

   public double getStileWidth()
   {
      return getDoorComponents().getLeftStile().getWidth();
   }
   
   public double getStileLength()
   {
      return ( /*getDoorOpening() .getHeight() + */
               getDoorComponents().getTopOverlay()   .getWidth() + 
               getDoorComponents().getBottomOverlay().getWidth() ) + .125;
   }

   public double getRailWidth()
   {
      return getDoorComponents().getTopRail().getWidth();
   }
   
   public double getRailLength()
   {
      return ( getDoorWidth() -
             ( getDoorComponents().getRightStile()  .getWidth() * 2 ) ) +
             ( getDoorComponents().getTennonLength().getWidth() * 2 );
   }
   
   public int getBoxNumber()
   {
      return BOX_NUMBER;
   }
   
   public int getNumberOfDoors()
   {
      return getNumberOfOpenings() * 2;
   }
   
   public int getNumberOfStiles()
   {
      return getNumberOfDoors() * 2;
   }
   
   public int getNumberOfRails()
   {
      System.out.println( getNumberOfDoors() );
      return getNumberOfDoors() * 2;
   }
   
   public int getNumberOfPanels()
   {
      return getNumberOfDoors();
   }
   
   public double getDoorLinearFeet()
   {
      return getStileLinearFeet() + getRailLinearFeet() + getPanelLinearFeet();
   }

   public double getStileLinearFeet()
   {
      return ( getDoorComponents().getLeftStile().getHeight() + getDoorComponents().getRightStile().getHeight() ) * 2;
   }

   public double getRailLinearFeet()
   {
      return ( getDoorComponents().getTopRail().getWidth() + getDoorComponents().getBottomRail().getWidth() ) * 2;
   }

   public double getPanelLinearFeet()
   {
      DoorPanel currentPanel = getDoorComponents().getPanels().get( 0 );
      
      return currentPanel.getHeight() * getNumberOfPanels();
   }
   
   public String getCutlistEntryString()
   {
      String doorNumber = "\t" + getDoorNumber() + " \t" + getDoorType() + " \t";
      //String quantity   = pQuantity + " @ " + String.valueOf( pWidth ) + " x " + String.valueOf( pHeight ) + "\t\t";
     // String linearFeet = pLinearFeet + "\n";
      
      String cutlistEntry = "";
      
      return cutlistEntry;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setMiddleGap( double pMiddleGap )
   {
      middleGap = new MiddleGap( verifyDouble( pMiddleGap, "Middle Gap invalid" ) );
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
