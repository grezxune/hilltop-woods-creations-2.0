/****************************
***************************** 
*
* File: CreateProjectPage.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: This should display a page that allows the user to change the project name,
*              and any of the other measurements displayed on the page before continuing 
*              to the next page.
* 
* Comments: 
* 
***************************** 
*****************************/

package pages;

import fileIO.FileOutput;
import guiComponents.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import windows.Driver;
import customJComponents.TommysButton;
import miscellaneous.*;
import doorComponents.*;

public class LoadedProjectPage extends JPanel
                               implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Label constants
   public static final int LABEL_WIDTH      = 185;
   public static final int LABEL_X_LOCATION = ( Driver.pnlCanvas.getWidth() / 2 ) - ( LABEL_WIDTH + 10 ) ;
   public static final int LABEL_Y_LOCATION = 90;
   
      // Button constants
   public static final int BUTTON_X_LOCATION = ( Driver.pnlCanvas.getWidth() / 2 ) - TommysButton.BUTTON_X_PIXELS;
   public static final int BUTTON_Y_LOCATION = Driver.pnlCanvas.getHeight() - TommysButton.BUTTON_Y_PIXELS - 60;
   public static final int BUTTON_SPACING    = 5;
   
      // Door viewing kit constants
   public static final int DOOR_VIEWING_KIT_WIDTH  = Driver.pnlCanvas.getWidth();
   public static final int DOOR_VIEWING_KIT_HEIGHT = ( Driver.pnlCanvas.getHeight() / 3 ) * 2;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private CreateProjectPage firstPage;
   
   private DoorViewingKit projectSpecificValues;
   
   private TommysButton btnBack;
   private TommysButton btnContinue;
   
   private CabinetProject currentProject;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public LoadedProjectPage( CreateProjectPage pFirstPage, CabinetProject pProject )
   {
      setBounds( 0, 0, Driver.pnlCanvas.getWidth(), Driver.pnlCanvas.getHeight() );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( null );
      
      firstPage      = pFirstPage;
      currentProject = pProject;
      
      Driver.pnlCanvas.removeAll();
      projectSpecificValues = new DoorViewingKit( currentProject,
                                                  LABEL_X_LOCATION, LABEL_Y_LOCATION,
                                                  DOOR_VIEWING_KIT_WIDTH, DOOR_VIEWING_KIT_HEIGHT );
      projectSpecificValues.hideBtnNext();
      projectSpecificValues.hideBtnPrevious();
      projectSpecificValues.hideBtnSaveOpening();
      projectSpecificValues.hideDoorSearch();
      projectSpecificValues.hideDoorSelector();
      projectSpecificValues.hideDoorLabel();
      projectSpecificValues.hideBtnEdit();
      projectSpecificValues.hideBtnDelete();
      projectSpecificValues.hideBtnLoadProject();
      projectSpecificValues.hideDefaultDoorValuesBox();
      /*projectSpecificValues.hideDoubleDoorValuesBox();
      projectSpecificValues.hideVerticalHorizontalDoorValuesBox();*/
      
      createButtons();
      
      addAllComponentsToPanel();
      
      Driver.lblPageHeader.setIcon( new ImageIcon( Driver.PROJECT_DIRECTORY + 
                                                   "Hilltop Woods Pictures/South Park Me.png" ) );
      
      Driver.setWindowTitle( currentProject.getProjectName() );
   }

   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void createButtons()
   {
      btnBack = new TommysButton( "Back", BUTTON_X_LOCATION, BUTTON_Y_LOCATION );
      btnBack.addActionListener( this );
      
      btnContinue = new TommysButton( "Continue", btnBack.getX() + BUTTON_SPACING +
                                      btnBack.getWidth(), BUTTON_Y_LOCATION );
      btnContinue.addActionListener( this );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   private void addAllComponentsToPanel()
   {
      JPanel newPanel = Driver.pnlCanvas;
      
      add( projectSpecificValues );
      add( btnBack     );
      add( btnContinue );
      
      newPanel.add( this );
      newPanel.repaint();
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if( e.getSource() == btnBack )
      {
         processBtnBack();
      }
      else if( e.getSource() == btnContinue )
      {
         processBtnContinue();
      }
   }
   
   private void processBtnBack()
   {
      new CreateProjectPage();
   }
   
   private void processBtnContinue()
   {
      if( projectSpecificValues.getDefaultValues().checkAllFields() )
      {
         try
         {
            currentProject.setProjectSpecificMeasurements( Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfLeftStileWidth ().getText() ), 
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfRightStileWidth().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfTopRailWidth   ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfBottomRailWidth().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfLeftOverlay    ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfRightOverlay   ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfTopOverlay     ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfBottomOverlay  ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfPanelGap       ().getText() ),
                                                           Double.parseDouble( projectSpecificValues.getDefaultValues().getTxfTennonLength   ().getText() ) );
            
            FileOutput.writeCabinetProjectObject( currentProject );
            new PageCards( currentProject );
         }
         catch( NumberFormatException e )
         {
            JOptionPane.showMessageDialog( Driver.pnlCanvas, "Error " + e.getMessage() );
         }
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "One or more of the fields is invalid." );
      }
   }
}
