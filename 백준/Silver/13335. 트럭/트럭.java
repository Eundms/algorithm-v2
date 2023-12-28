import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int truckCnt, bridgeLen, bridgeMaxWeight;
	static Queue<Integer> trucks = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		truckCnt = Integer.parseInt(st.nextToken()); // 다리 건너는 트럭의 수
		bridgeLen = Integer.parseInt(st.nextToken()); // 다리의 길이
		bridgeMaxWeight = Integer.parseInt(st.nextToken()); // 다리 최대하중
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < truckCnt; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int onBridgeWeight = 0;
		Queue<Integer> bridge = new ArrayDeque<>();
		for(int i = 0; i < bridgeLen; i++) {
			bridge.add(0);			
		}
		
		while(!bridge.isEmpty()) {
			time += 1;
			onBridgeWeight -= bridge.poll();
			if(!trucks.isEmpty()) {
				if(trucks.peek()+onBridgeWeight<=bridgeMaxWeight) {
					onBridgeWeight += trucks.peek();
					bridge.offer(trucks.poll());
				}else {
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}

 