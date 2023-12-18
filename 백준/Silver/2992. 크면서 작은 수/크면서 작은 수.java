import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static String X;
	static int[] count; 
	static int[][] way = {{1,0},{0,1},{-1,0},{0,-1}};
	static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = br.readLine();
        count = new int[10]; // 1 2 3 4 5 ...9
        for(int i = 0; i < X.length(); i++) {
        	count[X.charAt(i)-'0'] += 1;
        }
        min = Integer.MAX_VALUE;
        pick("",count);
        
        
        System.out.println(min==Integer.MAX_VALUE?0:min);
    }
    
    static void pick(String number, int[] count) {
    	if(X.length() == number.length()) {
    		int cur = Integer.parseInt(number);
    		if(cur > Integer.parseInt(X)) {
        		min = Math.min(min, cur);
    		}
    		return;
    	}
    	for(int i = 0; i < 10; i++) {
    		if(number.length() == 0 && i < X.charAt(0)-'0') {
    			continue;
    		}
    		if(count[i]>0) {
    			count[i] -= 1;
        		pick(number + i, count);
        		count[i] += 1;
    		}
    	}
    }
   

}


 