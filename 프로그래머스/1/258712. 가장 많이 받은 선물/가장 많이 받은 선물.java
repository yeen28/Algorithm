import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = -1000;
        int [][] mat = new int[friends.length][friends.length];
        int [] count = new int[friends.length];
        
        Map<String, Integer> fr = new HashMap<>();
        for(int i = 0; i< friends.length; i++) {
            fr.put(friends[i], i);
        }
        
        for(int i=0; i< gifts.length; i++) {
            String [] s= gifts[i].split("\\s");
            mat[fr.get(s[0])][fr.get(s[1])] += 1;
        }
        
        for(int i=0; i< mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if(i>=j) {
                    continue;
                }
                
                if(mat[fr.get(friends[i])][fr.get(friends[j])]
                        == mat[fr.get(friends[j])][fr.get(friends[i])]){ //선물 주고받은 기록 없거나 같다면
                    int give1 = 0, give2 = 0, take1 = 0, take2 = 0;
                    for(int k = 0; k< mat.length; k++){
                        give1 += mat[fr.get(friends[i])][k];
                        take1 += mat[k][fr.get(friends[i])];
                        give2 += mat[fr.get(friends[j])][k];
                        take2 += mat[k][fr.get(friends[j])];
                    }
                    if(give1 - take1 < give2 - take2){
                        // 2번 사람이 선물 지수가 더 크면
                        count[fr.get(friends[j])] += 1;
                    } else if(give1 - take1 > give2 - take2)
                        count[fr.get(friends[i])] += 1;
                }
                else if(mat[fr.get(friends[i])][fr.get(friends[j])]
                        > mat[fr.get(friends[j])][fr.get(friends[i])]){
                    // 선물 주고받은 기록 있으면
                    count[fr.get(friends[i])] += 1;
                } else count[fr.get(friends[j])] += 1;
            }
        }
        answer = Arrays.stream(count).max().getAsInt();
        return answer;
    }
}