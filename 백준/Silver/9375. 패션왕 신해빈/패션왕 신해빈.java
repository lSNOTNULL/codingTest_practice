import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i = 0; i<T; i++) {
                int n = Integer.parseInt(br.readLine());                
                HashMap<String,Integer> map = new HashMap<>();
                
                for(int j = 0; j<n; j++) {
                    st = new StringTokenizer(br.readLine());
                    String cloth = st.nextToken();
                    String kind = st.nextToken();
                    if(map.containsKey(kind)) {
                        map.put(kind,map.get(kind)+1);
                    } else {
                        map.put(kind,1);
                    }
                }
                // 종류별 경우의 수 : 한 종류의 모든 경우 + 입지 않는 경우 +1
                // 종류별 경우를 모두 곱하여 전체 경우의 수를 구함
                int answer = 1;
                for(int cnt : map.values()) {
                    answer *= (cnt+1);
                }
                // 아무것도 안입은 경우의 수 -1
                bw.write(String.valueOf(answer-1) + "\n");
            }
            bw.flush();
        }
    }
}