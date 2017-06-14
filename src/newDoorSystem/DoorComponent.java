/*****************************
 ***************************** 
 *
 * File:        DoorComponent.java
 * 
 * Project:     Hilltop Woods Creations 2.0
 * 
 * Author:      Tommy Trzebiatowski
 * 
 * Description: Contains the information needed for a component of a cabinet door
 * 
 * Comments:    Instance variables needed in this class: width  ( double )
 *                                                       height ( double )
 * 
 *****************************
 *****************************/

package newDoorSystem;

import java.io.*;

public class DoorComponent implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final double MINIMUM_MEASUREMENT = 0.0;
   
   public static final int MINIMUM_QUANTITY = 1;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private double width;
   
   private int quantity;
      
   /********************/
   /*** Constructors ***/
   /********************/
   
   public DoorComponent( double pWidth )
   {
      setWidth( pWidth );
      quantity = MINIMUM_QUANTITY;
   }
      
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public double getWidth()
   {
      return width;
   }
   
   public int getQuantity()
   {
      return quantity;
   }
   
   public boolean equals( DoorComponent pDoorComponent )
   {
      boolean doorComponentsEqual = false;
      
      if( ( getWidth()      == pDoorComponent.getWidth() ) &&
          ( this.getClass() == pDoorComponent.getClass() ) )
      {
         doorComponentsEqual = true;
      }
      
      return doorComponentsEqual;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setWidth( double pWidth )
   {
      if( verifyMeasurement( pWidth ) )
      {
         width = pWidth;
      }
   }
   
   public void setQuantity( int pQuantity )
   {
      if( verifyQuantity( pQuantity ) )
      {
         quantity = pQuantity;
      }
   }
   
   public void incrementQuantity()
   {
      quantity++;
   }
      
   /***************/
   /*** Helpers ***/
   /***************/
   
   public boolean verifyMeasurement( double pDoubleToVerify )
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean isDoubleVerified = false;
      
      if ( pDoubleToVerify >= MINIMUM_MEASUREMENT )
      {
         isDoubleVerified = true;
      }
      
      return isDoubleVerified;
   }
   
   public boolean verifyQuantity( int pQuantity )
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean isQuantityVerified = false;
      
      if ( pQuantity >= MINIMUM_QUANTITY )
      {
         isQuantityVerified = true;
      }
      
      return isQuantityVerified;
   }
}