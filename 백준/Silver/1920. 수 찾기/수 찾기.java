import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
        
            // N개의 정수를 배열 A에 저장
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            // A 배열 오름차순 정렬
            Arrays.sort(A);
        
            // M 개의 정수들을 입력 받을 준비
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
        
            // M개의 숫자들을 하나씩 입력받으며 이진탐색으로 확인
            for(int i = 0; i < M; i++){
                int target = Integer.parseInt(st.nextToken());
            
                // 존재하면 1, 아니면 0을 출력
                
                if(binarySearch(A,target)){
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        
            // 최종 결과 출력
            bw.write(sb.toString());
        }
    }
    // 이진 탐색 메소드 구현
    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

