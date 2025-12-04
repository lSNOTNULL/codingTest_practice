import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] city;
    static int[] question;
    static String result;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            city = new int[N][N];
            question = new int[M];
            result = "YES";
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    city[i][j] = Integer.parseInt(st.nextToken());
                }
                city[i][i] = 1;
            }
            solve(br);
            
            bw.write(result);
            bw.flush();
        }
    }
    public static void solve(BufferedReader br) throws IOException {
        
        for(int i=0; i<N; i++) { // 경유지
                for(int j=0; j<N; j++) { // 출발
                    for(int k=0; k<N; k++) { // 도착
                        if(city[j][i] == 1 && city[i][k] == 1) {
                            city[j][k] = 1;
                        }
                    }
                }
            }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            question[i] = num;
        }
        
        for(int i=0; i<M-1; i++) {
            int start = question[i] - 1;
            int end = question[i+1] - 1;
            if(city[start][end] == 0) {
                result = "NO";
                break;
            }
        }
    }
}