
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static int N;
  	static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	for(int n = 0; n < N; n++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String command = st.nextToken();
    		if(command.equals("push")){
    			int value = Integer.parseInt(st.nextToken());
    			queue.add(value);
    		} else if(command.equals("front")) {
    			if (queue.isEmpty()) {
    				System.out.println(-1);
    			} else {
    				System.out.println(queue.peekFirst());
    			}
    		} else if(command.equals("size")) {
    			System.out.println(queue.size());
    		} else if(command.equals("pop")) {
    			if(queue.isEmpty()) {
    				System.out.println(-1);
    			} else {
        			System.out.println(queue.pollFirst());    				
    			}
    		} else if (command.equals("back")) {
    			if(queue.isEmpty()) {
    				System.out.println(-1);
    			} else {    				
        			System.out.println(queue.peekLast());
    			}
    		} else if (command.equals("empty")) {
    			
    			if(queue.isEmpty()) {
    				System.out.println(1);
    			} else {    				
        			System.out.println(0);
    			}    			
    		}
    	}
    }

}