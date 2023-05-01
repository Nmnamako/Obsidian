import java.util.Scanner;
 
class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		sc.close();
 
		for (long i = 2L; i * i <= N; i++) {
			while(N % i == 0){
				System.out.print(i + " ");
				N /= i;
			}
		}
 
		if(N > 1) System.out.println(N);
 
	}
 
}
