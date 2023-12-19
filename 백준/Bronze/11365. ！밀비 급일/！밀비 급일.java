import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String v = br.readLine();
			if(v.equals("END"))break;
			for(int i = v.length()-1; i >= 0; i--) {
				System.out.print(v.charAt(i));							
			}
			System.out.println();
		}
	}
	
	
}
