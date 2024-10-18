package Interview_imp;
import java.util.*;
public class kthLargest {
    public static void main(String[] args) {
        int [] arr = new int[]{20,5,6,78,65,45,35};
        System.out.println(kthLargest2(arr,3));
    }
    static int kthLargest1 (int[] arr,int k)//using sorting
    {
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    static int kthLargest2(int[] arr, int k)//using min heap
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:arr)
        {
            pq.add(num);
            if(pq.size()>k)
            pq.remove();
        }
        return pq.poll();
    }
}
