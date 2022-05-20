import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static void main(String args[]) throws Exception {
    Main main = new Main();
		
    main.input();
  }

  private void input() {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    proc(str);
  }
	
  private void proc(String str) {
    StringTokenizer stk = new StringTokenizer(str, " ");
    int cnt=0;
    while(true) {
      if(stk.hasMoreTokens()) {
        stk.nextToken();
        cnt++;
      } else break;
    } //end while
    
    System.out.println(cnt);
  }
}
