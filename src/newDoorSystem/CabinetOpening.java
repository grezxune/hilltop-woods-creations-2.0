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

package newDoorSystem;

import java.io.*;
import java.util.*;

public class CabinetOpening implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Cabinet Opening values
   private int numberOfDoors;
   private int numberOfPanelsPerDoor;
   private int numberOfOpenings;
   private int openingNumber;
   private double openingWidth;
   private double openingHeight;
   private CabinetDoor doorForOpening;
   private LinkedList<Double> centerRailLocations;
   
      // Values used to create doors
   private double topRailWidth;
   private double bottomRailWidth;
   private double leftStileWidth;
   private double rightStileWidth;
   private double topOverlay;
   private double bottomOverlay;
   private double leftOverlay;
   private double rightOverlay;
   private double panelGap;
   private double tennonLength;
   private double middleGap;
   private double centerRailWidth;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CabinetOpening( int pNumberOfDoors        ,
                          int pNumberOfPanelsPerDoor,
                          int pNumberOfOpenings     ,
                          int pOpeningNumber        ,
                          double pOpeningWidth      ,
                          double pOpeningHeight     ,
                          double pTopRailWidth      ,
                          double pBottomRailWidth   ,
                          double pLeftStileWidth    ,
                          double pRightStileWidth   ,
                          double pTopOverlay        ,
                          double pBottomOverlay     ,
                          double pLeftOverlay       ,
                          double pRightOverlay      ,
                          double pPanelGap          ,
                          double pTennonLength      ,
                          double pMiddleGap         ,
                          double pCenterRailWidth   ,
                          LinkedList<Double> pCenterRailLocations )
   {
      numberOfDoors         = pNumberOfDoors;
      numberOfPanelsPerDoor = pNumberOfPanelsPerDoor;
      numberOfOpenings      = pNumberOfOpenings;
      openingNumber         = pOpeningNumber;
      openingWidth          = pOpeningWidth;
      openingHeight         = pOpeningHeight;
      topRailWidth          = pTopRailWidth;
      bottomRailWidth       = pBottomRailWidth;
      leftStileWidth        = pLeftStileWidth;
      rightStileWidth       = pRightStileWidth;
      topOverlay            = pTopOverlay;
      bottomOverlay         = pBottomOverlay;
      leftOverlay           = pLeftOverlay;
      rightOverlay          = pRightOverlay;
      panelGap              = pPanelGap;
      tennonLength          = pTennonLength;
      middleGap             = pMiddleGap;
      centerRailWidth       = pCenterRailWidth;
      
      centerRailLocations = pCenterRailLocations;
      
      createDoors();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public int getNumberOfDoors()
   {
      return numberOfDoors;
   }
   
   public int getNumberOfPanelsPerDoor()
   {
      return numberOfPanelsPerDoor;
   }
   
   public int getNumberOfOpenings()
   {
      return numberOfOpenings;
   }
   
   public int getOpeningNumber()
   {
      return openingNumber;
   }
   
   public double getOpeningWidth()
   {
      return openingWidth;
   }
   
   public double getOpeningHeight()
   {
      return openingHeight;
   }
   
   public CabinetDoor getDoors()
   {
      return doorForOpening;
   }
   
   public LinkedList <Double> getCenterRailLocations()
   {
      return centerRailLocations;
   }
   
   public double getTopRailWidth()
   {
      return topRailWidth;
   }
   
   public double getTopRailHeight()
   {
      return doorForOpening.getTopRail().getHeight();
   }
   
   public double getBottomRailWidth()
   {
      return bottomRailWidth;
   }
   
   public double getBottomRailHeight()
   {
      return doorForOpening.getBottomRail().getHeight();
   }
   
   public double getLeftStileWidth()
   {
      return leftStileWidth;
   }
   
   public double getLeftStileHeight()
   {
      return doorForOpening.getLeftStile().getHeight();
   }
   
   public double getRightStileWidth()
   {
      return rightStileWidth;
   }
   
   public double getRightStileHeight()
   {
      return doorForOpening.getRightStile().getHeight();
   }
   
   public double getTopOverlay()
   {
      return topOverlay;
   }
   
   public double getBottomOverlay()
   {
      return bottomOverlay;
   }
   
   public double getLeftOverlay()
   {
      return leftOverlay;
   }
   
   public double getRightOverlay()
   {
      return rightOverlay;
   }
   
   public double getPanelGap()
   {
      return panelGap;
   }
   
   public double getTennonLength()
   {
      return tennonLength;
   }
   
   public double getMiddleGap()
   {
      return middleGap;
   }
   
   public double getCenterRailWidth()
   {
      return centerRailWidth;
   }
   
   public int getNumberOfPanelsPerOpening()
   {
      return getNumberOfPanelsPerDoor() * getNumberOfDoors();
   }
   
   public int getNumberOfStilesPerOpening()
   {
      return getNumberOfDoors() * 2;
   }
   
   public int getNumberOfRailsPerOpening()
   {
      return getNumberOfDoors() * 2;
   }
   
   public String getOpeningType()
   {
      String openingType = "";
      
      switch( getNumberOfDoors() )
      {
      case 1: 
         openingType = "Single";
         break;
      case 2:
         openingType = "Double";
         break;
      case 3:
         openingType = "Triple";
         break;
      case 4:
         openingType = "Quad";
         break;
      default:
         openingType = getNumberOfDoors() + " Doors";
         break;
      }
      
      return openingType;
   }
   
   /*** Dimension accessors ***/
   public double getDoorWidth()
   {
      return doorForOpening.getWidth();
   }
   
   public double getDoorHeight()
   {
      return doorForOpening.getHeight();
   }
   
   public LinkedList<Double> getPanelWidths()
   {
      LinkedList<Double> panelWidths = new LinkedList<>();
      
      for( DoorPanel panel : doorForOpening.getPanels() )
      {
         panelWidths.add( panel.getWidth() );
      }
      
      return panelWidths;
   }
   
   public LinkedList<Double> getPanelHeights()
   {
      LinkedList<Double> panelHeights = new LinkedList<>();
      
      for( DoorPanel panel : doorForOpening.getPanels() )
      {
         panelHeights.add( panel.getHeight() );
      }
      
      return panelHeights;
   }

   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createDoors()
   {
      double doorWidth = getOpeningWidth() + getLeftOverlay() + getRightOverlay();
      doorWidth -= getMiddleGap() * ( getNumberOfDoors() - 1 );
      doorWidth = doorWidth / getNumberOfDoors();
      
      double doorHeight = getOpeningHeight() + getTopOverlay() + getBottomOverlay();
      
      doorForOpening = new CabinetDoor( doorWidth,
                                        doorHeight,
                                        getNumberOfPanelsPerDoor(),
                                        getNumberOfDoors(),
                                        new Rail( getTopRailWidth(), doorWidth ),
                                        new Rail( getBottomRailWidth(), doorWidth ),
                                        new Stile( getLeftStileWidth(), doorHeight ),
                                        new Stile( getRightStileWidth(), doorHeight ),
                                        new PanelGap( getPanelGap() ),
                                        new TennonLength( getTennonLength() ),
                                        new Overlay( getTopOverlay() ),
                                        new Overlay( getBottomOverlay() ),
                                        new Overlay( getLeftOverlay() ),
                                        new Overlay( getRightOverlay() ),
                                        centerRailLocations,
                                        new CenterRail( centerRailWidth, 
                                              ( doorHeight - getTopRailWidth() - getBottomRailWidth() + ( getTennonLength() * 2 ) ) ) );
   }
   
   
   public void setOpeningNumber( int pOpeningNumber )
   {
      openingNumber = pOpeningNumber;
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   
   
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
      // Door specific getter methods
   //public abstract String getDoorType();
   
      // Dimension getter methods
   //public abstract double[] getDoorWidths();
   //public abstract double[] getDoorHeights();
   
   //public abstract double[] getPanelWidths();
   //public abstract double[] getPanelHeights();
   
   //public abstract double[] getLeftStileWidths();
   //public abstract double[] getLeftStileHeights();
   //public abstract double[] getRightStileWidths();
   //public abstract double[] getRightStileHeights();
   
   //public abstract double[] getTopRailWidths();
   //public abstract double[] getTopRailHeights();
   //public abstract double[] getBottomRailWidths();
   //public abstract double[] getBottomRailHeights();
   
      // Quantity comparators
   //public abstract int getNumberOfDoors();
   //public abstract int getNumberOfPanels();
   //public abstract int getNumberOfStiles();
   //public abstract int getNumberOfRails();
   
   
   /*** STILL NEED TO IMPLEMENT THESE ***/
   
      // Linear feet comparators
   //public abstract double getDoorLinearFeet();
   //public abstract double getPanelLinearFeet();
   //public abstract double getStileLinearFeet();
   //public abstract double getRailLinearFeet();
   
      // Linear feet comparators
   //public abstract double getDoorBoardFeet();
   //public abstract double getPanelBoardFeet();
   //public abstract double getStileBoardFeet();
   //public abstract double getRailBoardFeet();
}
