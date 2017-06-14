/*****************************
***************************** 
*
* File: Driver.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 
* 
* WORK PROGRESS:
*                2/11/2013
*                Working on the create a door page - Something to keep in mind: Check my way of implementing
*                the doors...seems like it might not be done right.
*                
    *  current door files
    *  ------------------
    *  DoubleDoor
    *  HorizontalDoor
    *  SingleDoor
    *  VerticalDoor
    *  VerticalDoubleDoor    <<<< DELETE
    *  VerticalEndPanel
    *  VerticalSingleDoor    <<<< DELETE
    *  SingleHorizontalDoor  <<<< ADD
    *  DoubleHorizontalDoor  <<<< ADD
    *  HorizontalEndPanel    <<<< ADD
    *  
    *  doors files to use
    *  ------------------
    *  DoubleDoor
    *  SingleDoor
    *  VerticalEndPanel
    *  SingleHorizontalDoor
    *  DoubleHorizontalDoor
    *  HorizontalEndPanel
* 
***************************** 
*****************************/

package windows;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import customJComponents.TommysLabel;
import customJComponents.TommysPanel;
import pages.*;
import pictureComponents.CreditsLogo;
import pictureComponents.HilltopWoodsLogo;

public class Driver implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // JFrame constants
   public static final int JFRAME_X_LOCATION = 100;
   public static final int JFRAME_Y_LOCATION = 100;
   
   public static final int JFRAME_WIDTH  = 1200;
   public static final int JFRAME_HEIGHT = 800;
   
   public static final int JFRAME_CONTENT_PANE_WIDTH  = 1194;
   public static final int JFRAME_CONTENT_PANE_HEIGHT = 767;
   
      // Canvas constants
   public static JPanel pnlCanvas;
   
   public static final int CANVAS_X_LOCATION = 300;
   public static final int CANVAS_Y_LOCATION = 100;
   
   public static final int CANVAS_WIDTH  = JFRAME_CONTENT_PANE_WIDTH - 300;
   public static final int CANVAS_HEIGHT = JFRAME_CONTENT_PANE_HEIGHT - 200;
   
   public static final Color CANVAS_BACKGROUND_COLOR = Color.BLACK;
   
      // Page Header constants
   public static TommysLabel lblPageHeader;
   
   public static final int PAGE_HEADER_X_LOCATION = CANVAS_X_LOCATION;
   public static final int PAGE_HEADER_Y_LOCATION = 0;
   
   public static final int PAGE_HEADER_WIDTH  = CANVAS_WIDTH;
   public static final int PAGE_HEADER_HEIGHT = 100;
   
   public static final Color PAGE_HEADER_BACKGROUND_COLOR = new Color( 12, 75, 200 );
   
      // Logo constants
   private final HilltopWoodsLogo logo    = new HilltopWoodsLogo();
   private final CreditsLogo      credits = new CreditsLogo();
   
   public static final String PROJECT_DIRECTORY = "res/Hilltop Woods Creations/";
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private static JFrame window;
   
   private JPanel pnlPageHeader;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public Driver()
   {
      createWindow();
      createCanvas();
      createPageHeader();
      
      Container c = window.getContentPane();
      
      c.add( logo.getImage()    );
      c.add( credits.getImage() );
      c.add( pnlCanvas          );
      c.add( pnlPageHeader      );
      
      new CreateProjectPage();
   }

   /*****************/
   /*** Accessors ***/
   /*****************/
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public static void setWindowTitle( String pWindowTitle )
   {
      window.setTitle( "Hilltop Woods Creations - " + pWindowTitle );
   }

   /***************/
   /*** Helpers ***/
   /***************/
   
   private void createWindow()
   {
      window = new JFrame( "Hilltop Woods Creations - " );
      //window.setIconImage( new ImageIcon( "C://Hilltop Woods Creations//Hilltop Woods Pictures//Hilltop Woods.png" ).getImage() );
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible( true );
      window.setPreferredSize( new Dimension( JFRAME_WIDTH, JFRAME_HEIGHT ) );
      window.setBounds( JFRAME_X_LOCATION, JFRAME_Y_LOCATION, 
                        JFRAME_WIDTH, JFRAME_HEIGHT );
      window.setResizable( false );
      Container c = window.getContentPane();
      c.setLayout( null );
      window.pack();
      window.repaint();
   }
   
   private void createCanvas()
   {
      pnlCanvas = new TommysPanel( CANVAS_X_LOCATION, CANVAS_Y_LOCATION, 
                                   CANVAS_WIDTH, CANVAS_HEIGHT,
                                   CANVAS_BACKGROUND_COLOR );
      pnlCanvas.setLayout( new GridLayout( 1, 1 ) );
      pnlCanvas.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, PAGE_HEADER_BACKGROUND_COLOR, Color.WHITE ) );
   }
   
   private void createPageHeader()
   {
      pnlPageHeader = new TommysPanel( PAGE_HEADER_X_LOCATION, PAGE_HEADER_Y_LOCATION,
                                       PAGE_HEADER_WIDTH, PAGE_HEADER_HEIGHT,
                                       PAGE_HEADER_BACKGROUND_COLOR );
      lblPageHeader = new TommysLabel( 0, 0, PAGE_HEADER_WIDTH, PAGE_HEADER_HEIGHT );
      lblPageHeader.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, PAGE_HEADER_BACKGROUND_COLOR, Color.WHITE ) );
      pnlPageHeader.add( lblPageHeader );
   }
   
   public static void main( String args[] )
   {      
      new Driver();
   }
}