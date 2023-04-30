import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static PriorityQueue<Person> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 온라인 저지 회원의 수
        pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Person(n, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        // 나이와 이름이 공백으로 구분되어 주어짐.
        while (!pq.isEmpty()) {
            Person person = pq.poll();
            System.out.println(person.age +" "+person.name);
        }
    }

    static class Person implements Comparable<Person> {
        int idx;
        int age;
        String name;

        public Person(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) {
                return this.idx - o.idx;
            }
            return this.age - o.age;
        }
    }

}
