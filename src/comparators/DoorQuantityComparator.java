/*****************************
******************************
*
* File: DoorQuantityComparator.java
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

public class DoorQuantityComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      return ( door1.getNumberOfDoors() < door2.getNumberOfDoors() ? -1 : 
             ( door1.getNumberOfDoors() == door2.getNumberOfDoors() ? 0 : 1 ) );
   }
}
