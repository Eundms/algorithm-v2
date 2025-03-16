import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static String START;
	static String TARGET;
	static int ANS = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		START = br.readLine();
		TARGET = br.readLine();
		back(TARGET);
		System.out.println(ANS);
	}

	static void back(String current) {
		if (current.length() == START.length()) {
			if (current.equals(START)) {
				ANS = 1;
			}
			return;
		}

		if (current.endsWith("A")) {
			back(current.substring(0, current.length() - 1));
		}
		if (current.startsWith("B")) {
			back(new StringBuilder(current.substring(1)).reverse().toString());
		}

	}

}
