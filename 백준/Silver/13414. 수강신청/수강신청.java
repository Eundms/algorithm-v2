import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int K,L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		
		Set<Student> sIds = new HashSet<>();
		
		for(int l = 0; l < L ; l++) {
			String sId = br.readLine();
			Student nS = new Student(sId, l);
			if(sIds.contains(nS)) {
				sIds.remove(nS);
				sIds.add(nS);
			}else {
				sIds.add(nS);
			}
		}
		List<Student>students = new ArrayList<>(sIds);
		Collections.sort(students);
		//System.out.println(students);
		for(int i = 0; i < Math.min(K, students.size()); i++) {
			System.out.println(students.get(i).sId);
		}
	}
	static class Student implements Comparable<Student>{
		String sId;
		int rank;
		Student(String sId,int rank){
			this.rank = rank;
			this.sId = sId;
		}
		@Override
		public int compareTo(Student o) {
			return this.rank-o.rank;
		}
		@Override
		public boolean equals(Object o) {
			if(this==o) {
				return true;
			}
			if(!(o instanceof Student)) {
				return false;
			}
			Student student = (Student)o;
			return student.sId.equals(sId);
		}
		@Override
		public int hashCode() {
			return Objects.hash(sId);
		}
		@Override
		public String toString() {
			return sId+" ";
		}
	}
	
	
	
}