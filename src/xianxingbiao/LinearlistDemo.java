package xianxingbiao;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

public class LinearlistDemo {

    public static void main(String[] args) {
        Linearlist ll = new Linearlist(10);
        ll.insert(0,1);
        ll.insert(1,2);
        ll.insert(2,3);
        ll.insert(3,4);
        ll.insert(5,6);
        System.out.println(ll.length);
        System.out.println(Arrays.toString(ll.elementData));
    }
}

/**
 * 线性表类
 */
class Linearlist{
    int[] elementData;
    int length;
    Linearlist(int Maxsize){
        elementData = new int[Maxsize];
        length = 0;
    }

    /**
     *
     * @param index 要查询的值的下标
     * @return 如果查询的值不存在，返回-1；存在，返回查询值的索引
     */
    public int getelemetData(int index){
        if(index<0||index>length){
            System.out.println("下标错误");
        }

        return elementData[index];
    }

    /**
     *
     * @param index 要插入的数据插入的位置索引
     * @param data 要插入的数据
     * @return 插入成功返回true;失败返回false;
     */
    public boolean insert(int index,int data){
        if(length>=elementData.length){
            System.out.println("线性表已满");
            return false;
        }
        if(index<0||index>elementData.length-1){
            System.out.println("请插入到正确的位置");
            return false;
        }
        if(index>length-1) {
            elementData[index] = data;
            length++;
            return true;
        }
        for(int i=length-1;i>=index;i--){
            elementData[i+1] = elementData[i];
        }
        elementData[index] = data;
        length++;

        return true;
    }

    public boolean remove(int index){

        return false;
    }

}
