import java.util.*;
import java.io.*;

public class Main{
    static int[][] height;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            height = new int[N][M];
            int minTime = Integer.MAX_VALUE;
            int resultHeight = 0;
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    int H = Integer.parseInt(st.nextToken());
                    height[i][j] = H;
                }
            }
            for(int h = 0; h <= 256; h++) {
                long currentTime = calculateTime(h,N,M,B);
                // 답이 여러개라면 땅높이가 높은 것 출력
                if(currentTime < minTime || (currentTime == minTime && h > resultHeight)) {
                    minTime = (int) currentTime;
                    resultHeight = h;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(minTime).append(" ").append(resultHeight);
            bw.write(sb.toString());
            bw.flush();
        }
    }
    // 0~256 높이 모두 계산메서드 로직 실행시킴
    // 해당 높이와 각 땅의 높이 차를 계산하여 높으면 제거, 낮으면 추가로직 if문을 실행
    // 땅 고르기 후 B가 음수가 되는지 확인
    // 메서드 결과를 time으로 반환하여 minTime 비교 후 최단시간 구하기
    public static Long calculateTime(int targetHeight, int N, int M, int B) {
        int itemChange = 0;
        int H;
        long time = 0;
        for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    H = height[i][j];
                    if(targetHeight < H) {
                        itemChange += H - targetHeight;
                        time += 2*(H - targetHeight);
                    } if(targetHeight > H) {
                        itemChange -= targetHeight - H;
                        time += 1*(targetHeight - H);
                    }
                }
            }
        if(B + itemChange < 0) {
            return Long.MAX_VALUE;
        }
        return time;
    }
}