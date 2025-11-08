import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            char[][] color = new char[N][N];
            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<N; j++) {
                    char c = line.charAt(j);
                    color[i][j] = c;
                }
            }
            int answer = countColor(color);
            int answer_gr = COMBINE_GR(color);
            bw.write(String.valueOf(answer + " " + answer_gr));
            bw.flush();
        }
    }
    public static int countColor(char[][] color) {
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    DFS(i,j,visited,color);
                }
            }
        }
        return cnt;
    }
    
    public static void DFS(int i, int j, boolean[][] visited, char[][] color) {
        visited[i][j] = true;
        
        for(int m=0; m<4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(!visited[nx][ny] && color[nx][ny] == color[i][j]) {
                DFS(nx,ny, visited, color);
            }
        }
    }
    
    
    
    public static int COMBINE_GR(char[][] color) {
        char[][] colorGR = new char[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(color[i][j] == 'R') {
                    colorGR[i][j] = 'G';
                } else {
                    colorGR[i][j] = color[i][j];
                }
            }
        }
        return countColor(colorGR);
    }
}