package graph;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Scanner;

public class NDGraphDemo {
    public static void main(String[] args) {
        int numarc = 0;
        int numver = 0;

        Scanner scan = new Scanner(System.in);
        numver = scan.nextInt();
        numarc = scan.nextInt();

        String[] vers = new String[numver] ;
        int[][] arc = new int[numver][numver];
        for(int i=0;i<numver;i++){
            vers[i] = scan.next();
        }
        System.out.println("numver..."+numver);
        System.out.println("numarc..."+numarc);
        System.out.println(Arrays.toString(vers));
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