import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int A = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[A];
            int[] dp = new int[A];
            int maxLen = 0;
            for(int i = 0; i < A; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < A; i++) {
                dp[i] = 1;
                for(int j = 0; j <= i-1 ; j++) {
                    if(arr[j] < arr[i]) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                maxLen = Math.max(maxLen,dp[i]);
            }
            bw.write(String.valueOf(maxLen));
            bw.flush();
        }
    }
}