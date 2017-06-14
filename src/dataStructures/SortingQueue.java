/*****************************
******************************
*
* File: SortingQueue.java
* 
* Project: Hilltop Woods Creations 2.0
* 
* Author: Tommy Trzebiatowski
* 
* Description: 
* 
* Comments:     2/26/2013
* 
***************************** 
*****************************/

package dataStructures;

public class SortingQueue< T >
{
   /***********************/
   /*** Class Constants ***/
   /***********************/

   /**************************/
   /*** Instance Variables ***/
   /**************************/

   private Node frontOfLine;
   private Node backOfLine;
 
   private int size;
   
   /********************/
   /*** Constructors ***/
   /********************/

   public SortingQueue()
   {
      start();
   }
   
   /*****************/
   /*** Accessors ***/
   /*****************/

   public int getSize()
   {
      return size;
   }
   
   public T dequeue()
   {
      Node frontOfQueue = null;
      
      if( size > 0 )
      {
         frontOfQueue = frontOfLine;
         frontOfLine = frontOfLine.getPrevious();
         size--;
      }
      
      return frontOfQueue.getContent();
   }
   
   public void enqueue( T pContent )
   {
      Node newNode = new Node( pContent, null );
      
      if( size > 0 )
      {
         backOfLine.setPrevious( newNode );
         backOfLine = newNode;
      }
      else
      {
         frontOfLine = newNode;
         backOfLine  = newNode;
      }
      size++;
   }
   
   public T peek()
   {
      T currentContent = null;
      
      if( size > 0 )
      {
         currentContent = frontOfLine.getContent();
      }
      
      return currentContent;
   }
   
   /****************************/
   /*** Mutator/Transformers ***/
   /****************************/

   public void start()
   {
      frontOfLine = new Node( null, backOfLine );
      backOfLine  = new Node( null, null );
      size = 0;
   }
   
   /***************/
   /*** Helpers ***/
   /***************/
   
   /*********************/
   /*** Private Class ***/
   /*********************/
   
   private class Node
   {
      /**************************/
      /*** Instance Variables ***/
      /**************************/

      private T content;
      private Node previous;
      
      /********************/
      /*** Constructors ***/
      /********************/
      
      public Node( T pContent, Node pPreviousNode )
      {
         setContent( pContent );
         setPrevious( pPreviousNode );
      }
      
      /*****************/
      /*** Accessors ***/
      /*****************/

      public T getContent()
      {
         return content;
      }
      
      public Node getPrevious()
      {
         return previous;
      }
      
      /****************************/
      /*** Mutator/Transformers ***/
      /****************************/
      
      public void setContent( T pContent )
      {
         content = pContent;
      }
      
      public void setPrevious( Node pPreviousNode )
      {
         previous = pPreviousNode;
      }
   }
   
   /*public static void main( String args[] )
   {
      SortingQueue< Integer > test = new SortingQueue<>();
      for( int i = 0; i < 10; i++ )
      {
         test.enqueue( i );
         System.out.println( "Element " + ( i + 1 ) + ": " + test.peek() );
         System.out.println( "     Size: " + test.getSize() );
      }
      System.out.println( "********************************************************" );
      for( int i = 0; i < 10; i++ )
      {
         System.out.println( "Element " + ( i + 1 ) + ": " + test.dequeue() );
      }
   }*/
}
