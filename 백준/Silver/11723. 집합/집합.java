import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            HashSet<Integer> S = new HashSet<>();
            
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String calculate = st.nextToken();
                
                if(calculate.equals("add")) {
                    int x = Integer.parseInt(st.nextToken());
                    S.add(x);
                } if(calculate.equals("remove")) {
                    int x = Integer.parseInt(st.nextToken());
                    S.remove(x);
                } if(calculate.equals("check")) {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(S.contains(x)? 1:0).append("\n");
                } if(calculate.equals("toggle")) {
                    int x = Integer.parseInt(st.nextToken());
                    if(S.contains(x)) {
                        S.remove(x);
                    }else S.add(x);
                } if(calculate.equals("all")) {
                    for(int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                } if(calculate.equals("empty")) {
                    S.clear();
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}