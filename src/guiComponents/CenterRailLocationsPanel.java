/*****************************
******************************
*
* File: CenterRailLocationsPanel.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description:
* 
* Comments: 2/26/2013
* 
***************************** 
*****************************/

package guiComponents;

import customJComponents.*;
import javax.swing.*;
import java.awt.*;
import windows.*;

public class CenterRailLocationsPanel extends TommysPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   public static final Color PANEL_BACKGROUND_COLOR = Driver.CANVAS_BACKGROUND_COLOR;
   
   public static final String PANEL_TITLE = "Rail Locations";
   
   public static final int FIRST_LABEL_X_LOCATION = 5;
   public static final int FIRST_LABEL_Y_LOCATION = 10;
   public static final int LABEL_WIDTH = 50;
   public static final int LABEL_HEIGHT = 30;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private JLabel locationsLabel;
   private JLabel[] lblRails;
   private TommysTextField[] railLocations;

   /********************/
   /*** Constructors ***/
   /********************/

   public CenterRailLocationsPanel( int pXLocation, int pYLocation,
                                    int pNumberOfRails, double pDoorWidth )
   {
      super( pXLocation, pYLocation, PANEL_BACKGROUND_COLOR );
      lblRails = new JLabel[ pNumberOfRails ];
      railLocations = new TommysTextField[ pNumberOfRails ];
      
      // Instantiate labels
      createRailLabels();
      
      // Instantiate textfields
      createRailLocationsTextFields();
      
      // Add labels and textfields to panel ( this )
      addLabelsAndTextfields();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createRailLabels()
   {
      for( int i = 0; i < lblRails.length; i++ )
      {
         lblRails[ i ] = new JLabel( "Rail " + ( i + 1 ) );
         lblRails[ i ].setBounds( FIRST_LABEL_X_LOCATION, i == 0 ? FIRST_LABEL_Y_LOCATION : lblRails[ i - 1 ].getY(), LABEL_WIDTH, LABEL_HEIGHT );
      }
   }

   private void createRailLocationsTextFields()
   {
      for( int i = 0; i < railLocations.length; i++ )
      {
         railLocations[ i ] = new TommysTextField( lblRails[ i ].getX(), lblRails[ i ].getY() );
      }
   }
   
   private void addLabelsAndTextfields()
   {
      for( int i = 0; i < lblRails.length; i++ )
      {
         add( lblRails[ i ] );
         add( railLocations[ i ] );
      }
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
}
