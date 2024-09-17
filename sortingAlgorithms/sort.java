package sortingAlgorithms;

public class sort {
    public static void main(String[] args) {
        int[] arr = {20,10,40,30,60,50};
        // int[] ar = {10,20,30,40,50,60};
        sort s = new sort();
        long start = System.nanoTime();
        s.mergeSort(arr, 0,arr.length-1 );
        long end = System.nanoTime();
        System.out.println("Time Taken: "+(end-start));
        s.display(arr);
    }
    void display(int[] arr)
    {
        for(int i:arr)
        System.out.print(i+" ");
    }
    void bubbleSort(int[] arr)
    {
        int i,j,n=arr.length;
        boolean status=true;
        for(i=0;i<n-1;i++)
        {
            for(j=0;j<n-i-1;j++)
            {
                if(arr[j+1]<arr[j])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    status=false;
                }
            }
            if(status)
            break;
        }
    }
    void selectionSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int min=arr[i],minindex=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(min>arr[j])
                {
                min=arr[j];
                minindex=j;
                }
            }
            int temp = arr[minindex];
            arr[minindex]=arr[i];
            arr[i]=temp;
        }
    }
    void insertionSort(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int j=i-1,key=arr[i];
            while(j>=0&&arr[j]>=key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    void mergeSort(int[] arr, int low, int high)
    {
        if(low<high)
        {
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
        }
    }
    static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;  
        int n2 = high - mid;  
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) 
        {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
             else
                arr[k++] = right[j++];
        }
        while (i < n1) 
        arr[k++] = left[i++];
        while (j < n2)
        arr[k++] = right[j++];
    }
    void quickSort(int[] arr, int low,int high)
    {
        int mid = low + (high-low)/2;
    }
}
