/*****************************
******************************
*
* File: PanelCutlist.java
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

package guiComponents;

import java.util.LinkedList;
import javax.swing.JPanel;
import newDoorSystem.CabinetOpening;
import comparators.*;
import miscellaneous.*;

public class PanelCutlist extends CutlistPanel
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private PanelCutlistEntry[] panelCutlistEntries;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public PanelCutlist( CabinetProject pCurrentProject, String pTitle )
   {
      super( pTitle );
      setCurrentProject( pCurrentProject );
      populateCutlist( pCurrentProject.getOpenings() );
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public PanelQuantityComparator getQuantityComparator()
   {
      return new PanelQuantityComparator();
   }
   
   public DoorLinearFeetComparator getLinearFeetComparator()
   {
      return new DoorLinearFeetComparator();
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/
   
   public void populateCutlist( LinkedList < CabinetOpening > pListToPopulateFrom )
   {
      panelCutlistEntries = new PanelCutlistEntry[pListToPopulateFrom.size()];
      
      for(int i = 0; i < panelCutlistEntries.length; i++)
      {
         panelCutlistEntries[i] = new PanelCutlistEntry( pListToPopulateFrom.get( i ) );
         
         if(i == 0)
         {
            panelCutlistEntries[i].setBounds( FIRST_ENTRY_X_POSITION,
                                              FIRST_ENTRY_Y_POSITION,
                                              panelCutlistEntries[i].getWidth(),
                                              panelCutlistEntries[i].getHeight() );
         }
         else
         {
            panelCutlistEntries[i].setBounds( FIRST_ENTRY_X_POSITION,
                                              panelCutlistEntries[i - 1].getY() + panelCutlistEntries[i -1].getHeight() + 5,
                                              panelCutlistEntries[i].getWidth(),
                                              panelCutlistEntries[i].getHeight() );
         }
      }
      
      addEntriesToPanel();
   }
   
   private void addEntriesToPanel()
   {
      for(int i = 0; i < panelCutlistEntries.length; i++)
      {
         add( panelCutlistEntries[i] );
      }
   }

	@Override
	public void populateCutlist() {
		// TODO Auto-generated method stub
		
	}
}
