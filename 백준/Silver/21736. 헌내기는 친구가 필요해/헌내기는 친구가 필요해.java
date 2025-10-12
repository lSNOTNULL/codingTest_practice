import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    static int cnt;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new String[N][M];
            visited = new boolean[N][M];
            int currentX = 0;
            int currentY = 0;
            cnt = 0;
            
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    arr[i][j] = String.valueOf(line.charAt(j));
                    if(arr[i][j].equals("I")) {
                        currentX = i;
                        currentY = j;
                        
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            dfs(currentX,currentY);
            if(cnt == 0) {
                sb.append("TT");
            } else sb.append(cnt);
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y].equals("X")) {
            return;
        } if(arr[x][y].equals("P")) {
            cnt++;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && (arr[nx][ny].equals("O") || arr[nx][ny].equals("P")) && !visited[nx][ny]) {
                dfs(nx,ny);
            }
        }
    }
}