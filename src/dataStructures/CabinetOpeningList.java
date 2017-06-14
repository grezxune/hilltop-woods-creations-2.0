package dataStructures;

import java.io.*;
import java.util.LinkedList;
import newDoorSystem.*;

public class CabinetOpeningList extends LinkedList< CabinetOpening > implements Serializable
{
   /**************************/
   /*** Instance Variables ***/
   /**************************/
   
   private TommysCell frontAnchor;
   private TommysCell backAnchor;
   
   private TommysCell currentCell;
   
   private int size;
   
   /********************/
   /*** Constructors ***/
   /********************/
   
   public CabinetOpeningList()
   {
      setAnchors();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/
   
   public TommysCell getFrontAnchor()
   {
      return frontAnchor;
   }
   
   public TommysCell getBackAnchor()
   {
      return backAnchor;
   }
   
   public int size()
   {
      return size;
   }
   
   public CabinetOpening get( int pIndex )
   {
      CabinetOpening openingToReturn = null;
      
      if( pIndex >= 0 &&
          pIndex <= size )
      {
         start();
         for( int i = 0; i < pIndex; i++ )
         {
            currentCell = currentCell.getNext();
         }
         
         openingToReturn = currentCell.getContent();
         currentCell = backAnchor.getPrevious();
      }
      
      return openingToReturn;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/
   
   private void setAnchors()
   {
      frontAnchor = new Cell( null );
      backAnchor  = new Cell( null );
      
      frontAnchor.setNext( backAnchor );
      backAnchor.setPrevious( frontAnchor );
      
      currentCell = frontAnchor;
      size = 0;
   }
   
   public void start()
   {
      currentCell = frontAnchor;
   }
   
   public boolean add( CabinetOpening pNewCabinetOpening )
   {
      TommysCell newCell = new Cell( pNewCabinetOpening );
      
      currentCell = backAnchor.getPrevious();
      
      newCell.setNext( currentCell.getNext() );
      newCell.setPrevious( currentCell );
      newCell.getNext().setPrevious( newCell );
      currentCell.setNext( newCell );
      currentCell = newCell;
      
      size++;
      
      return true;
   }
   
   public boolean add( CabinetOpening pNewCabinetOpening, int pOpeningToOverwrite )
   {
      boolean successfullyAdded = false;
      
      if( pOpeningToOverwrite > 0 )
      {
         start();
         
         for( int i = 0; i < pOpeningToOverwrite; i++ )
         {
            currentCell = currentCell.getNext();
         }
         
         TommysCell newCell       = new Cell( pNewCabinetOpening );
         TommysCell beforeNewCell = currentCell.getPrevious();
         TommysCell afterNewCell  = currentCell.getNext();
         
         currentCell = newCell;
         currentCell.setPrevious( beforeNewCell );
         currentCell.setNext( afterNewCell );
         beforeNewCell.setNext( currentCell );
         afterNewCell .setPrevious( currentCell );
         
         successfullyAdded = true;
      }
      else
      {
         successfullyAdded = add( pNewCabinetOpening );
      }
      
      return successfullyAdded;
   }
   
   public CabinetOpening remove( int pDoorNumber )
   {
      TommysCell cellToDelete = getFrontAnchor();
      
      if( size > 0 )
      {
         if( pDoorNumber >= 0 && 
             pDoorNumber <= size )
         {
               // Iterates until cell number 'pDoorNumber' is reached
            for( int i = 0; i < pDoorNumber; i++ )
            {
               cellToDelete = cellToDelete.getNext();
            }
            
               // Collecting variable references to the cells on either side of the
               // cell to be deleted
            TommysCell behindCellToDelete  = cellToDelete.getPrevious();
            TommysCell aheadOfCellToDelete = cellToDelete.getNext();
            
               // Deleting cell
            behindCellToDelete.setNext( aheadOfCellToDelete );
            aheadOfCellToDelete.setPrevious( behindCellToDelete );
            
            size--;
            
               // Updating openingNumbers for specific CabinetOpening objects
            TommysCell cellToBeUpdated = aheadOfCellToDelete;
            
            while( cellToBeUpdated.getContent() != null )
            {
               cellToBeUpdated.getContent().setOpeningNumber( ( cellToBeUpdated.getContent().getOpeningNumber() - 1 ) );
               cellToBeUpdated = cellToBeUpdated.getNext();
            }
         }
      }
      
      return cellToDelete.getContent();
   }
   
   /*********************/
   /*** Private Class ***/
   /*********************/
   
   private class Cell extends LinkedList< CabinetOpening > implements TommysCell
   {
      /**************************/
      /*** Instance Variables ***/
      /**************************/

      private CabinetOpening content;
      
      private TommysCell next;
      private TommysCell previous;
      
      /********************/
      /*** Constructors ***/
      /********************/
      
      public Cell( CabinetOpening pContent )
      {
         setContent( pContent );
         setNext( null );
         setPrevious( null );
      }
      
      /*****************/
      /*** Accessors ***/
      /*****************/

      public CabinetOpening getContent()
      {
         return content;
      }
      
      public TommysCell getNext()
      {
         return next;
      }
      
      public TommysCell getPrevious()
      {
         return previous;
      }
      
      /****************************/
      /*** Mutator/Transformers ***/
      /****************************/
      
      public void setContent( CabinetOpening pContent )
      {
         content = pContent;
      }
      
      public void setNext( TommysCell pNext )
      {
         next = pNext;
      }
      
      public void setPrevious( TommysCell pPrevious )
      {
         previous = pPrevious;
      }
   }
   
   /*public static void main( String args[] )
   {
      CabinetList test = new CabinetList();
      
      
      test.add( new SingleDoor( new double[ 10 ], new double[ 3 ], 1 ) );
      test.add( new SingleDoor( new double[ 10 ], new double[ 3 ], 2 ) );
      test.add( new SingleDoor( new double[ 10 ], new double[ 3 ], 3 ) );
      test.add( new SingleDoor( new double[ 10 ], new double[ 3 ], 4 ) );
      test.add( new SingleDoor( new double[ 10 ], new double[ 3 ], 5 ) );
      
      
      System.out.println( test.remove( 3  ).getDoorNumber() );
   }*/
}
