package graph;

import java.util.Arrays;
import java.util.Scanner;

public class NDGraphDemo {
    public static void main(String[] args) {
        int numarc = 0;
        int numver = 0;
        int infinity = Integer.MAX_VALUE;


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
        }
        System.out.println("numver..."+numver);
        System.out.println("numarc..."+numarc);
        System.out.println(Arrays.toString(vers));
        sop(arc);
    }

    public static void sop(int[][] arrays){
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[i].length;j++){
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println();
        }

    }

}
class NDGraph{
    int maxNumVer; //最大顶点数
    String[] Vertex; //顶点
    int[][] Arc; //弧
    int curNumVer, curNumArc;

    public NDGraph(int maxNumVer){
        this.maxNumVer = maxNumVer;
        Vertex = new String[maxNumVer];
        Arc = new int[maxNumVer][maxNumVer];
        curNumArc = 0;
        curNumVer = 0;
    }

    public void createNDGraph(int NumArc, int NumVer, String[] vers, int[][] arc){
        this.Vertex = vers;
        this.Arc = arc;
        this.curNumArc = NumArc;
        this.curNumVer = NumVer;
    }
}