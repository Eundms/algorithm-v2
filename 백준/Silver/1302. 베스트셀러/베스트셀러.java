import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Main { //2580 스도쿠 //3061 사다리 //1302  //16235 //17492  //2776
	static int bookCnt = 0;
	static Map<String,Integer> books = new HashMap<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bookCnt = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < bookCnt; i++) {
			String name = br.readLine();
			books.put(name, books.getOrDefault(name, 0) + 1);
		}
		
		int maxCnt = 0;
		List<Book> lists = new ArrayList<>();
		List<String> keys = new ArrayList<>(books.keySet());
		for(int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			lists.add(new Book(key,books.get(key)));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			maxCnt = Math.max(maxCnt, books.get(key));
		}
		Collections.sort(lists);
		System.out.println(lists.get(0).name);
		
	}
	static class Book implements Comparable<Book>{
		String name;
		int cnt;
		Book(String name, int cnt){
			this.name = name;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Book o) {
			if(this.cnt == o.cnt) {
				return this.name.compareTo(o.name);
			}
			return o.cnt - this.cnt;
		}
		
	}


}


 