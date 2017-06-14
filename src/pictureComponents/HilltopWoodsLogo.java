/****************************
***************************** 
*
* File: HilltopWoodsLogo.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: This is just the picture logo
* 
* Comments: 
* 
***************************** 
*****************************/

package pictureComponents;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import windows.Driver;
import miscellaneous.*;

public class HilltopWoodsLogo
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private JLabel picture;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public HilltopWoodsLogo()
   {
      createPicture();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public JLabel getImage()
   {
      return picture;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void createPicture()
   {
      ImageIcon image = new ImageIcon( Driver.PROJECT_DIRECTORY + 
                                       "/Hilltop Woods Pictures/Hilltops Picture.png" );
      
      picture = new JLabel();
      picture.setBounds( 0, // X location
                         0, // Y location
                         300,  // Width
                         Driver.JFRAME_CONTENT_PANE_HEIGHT - 100 );// Height
      picture.setIcon( image );
      picture.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, Driver.PAGE_HEADER_BACKGROUND_COLOR, Color.WHITE ) );
   }
}
