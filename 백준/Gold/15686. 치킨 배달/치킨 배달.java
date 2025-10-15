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
    static int[][] arr;
    static int minDistance = Integer.MAX_VALUE;
    static List<Point> chickens;
    static List<Point> houses;
    static List<Point> selected;
    static int N,M;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            chickens = new ArrayList<>();
            houses = new ArrayList<>();
            selected = new ArrayList<>();
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if(num == 1) {
                        houses.add(new Point(i,j));
                    } if(num == 2) {
                        chickens.add(new Point(i,j));
                    }
                }
            }
            DFS(0,0);
            bw.write(String.valueOf(minDistance));
            bw.flush();
        }
    }
    public static void DFS(int idx, int cnt) {
        if(cnt == M) {
            int distance = calculateDistance(); // 함수
            minDistance = Math.min(minDistance,distance);
            return;
        }
        for(int i = idx; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            DFS(i+1, cnt+1);
            selected.remove(selected.size()-1);
        }
    }
    public static int calculateDistance() {
        int totalDistance = 0;
        
        for(Point  house : houses) {
            int maxDist = Integer.MAX_VALUE;
            for(Point chicken : selected) {
                int dist = Math.abs(house.r-chicken.r) + Math.abs(house.c-chicken.c);
                maxDist = Math.min(maxDist, dist);
            }
            totalDistance += maxDist;
        }
        return totalDistance;
    }
}