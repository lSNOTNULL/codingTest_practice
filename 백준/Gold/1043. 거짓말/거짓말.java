import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> party = new ArrayList<>();
            HashSet<Integer> truth = new HashSet<>();
            int answer = 0;
            
            st = new StringTokenizer(br.readLine());
            int truthNum = Integer.parseInt(st.nextToken());
            if(truthNum > 0) {
                for(int i = 0; i < truthNum; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    truth.add(num);
                }
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int join = Integer.parseInt(st.nextToken());
                List<Integer> currentParty = new ArrayList<>();
                for(int j = 0; j < join; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    currentParty.add(num);
                }
                party.add(currentParty);
            }
            spreadTruth(party, truth);
            
            for(List<Integer> currentParty : party) {
                boolean canLie = true;
                for(int personId : currentParty) {
                    if(truth.contains(personId)) {
                        canLie = false;
                        break;
                    }
                }
                if(canLie) answer++;
            }
                
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    public static void spreadTruth(List<List<Integer>> partyList, HashSet<Integer> truth) {
        while(true) {
            boolean newlyLearned = false;
            
            for(List<Integer> currentParty : partyList) {
                boolean foundTruth = false;
                for(int personId : currentParty) {
                    if(truth.contains(personId)) {
                        foundTruth = true;
                        break;
                    }
                }
                // 진실아는 사람 있으면 모두 전파
                if(foundTruth) {
                    for(int personId : currentParty) {
                        if(truth.add(personId)) {
                            newlyLearned = true;
                        }
                    }
                }
            }
            if(!newlyLearned) { // 새로 알게된 사람이 없음 = 전파 끝
                return;
            }
        }
    }
}
