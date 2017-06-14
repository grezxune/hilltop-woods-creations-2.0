/*****************************
******************************
*
* File: TommysRadioButtonMenuItem.java
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
import windows.Driver;
import miscellaneous.*;

public class TommysRadioButtonMenuItem extends JRadioButtonMenuItem
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color RADIO_BUTTON_TEXT_COLOR = Color.WHITE;
   public static final Color RADIO_BUTTON_BACKGROUND_COLOR = Driver.PAGE_HEADER_BACKGROUND_COLOR;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   /********************/
   /*** Constructors ***/
   /********************/

   public TommysRadioButtonMenuItem( String pButtonTitle )
   {
      super( pButtonTitle );
      setForeground( RADIO_BUTTON_TEXT_COLOR );
      setBackground( RADIO_BUTTON_BACKGROUND_COLOR );
      setFont( new Font( "Algerian", Font.PLAIN, 12 ) );
   }
}
