import java.util.*;
import java.io.*;

class Point {
    int r,c,dist;
    public Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

public class Main {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static int N;
    static int[][] arr;
    static int sharkR, sharkC, sharkSize = 2, eatCnt = 0, time = 0;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            StringTokenizer st;
            int result =0;
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if(num == 9) {
                        sharkR = i;
                        sharkC = j;
                        arr[i][j] = 0; // 상어 위치 0으로 변경
                    }
                }
            }
            solve();
            
            bw.write(String.valueOf(time));
            bw.flush();
        }
    }
    public static void solve() {
        /*
        자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
        
        더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
        먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
        먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
        거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
        거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
        */
        while(true) {
            Point nextFish = findNextFish();
            if(nextFish == null) break;
        
            time += nextFish.dist; // 시간
        
            arr[nextFish.r][nextFish.c] = 0; //먹기
        
            sharkR = nextFish.r;
            sharkC = nextFish.c; //위치갱신
        
            eatCnt++;
            if(eatCnt == sharkSize) { //경험치
                eatCnt = 0;
                sharkSize++;
            }
        }
    }
    public static Point findNextFish() {
        // BFS 수행, 가까운 먹이찾기
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sharkR,sharkC,0));
        // 누적 거리배열 활용
        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++) Arrays.fill(dist[i],-1);
        dist[sharkR][sharkC] = 0;
        
        List<Point> candidates = new LinkedList<>();
        int minDist = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            Point curr = q.poll();
            if(minDist <= curr.dist) continue;
            
            for(int i=0; i<4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || dist[nr][nc] != -1) continue;
                else {
                    int fishSize = arr[nr][nc];
                    if(fishSize <= sharkSize) {
                        if(fishSize > 0 && fishSize < sharkSize) { // 먹이후보 조건
                            minDist = curr.dist + 1;
                            candidates.add(new Point(nr, nc, minDist));
                        }
                        dist[nr][nc] = curr.dist + 1; // 안먹어도 탐색
                        q.offer(new Point(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
        if(candidates.isEmpty()) return null;
        
        candidates.sort((a,b) -> {
            if(a.r == b.r) {
                return Integer.compare(a.c,b.c);
            } else return Integer.compare(a.r, b.r);
        });
        
        return candidates.get(0);
    }
}