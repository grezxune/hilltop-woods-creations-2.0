/*****************************
***************************** 
*
* File: TommysPanel.java
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

public class TommysPanel extends JPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final int PANEL_LOCATION_X = 0;
   public static final int PANEL_LOCATION_Y = 0;

   /********************/
   /*** Constructors ***/
   /********************/
   
   public TommysPanel( Color pColor )
   {
      setBackground( pColor );
      setVisible( true );
      setLayout( null );
   }
   
   public TommysPanel( int xLocation, int yLocation, Color pColor )
   {
      //setSize( width, height );
      setLocation( xLocation, yLocation );
      //setBounds( xLocation, yLocation, width, height );
      setBackground( pColor );
      setVisible( true );
      setLayout( null );
      setBorder( BorderFactory.createEtchedBorder() );
   }
   
   public TommysPanel( int xLocation, int yLocation, 
                       int width    , int height   , 
                       Color pColor )
   {
      setBounds( xLocation, yLocation, width, height );
      setBackground( pColor );
      setVisible( true );
      setLayout( null );
      setBorder( BorderFactory.createEtchedBorder() );
   }
   
   public TommysPanel( int xLocation, int yLocation, 
                       int width    , int height    )
   {
      setBounds( xLocation, yLocation, width, height );
      setVisible( true );
      setLayout( null );
      setBorder( BorderFactory.createEtchedBorder() );
      setBackground( new Color( 50, 100, 150 ) );
   }
}
