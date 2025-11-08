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
            int answer = BFS(color);
            int answer_gr = BFS_GR(color);
            bw.write(String.valueOf(answer + " " + answer_gr));
            bw.flush();
        }
    }
    public static int BFS(char[][] color) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    cnt++;
                    
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int curr_x = curr[0];
                        int curr_y = curr[1];
                        
                        for(int m=0; m<4; m++) {
                            int nx = curr_x + dx[m];
                            int ny = curr_y + dy[m];
                            
                            if(nx < 0 || nx >=N || ny < 0 || ny >= N) continue;
                            if(!visited[nx][ny] && color[nx][ny] == color[curr_x][curr_y]) {
                                queue.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public static int BFS_GR(char[][] color) {
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
        return BFS(colorGR);
    }
}