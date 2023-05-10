import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            boolean[] visited = new boolean['z' - 'a' + 1];

            boolean isAnswer = true;
            String word = br.readLine();
            visited[word.charAt(0)-'a'] = true;
            for (int i = 1; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (visited[ch - 'a']) { // 방문한 적이 있다면,
                    // 바로 앞글자가 현재 글자랑 동일한지 확인
                    if (word.charAt(i - 1) != ch) { // 동일하지 않다면,
                        isAnswer = false;
                        break;
                    }
                } else { // 방문한적이 없다면,
                    visited[ch - 'a'] = true;
                }
            }

            if (isAnswer) { // 정답이라면
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
