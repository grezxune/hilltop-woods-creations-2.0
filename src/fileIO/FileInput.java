/*****************************
***************************** 
*
* File: FileInput.java
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

package fileIO;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import miscellaneous.CabinetProject;
import windows.Driver;

public class FileInput
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/

   public FileInput()
   {
      // Default constructor
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public static CabinetProject getCabinetProjectObject( File pCabinetProject )
   {
      CabinetProject projectFromFile = null;
      
      if( pCabinetProject != null )
      {
         try
         {
            FileInputStream inStream = new FileInputStream( pCabinetProject );
            ObjectInputStream objectInStream = new ObjectInputStream( inStream );
            projectFromFile = ( CabinetProject ) objectInStream.readObject();
            objectInStream.close();
         }
         catch( ClassNotFoundException e )
         {
            
         }
         catch( FileNotFoundException e )
         {
            
         }
         catch( IOException e )
         {
            
         }
      }
      
      return projectFromFile;
   }
   
   public static CabinetProject getCabinetProjectObject( String pProjectName )
   {
      CabinetProject projectFromFile = null;
      File file = new File( Driver.PROJECT_DIRECTORY + pProjectName + "/" + pProjectName + "'s Project.dat" );
      
      if( file.exists() )
      {
         try
         {
            FileInputStream inStream = new FileInputStream( file );
            ObjectInputStream objectInStream = new ObjectInputStream( inStream );
            projectFromFile = ( CabinetProject ) objectInStream.readObject();
            objectInStream.close();
         }
         catch( ClassNotFoundException e )
         {
            
         }
         catch( FileNotFoundException e )
         {
            
         }
         catch( IOException e )
         {
            
         }
      }
      
      return projectFromFile;
   }
   
   public ArrayList< String > getLinesFromFile( String pFileName )
   {
      ArrayList< String > lines = new ArrayList< String >();
      
      try
      {
         String currentLine;
         
         File newFile = new File( pFileName );
         
         BufferedReader reader = new BufferedReader( new FileReader( newFile ) );
         
         currentLine = reader.readLine();
         
         while( currentLine != null )
         {
            lines.add( currentLine );
            currentLine = reader.readLine();
         }
         
         reader.close();
      }
      catch( FileNotFoundException e )
      {
         e.printStackTrace();
      }
      catch( IOException e )
      {
         e.printStackTrace();
      }
      
      return lines;
   }
   
   //public CabinetDoor get

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/

   /************************/
   /*** Abstract Methods ***/
   /************************/
}
