import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                if(x > 0) {
                    heap.add(x);
                } if(x == 0) {
                    if(heap.isEmpty()) {
                        sb.append("0").append("\n");
                    } else {
                        int maxNum = heap.poll();
                        sb.append(maxNum).append("\n");
                    }
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}