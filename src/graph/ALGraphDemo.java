package graph;

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
}
class VertexNode {
    String vertex;
    EdgeNode firstedge;

    public VertexNode (String vertex) {
        this.vertex = vertex;
    }
}
