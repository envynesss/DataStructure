package graph;

import java.util.Arrays;
import java.util.Scanner;

public class NDGraphDemo {
    public static void main(String[] args) {
        /*int numarc = 0;
        int numver = 0;
        int infinity = 65535; //65535为2的16次方减1


        Scanner scan = new Scanner(System.in);
        System.out.println("请输入顶点数和边长数：");
        numver = scan.nextInt();
        numarc = scan.nextInt();

        String[] vers = new String[numver] ;
        int[][] arc = new int[numver][numver];
        for(int i=0;i<numver;i++){
            for(int j=0;j<numver;j++){
                arc[i][j] = infinity;
            }
        }

        System.out.println("请输入顶点名称：");
        for(int i=0;i<numver;i++){
            vers[i] = scan.next();
        }
        System.out.println("请输入"+ numarc+"组 i,j,和权重w:");
        for(int n=0;n<numarc;n++){
            int i = scan.nextInt();
            int j = scan.nextInt();
            int w = scan.nextInt();
            arc[i][j] = w;
            arc[j][i] = w;
        }*/
        String[] vers = {"A","B","C","D","E","F","G","H","I"} ;
        int[][] arc = {
                        {0, 10,65535, 65535, 65535, 11, 65535,65535,65535},
                        {10, 0, 18, 65535, 65535, 65535, 16, 65535, 12},
                        {65535, 18, 0, 22, 65535, 65535, 65535, 65535,8},
                        {65535, 65535,22, 0, 20, 65535, 65535,16,21},
                        {65535, 65535,65535, 20, 0, 26, 65535,7,65535},
                        {11, 65535,65535, 65535, 26, 0, 17,65535,65535},
                        {65535, 16,65535, 65535, 65535, 17, 0,19,65535},
                        {65535, 65535,65535, 16, 7, 65535, 19,0,65535},
                        {65535, 12,8, 21, 65535, 65535, 65535,65535,0},
                      };

        NDGraph ndGraph = new NDGraph(vers,arc);

        System.out.println(Arrays.toString(ndGraph.vers));
        sop(ndGraph.arc);
        ndGraph.creMinTree_Prim();
        //readAll (ndGraph.vers, ndGraph.arc);
    }

    public static void sop (int[][] arrays) {
        for (int i=0; i<arrays.length; i++) {
            for (int j=0; j<arrays[i].length; j++) {
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void readAll (String[] vers, int[][] arc) {
        boolean[] isVisited = new boolean[vers.length];
        for (int i=0;i<vers.length;i++){
            isVisited[i] = false;
        }
        for (int i=0;i<vers.length;i++){
            if(!isVisited[i]){
                DFS (vers, arc , isVisited, i);
            }
        }
    }

    public static void DFS (String[] vers, int[][] arc , boolean[] isVisited, int i) {
        isVisited[i] = true;
        System.out.println(vers[i]);
        for (int j=0; j<vers.length; j++) {
            if (arc[i][j]==1 && !isVisited[j]) {
                DFS (vers, arc , isVisited, j);
            }
        }
    }

}

class NDGraph {
    int numarc = 0;
    int numver = 0;
    String[] vers;
    int[][] arc;

    public NDGraph (String[] vers, int[][] arc) {
        this.vers = vers;
        this.arc = arc;
        this.numver = vers.length;
        this.numarc = arc.length;
    }

    public void creMinTree_Prim() {
        int min ,i, j, k;
        int adjvex[] = new int[numver];
        int lowcost[] = new int[numver];
        adjvex[0] = 0;
        lowcost[0] = 0;

        for (i = 1; i < vers.length; i++) {
            lowcost[i] = arc[0][i];
            adjvex[i] = 0;
        }

        for (i = 1; i < vers.length; i++) {
            min = 65535;
            j = 1; k = 0;
            while (j < vers.length) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println("("+ adjvex[k] + "," + k + ")");
            lowcost[k] = 0;
        }
    }
}
