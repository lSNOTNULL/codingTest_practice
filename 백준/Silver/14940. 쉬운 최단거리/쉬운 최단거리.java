import java.util.*;
import java.io.*;

class Point {
    int x,y;
        Point(int x, int y) {
        this.x = x;
        this.y = y;
    } 
}

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    static int m;
    static int[][] ground;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ground = new int[n][m];
            sum = new int[n][m];
            int startX = 0;
            int startY = 0;
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    ground[i][j] = num;
                    if(num == 2) {
                        startX = i;
                        startY = j;
                    }
                    if(num == 1) {
                        sum[i][j] = -1;
                    }
                }
            }
            BFS(startX,startY);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    sb.append(sum[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void BFS(int startX,int startY) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visisted = new boolean[n][m];
        visisted[startX][startY] = true;
        queue.offer(new Point(startX,startY));
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visisted[nx][ny] && ground[nx][ny] == 1) {
                    queue.offer(new Point(nx,ny));
                    sum[nx][ny] = sum[current.x][current.y] +1;
                    visisted[nx][ny] = true;
                }
            }
        }
    }
}