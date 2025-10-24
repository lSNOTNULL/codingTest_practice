import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b) -> {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                
                if(absA != absB) {
                    return absA - absB;
                } else return a-b;
            });
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < N; i++) {
                // 절댓값 작은값 출력(PriorityQueue)
                // 출력은 원본값
                int num = Integer.parseInt(br.readLine());
                if(num != 0) {
                    pQueue.add(num);
                } else {
                    if(!pQueue.isEmpty()) {
                        sb.append(pQueue.poll()).append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}