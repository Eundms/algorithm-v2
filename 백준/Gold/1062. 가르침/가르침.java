import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, K;
    static String[] words;
    static boolean[] alphabet;
    static int count = 0;
    static int result = 0;

    public static void main (String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        alphabet = new boolean[26];

        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        for(int i = 0; i < N; i++){
            words[i] = (br.readLine()).toString().replaceAll("[antic]", "");
        }

        if(K < 5){
            System.out.println(0);
            return;
        }
        else if(26 == K){
            System.out.println(N);
            return;
        }

        count = 5;
        result = countwords();

        for(int i = 0; i < 26; i++){
            if(alphabet[i] == false){
                dfs(i);
            }
        }
        System.out.println(result);
    }

    static void dfs(int index){
        //1. 체크인
        alphabet[index] = true;
        count++;
        //2. 목적지인가
        if(count == K){
            // 셀 수 있는 단어와 기존 max를 비교 하여 저장
            result = Math.max(countwords(), result);
        }
        //3. 갈 수 있는 곳 순회
        else{
            for(int i = index + 1; i < 26; i++){
                //4. 갈 수 있는가
                if(alphabet[i] == false){
                    //5. 간다
                    dfs( i);
                }
            }
        }
        //6. 체크아웃
        alphabet[index] = false;
        count--;
    }

    static int countwords() {
        int counter = 0;

        for(int i = 0; i < N; i++){
            boolean possible = true;
            String word =words[i];

            for(int j = 0; j < word.length(); j++){
                if(alphabet[word.charAt(j) - 'a'] == false){
                    possible = false;
                    break;
                }
            }
            if(possible == true){
                counter++;
            }
        }
        return counter;
    }

}