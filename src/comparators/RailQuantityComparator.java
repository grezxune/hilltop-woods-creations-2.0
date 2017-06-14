/*****************************
******************************
*
* File: RailQuantityComparator.java
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

public class RailQuantityComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      return 0;//( door1.getNumberOfRails() < door2.getNumberOfRails() ? -1 : 
             //( door1.getNumberOfRails() == door2.getNumberOfRails() ? 0 : 1 ) );
   }
}
