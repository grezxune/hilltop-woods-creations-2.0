/****************************
***************************** 
*
* File: CabinetDoorComponents.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: This should hold project specific measurements used 
*              to make creating doors quicker for the user.
* 
* Comments: 
* 
***************************** 
*****************************/

package doorComponents;

import java.io.*;
import java.util.*;
import newDoorSystem.DoorPanel;
import newDoorSystem.Overlay;
import newDoorSystem.PanelGap;
import newDoorSystem.Rail;
import newDoorSystem.Stile;
import newDoorSystem.TennonLength;

public class CabinetDoorComponents implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final double MINIMUM_MEASUREMENT_VALUE = 0.0;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // Stile widths
   private Stile leftStile;
   private Stile rightStile;
   
   private double leftStileWidth;
   private double rightStileWidth;
   
      // Rail heights
   private Rail topRail;
   private Rail bottomRail;
   
   private double topRailHeight;
   private double bottomRailHeight;
   
      // Overlays
   private Overlay leftOverlay;
   private Overlay rightOverlay;
   private Overlay topOverlay;
   private Overlay bottomOverlay;
   
      // Panel gap and tennon length
   private PanelGap     panelGap;
   private TennonLength tennonLength;
   
   private LinkedList< DoorPanel > panels;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CabinetDoorComponents( double pLeftStileWidth  ,
                                 double pRightStileWidth ,
                                 double pTopRailHeight   ,
                                 double pBottomRailHeight ,
                                 double pLeftOverlay     ,
                                 double pRightOverlay    ,
                                 double pTopOverlay      ,
                                 double pBottomOverlay   ,
                                 double pPanelGap        ,
                                 double pTennonLength    )
   {
      leftStileWidth   = pLeftStileWidth;
      rightStileWidth  = pRightStileWidth;
      topRailHeight    = pTopRailHeight;
      bottomRailHeight = pBottomRailHeight;
      
         // Door components
      setLeftOverlay    ( pLeftOverlay     );
      setRightOverlay   ( pRightOverlay    );
      setTopOverlay     ( pTopOverlay      );
      setBottomOverlay  ( pBottomOverlay   );
      setPanelGap       ( pPanelGap        );
      setTennonLength   ( pTennonLength    );

      panels = new LinkedList<>();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public Stile getLeftStile()
   {
      return leftStile;
   }
   
   public double getLeftStileWidth()
   {
      return leftStileWidth;
   }
   
   public Stile getRightStile()
   {
      return rightStile;
   }
   
   public double getRightStileWidth()
   {
      return rightStileWidth;
   }
   
   public Rail getTopRail()
   {
      return topRail;
   }
   
   public double getTopRailHeight()
   {
      return topRailHeight;
   }
   
   public Rail getBottomRail()
   {
      return bottomRail;
   }
   
   public double getBottomRailHeight()
   {
      return bottomRailHeight;
   }
   
   public Overlay getLeftOverlay()
   {
      return leftOverlay;
   }
   
   public Overlay getRightOverlay()
   {
      return rightOverlay;
   }
   
   public Overlay getTopOverlay()
   {
      return topOverlay;
   }
   
   public Overlay getBottomOverlay()
   {
      return bottomOverlay;
   }
   
   public PanelGap getPanelGap()
   {
      return panelGap;
   }
   
   public TennonLength getTennonLength()
   {
      return tennonLength;
   }
   
   public LinkedList< DoorPanel > getPanels()
   {
      return panels;
   }

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setLeftStile( double pLeftStileHeight )
   {
      leftStile = new Stile( verifyMeasurement( leftStileWidth, "Left Stile width invalid" ), 
                             verifyMeasurement( pLeftStileHeight, "Left Stile height invalid" ) );
   }
   
   public void setRightStile( double pRightStileHeight )
   {
      rightStile = new Stile( verifyMeasurement( rightStileWidth, "Right Stile width invalid" ),
                              verifyMeasurement( pRightStileHeight, "Right Stile height invalid" ) );
   }
   
   public void setTopRail( double pTopRailWidth )
   {
      topRail = new Rail( verifyMeasurement( pTopRailWidth, "Top Rail width invalid" ),
                          verifyMeasurement( topRailHeight, "Top Rail height invalid" ) );
   }
   
   public void setBottomRail( double pBottomRailWidth )
   {
      bottomRail = new Rail( verifyMeasurement( pBottomRailWidth, "Bottom Rail width invalid" ),
                             verifyMeasurement( bottomRailHeight, "Bottom Rail height invalid" ) );
   }
   
   public void setLeftOverlay( double pLeftOverlay )
   {
      leftOverlay = new Overlay( verifyMeasurement( pLeftOverlay, "Left Overlay invalid" ) );
   }
   
   public void setRightOverlay( double pRightOverlay )
   {
      rightOverlay = new Overlay( verifyMeasurement( pRightOverlay, "Right Overlay invalid" ) );
   }
   
   public void setTopOverlay( double pTopOverlay )
   {
      topOverlay = new Overlay( verifyMeasurement( pTopOverlay, "Top Overlay invalid" ) );
   }
   
   public void setBottomOverlay( double pBottomOverlay )
   {
      bottomOverlay = new Overlay( verifyMeasurement( pBottomOverlay, "Bottom Overlay invalid" ) );
   }
   
   public void setPanelGap( double pPanelGap )
   {
      panelGap = new PanelGap( verifyMeasurement( pPanelGap, "Panel Gap invalid" ) );
   }
   
   public void setTennonLength( double pTennonLength )
   {
      tennonLength = new TennonLength( verifyMeasurement( pTennonLength, "Tennon Length invalid" ) );
   }
   
   public void addPanel( double pWidth, double pHeight )
   {
      panels.add( new DoorPanel( verifyMeasurement( pWidth , "Door Panel Width invalid"  ), 
                                 verifyMeasurement( pHeight, "Door Panel Height invalid" ) ) );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public static double verifyMeasurement( double pDoubleToVerify, String pExceptionString )
   {
      if ( pDoubleToVerify >= MINIMUM_MEASUREMENT_VALUE )
      {
         return pDoubleToVerify;
      }
      else
      {
         throw new IllegalArgumentException( pExceptionString );
      }
   }
}
