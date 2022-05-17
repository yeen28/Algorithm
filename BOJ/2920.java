import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    String scales = sc.nextLine();

    
    if(scales.equals("1 2 3 4 5 6 7 8")) {
      System.out.println("ascending");
      return;
    }
    if(scales.equals("8 7 6 5 4 3 2 1")) {
      System.out.println("descending");
      return;
    }
    System.out.println("mixed");
  }
}
