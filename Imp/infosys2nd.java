import java.util.*;
public class infosys2nd{
    static final int MOD = 1000000007;
    public static int gcd(int a, int b) {
        while (b != 0) 
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int getAnswer(int N, List<Integer> A) {
        int[][] dp = new int[N + 1][101];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = dp[i - 1][j];
                int newGcd = gcd(j, A.get(i - 1));
                dp[i][newGcd] = (dp[i][newGcd] + dp[i - 1][j]) % MOD;
            }
        }

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        sc.close();
        System.out.println(getAnswer(N, A));
    }
}
