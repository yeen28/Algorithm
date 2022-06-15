import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder answer;
    private static Deque<Integer> deque;

    public static void main(String []args) throws IOException {
        Main main = new Main();

        String[] str = main.input();
        main.proc(str.length, str);

        System.out.println(answer);
    }

    public String[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }

        return str;
    }

    public StringBuilder proc(int N, String[] str) {
        answer = new StringBuilder();
        deque = new LinkedList<>();
        StringTokenizer stk;
        for(int i=0; i<N; i++) {
            if("pop_front".equals(str[i])) {
                func_pop_front();
            } else if("pop_back".equals(str[i])) {
                func_pop_back();
            } else if("size".equals(str[i])) {
                func_size();
            } else if("empty".equals(str[i])) {
                func_empty();
            } else if("front".equals(str[i])) {
                func_front();
            } else if("back".equals(str[i])) {
                func_back();
            } else {
                stk = new StringTokenizer(str[i], " ");
                String s = stk.nextToken();
                int a = Integer.parseInt(stk.nextToken());

                func_push(s, a);
            }
        }

        return answer;
    } //proc

    public void func_push(String s, int a) {
        if("push_front".equals(s)) {
            deque.addFirst(a);
        } else {
            deque.add(a);
        }
    }

    public void func_pop_front() {
        if(deque.isEmpty()) {
            answer.append(-1).append('\n');
            return;
        }

        answer.append(deque.getFirst()).append('\n');
        deque.removeFirst();
    } //func_pop_front

    public void func_pop_back() {
        if(deque.isEmpty()) {
            answer.append(-1).append('\n');
            return;
        }

        answer.append(deque.getLast()).append('\n');
        deque.removeLast();
    } //func_pop_back

    public void func_size() {
        answer.append(deque.size()).append('\n');
    } //func_size

    public void func_empty() {
        if(deque.isEmpty()) {
            answer.append(1).append('\n');
        } else {
            answer.append(0).append('\n');
        }
    } //func_empty

    public void func_front() {
        if(deque.isEmpty()) {
            answer.append(-1).append('\n');
            return;
        }

        answer.append(deque.getFirst()).append('\n');
    } //func_front

    public void func_back() {
        if(deque.isEmpty()) {
            answer.append(-1).append('\n');
            return;
        }

        answer.append(deque.getLast()).append('\n');
    } //func_back
}
