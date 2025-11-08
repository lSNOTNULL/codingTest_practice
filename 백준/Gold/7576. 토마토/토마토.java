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
    static int M,N;
    static int[][] ground;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            ground = new int[N][M];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    ground[i][j] = num;
                }
            }
            int answer = BFS(ground);
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static int BFS(int[][] ground) {
        Queue<Point> queue = new LinkedList<>();
        int day = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(ground[i][j] == 1) {
                    queue.offer(new Point(i,j));
                }
            }
        }
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            day = Math.max(day,ground[curr.x][curr.y]);
            
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if(ground[nx][ny] == 0) {
                    ground[nx][ny] = ground[curr.x][curr.y] + 1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(ground[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day -1;
    }
}