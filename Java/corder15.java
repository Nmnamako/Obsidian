import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		while(a != 0 && b != 0) {
			if(a < b) {
				b = b % a;
			} else {
				a = a % b;
			}
		}
		System.out.println((a != 0 ? a : b));	
	}
}
