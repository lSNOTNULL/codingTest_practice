import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashMap<String,String> map = new HashMap<>();
            
            for(int i = 0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                String site = st.nextToken();
                String pw = st.nextToken();
                map.put(site,pw);
            }
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i<M; i++) {
                String site = br.readLine();
                String pw = map.get(site);
                sb.append(pw).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}