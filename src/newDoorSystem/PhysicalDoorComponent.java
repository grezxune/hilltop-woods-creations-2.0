/***************************************************************************************************
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
***************************************************************************************************/

package newDoorSystem;

import java.io.*;

public class PhysicalDoorComponent extends DoorComponent implements Serializable
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private double height;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public PhysicalDoorComponent( double pWidth, double pHeight )
   {
      super( pWidth );
      setHeight( pHeight );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public double getHeight()
   {
      return height;
   }
   
   public boolean equals( PhysicalDoorComponent pDoorComponent )
   {
      boolean doorComponentsEqual = super.equals( pDoorComponent );
      
      if( ( doorComponentsEqual ) && 
          ( getHeight() == pDoorComponent.getHeight() ) )
      {
         doorComponentsEqual = true;
      }
      
      return doorComponentsEqual;
   }
   
   public double getLinearFeet()
   {
      return getWidth() * getHeight() * getQuantity();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setHeight( double pHeight )
   {
      if( verifyMeasurement( pHeight ) )
      {
         height = pHeight;
      }
   }
}