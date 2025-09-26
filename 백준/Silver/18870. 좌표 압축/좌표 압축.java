import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력준비
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] main = new int[N];
            int[] parse = new int[N];
            
            // 중복제거 , 정렬
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                main[i] = num;
                parse[i] = num;
            }
            Arrays.sort(parse);
            
            // 매핑
            HashMap<Integer,Integer> map = new HashMap<>();
            int cnt = 0;
            for(int value : parse) {
                if(!map.containsKey(value)) {
                    map.put(value, cnt);
                    cnt++;
                }
            }
            // 결과
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                main[i] = map.get(main[i]);
                sb.append(main[i]).append(" ");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}