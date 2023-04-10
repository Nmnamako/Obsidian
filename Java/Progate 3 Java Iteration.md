#### 1/13 メソッドとクラス
```java
class Main {
 public static void main(String[] args){
  hello();
 }

 public static void hello() {
  System.out.println("Hello Java");
 }
}
```
上記でhello()メソッドを構築し、mainメソッドでhello()メソッドを呼び出している。
***

#### 2/13 メソッドの定義
```java
class Main {
 public static void main(String[] args) {
  printData();
 }
 public static void printData() {
  System.out.println("私の名前はTEST1です");
 }
}
```

メソッドの定義方法が以下の通り
```java
class Main {
 public static void メソッド名(ブロック内) {処理}
}
```
メソッド定義は必ず**クラス内で行う**

***
#### 3/13 引数について
```java
class Main {
 public static void main(Strng[] args) {
  printData("test1");
  printData("test2");
 }
 public static void printData(String name){
  System.out.println("私の名前は" + name + "です");
 }
}
```

メソッドのブロックに「データ型」「仮引数名」を指定すると
その仮引数名に引数を渡すことができる。
```java
class Main {
 printData("test1");
 public static void printData(データ型 仮引数名) {
  // 処理内容
 }
}
```
***

#### 4/13 複数の引数を持つメソッド
```java
class Main {
 public static void main(String[] args) {
  printData("test1",15);
  printData("test1",40);
 }
 public static void printData(String name, int age) {
  System.out.println("私の名前は" + name + "です");
  System.out.println("私の年齢は" + age + "です");
 }
}
```
上記のように渡す引数を「,」で区切り、メソッドのブロック内に
「,」で区切り「データ型」「仮引数名」を記述すれば
複数の引数が利用できる。

***
#### 5/13 戻り値
```java
class Main {
 public static void main(String[] args) {
 String name = fullName("test1","tarou");
 
 printData(name,27);
 printData("test2",65);
 }
 public static String fullName(String firstName, String lastName) {
  return firstName + " " + lastName;
 }
}
```

returnで戻り値を返す場合は、voidの記述が不要
```java
public static void メソッド名(ブロック内) {
 // 処理記述
}

public static データ型 メソッド名(ブロック内) {
 // 処理記述
 return 処理記述;
}
```

***
#### 6/13 同名のメソッド
同名のメソッドは原則として定義できない
ただし**変数の型や個数が違う場合は**同名のメソッドを定義できる。
```java
class Main {
 public static void main(String args) {
  printData(fullName("test1", "tarou"),17);
  printData(fullName("test2","test3","reiwa"),65);
 }

 public static void printData(String name) {
  System.out.println("私の名前は" + name + "です");
  System.out.println("年齢は" + age + "歳です");
 }
 
 public static String fullName(String firstName, String lastName) {
  return firstName + " " + lastName; 
 }
 
 public static String fullName(String firstName, String middleName, String lastName) {
  return firstName + middleName + lastName;
 }
}
```

上記のように**変数の型や個数が違う場合**は、引数の中身や数で自動的にどのメソッドを使うか割り当てられる。
（自動的 = 条件にあったメソッド）を選別している。
***

#### 7/13 メソッドからメソッドで呼ぶ
```java
class Main {
 public static void main(String args) {
  printData(fullName("test1","tarou"), 25, 1.6, 50.0);
  printData(fullName("test2","test3","reiwa"), 65, 1.75, 80.0);
 }

 public static void printData(String name, int age, double height, double weight) {
  System.out.println("私の名前は" + name + "です");
  System.out.println("年齢は" + age + "歳です");
  System.out.println("身長は" + height + "mです");
  System.out.println("体重は" + weight + "kgです");

  double bmi = bmi(height, weight);

  System.out.println("BMIは" + bmi + "です");
 }
 
 public static String fullName(String firstName, String lastName) {
  return firstName + " " + lastName;
 }

 public static String fullName(String firstName, String middleName, String lastName) {
  return firstName + " " + middleName + " " + lastName;
 }

 public static double bmi(double height, double weight) {
  return weight / height / height;
 }
}
```

上記のようにprintDataメソッド内で、bmi()メソッドを呼び出している。
***

#### 8/13 真偽値を返す
```java
class Main {
 public static void main(String[] args) {
  printData("Kate", "Jones"), 27, 1.6, 50.0);
  printData("John", "Christopher", "Smith"), 65, 1.75, 80.0);
 }

 public static void printData(String name, int age, double height, double weight) {
  System.out.println("私の名前は" + name + "です");
  System.out.println("年齢は" + age + "歳です");
  System.out.println("身長は" + height + "mです");
  System.out.println("体重は" + weight + "kgです");
  
  double bmi = bmi(height, weight);
  System.out.println("BMIは" + bmi + "です");

  if (isHealthy(bmi)) {
   System.out.println("健康です");
  } else {
   System.out.println("健康ではありません");
  }
 }

 public static String fullName(String firstName, String lastName) {
  return firstName + " " + lastName;
 }

 public static String fullName(String firstName, String  middleName, String lastName) {
  return firstName + " " + middleName + " " + lastName;
 }

 public static double bmi(double height, double weight) {
  return weight / height / height;
 }

 public static boolean isHealthy(double bmi) {
  return bmi >= 18.5 && bmi < 25;
 }
}
```

