import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static int R,C,maxDist;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new char[R][C];
            maxDist = 0;
            
            for(int i=0; i<R; i++) {
                String line = br.readLine();
                board[i] = line.toCharArray();
            }
            DFS(0,0,1);
            
            bw.write(String.valueOf(maxDist));
            bw.flush();
        }
    }
    public static void DFS(int r, int c, int dist) {
        int idx = board[r][c] - 'A';
        visited[idx] = true;
        maxDist = Math.max(maxDist,dist);
        
        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            else if (!visited[board[nr][nc] - 'A']) {
                DFS(nr,nc,dist+1);
            }
        }
        visited[idx] = false;
    }
}