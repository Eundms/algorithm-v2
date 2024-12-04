import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Person> ppl = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int dd = Integer.parseInt(st.nextToken());
			int mm = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			ppl.add(new Person(yy, mm, dd, name));
		}
		Collections.sort(ppl);
		System.out.println(ppl.get(ppl.size() - 1).name);
		System.out.println(ppl.get(0).name);

	}

	static class Person implements Comparable<Person> {
		int yy, mm, dd;
		String name;

		Person(int yy, int mm, int dd, String name) {
			this.yy = yy;
			this.mm = mm;
			this.dd = dd;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			if (this.yy == o.yy) {
				if (this.mm == o.mm) {
					return this.dd - o.dd;
				}
				return this.mm - o.mm;
			}
			return this.yy - o.yy;
		}
	}

}
