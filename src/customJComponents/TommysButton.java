/*****************************
***************************** 
*
* File: TommysButton.java
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
import java.awt.event.*;
import javax.swing.*;

public class TommysButton extends JButton
			                 implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

	public static final int BUTTON_X_PIXELS = 90;
	public static final int BUTTON_Y_PIXELS = 25;
	
	public static final Color BUTTON_BACKGROUND_COLOR = new Color( 12, 75, 200 );
	public static final Color BUTTON_FOREGROUND_COLOR = Color.WHITE;
	
	private boolean beenPressed;

	/********************/
	/*** Constructors ***/
	/********************/
	
	public TommysButton( String pButtonTitle )
	{
		super( pButtonTitle );
		addActionListener( this );
		setSize( new Dimension( BUTTON_X_PIXELS, BUTTON_Y_PIXELS ) );
		setBackground( BUTTON_BACKGROUND_COLOR );
		setForeground( BUTTON_FOREGROUND_COLOR );
		setVisible( true );
	}

	public TommysButton( String pButtonTitle, Color newColor )
	{
		super( pButtonTitle );
		addActionListener( this );
		setPreferredSize( new Dimension( BUTTON_X_PIXELS, BUTTON_Y_PIXELS ) );
		setBackground( newColor );
		setForeground( BUTTON_FOREGROUND_COLOR );
		setVisible( true );
	}
	
	public TommysButton( String pButtonTitle, 
	                     int xLocation, int yLocation,                                 
	                     int width    , int height   )
   {
      super( pButtonTitle );
      addActionListener( this );
      setPreferredSize( new Dimension( width, height ) );
      setBackground( BUTTON_BACKGROUND_COLOR );
      setForeground( BUTTON_FOREGROUND_COLOR );
      setBounds( xLocation, yLocation, width, height );
      setVisible( true );
   }

	public TommysButton( String pButtonTitle, Color newColor, int pWidth, int pHeight )
	{
		super( pButtonTitle );
		addActionListener( this );
		setPreferredSize( new Dimension( pWidth, pHeight ) );
		setBackground( newColor );
		setVisible( true );
	}
	
	public TommysButton( String pButtonTitle, int xLocation, int yLocation )
   {
      super( pButtonTitle );
      addActionListener( this );
      setPreferredSize( new Dimension( BUTTON_X_PIXELS, BUTTON_Y_PIXELS ) );
      setBackground( BUTTON_BACKGROUND_COLOR );
      setForeground( BUTTON_FOREGROUND_COLOR );
      setBounds( xLocation, yLocation, BUTTON_X_PIXELS, BUTTON_Y_PIXELS );
      setVisible( true );
   }
	
	public TommysButton( int xLocation, int yLocation, ImageIcon icon )
	{
	   addActionListener( this );
	   setBounds( xLocation, yLocation, BUTTON_X_PIXELS, BUTTON_Y_PIXELS );
	   setIcon( icon );
	}
	
	public TommysButton( int xLocation, int yLocation,
	                     int width    , int height   ,
	                     ImageIcon icon )
	{
	   addActionListener( this );
      setBounds( xLocation, yLocation, width, height );
      setIcon( icon );
	}

	public void actionPerformed( ActionEvent e )
	{
	   /*if ( beenPressed )
	   {
	      setBackground( Color.BLACK );
	      setForeground( LIME_GREEN );
	      beenPressed = false;
	   }
	   else
	   {
	      setBackground( LIME_GREEN );
	      setForeground( Color.BLACK );
	      beenPressed = true;
	   }*/
	}
}