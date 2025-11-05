import java.util.*;
import java.io.*;

class Point {
    int r,c,dir;
    Point(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;  // 파이프 현재 방향상태 가로 0, 세로 1, 대각 2
    }
}

public class Main {
    static int[] dr = {0,1,1}; // 가로,세로 및 대각선방향
    static int[] dc = {1,0,1};
    static int N;
    static int cnt;
    static int[][] house;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            N = Integer.parseInt(br.readLine());
            house = new int[N][N];
            StringTokenizer st;
            cnt = 0;
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    house[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            checkPipe(0,1,0);
            
            bw.write(String.valueOf(cnt));
            bw.flush();
        }
    }
    public static void checkPipe(int r, int c, int dir) {
        // 3칸 비어있으면 대각선 가능, 대각선에서 대각선, 오른쪽 ,아래 방향 가능
        // 파이프 첫 위치는 고정
        if(r == N-1 && c == N-1) {
            cnt++;
            return;
        }
        for(int i=0; i<3; i++) {
            // 90도 꺾기 제외
            if(dir == 0 && i == 1) continue;
            if(dir == 1 && i == 0) continue;
            
            int next_r = r+dr[i];
            int next_c = c+dc[i];
            
            // 벽확인
            if(next_r >= N || next_c >= N) continue;
            if(i==2) {
                if(house[r][next_c] == 1 || house[next_r][next_c] == 1 || house[next_r][c] == 1) {
                    continue;
                }
            } else {
                if(house[next_r][next_c] == 1) continue;
            }
            checkPipe(next_r,next_c,i);
        }
    }    
}