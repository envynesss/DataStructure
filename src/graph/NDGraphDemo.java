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
        this.numarc = 15;
    }

    /**
     * 普里姆算法
     */
    public void creMinTree_Prim() {
        int min ,i, j, k; //k值为保存被选顶点(终点)下标,即为该点所在的列数
        int adjvex[] = new int[numver]; //保存候选顶点(起点)的下标,即为该点所在的行数
        int lowcost[] = new int[numver]; //保存相关顶点间边的权值,存储探索到的候选路径
        adjvex[0] = 0;
        lowcost[0] = 0;

        for (i = 1; i < vers.length; i++) {
            lowcost[i] = arc[0][i];
            adjvex[i] = 0;
        }

        for (i = 1; i < vers.length; i++) {
            min = 65535;
            j = 1; k = 0;
            //挑选lowcost[j]候选点中的最小值
            while (j < vers.length) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.println("("+ adjvex[k] + "," + k + ")");
            lowcost[k] = 0; //每循环一次把最小值置零,作为已处理信号

            //把探索到的小的权值给lowcost[j],以供候选
            for (j = 1; j < vers.length; j++) {
                if (lowcost[j] != 0 && arc[k][j] < lowcost[j]) {
                    lowcost[j] = arc[k][j];
                    adjvex[j] = k;
                }
            }
            //System.out.println("adjvex[]..." + Arrays.toString(adjvex));
        }
    }

    /**
     * 克鲁斯卡尔算法
     */
    public void creMinTree_Kruskal() {
        int i, n, m;
        Edge[] edges = new Edge[15];
        int[] parent = new int[vers.length];
        Arrays.sort(edges); //按照weight大小升序排列edges[]
        for (i = 0; i < vers.length; i++) {
            parent[i] = 0;
        }
        for (i = 0; i < numarc; i++) {
            n = Find(parent, edges[i].begin);
            m = Find(parent, edges[i].end);
            if (n!=m) {
                parent[n] = m;
                System.out.println(edges[i].begin + " " + edges[i].end + " " + edges[i].weight);
            }
        }
    }

    public int Find(int[] parent, int f) {
        while (parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }


}

class Edge implements Comparable{
    int begin;
    int end;
    int weight;

    public Edge(int begin,  int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge)o;
        return Integer.valueOf(this.weight).compareTo(edge.weight);
    }
}

