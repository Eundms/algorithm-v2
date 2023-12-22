import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
	static int[][] box;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        box = new int[3][2];
        Map<Integer,Integer> leftCnt = new HashMap<>();
        Map<Integer,Integer> rightCnt = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	box[i][0] = Integer.parseInt(st.nextToken());
        	box[i][1] = Integer.parseInt(st.nextToken());
        	leftCnt.put(box[i][0], leftCnt.getOrDefault(box[i][0], 0) + 1);
        	rightCnt.put(box[i][1], rightCnt.getOrDefault(box[i][1], 0) + 1);
        }
        int x = -1;
        List<Integer> leftKeys = new ArrayList<>(leftCnt.keySet());
        for(int i = 0; i < leftKeys.size(); i++) {
        	if(leftCnt.get(leftKeys.get(i)) == 1) {
        		x = leftKeys.get(i);
        		break;
        	}
        }
        int y = -1;
        List<Integer> rightKeys = new ArrayList<>(rightCnt.keySet());
        for(int i = 0; i < rightKeys.size(); i++) {
        	if(rightCnt.get(rightKeys.get(i)) == 1) {
        		y = rightKeys.get(i);
        		break;
        	}
        }
        System.out.println(x+" "+y);
    }

}


 