import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] cabbage;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;            
            
            // 케이스가 여러개이면 매번 초기화
            for(int t = 0; t < T; t++) {
                st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                
                cabbage = new int[M][N];
                visited = new boolean[M][N];
                int cnt = 0;
                
                // 배추밭 정보
                for(int j = 0; j < K; j++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    
                    cabbage[x][y] = 1;
                }
                // 배추 탐색
                for(int i = 0; i<M; i++) {
                    for(int j=0; j<N; j++) {
                        if(cabbage[i][j] == 1 && !visited[i][j]) {
                            dfs(i,j);
                            cnt++;
                        }
                    }
                }
                sb.append(cnt).append("\n");
            }
            bw.write(sb.toString());

        }
    }
    // 상하좌우 탐색
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && nx< M && ny>=0 && ny<N && cabbage[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx,ny);
            }  
        }
    }
}