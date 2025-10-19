import java.util.*;
import java.io.*;
class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static boolean[][] visited;
    static int[][] arr;
    static int[][] distance;
    public static void main (String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new boolean[N][M];
            distance = new int[N][M];
            arr = new int[N][M];
                        
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    arr[i][j] = line.charAt(j) -'0';
                }
            }
            BFS(0,0);
            int answer = distance[N-1][M-1];
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static void BFS(int x, int y) {
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        distance[x][y] = 1;
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
            
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny));
                    distance[nx][ny] = distance[current.x][current.y] +1;
                }
            }
        }    
    }
}