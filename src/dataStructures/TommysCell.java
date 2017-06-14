/*****************************
***************************** 
*
* File: Cell.java
* 
* Project: 
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 
* 
***************************** 
*****************************/

package dataStructures;
import newDoorSystem.CabinetOpening;

public interface TommysCell
{
   /************************/
   /*** Abstract Methods ***/
   /************************/
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public CabinetOpening getContent();
   
   public TommysCell getNext();
   
   public TommysCell getPrevious();
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   public void setContent( CabinetOpening pContent );
   
   public void setNext( TommysCell pNext );
   
   public void setPrevious( TommysCell pPrevious );
}
