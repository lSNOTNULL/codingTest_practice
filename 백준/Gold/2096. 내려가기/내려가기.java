import java.util.*;
import java.io.*;

public class Main {
    static int[] dpMax_curr, dpMax_prev, dpMin_curr, dpMin_prev;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            dpMax_curr = new int[3];
            dpMax_prev = new int[3];
            dpMin_curr = new int[3];
            dpMin_prev = new int[3];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine()); 
                int n0 = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                
                solve(n0,n1,n2);
            }
            int max = Math.max(Math.max(dpMax_curr[0],dpMax_curr[1]),dpMax_curr[2]);
            int min = Math.min(Math.min(dpMin_curr[0],dpMin_curr[1]),dpMin_curr[2]);
            
            bw.write(max + " " + min);
            bw.flush();
        }
    }
    public static void solve(int n0, int n1, int n2) {
        dpMax_curr[0] = Math.max(dpMax_prev[0],dpMax_prev[1]) + n0;
        dpMax_curr[1] = Math.max(Math.max(dpMax_prev[0],dpMax_prev[1]),dpMax_prev[2]) + n1;
        dpMax_curr[2] = Math.max(dpMax_prev[1],dpMax_prev[2]) + n2;
                
        dpMin_curr[0] = Math.min(dpMin_prev[0],dpMin_prev[1]) + n0;
        dpMin_curr[1] = Math.min(Math.min(dpMin_prev[0],dpMin_prev[1]),dpMin_prev[2]) + n1;
        dpMin_curr[2] = Math.min(dpMin_prev[1],dpMin_prev[2]) + n2;
        
        dpMax_prev[0] = dpMax_curr[0];
        dpMax_prev[1] = dpMax_curr[1];
        dpMax_prev[2] = dpMax_curr[2];
        
        dpMin_prev[0] = dpMin_curr[0];
        dpMin_prev[1] = dpMin_curr[1];
        dpMin_prev[2] = dpMin_curr[2];
    }
}