package Interview_imp;

public class lgstRepetingChar {
    public static void main(String[] args) {
        String s = "aaabbbbcccccddbbbbbbcc";
        int len = s.length();
        int maxCount = 0;
        char maxChar = ' ';
    
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int count = 1;
            for (int j = i + 1; j < len && s.charAt(j) == c; j++)
                count++;
            if (count > maxCount){
                maxCount = count;
                maxChar = c;
            }
        }
        System.out.println("Most frequent character: " + maxChar + " with count: " + maxCount);
    }
}
