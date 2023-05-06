import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // #1946 신입 사원
    static int T;
    static int N; // 지원자의 숫자
    static List<Applicant> applicants;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 지원자의 숫자

            applicants = new ArrayList<>();
            StringTokenizer st;
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());
                Applicant applicant = new Applicant( score, interviewRank); // 지원자의 서류 심사 성적, 면접 성적 순위
                applicants.add(applicant);
            }
            Collections.sort(applicants, Comparator.comparingInt(x -> x.scoreRank));
            // 자신보다 서류심사 성적이 높은 면접자들의 면접 성적보다 A의 성적이 높아야 한다.
            // == 자신보다 서류 심사 성적이 높은 면접자들의 면접 성적 중 가장 높은 성적보다 A의 성적이 높아야 한다.
            int cnt = 1;
            int maxRankPrev = applicants.get(0).interviewRank;
            for (int i = 0; i < N; i++) {
                Applicant applicant = applicants.get(i);
                if (maxRankPrev > applicant.interviewRank) {
                    maxRankPrev = applicant.interviewRank;
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }

    public static class Applicant {
        private int  scoreRank, interviewRank;

        public Applicant(int scoreRank, int interviewRank) {
            this.scoreRank = scoreRank;
            this.interviewRank = interviewRank;
        }

        @Override
        public String toString() {
            return "Applicant{" +
                    "scoreRank=" + scoreRank +
                    ", interviewRank=" + interviewRank +
                    '}';
        }
    }
}
