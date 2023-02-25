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
****
### returnについて
class Main {
  public static void main(String[] args) {

   String name = fullName("Kate","Jones");
    
    printData(name, 27);
    
    printData("John Christopher Smith", 65);
    
  }

  public static void printData(String name, int age) {
    System.out.println("私の名前は" + name + "です");
    System.out.println("年齢は" + age + "歳です");
  }

  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  } 
}


**この記述で、fullName()メソッドに入れ物と仕切りを提供する
fullName(最初の名前 | 後ろの名前)**

public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  } 

**fullNameは上記で仕切りを作っているので、"Kate"、"Jones"を
第一引数と第二引数で格納ができる**

String name = fullName("Kate","Jones");

**オーバーロード**
基本的にメソッドは同名で作ることはできないが
public static void hello() {

}

public static void hello( String name ) {

}
上記の様に仮引数が違えば同名でも作成可能

****
class Main {
  public static void main(String[] args) {
    printData(fullName("Kate", "Jones"), 27);
    
    printData(fullName("John", "Christopher", "Smith"), 65);
  }

  public static void printData(String name, int age) {
    System.out.println("私の名前は" + name + "です");
    System.out.println("年齢は" + age + "歳です");
  }
  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }
  public static String fullName(String firstName, String middleName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
  }
}
****
上記の様にオーバーロードができている

printData(fullName("Kate", "Jones"), 27 );
printData(fullName("John", "Christopher", "Smith" 65);

恐らく、引数が入る数でどちらのfullNameを使うか
決めている

public static void printData(String name, int age) {
}
String name で文字列を自動的に代入している？
int ageも同様な気がする
