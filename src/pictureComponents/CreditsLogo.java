/****************************
***************************** 
*
* File: CreditsLogo.java
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

public class CreditsLogo
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private JLabel picture;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CreditsLogo()
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
                                       "Hilltop Woods Pictures/Test Picture.png" );
      
      picture = new JLabel();
      picture.setBounds( 0  ,  // X location 
                         Driver.JFRAME_CONTENT_PANE_HEIGHT - 100,  // Y location
                         Driver.JFRAME_CONTENT_PANE_WIDTH, // Width
                         100 );               // Height
      picture.setIcon( image );
      picture.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, Driver.PAGE_HEADER_BACKGROUND_COLOR, Color.WHITE ) );
   }
}
