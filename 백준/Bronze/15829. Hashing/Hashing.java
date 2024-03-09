
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int L;
	static String str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		long sum = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a' + 1;
			sum += (val * Math.pow(31,i))%1234567891;
		}
		System.out.println((int)(sum%1234567891));
	}
}