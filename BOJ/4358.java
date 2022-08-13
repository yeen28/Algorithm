import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      Map<String,Integer> map = new HashMap<String,Integer>();
      List<String> list = new LinkedList<String>();
     
      int cnt = 0;
      String str = "";
      while((str=br.readLine()) != null) {
          map.put(str, map.getOrDefault(str, 0)+1);
          cnt++;
      }
      
      for(String s : map.keySet()) {
          list.add(s);
      }
      
      Collections.sort(list);
      
      for(String key : list) {
          sb.append(key).append(" ").append(String.format("%.4f", (double)map.get(key)/(double)cnt * 100)).append("\n");
      }
      System.out.println(sb);
    }
}
