import java.util.*;
import java.io.*;

class Point {
    int x,y;
    Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            int groupCnt = 0;
            List<Integer> houseCnt = new ArrayList<>();
            
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    arr[i][j] = line.charAt(j) -'0';
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 1 & !visited[i][j]) {
                        houseCnt.add(BFS(i,j));
                        groupCnt++;
                    }
                }
            }
            Collections.sort(houseCnt);
            
            StringBuilder sb = new StringBuilder();
            sb.append(groupCnt).append("\n");
            for(int i = 0; i < groupCnt; i++) {
                sb.append(houseCnt.get(i)).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static int BFS(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        int cnt = 1;
        queue.offer(new Point(i,j));
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = current.x + dx[k];
                int ny = current.y + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] ==  1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}