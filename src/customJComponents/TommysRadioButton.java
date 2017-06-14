/*****************************
******************************
*
* File: .java
* 
* Project: 
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

public class TommysRadioButton extends JRadioButton
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color RADIO_BUTTON_BACKGROUND_COLOR = Color.BLACK;
   public static final Color RADIO_BUTTON_FOREGROUND_COLOR = Color.WHITE;
   
   public static final int RADIO_BUTTON_WIDTH  = 160;
   public static final int RADIO_BUTTON_HEIGHT = 30;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/

   public TommysRadioButton( String pContent, int xLocation, int yLocation )
   {
      super( pContent );
      setBackground( RADIO_BUTTON_BACKGROUND_COLOR );
      setForeground( RADIO_BUTTON_FOREGROUND_COLOR );
      setBounds( xLocation, yLocation, RADIO_BUTTON_WIDTH, RADIO_BUTTON_HEIGHT );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
}
