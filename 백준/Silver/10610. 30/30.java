import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main { //30의 배수 3의 배수(각자리수합이3의배수) + 맨 마지막수 0
	static String str;
	static List<Character> number = new ArrayList<>();
	static int ans = -1;
	static int size;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		size = str.length();
		int total = 0;
		boolean hasZero = false;
		for(int i  = 0 ; i < size; i++) {
			number.add(str.charAt(i));
			if(number.get(i) == '0') {
				hasZero = true;
			}
			total += (str.charAt(i)-'0');
		}
		if(hasZero && total%3==0) {
			Collections.sort(number,Comparator.reverseOrder());
			for(int i = 0; i < size; i++) {
				System.out.print(number.get(i));
			}
			return;
		}
		
		System.out.println(ans);
	}


}