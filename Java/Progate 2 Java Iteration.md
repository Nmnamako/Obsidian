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
#### 5/15 else
```java
class Main {
 public static void main(String[] args) {
  int number = 19;

  // numberが20より小さいとき、どちらでもないときの条件分岐を追加してください

  if (number > 20) {
   System.out.println("10より小さい");
  } else if (number < 20) {
   System.out.println("10以上、20より小さい");
  } else {
   System.out.println("20以上");
  }
 }
}
```
***
#### 6/15 switch文
```java
class Main {
 public static void main(String[] args) {
  int n = 1;

  switch(n) {
   case 1:
    System.out.println("大吉です");
    break;
   case 2:
    System.out.println("吉です");
    break;
  }
 }
}
```
switch文では、caseに該当する条件の処理を実行する。
switch文では、breakが必要になる。
***
#### 7/15 default
```java
class Main {
  public static void main(String[] args) {
    int n = 0;
    
    switch (n) {
      case 1:
        System.out.println("大吉です");
        break;
      case 2:
        System.out.println("中吉です");
        break;
      // defaultを用いて、変数nの値がどのcaseにも合致しない場合の処理を記述してください
      default:
       System.out.println("凶です");
       break;
    }
  }
}
```
***
#### 8/15 while文
```java
class Main {
 public static void main(String[] args) {
  int number = 10;

  while (number > 10) {
   System.out.println(number);
   number--;
  }
 }
}
```
***
#### 9/15 for文
```java
clas Main {
 public static void main(String[] args) {
  for(int i = 1; i <= 10; i++) {
   System.out.println(i + "回目の処理");
  }
 }
}
```
forの条件内容に変数「i」を宣言した際に
for文の上に「int型」の「i」を宣言しているとエラーが発生する。

for文では、while文の時のように先に変数宣言してから処理を
実行することができない？

上記コードをwhileの時と同じ記述を行なったがエラー発生
下記のコードがそれに該当する。
```java
// 実行時にエラーが発生する
class Main {
  public static void main(String[] args) {
    // for文を用いて、繰り返し処理をつくってください
    int i = 1;
    
    for (i <= 10) {
      System.out.println(i + "回目のループです");
      i++;
    }
  }
}
```
***
#### 10/15 break,continue
```java
class Main {
  public static void main(String[] args) {
    System.out.println("=== while文 ===");
    int i = 1;
    while (i < 10) {
      // iが5の倍数のとき、繰り返し処理を終了してください
      if (i % 5 == 0) {
        break;
      }
      System.out.println(i);
      i++;
    }
    System.out.println("=== for文 ===");
    for (int j = 1; j < 10; j++) {
      if (j % 3 == 0) {
        continue;
      }
      // jが3の倍数のとき、処理をスキップ
      System.out.println(j);
    }
  }
}
```
***

#### 11/15 配列
```java
class Main {
 public static void main(String[] args) {
  String[] names = {"test1","test2","test3"}

  System.out.println(names[0]);
  System.out.println(names[2]);
 }
}
```
javaで配列を作るには、変数名の前に配列カッコを入れ
代入先で、ハッシュカッコを使用する。
***

#### 12/15 配列の要素を上書き
```java
class Main {
 public static void main(String[] args){
  // 変数languagesを定義し、配列を代入
  String[] languages = {"Ruby","PHP",""Python};
  
  // インデックス番号が「1」の要素を出力
  System.out.println(languages[1]);
  
  // インデックス番号が「1」の要素を「Java」で上書き
  languages[1] = "Java";

  // インデックス番号が「1」の要素を出力
  System.out.println(languages[1]);
 }
}
```
上記はあくまで、要素の上書きであり新規で要素を追加できる
わけではないので注意のこと
***
#### 13/15 配列と繰り返し
```java
class Main{
 public static void main(String[] args){
  String[] names = {"test1", "test2", "test3"};

  for(int i = 0; i < names.length; i++){
   System.out.println(私の名前は" + names[i] + "です);
   
  }
 }
}
```
lengthで中の要素の個数をカウントし、iと比較し
その回数以下なら処理を実行
その回数を超えたら機能停止
***
#### 14/15 拡張for文の文法
```java
class Main {
 public static void main(String[] args){
  String[] names = {"test1","test2","test3"};

  for(String name: names) {
   System.out.println(name);
  }
 }
}
```
上記コードは13/15の記述の改良版
for文には拡張for文としてこのような記述が存在している。
***
#### 15/15 総合課題
```java
class Main {
 public static void main(String[] args){
  // 変数numbersに、与えられた数字の配列を代入
  int[] numbers = {1, 4, 6, 9, 13, 16};

  int oddSum = 0;
  int evenSum = 0;

  for(int number: numbers){
   if(number % 2 == 0){
    evenSum += number;
   } else {
    oddSum += number;
  }

  System.out.println("奇数の和は" + oddSum + "です");
  System.out.println("偶数の和は" + evenSum + "です");
  }
 }
}
```

上記コード作成時に省略型の存在を忘れていた箇所あり。
```java
// 下記でも可能だが省略できる
evenSum = evenSum + number;

// 省略型
evenSum += number;
```

***
