/*****************************
***************************** 
*
* File: TommysTextField.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 
* 
***************************** 
*****************************/

package customJComponents;

import java.awt.*;
import javax.swing.*;
import miscellaneous.*;

public class TommysTextField extends JTextField
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final int TEXT_FIELD_X_PIXELS = 125;
   public static final int TEXT_FIELD_Y_PIXELS = 30;
   
   public static final Color BACKGROUND_COLOR = Color.BLACK;
   public static final Color FOREGROUND_COLOR = Color.WHITE;
   
   public static final int INVALID_TEXT_FIELD_VALUE = -666;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private boolean capitalizeFirst;
   
   private double fractionValue;

   /********************/
   /*** Constructors ***/
   /********************/
   
   public TommysTextField( int xPosition, int yPosition )
   {
      setBounds( xPosition, yPosition, TEXT_FIELD_X_PIXELS, TEXT_FIELD_Y_PIXELS );
      setBackground( BACKGROUND_COLOR );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 12 ) );
      setEditable( true );
      setVisible( true );
   }
   
   public TommysTextField( int xPosition, int yPosition, int width, int height )
   {
      setBounds( xPosition, yPosition, width, height );
      setBackground( BACKGROUND_COLOR );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 12 ) );
      setEditable( true );
      setVisible( true );
   }
   
   public TommysTextField( int xPosition, int yPosition,
                           int width    , int height   , boolean pEditable )
   {
      setBounds( xPosition, yPosition, width, height );
      setBackground( BACKGROUND_COLOR );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 12 ) );
      setEditable( pEditable );
      setVisible( true );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public String getText()
   {
      String toReturn;
      
      if( capitalizeFirst )
      {
         toReturn = capitalizeFirst( super.getText() );
      }
      else
      {
         toReturn = super.getText();
      }
      
      return toReturn;
   }
   
   public String capitalizeFirst( String pStringToCap )
   {
      char firstLetter = pStringToCap.charAt( 0 );
      String allButFirst = pStringToCap.substring( 1, pStringToCap.length() );
      return Character.toUpperCase( firstLetter ) + allButFirst;
   }
   
   public double getTextFieldDouble()
   {
      /*** Local Variables ***/
      /***********************/
      
      double textFieldValue;
      
      if( containsFraction() )
      {
         textFieldValue = fractionValue;
      }
      else if( containsDouble() )
      {
         textFieldValue = Double.parseDouble( getText() );
      }
      else
      {
         textFieldValue = INVALID_TEXT_FIELD_VALUE;
      }
      
      return textFieldValue;
   }
   
   public int getTextFieldInt()
   {
      /*** Local Variables ***/
      /***********************/
      
      int textFieldValue;
      
      if( containsInt() )
      {
         textFieldValue = Integer.parseInt( getText() );
      }
      else
      {
         textFieldValue = INVALID_TEXT_FIELD_VALUE;
      }
      
      return textFieldValue;
   }
   
   public boolean containsDouble()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean containsDouble = true;
      
      try
      {
         Double.parseDouble( getText() );
      }
      catch( IllegalArgumentException e )
      {
         containsDouble = false;
      }
      
      if( containsFraction() )
      {
         containsDouble = true;
      }
      
      return containsDouble;
   }
   
   public boolean containsInt()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean containsInt = true;
      
      try
      {
         Integer.parseInt( getText() );
      }
      catch( IllegalArgumentException e )
      {
         containsInt = false;
      }
      
      return containsInt;
   }
   
   private boolean containsFraction()
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean containsFraction = true;
      String currentText = super.getText();
      double firstDouble;
      double secondDouble;
      double thirdDouble;
      
      try
      {
         firstDouble = Double.parseDouble( currentText.substring( 0, currentText.indexOf( ' ' ) ) );                            // REGULAR EXPRESSIONS
         secondDouble = Double.parseDouble( currentText.substring( currentText.indexOf( ' ' ) + 1, currentText.indexOf( '/' ) ) ); // buffered items, selectable interface
          // Kasi 
         thirdDouble = Double.parseDouble( currentText.substring( currentText.indexOf( '/' ) + 1 ) );
         
         fractionValue = ( firstDouble + ( secondDouble / thirdDouble ) );
      }
      catch( IllegalArgumentException e )
      {
         containsFraction = false;
      }
      catch( StringIndexOutOfBoundsException e )
      {
         containsFraction = false;
      }
      
      return containsFraction;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void CapitalizeFirst( boolean pCapitalize )
   {
      capitalizeFirst = pCapitalize;
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
