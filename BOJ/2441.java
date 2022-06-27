import java.lang.StringBuilder;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i=n; i>0; i--) {
            for(int j=n-i; j>0; j--) {
                sb.append(" ");
            }
            
            for(int j=i; j>0; j--) {
                sb.append("*");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
