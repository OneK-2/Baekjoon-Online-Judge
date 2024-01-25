import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = arr[i][j];
                if (cnt == 0) break;
                if (i + cnt < n) {
                    dp[i + cnt][j] += dp[i][j];
                }
                if (j + cnt < n) {
                    dp[i][j + cnt] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

}