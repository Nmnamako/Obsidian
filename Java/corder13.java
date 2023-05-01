import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final long N = sc.nextLong();
		HashSet<Long> set = new HashSet<>();
		
		for (long i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				set.add(i);
				set.add(N / i);
			}
		}
		
		for (Long i : set) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
