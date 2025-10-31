import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            // 2차원 배열 선언 , 시작,종료시간 입력
            int[][] meetings = new int[N][2];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                meetings[i][0] = Integer.parseInt(st.nextToken());
                meetings[i][1] = Integer.parseInt(st.nextToken());
            }
            // 정렬 -> 종료시간 오름차순, 종료시간 같으면 시작시간 오름차순
            Arrays.sort(meetings, (a,b) ->{
                if(a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            // 회의 배정, 최대 개수 계산
            int cnt = 0;
            int prevEndTime = 0;
            
            for(int i=0; i<N; i++) {
                int currentStart = meetings[i][0];
                int currentEnd = meetings[i][1];
                // 회의 시작시간이 직전회의 종료시간 과 같거나커야함
                if(currentStart >= prevEndTime) {
                    prevEndTime = currentEnd;
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt));
            bw.flush();
        }
    }
}