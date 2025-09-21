import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int N = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                
                if(x == 0) {
                    if(heap.peek() == null) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(heap.poll()).append("\n");
                    }
                } else {
                    heap.add(x);
                }  
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}