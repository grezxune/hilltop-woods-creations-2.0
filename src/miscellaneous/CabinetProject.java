/*****************************
***************************** 
*
* File: CabinetProject.java
* 
* Project: 
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: The updating door number function of this class still needs to be
*           verified that it works.
* 
***************************** 
*****************************/

package miscellaneous;

import java.io.*;
import javax.swing.*;
import newDoorSystem.CabinetOpening;
import windows.Driver;
import dataStructures.*;
import doorComponents.*;

public class CabinetProject implements Serializable
{
   /***********************/
   /*** Class Constants ***/
   /***********************/
   
   public static final String DEFAULT_PROJECT_NAME = "Invalid Name";
   
   public static final int MINIMUM_NAME_LENGTH = 1;

   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
      // User's name of project
   private String projectName;
   
      // Cabinet project door list
   private CabinetOpeningList cabinetList;
   
   private ProjectSpecificValues projectSpecificComponents;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public CabinetProject( String pProjectName )
   {
      setProjectName( pProjectName );
      cabinetList = new CabinetOpeningList();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public String getProjectName()
   {
      return projectName;
   }
   
   public int getNumberOfOpenings()
   {
      return cabinetList.size();
   }
   
   public ProjectSpecificValues getProjectSpecificValues()
   {
      return projectSpecificComponents;
   }
   
   public int getNumberOfOpeningsInProject()
   {
      return cabinetList.size();
   }
   
   public CabinetOpeningList getOpenings()
   {
      return cabinetList;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void setProjectName( String pProjectName )
   {
      if ( verifyProjectName( pProjectName ) )
      {
         projectName = StringFormatting.formatProjectName( pProjectName );
      }
      else
      {
         throw new IllegalArgumentException( "Name invalid" );
      }
   }
   
   public void addOpening( CabinetOpening pOpeningToAdd, int pOpeningToOverwrite )
   {
      cabinetList.add( pOpeningToAdd, pOpeningToOverwrite );
   }
   
   public void removeOpening( int pDoorNumber )
   {
      cabinetList.remove( pDoorNumber );
   }
   
   public CabinetOpening getOpening( int pOpeningNumber )
   {
      return cabinetList.get( pOpeningNumber );
   }
   
   public void setProjectSpecificMeasurements( double pLeftStileWidth ,
                                               double pRightStileWidth,
                                               double pTopRailWidth   ,
                                               double pBottomRailWidth,
                                               double pLeftOverlay    ,
                                               double pRightOverlay   ,
                                               double pTopOverlay     ,
                                               double pBottomOverlay  ,
                                               double pPanelGap       , 
                                               double pTennonLength   )
   {
      try
      {
         projectSpecificComponents = new ProjectSpecificValues( pLeftStileWidth ,
                                                                pRightStileWidth,
                                                                pTopRailWidth   ,
                                                                pBottomRailWidth,
                                                                pLeftOverlay    ,
                                                                pRightOverlay   ,
                                                                pTopOverlay     ,
                                                                pBottomOverlay  ,
                                                                pPanelGap       ,
                                                                pTennonLength   );
      }
      catch( IllegalArgumentException e )
      {
         JOptionPane.showMessageDialog( Driver.pnlCanvas, e.getMessage() );
      }
      
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   public boolean verifyProjectName( String pProjectNameToVerify )
   {
      /*** Local Variables ***/
      /***********************/
      
      boolean isProjectNameVerified = false;
      
      if ( pProjectNameToVerify.length() >= MINIMUM_NAME_LENGTH )
      {
         isProjectNameVerified = true;
      }
      
      return isProjectNameVerified;
   }
}
