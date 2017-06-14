/*****************************
******************************
*
* File: DoorWidthComparator.java
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

public class DoorWidthComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      //return ( door1.getDoorWidth() <  door2.getDoorWidth() ? -1 : 
      //       ( door1.getDoorWidth() == door2.getDoorWidth() ? 0 : 1 ) );
      return 0;
   }
}
