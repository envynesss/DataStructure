package search;

public class OrderedListDemo {
    public static void main(String[] args) {
        int[] arrays = {1,3,5,7,9};
        int index = BinarySearch(arrays, 4);
        System.out.println(index);
    }

    /**
     * 顺序表的折半查找
     * @param arr 顺序表
     * @param key 查找的值
     * @return 查找值的索引
     */
    public static int BinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    
}
