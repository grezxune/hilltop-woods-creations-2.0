/*****************************
******************************
*
* File: TommysMenu.java
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

public class TommysMenu extends JMenu
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color MENU_BACKGROUND_COLOR = Driver.PAGE_HEADER_BACKGROUND_COLOR;
   public static final Color MENU_FOREGROUND_COLOR = Color.WHITE;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   public TommysMenu( String pMenuTitle )
   {
      super( pMenuTitle );
      setBackground( MENU_BACKGROUND_COLOR );
      setForeground( MENU_FOREGROUND_COLOR );
      getPopupMenu().setBackground( MENU_BACKGROUND_COLOR );
      setFont( new Font( "Algerian", Font.PLAIN, 12 ) );
   }
   
   /********************/
   /*** Constructors ***/
   /********************/
}
