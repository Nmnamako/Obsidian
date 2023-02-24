Javaでのメソッドは以下の様な感じ
Javascriptと同じか？

==hello()==がメソッド名
class Main {
	public static void ==hello()== {
		実行する処理;
	}
}
メソッドはクラスの中に記述を行わないとエラーが発生する
**public**
どこからでもアクセスできる様にする記述らしい
**static**
メソッド名を固定化させる

メソッドの呼び出し方は、 hello();これだけOK

****
**引数を受け取るメソッド**
public static void メソッド名 (データ型 変数名 ) {
	実行する処理 ;
}

以下例文
class Main {
  public static void main(String[] args) {
    printData("Kate Jones");
    printData("John Christopher Smith");
  }
  public static void printData(String name) {
    System.out.println("私の名前は" + name + "です");
  }
}
****
**複数の引数を持つメソッド**

引数は左から第一引数,第二引数という

public static void メソッド名 (データ型 変数名1 , データ型 変数名2) {
	実行する処理;
}

例文
class Main {
  public static void main(String[] args) {
    // それぞれ年齢に関する引数を追加してください
    printData("Kate Jones",27);
    printData("John Christopher Smith",65);
  }

  // 年齢に関する引数を受け取れるようにしてください
  public static void printData(String name, ==int age==) {
    System.out.println("私の名前は" + name + "です");
    // 「年齢は◯◯歳です」と出力してください
    System.out.println("年齢は" + age + "歳です");
    
  }
}
****
