import java.util.*;
import java.io.*;

public class Main {
    static int N,M,maxSum;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,-1,0,0};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maxSum = 0;
            arr = new int[N][M];
            visited = new boolean[N][M];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                }
            }
            // ㅗ 모양 제외, 나머지는 DFS로 가능
            check();
            
            bw.write(String.valueOf(maxSum));
            bw.flush();
        }
    }
    public static void check() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                DFS(i,j,1,arr[i][j]);
                visited[i][j] = false;
                
                checkT(i,j);
            }
        }
    }
    public static int[][] T_SHAPES = {
        {0,-1, 0,1, 1,0}, // ㅜ
        {0,-1, 0,1, -1,0}, // ㅗ
        {-1,0, 1,0, 0,1}, // ㅏ
        {-1,0, 1,0, 0,-1} // ㅓ
    };
    public static void DFS(int x, int y, int depth, int sum) {
        if(depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny, depth+1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
    public static void checkT(int x, int y) {
        for(int i=0; i<4; i++) {
            int sum = arr[x][y];
            boolean outOfBounds = false;
            for(int j=0; j<6; j+=2) {
                int nx = x + T_SHAPES[i][j];
                int ny = y + T_SHAPES[i][j+1];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    outOfBounds = true;
                    break;
                }
                sum += arr[nx][ny];
            }
            if(!outOfBounds) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}