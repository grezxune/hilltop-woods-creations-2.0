/*****************************
******************************
*
* File: CutlistEntry.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 12/19/2013
* 
***************************** 
*****************************/

package guiComponents;

import miscellaneous.*;
import newDoorSystem.CabinetOpening;
import javax.swing.*;
import windows.Driver;
import comparators.*;
import customJComponents.*;
import dataStructures.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public abstract class CutlistEntry extends JPanel
                                   implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // First label in entry's dimensions/locations
   public static final int OPENING_NUMBER_WIDTH   = 50;
   public static final int FIRST_LABEL_X_POSITION = 20;
   public static final int FIRST_LABEL_Y_POSITION = 20;
   
   public static final int OPENING_TYPE_WIDTH   = 50;
   public static final int QUANTITY_WIDTH       = 50;
   public static final int WIDTH_X_HEIGHT_WIDTH = 50;
   public static final int LINEAR_FEET_WIDTH    = 50;
   
      // Cutlist general constants
   public static final int LABEL_SPACING = 7;
   public static final int LABEL_HEIGHT = 30;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private TommysLabel lblOpeningNumber;
   private TommysLabel lblOpeningType;
   private TommysLabel[] lblQuantity;
   private TommysLabel[] lblWidthXHeight;
   private TommysLabel[] lblLinearFeet;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CutlistEntry( CabinetOpening pOpening, int pNumberOfLines )
   {
      lblQuantity = new TommysLabel[ pNumberOfLines ];
      lblWidthXHeight = new TommysLabel[ pNumberOfLines ];
      lblLinearFeet = new TommysLabel[ pNumberOfLines ];
      
      createLabels();
      
      setLblOpeningNumberText( pOpening.getOpeningNumber() );
      setLblOpeningTypeText( pOpening.getOpeningType() );
   }

   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public TommysLabel getLblOpeningNumber()
   {
      return lblOpeningNumber;
   }
   
   public TommysLabel getLblOpeningType()
   {
      return lblOpeningType;
   }
   
   public TommysLabel[] getLblQuantity()
   {
      return lblQuantity;
   }
   
   public TommysLabel[] getLblWidthXHeight()
   {
      return lblWidthXHeight;
   }
   
   public TommysLabel[] getLblLinearFeet()
   {
      return lblLinearFeet;
   }

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setLblOpeningNumberText( int pOpeningNumber )
   {
      lblOpeningNumber.setText( String.valueOf( pOpeningNumber ) );
   }
   
   public void setLblOpeningTypeText( String pOpeningType )
   {
      lblOpeningType.setText( pOpeningType );
   }
   
   public void setLblQuantityText( int pQuantity )
   {
      lblQuantity[0].setText( String.valueOf( pQuantity ) );
   }
   
   public void setLblWidthXHeightText( double pWidth, double pHeight )
   {
      lblWidthXHeight[0].setText( pWidth + " x " + pHeight );
   }
   
   public void setLblLinearFeetText( double pLinearFeet )
   {
      lblLinearFeet[0].setText( String.valueOf( pLinearFeet ) );
   }
   
   public void setLblQuantityText( int[] pQuantity )
   {
      for( int i = 0; i < pQuantity.length; i++ )
      {
         lblQuantity[i].setText( String.valueOf( pQuantity[i] ) );
      }
   }
   
   public void setLblWidthXHeightText( double[] pWidth, double[] pHeight )
   {
      for( int i = 0; i < pWidth.length; i++ )
      {
         lblWidthXHeight[i].setText( pWidth[i] + " x " + pHeight[i] );
      }
   }
   
   public void setLblLinearFeetText( double[] pLinearFeet )
   {
      for( int i = 0; i < pLinearFeet.length; i++ )
      {
         lblLinearFeet[i].setText( String.valueOf( pLinearFeet[i] ) );
      }
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   private void createLabels()
   {
      lblOpeningNumber = new TommysLabel( FIRST_LABEL_X_POSITION, 
                                          FIRST_LABEL_Y_POSITION, 
                                          OPENING_NUMBER_WIDTH, 
                                          LABEL_HEIGHT );
      
      lblOpeningType = new TommysLabel( lblOpeningNumber.getX() + lblOpeningNumber.getWidth() + LABEL_SPACING, 
                                        FIRST_LABEL_Y_POSITION, 
                                        OPENING_TYPE_WIDTH, 
                                        LABEL_HEIGHT );
      
      for( int i = 0; i < lblQuantity.length; i++ )
      {
         lblQuantity[ i ] = new TommysLabel( lblOpeningType.getX() + lblOpeningType.getWidth() + LABEL_SPACING, 
                                             ( i == 0 ? FIRST_LABEL_Y_POSITION : ( lblQuantity[ i-1 ].getY() + LABEL_HEIGHT + LABEL_SPACING ) ),
                                             QUANTITY_WIDTH,
                                             LABEL_HEIGHT );
      }
      
      for( int i = 0; i < lblWidthXHeight.length; i++ )
      {
         lblWidthXHeight[ i ] = new TommysLabel( lblQuantity[ 0 ].getX() + lblQuantity[ 0 ].getWidth() + LABEL_SPACING, 
                                                 ( i == 0 ? FIRST_LABEL_Y_POSITION : ( lblWidthXHeight[ i-1 ].getY() + LABEL_HEIGHT + LABEL_SPACING ) ),
                                                 WIDTH_X_HEIGHT_WIDTH,
                                                 LABEL_HEIGHT );
      }
      
      for( int i = 0; i < lblLinearFeet.length; i++ )
      {
         lblLinearFeet[ i ] = new TommysLabel( lblWidthXHeight[ 0 ].getX() + lblWidthXHeight[ 0 ].getWidth() + LABEL_SPACING, 
                                               ( i == 0 ? FIRST_LABEL_Y_POSITION : ( lblLinearFeet[ i-1 ].getY() + LABEL_HEIGHT + LABEL_SPACING ) ),
                                               LINEAR_FEET_WIDTH,
                                               LABEL_HEIGHT );
      }
   }
   
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
   public abstract void setLabelTexts( CabinetOpening pOpening );
}
