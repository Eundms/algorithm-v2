import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {//16987
	static int N;
	static int[] strength;
	static int[] weight;
	static int maxBrokenEggs;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 계란의 수
        strength = new int[N];
        weight = new int[N];
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());// 내구도
        	int w = Integer.parseInt(st.nextToken());// 무게
        	strength[i] = s;
        	weight[i] = w;
        }
        // 계란i로 j를 치게 되면 
        // i의 내구도는 eggs[j].weight 만큼 감소, j의 내구도는 eggs[i].weight만큼 감소
        brokeEgg(0,strength); 
       System.out.println(maxBrokenEggs);
  
    }
	static void brokeEgg(int hand,int[] strength) {
		if(hand==N) { // 종료 
			int cnt = 0;
			for(int i = 0; i < N ; i++) {
				if(strength[i]<=0) {
					cnt+=1;
				}
			}
			maxBrokenEggs = Math.max(maxBrokenEggs, cnt);
			return;
		}
		
		if(strength[hand]<=0) { // 본인이 깨져있는 상황
			brokeEgg(hand+1, strength); // 다음으로 넘긴다
			return;
		}
		
		boolean flag = true; // 자기 빼고 다 깨져있는 경우
		for(int i = 0; i < N; i++) {
			if(i == hand)continue;
			if(strength[i]>0) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			maxBrokenEggs = Math.max(maxBrokenEggs, N-1);
			return;
		}
		

		for(int i = 0; i < N; i++) {
			if(i==hand || strength[i]<=0)continue; // 손에 쥔 계란으로 다른 깨지지 않은 계란을 쳐야 함
			int[] copyed = copy(strength); 
			copyed[hand] -= weight[i];
			copyed[i] -= weight[hand];
			
			brokeEgg(hand+1, copyed);
		}
	
	}
	
	static int[] copy(int[] strength) {
		int[] copyed = new int[strength.length];
		for(int i = 0; i < strength.length; i++) {
			copyed[i] = strength[i];
		}
		return copyed;
	}



}