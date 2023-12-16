import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
class Main { 	
	// 형택구에 나온 국회의원 후보 : N명
	// 마을 M명의 마음 읽음
	// 1득표수 > 2...N번 후보 각각의 득표수 -> 국회의원에 당선
	static int N;
	static Candidate dasom;
	static PriorityQueue<Candidate> others;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 후보의 수  
		
		dasom = new Candidate(0,Integer.parseInt(br.readLine())); 
		others = new PriorityQueue<>();
		for(int i = 1; i < N; i++) {
			others.add(new Candidate(i+1,Integer.parseInt(br.readLine())));
		}
		int cnt = 0;
		if(others.size()>0) {
			while(true) {
				if(dasom.voteCnt > others.peek().voteCnt) {
					break;
				}
				cnt += 1;
				Candidate person = others.poll();
				person.voteCnt-=1;
				others.add(person);
				dasom.voteCnt+=1;
			}
			
		}
		System.out.println(cnt);
		
	}
	static class Candidate implements Comparable<Candidate>{
		int id, voteCnt;
		Candidate(int id, int voteCnt){
			this.id = id;
			this.voteCnt = voteCnt;
		}
		@Override
		public int compareTo(Candidate o) {
			if(this.voteCnt == o.voteCnt) {
				return this.id - o.id;
			}
			return o.voteCnt - this.voteCnt;
		}
	}

}


 