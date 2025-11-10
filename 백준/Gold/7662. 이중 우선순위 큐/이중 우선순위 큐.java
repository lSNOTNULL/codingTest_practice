import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> min_pq;
    static PriorityQueue<Integer> max_pq;
    static HashMap<Integer,Integer> count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st;
            int T = Integer.parseInt(br.readLine());

            for(int i=0; i<T; i++) {
                int k = Integer.parseInt(br.readLine());
                // 오름,내림차순 정렬 큐 2개 , HashMap을 통한 동기화
                min_pq = new PriorityQueue<>();
                max_pq = new PriorityQueue<>(Collections.reverseOrder());
                count = new HashMap<>();
                for(int j=0; j<k; j++) {
                    st = new StringTokenizer(br.readLine());
                    char type = st.nextToken().charAt(0);
                    int num = Integer.parseInt(st.nextToken());
                    solve(type,num);
                }
                cleanUp(min_pq);
                cleanUp(max_pq);
                if(min_pq.isEmpty() || max_pq.isEmpty()) {
                    sb.append("EMPTY").append("\n");
                } else {
                    sb.append(max_pq.peek()).append(" ").append(min_pq.peek()).append("\n");
                }
                
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void solve(char type, Integer num) {
        if(type == 'I') {
            min_pq.add(num);
            max_pq.add(num);
            count.put(num,count.getOrDefault(num,0) + 1);
        } if(type == 'D') {
             if(num == 1) {
                 delete(max_pq);
             } if (num == -1) {
                 delete(min_pq);
             }   
        }
        
    }
    public static void delete(PriorityQueue<Integer> pq) {
        cleanUp(pq);
        
        if(!pq.isEmpty()) {
            int pqNum = pq.poll();
            count.put(pqNum, count.get(pqNum) - 1);
        }
    }
    public static void cleanUp(PriorityQueue<Integer> pq) {
        while(!pq.isEmpty() && count.getOrDefault(pq.peek(),0) == 0) {
            pq.poll();
        }
    }
}