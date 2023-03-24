#### 1/15 真偽値を出力
```java
class Main {
  public static void main(String[] args) {
    // 「true」を用いて、「真」を表す真偽値を出力してください
    System.out.println(true);
    
    // 「false」を用いて、「偽」を表す真偽値を出力してください
    System.out.println(false);
    
    // 「==」を用いて、値を比較した結果を出力してください
    System.out.println(12 / 4 == 3);
    
    // 「!=」を用いて、値を比較した結果を出力してください
    System.out.println(12 / 4 != 3);
    
    // 変数を定義し、値を比較した結果を代入してください
    boolean bool = 3 * 9 == 27;
    
    // 変数boolの値を出力してください
    System.out.println(bool);
    
  }
}
```

***

#### 2/15 大小比較
```java
class Main {
 public static void main(String[] args) {
  // 「4 + 2」と「6」を比較し、falseとなるようにしてください
  System.out.println(4 + 2 != 6);
  
  // 「4 + 2」と「6」を比較し、trueとなるようにしてください
  System.out.println(4 + 2 == 6);
  
 }
}
```

***

#### 3/15 理論演算子 
```java
class Main{
 public static void main(String[] args){
  // trueと出力されるようにしてください
  System.out.println(true != false);
  
  // falseと出力されるようにしてください
  System.out.println(false == true);
  
  // 「8 < 5」かつ「3 >= 2」の結果を出力してください
  System.out.println(8 < 5 && 3 >= 2);
  
  // 「8 < 5」または「3 >= 2」の結果を出力してください
  System.out.println(8 < 5 || 3 >= 2);
  
  // 「8 < 5」でない、の結果を出力してください
  System.out.println(!(8 < 5));
 }
}
```
***

#### 4/15 if文
```java
class Main {
 public static void main(String[] args){
  // 条件式に直接trueをいれてください
  if (true) {
      System.out.println("条件式がtrueのため、出力されます");
    }
    
  // 条件式に直接falseをいれてください
  if (false) {
      System.out.println("条件式がfalseのため、出力されません");
    }

   int x = 5;
  // if文を用いて、変数xが2より大きいとき「xは2より大きい」と出力してください
  if (x > 2) {
      System.out.println("xは2より大きい");
    }

  // if文を用いて、変数xが8より大きいとき「xは8より大きい」と出力してください
  if (x > 8) {
   System.out.println("xは8より大きい");
  }
 }
}
```
「変数xが2より大きいとき」を誤認し、「>」「>=」で回答した。
「〜より大きい」「〜以上」に注意
***
