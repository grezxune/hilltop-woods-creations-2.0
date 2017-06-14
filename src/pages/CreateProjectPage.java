/****************************
***************************** 
*
* File: CreateProjectPage.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: This should display a page that allows the user to enter in a name
*              and click create, or click open and allow the user to choose a current
*              directory to work from.
* 
* Comments: 
* 
***************************** 
*****************************/

package pages;

import fileIO.FileInput;
import fileIO.FileOutput;
import guiComponents.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import windows.Driver;
import customJComponents.TommysButton;
import customJComponents.TommysLabel;
import customJComponents.TommysTextField;
import miscellaneous.*;
import java.io.*;

public class CreateProjectPage extends JPanel 
                               implements ActionListener
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

      // Page panel constants
   public static final int PANEL_X_LOCATION = 0;
   public static final int PANEL_Y_LOCATION = 0;
   
      // Project text field constants
   public static final int PROJECT_NAME_FIELD_WIDTH  = 110;
   public static final int PROJECT_NAME_FIELD_HEIGHT = 30;
   
   public static final int PROJECT_NAME_FIELD_X_LOCATION = ( Driver.pnlCanvas.getWidth() / 2 ) - 
                                                           PROJECT_NAME_FIELD_WIDTH;
   public static final int PROJECT_NAME_FIELD_Y_LOCATION = ( Driver.pnlCanvas.getHeight() / 2 ) - 
                                                           PROJECT_NAME_FIELD_HEIGHT;
      // Project label constants
   public static final int PROJECT_NAME_LABEL_WIDTH  = 150;
   public static final int PROJECT_NAME_LABEL_HEIGHT = 30;
   
   public static final int PROJECT_NAME_LABEL_X_LOCATION = PROJECT_NAME_FIELD_X_LOCATION - 
                                                           ( PROJECT_NAME_LABEL_WIDTH + 5 );
   public static final int PROJECT_NAME_LABEL_Y_LOCATION = PROJECT_NAME_FIELD_Y_LOCATION;
   
      // Create project button constants
   public static final int CREATE_PROJECT_BUTTON_WIDTH  = 125;
   public static final int CREATE_PROJECT_BUTTON_HEIGHT = 30;
   
   public static final int CREATE_PROJECT_BUTTON_X_LOCATION = PROJECT_NAME_FIELD_X_LOCATION +
                                                              PROJECT_NAME_FIELD_WIDTH + 10;
   public static final int CREATE_PROJECT_BUTTON_Y_LOCATION = PROJECT_NAME_FIELD_Y_LOCATION;
   
      // Open project button constants
   public static final int OPEN_PROJECT_BUTTON_WIDTH  = 125;
   public static final int OPEN_PROJECT_BUTTON_HEIGHT = 30;
   
   public static final int OPEN_PROJECT_BUTTON_X_LOCATION = CREATE_PROJECT_BUTTON_X_LOCATION;
   public static final int OPEN_PROJECT_BUTTON_Y_LOCATION = CREATE_PROJECT_BUTTON_Y_LOCATION + 40;
   
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private TommysLabel lblProjectName;
   
   private TommysTextField txfProjectName;
   
   private TommysButton    btnCreateProject;
   private TommysButton    btnOpenProject;

   /********************/
   /*** Constructors ***/
   /********************/
   
   public CreateProjectPage()
   {
      setBounds( 0, 0, Driver.pnlCanvas.getWidth(), Driver.pnlCanvas.getHeight() );
      setBackground( Driver.CANVAS_BACKGROUND_COLOR );
      setLayout( null );
      
      createLabels();
      createTextFields();
      createButtons();
      
      displayCreateProjectPage();
      
      Driver.lblPageHeader.setIcon( new ImageIcon( Driver.PROJECT_DIRECTORY + 
                                                   "Hilltop Woods Pictures/South Park Me.png" ) );
      
      Driver.setWindowTitle( "" );
   }

   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   private void createLabels()
   {
      lblProjectName = new TommysLabel( "Project Name: ", PROJECT_NAME_LABEL_X_LOCATION, 
                                        PROJECT_NAME_LABEL_Y_LOCATION,
                                        PROJECT_NAME_LABEL_WIDTH, PROJECT_NAME_LABEL_HEIGHT );
   }
   
   private void createTextFields()
   {
      txfProjectName = new TommysTextField( PROJECT_NAME_FIELD_X_LOCATION, PROJECT_NAME_FIELD_Y_LOCATION,
                                            PROJECT_NAME_FIELD_WIDTH, PROJECT_NAME_FIELD_HEIGHT );
      txfProjectName.addActionListener( this );
   }
   
   private void createButtons()
   {
      btnCreateProject = new TommysButton( "Create Project", CREATE_PROJECT_BUTTON_X_LOCATION, 
                                           CREATE_PROJECT_BUTTON_Y_LOCATION, CREATE_PROJECT_BUTTON_WIDTH,
                                           CREATE_PROJECT_BUTTON_HEIGHT );
      btnCreateProject.addActionListener( this );

      btnOpenProject = new TommysButton( "Open Project", OPEN_PROJECT_BUTTON_X_LOCATION, 
                                         OPEN_PROJECT_BUTTON_Y_LOCATION, OPEN_PROJECT_BUTTON_WIDTH,
                                         OPEN_PROJECT_BUTTON_HEIGHT );
      btnOpenProject.addActionListener( this );
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public void displayCreateProjectPage()
   {
      JPanel pnlCanvas = Driver.pnlCanvas;
      
      pnlCanvas.removeAll();
      pnlCanvas.repaint();
      
      add( lblProjectName   );
      add( txfProjectName   );
      add( btnCreateProject );
      add( btnOpenProject   );
      
      pnlCanvas.add( this );
   }
   
   private void processBtnCreateProject()
   {
      String fileNameRequest = StringFormatting.formatProjectName( txfProjectName.getText() );
      String formattedFileNameRequest = Driver.PROJECT_DIRECTORY + fileNameRequest + "'s Project.dat";
      
      File newFile = new File( formattedFileNameRequest );
      
      if( !newFile.exists() )
      {
            // Creates new project
         createNewProject( fileNameRequest );
      }
      else if( txfProjectName.getText().length() == 0 )
      {
            // User failed to enter anything in the name text field
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "Enter a name please." );
      }
      else
      {
            // Asks user if they wish to overwrite current project
         int overwriteConfirmation = JOptionPane.showConfirmDialog( Driver.pnlCanvas, 
                                                                    "Do you wish to overwrite it?", 
                                                                    "Project already exists", 
                                                                    JOptionPane.YES_NO_OPTION );
         
         if( overwriteConfirmation == JOptionPane.YES_OPTION )
         {
            int overwriteConfirmationTierTwo = JOptionPane.showConfirmDialog( Driver.pnlCanvas,
                                                                              "Yes: Overwrite \n No: Open \n Cancel: Fresh Page", 
                                                                              "OVERWRITING PROJECT", 
                                                                              JOptionPane.YES_NO_CANCEL_OPTION );
            if( overwriteConfirmationTierTwo == JOptionPane.YES_OPTION )
            {
               createNewProject( fileNameRequest );
            }
            else if( overwriteConfirmationTierTwo == JOptionPane.NO_OPTION )
            {
               CabinetProject projectFromFile = FileInput.getCabinetProjectObject( fileNameRequest );
               new LoadedProjectPage( this, projectFromFile );
            }
            else if( overwriteConfirmationTierTwo == JOptionPane.CANCEL_OPTION )
            {
               txfProjectName.setText( "" );
            }
         }
      }
   }
   
   private void createNewProject( String pFormattedFileName )
   {
      CabinetProject newProject = new CabinetProject( pFormattedFileName );
      
      FileOutput.writeCabinetProjectObject( newProject );
      new LoadedProjectPage( this, newProject );
   }
   
   private void processBtnOpenProject()
   {
      JFileChooser chooser = new JFileChooser();
      chooser.setCurrentDirectory( new File( Driver.PROJECT_DIRECTORY ) );
      chooser.showOpenDialog( Driver.pnlCanvas );
      CabinetProject projectFromFile = FileInput.getCabinetProjectObject( chooser.getSelectedFile() );
      
      if( projectFromFile == null )
      {
         
      }
      else if( projectFromFile instanceof CabinetProject )
      {
         new LoadedProjectPage( this, projectFromFile );
      }
      else
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, "That was not a valid project file." );
      }
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if( e.getSource() == btnCreateProject ||
          e.getSource() == txfProjectName   )
      {
         processBtnCreateProject();
      }
      else if( e.getSource() == btnOpenProject )
      {
         processBtnOpenProject();
      }
   }
}
