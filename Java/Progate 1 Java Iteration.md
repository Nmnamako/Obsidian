```java
class Main {
 public static void main(String[] args) {
  System.out.println("hello");
 }
}
```

文字を出力するには、以下の記述
```java
System.out.println("");
```

***

以下演算の出力結果
```java
class Main {
 public static void main(String[] args) {
  
  // 12を3で割った値が出力される
  System.out.println(12 / 3);

  // 3に6を掛けた値が出力される
  System.out.println(3 * 6);

  // 8を3で割った時の余りが出力される
  System.out.println(8 % 3);
 }
}
```

***
変数宣言
```java
class Main {
  public static void main(String[] args) {
    // int型の変数numberを定義
    int number;
	// 以下でも可能
    int number = 3;
    
    // 変数numberに3を代入、再代入はデータ型を付けない
    number = 3;
    
    // 変数numberを出力
    System.out.println(number);

    // String型の変数nameを定義
    String name;
    
    // 変数nameに"Wanko"を代入
    name = "Wanko";
    
    // 変数nameを出力
    System.out.println(name);
    
  }
}
```

***
