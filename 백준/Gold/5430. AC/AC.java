import java.util.*;
import java.io.*;

public class Main {
    static boolean isReversed;
    static boolean isError;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringBuilder sb = new StringBuilder();
            
            int T = Integer.parseInt(br.readLine());
            // Deque 사용, 뒤집기 시 boolean처리
            // 배열 입력,빈 경우 []로 출력
            // 빈 경우 D -> "error"
            for(int i=0; i<T; i++) {
                String p = br.readLine();
                int n = Integer.parseInt(br.readLine());
                String arrayInput = br.readLine();
                
                String line = arrayInput.replaceAll("[\\[\\]\\s]", "");
                
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                isReversed = false;
                isError = false;
                
                InputDeque(p,line,deque,sb);

                
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
    public static void InputDeque(String p, String line, Deque<Integer> deque, StringBuilder sb) {
        if(line.length() > 0) {
            StringTokenizer st = new StringTokenizer(line, ",");
            while(st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
        }
                
        for(int j=0; j<p.length(); j++) {
            if(p.charAt(j) == 'R') {
                isReversed = !isReversed;
            } else if(p.charAt(j) == 'D') {
                if(deque.isEmpty()) {
                    isError = true;
                    break;
                }
                if(isReversed) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        if(isError) {
            sb.append("error").append("\n");
        } else {
            printDeque(deque,sb);
        }
    }
    public static void printDeque(Deque<Integer> deque, StringBuilder sb) {
        sb.append('[');
        List<String> result = new ArrayList<>();
        while(!deque.isEmpty()) {
            if(isReversed) {
                result.add(String.valueOf(deque.pollLast()));
            } else {
                result.add(String.valueOf(deque.pollFirst()));
            }
        }
        sb.append(String.join(",", result));
        sb.append(']').append("\n");
    }
}