上記の記述を行う際に、if文の「または」の条件記述を勘違いしていた。
または = &&
かつ == ||

***
#### 9/13 クラスに触れてみよう
Progate参照

#### 10/13 クラスの定義
Main.java
```java
class Main {
 public static void main(String[] args) {
  Person.printData(Person.fullName("test1","tarou"), 25, 1.7, 50.0);  
 }
}
```

Person.java
```java
class Person {
  public static void printData(String name, int age, double height, double weight) {
    System.out.println("私の名前は" + name + "です");
    System.out.println("年齢は" + age + "歳です");
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");

    double bmi = bmi(height, weight);
    System.out.println("BMIは" + bmi + "です");

    if (isHealthy(bmi)) {
      System.out.println("標準値です");
    } else {
      System.out.println("標準値の範囲外です");
    }
  }

  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }

  public static String fullName(String firstName, String middleName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }

  public static boolean isHealthy(double bmi) {
    return bmi >= 18.5 && bmi < 25.0;
  }
}
```

上記のようにmain.javaとPerson.javaでファイルを分けても
main.javaでPerson.java内にあるメソッドを呼び出せる。

正確には別クラスから呼び出している。

呼び出し時は、頭にクラス名を含める必要がある。
以下の通り
```java
Person.printData(Person.fullName(...));
```

==メソッドないからメソッドを呼び出す際に頭にクラス名の書き忘れがあったので注意のこと==
***

#### 11/13 外部ライブラリ
```java
import java.lang.Math;

class Person {
  public static void printData(String name, int age, double height, double weight) {
    System.out.println("私の名前は" + name + "です");
    System.out.println("年齢は" + age + "歳です");
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
    double bmi = bmi(height, weight);
    // Mathクラスのroundメソッドを用いて、BMIを四捨五入して出力するようにしてください
    System.out.println("BMIは" + Math.round(bmi) + "です");

    if (isHealthy(bmi)) {
      System.out.println("標準値です");
    } else {
      System.out.println("標準値の範囲外です");
    }
  }

  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }

  public static String fullName(String firstName, String middleName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }
  
  public static boolean isHealthy(double bmi) {
    return bmi >= 18.5 && bmi < 25.0;
  }
}

```

外部ライブラリの読み込み記述を忘れていた
```java
// こちらは正しい
import java.lang.Math;


// こちら2つは間違い
import.java.lang.Math;
java.lang.Math;

```

Mathのメソッドを扱う際は以下の通り
```java
Math.round(引数);
```

なお、Mathはよく呼び出されるライブラリなので
importで明記する必要はなく、普通にroundメソッドなど
呼び出せるとのこと
***
#### 12/13 スキャナー
```java
import java.util.Scanner;

class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("名前： ");
    
    String name = scanner.next();
    
    System.out.println("こんにちは" + name + "さん");
  }
}
```

スキャナーの使い方
```java
// 外部ライブラリを呼び出し
import java.util.Scanner;

// スキャナーの値を初期化している
Scanner scanner = new Scanner(System.in);

// 入力待ちになり入力された値をnameへ格納
String name = scanner.next();
```

Progateでは
スキャナーの初期化はメソッド内で行った
***
#### 13/13 総合課題
Scannerで整数や小数を受け取る場合は以下の通り
```java
// 文字
String name = scanner.next();

// 整数
int age = scanner.nextInt();

// 小数
double weight = scanner.nextDouble();
```


Main.java
```java
import java.util.Scanner;

class Main{
 public static void main(String[] args) {
  Scanner scanner = new scanner(System.in);

  System.out.print("名前：");
  // 文字列の入力を受け取る
  String firstName = scanner.next();
    
  System.out.print("名字：");
  // 文字列の入力を受け取る
  String lastName = scanner.next();
    
  System.out.print("年齢：");
  // 整数の入力を受け取る
  int age = scanner.nextInt();
    
  System.out.print("身長(m)：");
  // 小数の入力を受け取る
  double height = scanner.nextDouble();
    
  System.out.print("体重(kg)：");
  // 小数の入力を受け取る
  double weight = scanner.nextDouble();


  Person.printData(Person.fullName(firstName, lastName), age, height, weight);
 }
}
```

Person.java
```java
class Person {
  public static void printData(String name, int age, double height, double weight) {
    System.out.println("私の名前は" + name + "です");
    System.out.println("年齢は" + age + "歳です");
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
    double bmi = bmi(height, weight);
    System.out.println("BMIは" + Math.round(bmi) + "です");

    if (isHealthy(bmi)) {
      System.out.println("標準値です");
    } else {
      System.out.println("標準値の範囲外です");
    }
  }

  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }

  public static String fullName(String firstName, String middleName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }
  
  public static boolean isHealthy(double bmi) {
    return bmi >= 18.5 && bmi < 25.0;
  }
}

```

***
