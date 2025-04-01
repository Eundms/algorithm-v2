import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static String A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(B);
		while (sb.length() > A.length()) {
			char last = sb.charAt(sb.length() - 1);
			if (last == 'A') {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.deleteCharAt(sb.length() - 1);
				sb = sb.reverse();
			}
		}

		if (sb.toString().equals(A)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}