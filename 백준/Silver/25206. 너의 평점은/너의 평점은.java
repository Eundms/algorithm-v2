import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
class Main {// 25206 너의 평점은 // 20055 컨베이어 벨트 //2580 스도쿠 //3061 사다리  //1080 행렬
	static Map<String, Double> alphaToHack;
	public static void main(String[] args) throws Exception {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
		int cnt = 0;
		StringTokenizer st;
		for(int i = 0; i < 20 ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	String name = st.nextToken();
        	double hackjum = Double.parseDouble(st.nextToken());
        	String score = st.nextToken();
        	if(score.equals("P"))continue;
        	cnt += hackjum;
        	sum += alphaToHack.get(score) * hackjum;
        	
        }
		System.out.printf("%.6f",sum/cnt);
    }
	static void init() {
		alphaToHack = new HashMap<>();
		alphaToHack.put("A+", 4.5);
		alphaToHack.put("A0", 4.0);
		alphaToHack.put("B+", 3.5);
		alphaToHack.put("B0", 3.0);
		alphaToHack.put("C+", 2.5);
		alphaToHack.put("C0", 2.0);
		alphaToHack.put("D+", 1.5);
		alphaToHack.put("D0", 1.0);
		alphaToHack.put("F", 0.0);
		
	}

}
// 전공평점 = SUM (학점 * 과목평점 + ... ) / SUM(학점1, 학점2, .. ) 


 