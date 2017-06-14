/*****************************
******************************
*
* File: TommysTextArea.java
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
import javax.swing.border.*;
import windows.Driver;

public class TommysTextArea extends JTextArea
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color TEXT_AREA_BACKGROUND_COLOR = Driver.CANVAS_BACKGROUND_COLOR;
   public static final Color TEXT_AREA_FOREGROUND_COLOR = Color.WHITE;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/
   
   public TommysTextArea()
   {
      setBackground( TEXT_AREA_BACKGROUND_COLOR );
      setForeground( TEXT_AREA_FOREGROUND_COLOR );
      setFont( new Font( "Consolas", Font.BOLD, 20 ) );
      setEditable( false );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setTitle( String pTitle )
   {
      TitledBorder border = new TitledBorder( pTitle );
      border.setTitleFont( new Font( "Algerian", Font.PLAIN, 25 ) );
      border.setTitleColor( TEXT_AREA_FOREGROUND_COLOR );
      border.setTitleJustification( TitledBorder.CENTER );
      setBorder( border );
   }
   /***************/
   /*** Helpers ***/
   /***************/
}
