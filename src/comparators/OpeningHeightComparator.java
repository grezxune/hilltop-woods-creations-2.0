/*****************************
******************************
*
* File: OpeningHeightComparator.java
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

public class OpeningHeightComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      //return ( door1.getDoorOpening().getHeight() <  door2.getDoorOpening().getHeight() ? -1 : 
      //       ( door1.getDoorOpening().getHeight() == door2.getDoorOpening().getHeight() ? 0 : 1 ) );
      return 0;
   }
}
