import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    List<String> answer = new ArrayList<String>();
    List<String> listMsg = new ArrayList<String>();
    List<String> listId = new ArrayList<String>();
    Map<String, String> mapUser = new HashMap<String, String>();
    
    public static final String ENTER_MSG = "님이 들어왔습니다.";
    public static final String LEAVE_MSG = "님이 나갔습니다.";
    
    public void enter(String user) {
        int idx = user.indexOf(" ");
        
        String id = user.substring(0, idx);
        String nickName = user.substring(idx+1);
        
        mapUser.put(id, nickName);
        listId.add(id);
        listMsg.add(ENTER_MSG);
    }
    
    public void leave(String id) {
        listId.add(id);
        listMsg.add(LEAVE_MSG);
    }
    
    public void change(String user) {
        int idx = user.indexOf(" ");
        
        String id = user.substring(0, idx);
        String nickName = user.substring(idx+1);
        
        mapUser.replace(id, nickName);
    }
    
    public List solution(String[] record) {    
        // Enter, Leave, Change에 대한 처리
        for(String msg : record) {
            switch(msg.substring(0,1)) {
                case "E": enter(msg.substring(6)); break;
                case "L": leave(msg.substring(6)); break;
                case "C": change(msg.substring(7));
            }
        }
        
        for(int i = 0; i < listId.size(); i++)
	        answer.add(mapUser.get(listId.get(i)) + listMsg.get(i));

        return answer;
    }
}
