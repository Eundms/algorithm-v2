import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	static String bomb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			sb.append(ch);
			if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
				sb.delete(sb.length() - bomb.length(), sb.length());
			}
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

}
