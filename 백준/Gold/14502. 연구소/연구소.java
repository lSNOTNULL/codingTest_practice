import java.util.*;
import java.io.*;

class Point {
    int r,c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static int N,M,result;
    static int[][] lab;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static List<Point> vList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            lab = new int[N][M];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    lab[i][j] = num;
                    if(num == 2) {
                        vList.add(new Point(i,j));
                    }
                }
            }
            solve();
            
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
    public static void solve() {
        // 1.벽 세우기
        makeWall(0);
        
        // 2.바이러스 전파 
        // 3.전파 후 빈 공간 cnt
    }
    public static void makeWall(int cnt) {
        if(cnt == 3) {
            spreadV();
            return;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    makeWall(cnt + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    
    public static void spreadV () {
        // 세운 벽 기반 맵 탐색
        Queue<Point> q = new LinkedList<>();
        int[][] copyMap = new int[N][M];
        
        for(int i=0; i<N; i++) {
            copyMap[i] = lab[i].clone();
        }
        
        for(Point v : vList) {
            q.offer(v);
        }
        
        while(!q.isEmpty()) {
            Point curr = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if(nr<0 || nr>= N || nc<0 || nc>=M || copyMap[nr][nc] >= 1) continue;
                copyMap[nr][nc] = 2;
                q.offer(new Point(nr,nc));
            }
        }
        cntSafeZone(copyMap);
    }
    
    public static void cntSafeZone(int[][] copyMap) {
        int safe = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 0) safe++;
            }
        }
        result = Math.max(result, safe);
    }
}