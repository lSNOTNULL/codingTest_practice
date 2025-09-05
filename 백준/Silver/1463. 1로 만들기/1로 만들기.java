import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int X = Integer.parseInt(br.readLine());
            int[] dp = new int[X+1];
            dp[1] = 0;
            
            for(int i = 2; i <= X; i++) {
                dp[i] = dp[i-1] + 1;
                
                if(i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/2] + 1);
                }if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/3] + 1);
                }
            }
            
            bw.write(String.valueOf(dp[X]));
            bw.flush();        
            }
        }
        
}