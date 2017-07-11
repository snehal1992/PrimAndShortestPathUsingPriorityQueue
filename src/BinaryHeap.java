// Ver 1.0:  Starter code for Binary Heap implementation

import java.util.Comparator;

public class BinaryHeap<T extends Index>  implements PQ<T> {
    Object[] pq;
    Comparator<T> c;
    int size;// size of priority queue
    /** Build a priority queue with a given array q */
    int hole;
    BinaryHeap(T[] q, Comparator<T> comp) {
	pq = q;
	c = comp;
	buildHeap();
    }
    
    /** Create an empty priority queue of given maximum size */
    BinaryHeap(int n, Comparator<T> comp) { /* to be implemented */
        pq=new Object [n+1];
        size=0;
        c=comp;
    }
    public void insert(T x) {
	add(x);
    }

    public T deleteMin() {
	return remove();
    }

    public T min() { 
	return peek();
    }

    public void add(T x) { /* to be implemented */
    	pq[0]=x;
    	percolateUp(size+1);
    	size++;
    	}

    public T remove() { /* to be implemented */
    	if(size==0){
    		return null;
    	}else{
    		pq[0]=(T)pq[1];
    		//System.out.println("pg  "+(T)pq[1]);
    		percolateDown(1);
    		size--;
    		return (T)pq[0];
    	  }
    }

    public T peek() { /* to be implemented */
    
    	if(size==0){
    		return null ;
    	}else{
    		return (T)pq[1];
    	 }
    }
    
    /** pq[i] may violate heap order with parent */
    void percolateUp(int i) { /* to be implemented */
    	if(i<size+1){
    		pq[0]=(T)pq[i];
    	}
        hole=i;
    	while(c.compare((T)pq[hole/2], (T)pq[0])>0){
    		pq[hole]=(T)pq[hole/2];
    	    ((T)pq[hole]).putIndex(hole);
    		hole=hole/2;
    	}
    	pq[hole]=(T)pq[0];
       ((T)pq[hole]).putIndex(hole);
    }
    
    /** pq[i] may violate heap order with children */
    void percolateDown(int i) { /* to be implemented */
    	pq[1]=(T)pq[size]; 
    	T x=(T)pq[1];
    	 int schild;
    	 while(true){
    		 if(i*2>size){
    			 break;
    		 }else{
    			 if(i*2==size){
    			 schild=i*2;
    			 }else{
    				 if(c.compare((T)pq[2*i], (T)pq[2*i+1])<=0){
    				 schild=2*i;
    				 }else{
    					 schild=2*i+1;
    				 }
    		      }
    			 if(c.compare(x, (T)pq[schild])<=0){
    				 break;
    			 }else{
    				 T temp=(T)pq[i];
    				 pq[i]=(T)pq[schild];
    				 ((T)pq[i]).putIndex(i);
    				 pq[schild]=temp;
    				 i=schild;
    			  }
    		   }
          }
    	 pq[i]=x;
    	 ((T)pq[i]).putIndex(i);
    }

    /** Create a heap.  Precondition: none. */
    void buildHeap() {
        int i=0;
        for(i=size/2;i>=1;i++){
        	percolateDown(i);
        }
     }

    /* sort array A[1..n].  A[0] is not used. 
       Sorted order depends on comparator used to buid heap.
       min heap ==> descending order
       max heap ==> ascending order
     */
    public static<T> void heapSort(T[] A, Comparator<T> comp) { /* to be implemented */
    }
}
