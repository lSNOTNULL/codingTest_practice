import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(br.readLine());
                arr[i] = num;
            }
            int answer = solve(arr);
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static int solve(int[] arr) {
        int sum = 0;
        int maxDay = 0;
        // N일 중 가장큰 출금 = low ,인출 금액 총합계 = high
        for(int day : arr) {
            sum += day;
            maxDay = Math.max(maxDay, day);
        }
        int low = maxDay;
        int high = sum;
        int minK = high;
        
        while(low <= high) {
            int K = low + (high - low) / 2;
            
            if(checkK(K,arr)) {
                minK = K;
                high = K-1;
            } else {
                low = K+1;
            }
        }
        return minK;
    }
    public static boolean checkK(int K, int[] arr) {
        int cnt = 1;
        int money = K;
        // 모자라면 남은금액 입금 후 다시 K원 인출
        for(int num : arr) {
            if(money < num) {
                cnt++;
                money = 0;
                money += K;
            }
            money -= num;
        }
        return cnt <= M;
    }
}