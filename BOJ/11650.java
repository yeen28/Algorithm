import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	
	public static class Coordinate {
		int x, y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
     public static void main(String []args) throws IOException {
    	 Main main = new Main();
         main.input();
     }
     
     public void input() throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int N = Integer.parseInt(br.readLine());
         Coordinate[] coordinate = new Coordinate[N];
         String[] str = new String[2];
         for(int i=0; i<N; i++) {
        	 str = br.readLine().split(" ");
             coordinate[i] = new Coordinate(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
         }
         
         proc(coordinate);
     } //input
     
     public void proc(Coordinate[] coordinate) {
         Arrays.sort(coordinate, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				
				return o1.x - o2.x;
			}
         });
         
         StringBuilder sb = new StringBuilder();
         for(Coordinate val : coordinate) {
        	 sb.append(val.x).append(" ").append(val.y).append("\n"); 
         }
         
         System.out.println(sb);
     }
}
