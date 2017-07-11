
/* Ver 1.0: Starter code for Dijkstra's Shortest path algorithm */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Comparable;
import java.io.FileNotFoundException;
import java.io.File;

public class ShortestPath {
    static final int Infinity = Integer.MAX_VALUE;

    static void DijkstraShortestPaths(Graph g, Vertex s)
    {
    	 IndexedHeap<Vertex> q= new IndexedHeap<Vertex>(g.size, s);
    	   for(Vertex u : g){
           	u.d=Infinity;
           	u.p=null;
           	u.inTree=false;
           	q.add(u);
           }
           s.d=0;
           q.decreaseKey(s);
           while(q.size!=0){
           	Vertex u=q.remove();
           	u.inTree=true;
           	for(Edge e : u.adj){
        		Vertex v=e.otherEnd(u);
           		if(!(v.inTree) && e.weight+u.d<v.d){
           			v.d=e.weight+u.d ;
           			v.p=u;
           			q.decreaseKey(v);
           		}
           	}
           }
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
	int src = in.nextInt();
	int target = in.nextInt();
        Vertex s = g.getVertex(src);
	Vertex t = g.getVertex(target);
        DijkstraShortestPaths(g, s);

	System.out.println(t.d);
    }
}
