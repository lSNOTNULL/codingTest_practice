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
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int N = Integer.parseInt(br.readLine());
            List<Point> vertices = new ArrayList<>();
            StringTokenizer st;
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                vertices.add(new Point(x,y));
            }
            double result = calc(vertices);
            
            bw.write(String.format("%.1f",result));
            bw.flush();
        }
    }
    public static double calc(List<Point> vertices) {
        long sum1 = 0;
        long sum2 = 0;
        int N = vertices.size();
        
        for(int i=0; i<N; i++) {
            Point curr = vertices.get(i);
            Point next = vertices.get((i+1) % N);
            
            sum1 += (long) curr.x * next.y;
            sum2 += (long) curr.y * next.x;
        }
        double result = Math.abs(sum1 - sum2) / 2.0 ;
        
        return result;
    }
}