import java.util.List;
import java.util.*;
class infosysnd{
    public static int get_answer(int N, int K, List<Integer> A) {
        if (K > N)
            return 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < N; j++) 
            {
                freqMap.put(A.get(j), freqMap.getOrDefault(A.get(j), 0) + 1);
                if (isGoodSubArray(freqMap, K))
                    count++;
            }
        }
        return count;
    }
    public static boolean isGoodSubArray(Map<Integer, Integer> freqMap, int K) {
        for (int count : freqMap.values())
        {
            if (count != K)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2,2,3,4,5));
        System.out.println(get_answer(5, 2,list));
    }
}
