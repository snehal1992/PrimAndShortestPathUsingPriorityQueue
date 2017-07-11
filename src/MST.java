
/* Ver 1.0: Starter code for Prim's MST algorithm */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.lang.Comparable;
import java.io.FileNotFoundException;
import java.io.File;

public class MST {
    static final int Infinity = Integer.MAX_VALUE;

    static int PrimMST(Graph g, Vertex s)
    {
        int wmst = 0;
        IndexedHeap<Vertex> q= new IndexedHeap<Vertex>(g.size, s);
        for(Vertex u : g){
        	u.d=Integer.MAX_VALUE;
        	u.p=null;
        	q.add(u);
        }
        s.d=0;
        q.decreaseKey(s);
        while(q.size!=0){
        	Vertex u=q.remove();
        	wmst+=u.d;
        	u.inTree=true;
        	for(Edge e : u.adj){
        		Vertex v=e.otherEnd(u);
        		if(!(v.inTree) && e.weight<v.d){
        			v.d=e.weight;
        			v.p=u;
        			q.decreaseKey(v);
        		}
        	}
        }
        return wmst;
    }
   static int PrimMST2(Graph g , Vertex s){
	   int size=1;
	   int wmst=0;
	   PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
	   s.inTree=true;
	   for(Edge e : s.adj){
		   pq.add(e);
	   }
	   while(size<g.size){
		   Edge e=pq.remove();
		   if(e.from.inTree && e.to.inTree){
			   continue;
		   }
		   wmst+=e.weight;
		   if(e.from.inTree){
			   for(Edge f : e.to.adj){
				   pq.add(f);
			   }
			   e.to.inTree=true;
			   e.to.p=e.from;
		   }else{
			   for(Edge f : e.from.adj){
				   pq.add(f);
				   }
			   e.from.inTree=true;
			   e.from.p=e.to;
		   }
		   size++;
	   }
   return wmst;
   }
    public static void main(String[] args) throws FileNotFoundException {
	Scanner in;

        if (args.length > 0) {
            File inputFile = new File(args[0]);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }

	Graph g = Graph.readGraph(in);
        Vertex s = g.getVertex(1);
        System.out.println(PrimMST(g, s));
    }
}
