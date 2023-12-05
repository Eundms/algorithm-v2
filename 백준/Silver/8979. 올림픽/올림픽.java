import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	// 금메달 수가 더 많은 나라
	// 금메달 수가 같으면, 은메달 수가 더 많은 나라
	// 금,은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
	// 국가 1 ~ N 
	// 등수 = (자신보다 더 잘한 나라 수) + 1
	static int N, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 일단 sort
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<Country> list = new ArrayList<>();
		
		// 앞에서부터 순서 매기기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			list.add(new Country(idx, gold, silver, bronze));
		}
		Collections.sort(list);
		
		int[] rank = new int[N+1];
		
		
		rank[list.get(0).idx] = 1;
		for(int i = 1; i< list.size(); i++) {
			Country prev = list.get(i-1);
			Country now = list.get(i);
			if(now.gold == prev.gold && now.silver == prev.silver && now.bronze == prev.bronze) {
				// 금, 은, 동 수가 모두 같음
				rank[now.idx] = rank[prev.idx];
			}else {
				rank[now.idx] = i+1;
			}
		}
		//System.out.println(Arrays.toString(rank));
		System.out.println(rank[K]);
	}
	
	static class Country implements Comparable<Country>{
		int idx, gold, silver, bronze;
		Country(int idx, int gold, int silver, int bronze){
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		@Override
		public int compareTo(Country o) {
			if(this.gold == o.gold) {
				if(o.silver == this.silver) {
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}
}