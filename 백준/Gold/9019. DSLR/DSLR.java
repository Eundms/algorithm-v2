import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int T; // 테스트 케이스 개수
	static boolean[] visited;
	public static void main(String[] args)throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 레지스터의 초기 값
			int B = Integer.parseInt(st.nextToken()); // 최종값
			
			visited = new boolean[10000];
			sb.append(bfs(A,B)+"\n");
		}
		System.out.println(sb.toString());
	}
	// 0 이상 10,000미만의 십진수
	static String bfs(int A, int B) { // 정수 A, 정수 B에 대하여 A를 B로 변경
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(A,""));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.value == B) {
				return now.command;
			}
			if(visited[now.value])continue;
			visited[now.value] = true;
			if(isValid(commandD(now.value))) {
				queue.add(new Node(commandD(now.value),now.command+"D"));
			}
			if(isValid(commandS(now.value))) {
				queue.add(new Node(commandS(now.value),now.command+"S"));
			}
			if(isValid(commandL(now.value))) {
				queue.add(new Node(commandL(now.value),now.command+"L"));
			}
			if(isValid(commandR(now.value))) {
				queue.add(new Node(commandR(now.value),now.command+"R"));
			}
			
		}
		
		return "";
	}
	static boolean isValid(int value) {
		return value >=0 && value < 10000 && !visited[value];
	}

	static class Node{
		int value;
		String command;
		Node(int value, String command){
			this.value = value;
			this.command = command;
		}
	}
	
	static int commandD(int n) { // n을 두배로 바꿈
		int next = n * 2;
		if(next > 9999) { 
			return next % 10000;
		}
		return next;
	}
	static int commandS(int n) { // n에서 1을 뺀 결과 n-1를 레지스터에 저장
		if(n == 0) {
			return 9999;
		}
		return n-1;
	}
	static int commandL(int n) { // n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장
		int leftValue = n / 1000;
		return (n - leftValue * 1000) * 10 + leftValue;
	}
	static int commandR(int n) { // n의 각 자릿수를 오른편으로 회전시켜 극 결과를 레지스터에 저장
		int rightValue = n % 10;
		return n/10 + rightValue * 1000;
	}
}


 

 