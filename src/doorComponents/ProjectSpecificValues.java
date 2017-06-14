/*****************************
******************************
*
* File: ProjectSpecificValues.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 3/16/2013
* 
***************************** 
*****************************/

package doorComponents;

import java.io.*;

public class ProjectSpecificValues implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final double MINIMUM_MEASUREMENT_VALUE = 0;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   double leftStileWidth;
   double rightStileWidth;
   double topRailWidth;
   double bottomRailWidth;
   double leftOverlay;
   double rightOverlay;
   double topOverlay;
   double bottomOverlay;
   double panelGap;
   double tennonLength;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public ProjectSpecificValues( double pLeftStileWidth  ,
                                 double pRightStileWidth ,
                                 double pTopRailWidth    ,
                                 double pBottomRailWidth ,
                                 double pLeftOverlay     ,
                                 double pRightOverlay    ,
                                 double pTopOverlay      ,
                                 double pBottomOverlay   ,
                                 double pPanelGap        ,
                                 double pTennonLength    )
   {
      setLeftStileWidth ( pLeftStileWidth  );
      setRightStileWidth( pRightStileWidth );
      setTopRailWidth   ( pTopRailWidth    );
      setBottomRailWidth( pBottomRailWidth );
      setLeftOverlay    ( pLeftOverlay     );
      setRightOverlay   ( pRightOverlay    );
      setTopOverlay     ( pTopOverlay      );
      setBottomOverlay  ( pBottomOverlay   );
      setPanelGap       ( pPanelGap        );
      setTennonLength   ( pTennonLength    );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public double getLeftStileWidth()
   {
      return leftStileWidth;
   }
   
   public double getRightStileWidth()
   {
      return rightStileWidth;
   }
   
   public double getTopRailWidth()
   {
      return topRailWidth;
   }
   
   public double getBottomRailWidth()
   {
      return bottomRailWidth;
   }
   
   public double getLeftOverlay()
   {
      return leftOverlay;
   }
   
   public double getRightOverlay()
   {
      return rightOverlay;
   }
   
   public double getTopOverlay()
   {
      return topOverlay;
   }
   
   public double getBottomOverlay()
   {
      return bottomOverlay;
   }
   
   public double getPanelGap()
   {
      return panelGap;
   }
   
   public double getTennonLength()
   {
      return tennonLength;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setLeftStileWidth( double pLeftStileWidth )
   {
      leftStileWidth = verifyMeasurement( pLeftStileWidth, "Left Stile Width invalid" );
   }
   
   public void setRightStileWidth( double pRightStileWidth )
   {
      rightStileWidth = verifyMeasurement( pRightStileWidth, "Right Stile Width invalid" );
   }
   
   public void setTopRailWidth( double pTopRailWidth )
   {
      topRailWidth = verifyMeasurement( pTopRailWidth, "Top Rail Width invalid" );
   }
   
   public void setBottomRailWidth( double pBottomRailWidth )
   {
      bottomRailWidth = verifyMeasurement( pBottomRailWidth, "Bottom Rail Width invalid" );
   }
   
   public void setLeftOverlay( double pLeftOverlay )
   {
      leftOverlay = verifyMeasurement( pLeftOverlay, "Left Overlay invalid" );
   }
   
   public void setRightOverlay( double pRightOverlay )
   {
      rightOverlay = verifyMeasurement( pRightOverlay, "Right Overlay invalid" );
   }
   
   public void setTopOverlay( double pTopOverlay )
   {
      topOverlay = verifyMeasurement( pTopOverlay, "Top Overlay invalid" );
   }
   
   public void setBottomOverlay( double pBottomOverlay )
   {
      bottomOverlay = verifyMeasurement( pBottomOverlay, "Bottom Overlay invalid" );
   }
   
   public void setPanelGap( double pPanelGap )
   {
      panelGap = verifyMeasurement( pPanelGap, "Panel Gap invalid" );
   }
   
   public void setTennonLength( double pTennonLength )
   {
      tennonLength = verifyMeasurement( pTennonLength, "Tennon Length invalid" );
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
