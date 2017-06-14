/*****************************
******************************
*
* File: CabinetDoor.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 2/26/2013
* 
***************************** 
*****************************/

package newDoorSystem;

import java.io.*;
import java.util.*;

public class CabinetDoor implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private double width;
   private double height;
   
   private int numberOfPanels;
   private int quantity;
   
   private LinkedList<DoorPanel> panels;
   private LinkedList<CenterRail> centerRails;
   private LinkedList<Double> centerRailLocations;
   private Rail topRail;
   private Rail bottomRail;
   private Stile leftStile;
   private Stile rightStile;
   private PanelGap panelGap;
   private TennonLength tennonLength;
   private Overlay topOverlay;
   private Overlay bottomOverlay;
   private Overlay leftOverlay;
   private Overlay rightOverlay;
   private CenterRail centerRail;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CabinetDoor( double pWidth,
                       double pHeight,
                       int pNumberOfPanels,
                       int pQuantity,
                       Rail pTopRail,
                       Rail pBottomRail,
                       Stile pLeftStile,
                       Stile pRightStile,
                       PanelGap pPanelGap,
                       TennonLength pTennonLength,
                       Overlay pTopOverlay,
                       Overlay pBottomOverlay,
                       Overlay pLeftOverlay,
                       Overlay pRightOverlay,
                       LinkedList<Double> pCenterRailLocations,
                       CenterRail pCenterRail )
   {
      width          = pWidth;
      height         = pHeight;
      numberOfPanels = pNumberOfPanels;
      quantity       = pQuantity;
      
         // Can be empty - if it is panel widths are defaulted
      centerRailLocations = pCenterRailLocations;
      
      topRail       = pTopRail;
      bottomRail    = pBottomRail;
      leftStile     = pLeftStile;
      rightStile    = pRightStile;
      panelGap      = pPanelGap;
      tennonLength  = pTennonLength;
      topOverlay    = pTopOverlay;
      bottomOverlay = pBottomOverlay;
      leftOverlay   = pLeftOverlay;
      rightOverlay  = pRightOverlay;
      
      centerRail    = pCenterRail;
      
      createCenterRails();
      createPanels();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public LinkedList<DoorPanel> getPanels()
   {
      return panels;
   }
   
   public double getCenterRailWidth()
   {
      return centerRails.get( 0 ).getWidth();
   }
   
   public Rail getTopRail()
   {
      return topRail;
   }
   
   public Rail getBottomRail()
   {
      return bottomRail;
   }
   
   public Stile getLeftStile()
   {
      return leftStile;
   }
   
   public Stile getRightStile()
   {
      return rightStile;
   }
   
   public LinkedList<CenterRail> getCenterRails()
   {
      return centerRails;
   }
   
   public PanelGap getPanelGap()
   {
      return panelGap;
   }
   
   public TennonLength getTennonLength()
   {
      return tennonLength;
   }
   
   public Overlay getTopOverlay()
   {
      return topOverlay;
   }
   
   public Overlay getBottomOverlay()
   {
      return bottomOverlay;
   }
   
   public Overlay getLeftOverlay()
   {
      return leftOverlay;
   }
   
   public Overlay getRightOverlay()
   {
      return rightOverlay;
   }
   
   public double getWidth()
   {
      return width;
   }
   
   public double getHeight()
   {
      return height;
   }
   
   public int getQuantity()
   {
      return quantity;
   }
   
   public double getLinearFeet()
   {
      return 0.0;
   }
   
   public double calculateWidth()
   {
      double width = getLeftStile().getWidth() + getRightStile().getWidth();
      
      for( DoorPanel panel : panels )
      {
         width += panel.getWidth();
         width -= getPanelGap().getWidth() * 2;
         width -= getTennonLength().getWidth() * 2;
      }
      
      for( CenterRail centerRail : centerRails )
      {
         width += centerRail.getWidth();
         width -= getPanelGap().getWidth() * 2;
      }
      
      return width;
   }
   
   public double calculateHeight()
   {
      double height = getTopRail().getHeight() + getBottomRail().getHeight();
      
      height -= getPanelGap().getWidth() * 2;
      height -= getTennonLength().getWidth() * 2;
      height += panels.get( 0 ).getHeight();
      
      return height;
   }

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createCenterRails()
   {
      centerRails = new LinkedList<CenterRail>();
      
      for( int i = 0; i < ( numberOfPanels - 1 ); i++ )
      {
         centerRails.add( new CenterRail( centerRail.getWidth(), centerRail.getHeight() ) );
      }
   }
   
   private void createPanels()
   {
      panels = new LinkedList<DoorPanel>();
      double[] panelWidths = new double[numberOfPanels];
      
      double panelHeight = getHeight();
      panelHeight -= getTopRail().getWidth();
      panelHeight -= getBottomRail().getWidth();
      panelHeight += ( getTennonLength().getWidth() * 2 );
      
      for( int i = 0; i < numberOfPanels; i++ )
      {
         if( centerRailLocations.size() == 0 )
         {
               // Default center rails to center
            panelWidths[ i ] = getWidth() / numberOfPanels;
            panelWidths[ i ] -= getCenterRailWidth() / 2;
            panelWidths[ i ] -= getLeftStile().getWidth();
         }
         else
         {
               // Custom set center rails
            if( i == 0 )
            {
               panelWidths[ i ] = centerRailLocations.get( i );
               panelWidths[ i ] -= getLeftStile().getWidth();
            }
            else if( ( i != 0 ) && 
                     ( i != ( numberOfPanels - 1 ) ) )
            {
               panelWidths[ i ] = centerRailLocations.get( i );
               panelWidths[ i ] -= centerRailLocations.get( i - 1 );
               panelWidths[ i ] += centerRails.get( i - 1 ).getWidth();
            }
            else if( i == ( numberOfPanels - 1 ) )
            {
               panelWidths[ i ] = ( getWidth() - centerRailLocations.get( i - 1 ) );
               panelWidths[ i ] -= centerRails.get( i - 1 ).getWidth();
               panelWidths[ i ] -= getRightStile().getWidth();
            }
         }
         panelWidths[ i ] += ( getTennonLength().getWidth() * 2 );
         panelWidths[ i ] -= ( getPanelGap().getWidth() * 2 );
         
         DoorPanel newPanel = new DoorPanel( panelWidths[i],  panelHeight );
         
         if( !panels.contains( newPanel ) )
         {
            panels.add( newPanel );
         }
         else 
         {
            for( DoorPanel panel : panels )
            {
               if( panel.equals( newPanel ) )
               {
                  panel.incrementQuantity();
               }
            }
         }
      }
   }

   /***************/
   /*** Helpers ***/
   /***************/

   /**********************/
   /*** Static Methods ***/
   /**********************/
}
