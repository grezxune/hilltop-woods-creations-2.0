/*****************************
******************************
*
* File: PanelWidthComparator.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 3/1/2013
* 
***************************** 
*****************************/

package comparators;

import java.util.Comparator;
import newDoorSystem.CabinetOpening;

public class PanelWidthComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      //double doorOnePanelWidth = door1.getPanelWidth();
      //double doorTwoPanelWidth = door2.getPanelWidth();
      
      //return Double.compare( doorOnePanelWidth, doorTwoPanelWidth );
      return 0;
   }
}