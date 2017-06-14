/*****************************
******************************
*
* File: BottomOverlayComparator.java
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

public class BottomOverlayComparator implements Comparator< CabinetOpening >
{
   public int compare( CabinetOpening door1, CabinetOpening door2 )
   {
      return 0; // ( door1.getDoorComponents().getBottomOverlay().getWidth() <  door2.getDoorComponents().getBottomOverlay().getWidth() ? -1 : 
             //( door1.getDoorComponents().getBottomOverlay().getWidth() == door2.getDoorComponents().getBottomOverlay().getWidth() ? 0 : 1 ) );
   }
}
