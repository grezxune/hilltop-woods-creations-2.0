/*****************************
***************************** 
*
* File: TommysLabel.java
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

import javax.swing.*;
import java.awt.*;

public class TommysLabel extends JLabel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final int LABEL_X_PIXELS = 90;
   public static final int LABEL_Y_PIXELS = 25;
   
   public static final Color FOREGROUND_COLOR = Color.WHITE;

   /********************/
   /*** Constructors ***/
   /********************/
   
   public TommysLabel( int xLocation, int yLocation )
   {
      setBounds( xLocation, yLocation, LABEL_X_PIXELS, LABEL_Y_PIXELS );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 12 ) );
      setVisible( true );
   }
   
   public TommysLabel( String content, int xLocation, int yLocation )
   {
      setText( content );
      setBounds( xLocation, yLocation, LABEL_X_PIXELS, LABEL_Y_PIXELS );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 10 ) );
      setVisible( true );
   }
   
   public TommysLabel( String content, int xLocation, int yLocation, 
                                       int width    , int height )
   {
      setText( content );
      setBounds( xLocation, yLocation, width, height );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 16 ) );
      setVisible( true );
   }
   
   public TommysLabel( int xLocation, int yLocation,
                       int width    , int height )
   {
      setBounds( xLocation, yLocation, width, height );
      setForeground( FOREGROUND_COLOR );
      setFont( new Font( "Algerian", Font.BOLD, 16 ) );
      setVisible( true );
   }
   
   public TommysLabel( ImageIcon image, int xLocation, int yLocation )
   {
      setIcon( image );
      setBounds( xLocation, yLocation, LABEL_X_PIXELS, LABEL_Y_PIXELS );
      setVisible( true );
   }
   
   public TommysLabel( ImageIcon image, int xLocation, int yLocation, 
                                        int width, int height )
   {
      setIcon( image );
      setBounds( xLocation, yLocation, width, height );
      setVisible( true );
   }
}
