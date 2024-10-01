import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = 10;
    int[][] box = new int[100][102];// 0패딩, 1 - 100, 101패딩
    for (int t = 1; t <= T; t++) {
    	// 입력값 
    	br.readLine();
    	int distX = 0, distY = 0;
    	for(int i = 0; i < 100; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= 100; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			
    			if(box[i][j] == 2) {
    				distX = i;
    				distY = j;
    			}
    		}
    	}
    	
    	// 0 행까지 올라가면서 1. (좌/우) , 2. 위 
    	while(distX > 0) {
    		box[distX][distY] = 0;
    		if(box[distX][distY-1] == 1) {
    			distY -= 1;
    		}
    		else if(box[distX][distY+1] == 1) {
    			distY += 1;
    		} 
    		else {
    			distX -= 1;
    		}
    	}
    	
    	System.out.println("#"+t+" "+(distY-1));
    	

    }
    
  }

}
