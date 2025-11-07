import java.util.*;
import java.io.*;

class Point {
    int h,y,x;
    Point(int h, int y, int x) {
        this.h = h;
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static int M,N,H;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][][] arr = new int[H][N][M];
            
            for(int i=0; i<H; i++) {
                for(int j=0; j<N; j++) {
                    st = new StringTokenizer(br.readLine());
                    for(int k=0; k<M; k++) {
                        int num = Integer.parseInt(st.nextToken());
                        arr[i][j][k] = num;
                    }
                }
            }
            int answer = BFS(arr);
                bw.write(String.valueOf(answer));
                bw.flush();
        }
    }
    public static int BFS(int[][][] arr) {
        int day = 0;
        Queue<Point> queue = new LinkedList<>();
        // 익은 토마토 넣고시작
        for(int h=0; h<H; h++) {
            for(int y=0; y<N; y++) {
                for(int x=0; x<M; x++) {
                    if(arr[h][y][x] == 1) {
                        queue.offer(new Point(h,y,x));
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            day = Math.max(arr[current.h][current.y][current.x],day);
            // 0인곳만 진입가능
            for(int i=0; i<6; i++) {
                int next_y = current.y + dy[i];
                int next_x = current.x + dx[i];
                int next_h = current.h + dh[i];
                if(next_y < 0 || next_y >= N || next_x < 0|| next_x >= M || next_h < 0 || next_h >= H) {
                    continue;
                }
                if(arr[next_h][next_y][next_x] == 0) {
                    arr[next_h][next_y][next_x] = arr[current.h][current.y][current.x] + 1;
                    queue.offer(new Point(next_h,next_y,next_x));
                }
            }   
        }
        // 탐색 후 0 토마토가 남있는지 확인
        for(int h=0; h<H; h++) {
            for(int y=0; y<N; y++) {
                for(int x=0; x<M; x++) {
                    if(arr[h][y][x] == 0) {
                        return -1;
                    }
                }
            }
        }
        
        return day -1;
    }
}