import java.util.*;
class infosys1st{
    static int max3sum(List<Integer> list)
    {
        int sum=0;
        for(int i=2;i<list.size();i++)
            sum=Math.max(sum,list.get(i)+list.get(i-1)+list.get(i-2));
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,4,11,7,4,6,9));
        System.out.println(max3sum(list));
    }
}