import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            
            Arrays.sort(arr);
            int answer = find(N,arr);
            
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static int find(int N, int[] arr) {
        int cnt = 0;

        for(int i=0; i<N; i++) {
            int end = N-1;
            int start = 0;
            int target = arr[i];

            while(start < end) {
                int sum = arr[start] + arr[end];
                
                if(sum == target) {
                    
                    if(start != i && end != i) {
                        cnt++;
                        break;
                    } else if(start == i) {
                        start++;
                    } else {
                        end--;
                    }
                    
                } else if(sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return cnt;
    }
}