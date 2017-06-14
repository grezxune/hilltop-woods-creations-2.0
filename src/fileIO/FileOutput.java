/*****************************
***************************** 
*
* File: FileOutput.java
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
import miscellaneous.CabinetProject;
import windows.Driver;

public class FileOutput
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

   public FileOutput()
   {
      
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public static void writeCabinetProjectObject( CabinetProject pCabinetProject )
   {
      try
      {
         File newFile = new File( Driver.PROJECT_DIRECTORY + pCabinetProject.getProjectName() + "'s Project.dat" );
         FileOutputStream outStream = new FileOutputStream( newFile );
         ObjectOutputStream objectStream = new ObjectOutputStream( outStream );
         objectStream.writeObject( pCabinetProject );
         objectStream.close();
      }
      catch( FileNotFoundException e )
      {
         
      }
      catch( IOException e )
      {
         
      }
   }
   
   public static boolean createDirectory( String pFileName )
   {
      File newDirectory = new File( Driver.PROJECT_DIRECTORY + pFileName );
      
      return newDirectory.mkdir();
   }
   
   public static boolean createDirectory( File pFile )
   {
      return pFile.mkdir();
   }

   /************************/
   /*** Abstract Methods ***/
   /************************/
}
