/*****************************
******************************
*
* File: StringFormatting.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments: 2/26/2013
* 
***************************** 
*****************************/

package miscellaneous;

public class StringFormatting
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   /********************/
   /*** Constructors ***/
   /********************/

   /*****************/
   /*** Accessors ***/
   /*****************/

   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   /***************/
   /*** Helpers ***/
   /***************/

   /**********************/
   /*** Static Methods ***/
   /**********************/
   
   public static String formatProjectName( String pProjectNameToFormat )
   {
      /*** Local Variables ***/
      /***********************/
      
         // Sets the first letter of the userName to upper case and the rest 
         // lower case no matter what.
      String projectNameInLowerCase = pProjectNameToFormat.toLowerCase();
      char firstCharInName       = projectNameInLowerCase.charAt( 0 );
      String projectNameFormatted;
   
         // userName formatted with first letter capitalized - rest lower case
      projectNameFormatted = projectNameInLowerCase.replaceFirst( String.valueOf( firstCharInName ), 
                             String.valueOf( Character.toUpperCase( firstCharInName ) ) );
      return projectNameFormatted;
   }
}
