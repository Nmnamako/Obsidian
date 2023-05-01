class Main {
  public static void main(String[] args) {
    if(isPrime(11) == true) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    System.out.println(isPrime(12) ? "Yes" : "No");
  }

  public static boolean isPrime(long N) {
    // 2 以上の整数 N に対し、N が素数であれば true、素数でなければ false を返す関数
    for (long i = 2; i * i <= N; i++) {
      if (N % i == 0) {
        return false;
      }
    }
    return true;
  }
}
