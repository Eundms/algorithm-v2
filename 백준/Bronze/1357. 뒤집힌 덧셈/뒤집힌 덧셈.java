
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static String X,Y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = st.nextToken();
		Y = st.nextToken();
		int pre = Integer.parseInt(rev(X))+Integer.parseInt(rev(Y));
		System.out.println(rev(Integer.toString(pre)));
	}
	public static String rev(String item) {
		 StringBuffer sb = new StringBuffer(item);
	     String reverse = sb.reverse().toString();
	     int res = Integer.parseInt(reverse);
		return Integer.toString(res);
	}
	
	

}
