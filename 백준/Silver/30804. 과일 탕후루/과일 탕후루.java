import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] fruitCnt = new int[10];
            int start = 0;
            int kindCnt = 0;
            int maxLen = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            
            for(int end = 0; end < N; end++) {
                int current = arr[end];
                if(fruitCnt[current] == 0) {
                    kindCnt++;
                }
                fruitCnt[current]++;
                
                while(kindCnt > 2) {
                    int oldFruit =  arr[start];
                    fruitCnt[oldFruit]--;
                    if(fruitCnt[oldFruit] == 0) {
                        kindCnt--;
                    }
                    start++;
                }
                maxLen = Math.max(maxLen, end-start+1);
            }
            bw.write(String.valueOf(maxLen));
            bw.flush();
        }
    }
}