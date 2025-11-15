import java.io.*;
import java.util.*;

public class Main {
    static long T;
    static int n,m;
    static int[] arrA,arrB;
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            T = Long.parseLong(br.readLine());
            n = Integer.parseInt(br.readLine());
            arrA = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<n; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            arrB = new int[m];
            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<m; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            long answer = solve();
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static long solve() {
        // 부분 배열 합
        List<Long> sumsA = createSums(arrA);
        List<Long> sumsB = createSums(arrB);
        // 배열 정렬
        Collections.sort(sumsA);
        Collections.sort(sumsB, Collections.reverseOrder());
        // 투포인터 로직
        long cnt = 0;
        int ptrA = 0;
        int ptrB = 0;
        
        while(ptrA < sumsA.size() && ptrB < sumsB.size()) {
            long currSum = sumsA.get(ptrA) + sumsB.get(ptrB);
            if(currSum < T) ptrA++;
            else if(currSum > T) ptrB++;
            else {
                long valA = sumsA.get(ptrA);
                long cntA = 0;
                while(ptrA < sumsA.size() && valA == sumsA.get(ptrA)) {
                    cntA++;
                    ptrA++;
                }
                long valB = sumsB.get(ptrB);
                long cntB = 0;
                while(ptrB < sumsB.size() && valB == sumsB.get(ptrB)) {
                    cntB++;
                    ptrB++;
                }
                cnt += cntA * cntB;
            }
        }
        return cnt;
    }
    public static List<Long> createSums(int[] arr) {
        List<Long> sums = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            long currSum = 0;
            for(int j=i; j<arr.length; j++) {
                currSum += arr[j];
                sums.add(currSum);
            }
        }
        return sums;
    }
}