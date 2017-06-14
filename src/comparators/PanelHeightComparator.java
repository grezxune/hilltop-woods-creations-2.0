/*****************************
******************************
*
* File: PanelHeightComparator.java
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

public class PanelHeightComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      //return ( door1.getPanelHeight() <  door2.getPanelHeight() ? -1 : 
      //       ( door1.getPanelHeight() == door2.getPanelHeight() ? 0 : 1 ) );
      return 0;
   }
}
