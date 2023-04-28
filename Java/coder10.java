class Main {
  public static void main(String[] args) {
    int n = new java.util.Scanner(System.in).nextInt();
    int a = n;
    for(int i = 1; i < a; i++) {
      n *= i;
    }
    System.out.println(n);
  }
}
