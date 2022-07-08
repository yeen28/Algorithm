import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        Map<String, Integer> findCnt = new HashMap<String, Integer>();
        
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<String>());
            findCnt.put(id_list[i], 0);
        }
        
        StringTokenizer stk;
        String reporting, reported;
        for(int i=0; i<report.length; i++) {
            stk = new StringTokenizer(report[i], " ");
            
            reporting = stk.nextToken();
            reported = stk.nextToken();
            
            map.get(reported).add(reporting);
        }
        
        for(String idVal : id_list) {
            if(map.get(idVal).size() >= k) {
                for(String setVal : map.get(idVal)) {
                    findCnt.put(setVal, findCnt.get(setVal)+1);
                }
            }
        }
        
        answer = findAnswer(id_list, findCnt);
        
        return answer;
    }
    
    /* 결과 찾기 */
    public int[] findAnswer(String[] id_list, Map<String, Integer> findCnt) {
        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++) {
            answer[i] = findCnt.get(id_list[i]);
        }
        
        return answer;
    }
}
