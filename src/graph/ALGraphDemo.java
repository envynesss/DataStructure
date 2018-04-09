package graph;

import javafx.scene.control.ListView;

import java.util.Arrays;
import java.util.Scanner;

public class ALGraphDemo {
    public static void main(String[] args) {
        ALGraph alGraph = new ALGraph(5);
        System.out.println("请输入顶点数和边长数：");
        Scanner scan = new Scanner(System.in);
        alGraph.numVers = scan.nextInt();
        alGraph.numEdges = scan.nextInt();
        System.out.println("请输入顶点信息：");

        for(int i=0;i<alGraph.numVers;i++){
            VertexNode newNode = new VertexNode(scan.next());
            alGraph.AdjList[i] = newNode;
        }
        System.out.println(Arrays.toString(alGraph.AdjList));

        System.out.println("请输入边上的顶点序号");
        for(int k=0;k<alGraph.numEdges;k++){
            int i = scan.nextInt(); //
            int j = scan.nextInt(); //临接序号为j
            
            EdgeNode edgeNode1 = new EdgeNode(i);
            alGraph.AdjList[j].firstedge = edgeNode1;

            EdgeNode edgeNode2 = new EdgeNode(j);
            alGraph.AdjList[i].firstedge = edgeNode2;

        }
    }


}

class ALGraph {
    int numVers;
    int numEdges;
    int maxsize;
    VertexNode[] AdjList;
    public ALGraph (int maxsize) {
        numEdges = 0;
        numVers = 0;
        this.maxsize = maxsize;
        AdjList = new VertexNode[maxsize];
    }

    public void createALGraph(){
        //TODO:
    }
}
class EdgeNode {
    int adjvex;
    int weight;
    EdgeNode next;

    public EdgeNode (int adjvex) {
        this.adjvex = adjvex;
    }
}
class VertexNode {
    String vertex;
    EdgeNode firstedge;

    public VertexNode (String vertex) {
        this.vertex = vertex;
    }
}
