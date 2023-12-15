import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
class Main { 	
	static int[] ans = {1,1,2,2,2,8};
	static int[] box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int i = Integer.parseInt(br.readLine());
		System.out.println(word.charAt(i-1));
	}

}


 