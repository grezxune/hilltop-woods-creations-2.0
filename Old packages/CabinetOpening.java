/***************************************************************************************************
 *
 * File:        CabinetDoor.java
 * 
 * Project:     Hilltop Woods Creations 2.0
 * 
 * Author:      Tommy Trzebiatowski
 * 
 * Description: Contains all the information needed for any 
 *              cabinet door possible.
 * 
 * Comments:    Instance variables needed in subclasses: middleGap ( double doors only )
 * 
 *              Calculations for subclasses: doorWidth  , doorHeight , panelWidth,  
 *                                           panelHeight, stileLength, railLength
 *
 *              Class constants needed in subclasses: DOOR_TYPE
 *           
 ***************************************************************************************************/

package doorComponents;

import guiComponents.*;
import java.io.*;
import javax.swing.*;
import windows.Driver;
import doorComponents.*;
import miscellaneous.*;
import java.util.*;

public abstract class CabinetOpening implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
      // Default values for instance variables
   public static final int DEFAULT_NUMBER_OF_OPENINGS = 1;
   
      // Constants used to verify input
   public static final int MINIMUM_MEASUREMENT_VALUE     = 0;
   public static final int MINIMUM_DOOR_NUMBER           = 1;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Number specifying how many openings that are identical
   private int numberOfOpenings;
   
   private CabinetDoorComponents doorComponents;
   
      // Opening width/height
   private double width;
   private double height;
   
   /* TODO
    * Try to remove this by: just returning the index of the list while it is being looped through, then no need for
    * renumbering or anything, it is just always correct
    */
   private int doorNumber;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CabinetOpening( double pLeftStileWidth  ,
                          double pRightStileWidth ,
                          double pTopRailWidth    ,
                          double pBottomRailWidth ,
                          double pLeftOverlay     ,
                          double pRightOverlay    ,
                          double pTopOverlay      ,
                          double pBottomOverlay   ,
                          double pPanelGap        ,
                          double pTennonLength    ,
                          double pOpeningWidth    ,
                          double pOpeningHeight   ,
                          int    pNumberOfOpenings,
                          int    pDoorNumber      )
   {
      doorComponents = new CabinetDoorComponents( pLeftStileWidth      ,
                                                  pRightStileWidth     ,
                                                  pTopRailWidth        ,
                                                  pBottomRailWidth     ,
                                                  pLeftOverlay         ,
                                                  pRightOverlay        ,
                                                  pTopOverlay          ,
                                                  pBottomOverlay       ,
                                                  pPanelGap            ,
                                                  pTennonLength        );
      
      setDoorOpening( pOpeningWidth, 
                      pOpeningHeight );
      
      setNumberOfOpenings( pNumberOfOpenings );
      setDoorNumber      ( pDoorNumber       );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public int getNumberOfOpenings()
   {
      return numberOfOpenings;
   }
   
   public CabinetDoorComponents getDoorComponents()
   {
      return doorComponents;
   }
   
   public double getOpeningWidth()
   {
      return width;
   }
   
   public double getOpeningHeight()
   {
      return height;
   }
   
   public int getDoorNumber()
   {
      return doorNumber;
   }
   
   public double tennonLengthMinusPanelGapTwice()
   {
      return ( doorComponents.getTennonLength().getWidth() * 2 ) - 
             ( doorComponents.getPanelGap()    .getWidth() * 2 );
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   /*public void setDoorComponents( ProjectSpecificValues pValues )
   {
      doorComponents = new CabinetDoorComponents( pValues.getLeftStileWidth()  ,
                                                          getLeftStileHeight() ,
                                                  pValues.getRightStileWidth() ,
                                                          getRightStileHeight(),
                                                  pValues.getTopRailWidth()    ,
                                                          getTopRailHeight()   ,
                                                  pValues.getBottomRailWidth() ,
                                                          getBottomRailHeight(),
                                                  pValues.getLeftOverlay()     ,
                                                  pValues.getRightOverlay()    ,
                                                  pValues.getTopOverlay()      ,
                                                  pValues.getBottomOverlay()   ,
                                                  pValues.getPanelGap()        ,
                                                  pValues.getTennonLength()    );
   }*/
   
   public void setNumberOfOpenings( int pNumberOfOpenings )
   {
      numberOfOpenings = verifyInteger( pNumberOfOpenings, "Number of Openings invalid" );
   }
   
   public void setDoorOpening( double pOpeningWidth, double pOpeningHeight )
   {
      width = verifyDouble( pOpeningWidth, "Opening Width invalid" );
      height = verifyDouble( pOpeningHeight, "Opening Height invalid" );
   }
   
   public void setDoorNumber( int pDoorNumber )
   {
      doorNumber = verifyInteger( pDoorNumber, "Door Number invalid" );
   }
   
   public void setLeftStileHeight( double pHeight )
   {
      doorComponents.setLeftStile( verifyDouble( pHeight, "Left Stile Height invalid" ) );
   }
   
   public void setRightStileHeight( double pHeight )
   {
      doorComponents.setRightStile( verifyDouble( pHeight, "Right Stile Height invalid" ) );
   }
   
   public void setTopRailWidth( double pWidth )
   {
      doorComponents.setTopRail( verifyDouble( pWidth, "Top Rail Width invalid" ) );
   }
   
   public void setBottomRailWidth( double pWidth )
   {
      doorComponents.setBottomRail( verifyDouble( pWidth, "Bottom Rail Width invalid" ) );
   }
   
   /*public boolean compareTo( CabinetDoor pDoorToCompare )
   {
      if( ( doorType.equals( pDoorToCompare.getDoorType() ) ) && 
          ( doorComponents.getLeftStile().getWidth() ==
            pDoorToCompare.getDoorComponents().getLeftStile().getWidth() ) &&
          ( doorComponents.getRightStile().getWidth() ==
            pDoorToCompare.getDoorComponents().getRightStile().getWidth() ) &&
          ( doorComponents.getTopRail().getWidth() ==
            pDoorToCompare.getDoorComponents().getTopRail().getWidth() ) &&
          ( doorComponents.getBottomRail().getWidth() == 
            pDoorToCompare.getDoorComponents().getBottomRail().getWidth() ) && 
          ( doorComponents.getLeftOverlay().getWidth() == 
            pDoorToCompare.getDoorComponents().getLeftOverlay().getWidth() ) &&
          ( doorComponents.getRightOverlay().getWidth() ==
            pDoorToCompare.getDoorComponents().getRightOverlay().getWidth() ) && 
          ( doorComponents.getTopOverlay().getWidth() ==
            pDoorToCompare.getDoorComponents().getTopOverlay().getWidth() ) &&
          ( doorComponents.getBottomOverlay().getWidth() == 
            pDoorToCompare.getDoorComponents().getBottomOverlay().getWidth() ) && 
          ( doorComponents.getPanelGap().getWidth() == 
            pDoorToCompare.getDoorComponents().getPanelGap().getWidth() ) &&
          ( doorComponents.getTennonLength().getWidth() == 
            pDoorToCompare.getDoorComponents().getTennonLength().getWidth() ) )
      {
         if( doorType.equals( SingleDoor.DOOR_TYPE ) )
         {
            // Finish this method later -- > put compareTo in doorComponents class
            // and have a universal one for comparing all of those values
            // then put a compareto in each different type of door
         }
         else if( doorType.equals( DoubleDoor.DOOR_TYPE ) )
         {
            
         }
         //else if( doorType.equals( ))
      }
      
      return false;
   }*/
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public int verifyInteger( int pDoorNumberToVerify, String pExceptionString )
   {
      /*** Local Variables ***/
      /***********************/
      
      int intToReturn = 0;
      
      if ( pDoorNumberToVerify >= MINIMUM_DOOR_NUMBER )
      {
         intToReturn = pDoorNumberToVerify;
      }
      else
      {
         throw new IllegalArgumentException( pExceptionString );
      }
      
      return intToReturn;
   }
   
   public double verifyDouble( double pDoubleToVerify, String pExceptionString )
   {
      /*** Local Variables ***/
      /***********************/
      
      double doubleToReturn = 0;
      
      if ( pDoubleToVerify >= MINIMUM_MEASUREMENT_VALUE )
      {
         doubleToReturn = pDoubleToVerify;
      }
      else
      {
         throw new IllegalArgumentException( pExceptionString );
      }
      
      return doubleToReturn;
   }
   
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
      // Door specific getter methods
   public abstract String getDoorType();
   
      // Dimension getter methods
   public abstract double[] getDoorWidths();
   public abstract double[] getDoorHeights();
   
   public abstract double[] getPanelWidths();
   public abstract double[] getPanelHeights();
   
   public abstract double[] getLeftStileWidths();
   public abstract double[] getLeftStileHeights();
   public abstract double[] getRightStileWidths();
   public abstract double[] getRightStileHeights();
   
   public abstract double[] getTopRailWidths();
   public abstract double[] getTopRailHeights();
   public abstract double[] getBottomRailWidths();
   public abstract double[] getBottomRailHeights();
   
      // Quantity comparators
   public abstract int getNumberOfDoors();
   public abstract int getNumberOfPanels();
   public abstract int getNumberOfStiles();
   public abstract int getNumberOfRails();
   
      // Linear feet comparators
   public abstract double getDoorLinearFeet();
   public abstract double getPanelLinearFeet();
   public abstract double getStileLinearFeet();
   public abstract double getRailLinearFeet();
   
      // Linear feet comparators
   public abstract double getDoorBoardFeet();
   public abstract double getPanelBoardFeet();
   public abstract double getStileBoardFeet();
   public abstract double getRailBoardFeet();
}
