#### 1/11 実際の挙動
どのように動いているか確認
Progate参照
***

#### 2/11 文字列表示
```java
class Main {
  public static void main(String[] args) {
    System.out.println("名前はKate Jonesです");
  }
}

```

***
#### 3/11 入力受け取り
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.println("名前は" + firstName + "です");
  }
}

```

スキャナー関連の記述が記憶定着していなかった。
やることは記憶できているが、
書き入れる内容が思い出せていない
***
#### 4/11 文字列の連結
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.print("名字：");
    String lastName = scanner.next();
    
    System.out.println("名前は" + firstName + " " + lastName + "です");
  }
}

```

***
#### 5/11 条件分岐
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.print("名字：");
    String lastName = scanner.next();
    
    System.out.print("年齢：");
    int age = scanner.nextInt();
    
    System.out.println("名前は" + firstName + " " + lastName + "です");
    System.out.println("年齢は" + age + "歳です");
    if (age >= 20) {
      System.out.println("成年者です");
    } else {
      System.out.println("未成年者です");
    }
  }
}

```

***
#### 6/11 メソッドにまとめる
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.print("名字：");
    String lastName = scanner.next();
    
    System.out.print("年齢：");
    int age = scanner.nextInt();
    
    System.out.print("身長(m)：");
    double height = scanner.nextDouble();
    
    System.out.print("体重(kg)：");
    double weight = scanner.nextDouble();
    
    System.out.println("名前は" + fullName(firstName, lastName) + "です");
    System.out.println("年齢は" + age + "歳です");
    if (age >= 20) {
      System.out.println("成年者です");
    } else {
      System.out.println("未成年者です");
    }
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
  }
  public static void printData() {
    
  }
  
  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }
}

```

基本的に問題ないが、必要事項にprintDataメソッドの中身は
空でもいい、といった注記書きなどなく手間取った。
***
#### 7/11 BMI変換
Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.print("名字：");
    String lastName = scanner.next();
    
    System.out.print("年齢：");
    int age = scanner.nextInt();
    
    System.out.print("身長(m)：");
    double height = scanner.nextDouble();
    
    System.out.print("体重(kg)：");
    double weight = scanner.nextDouble();
    
    Person.printData(firstName, lastName, age, height, weight);
  }
}
```

Person.java
```java
class Person {
  public static void printData(String firstName, String lastName, int age, double height, double weight) {
    System.out.println("名前は" + fullName(firstName, lastName) + "です");
    System.out.println("年齢は" + age + "歳です");
    
    if (age >= 20) {
      System.out.println("成年者です");
    } else {
      System.out.println("未成年者です");
    }
    
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
    
    double bmi = bmi(height, weight);
    System.out.println("BMIは" + Math.round(bmi) + "です");
  }
  
  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }
}
```

作成時に問題はなかったが、変数 bmi に対して bmiメソッドを
代入しているが、引数の中身が前後しているとエラーが発生した
```java
double bmi = bmi(height, weight);

public static double bmi(double height, double weight){
 // 処理内容
}
```
メソッドの第一引数と必ずマッチしなければならない
言わば、厳密に記述しなければならない。
***
#### 8/11 論理演算子の使用
Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.print("名字：");
    String lastName = scanner.next();
    
    System.out.print("年齢：");
    int age = scanner.nextInt();
    
    System.out.print("身長(m)：");
    double height = scanner.nextDouble();
    
    System.out.print("体重(kg)：");
    double weight = scanner.nextDouble();
    
    Person.printData(firstName, lastName, age, height, weight);
  }
}

```

Person.java
```java
class Person {
  public static void printData(String firstName, String lastName, int age, double height, double weight) {
    System.out.println("名前は" + fullName(firstName, lastName) + "です");
    System.out.println("年齢は" + age + "歳です");
    
    if (age >= 20) {
      System.out.println("成年者です");
    } else {
      System.out.println("未成年者です");
    }
    
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
    
    double bmi = bmi(height, weight);
    System.out.println("BMIは" + Math.round(bmi) + "です");
    isHealthy(bmi);
  }
  
  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }
  
  public static void isHealthy(double bmi) {
    if (bmi >= 18.5 && bmi < 25 ) {
      System.out.println("健康です");
    } else {
      System.out.println("健康ではありません");
    }
  }
}
```

記述時に問題は特になかったが、
isHealthy()メソッド作成時に返り値（return）がないのに
データ型を宣言していた。
***
#### 9/11 繰り返し処理
Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("何人分の情報を入力しますか：");
    int count = scanner.nextInt();
    
    for (int i = 0; i < count;) {
      i++;
      System.out.print( i + "人目");
      
      System.out.print("名前：");
      String firstName = scanner.next();
      
      System.out.print("名字：");
      String lastName = scanner.next();
      
      System.out.print("年齢：");
      int age = scanner.nextInt();
      
      System.out.print("身長(m)：");
      double height = scanner.nextDouble();
      
      System.out.print("体重(kg)：");
      double weight = scanner.nextDouble();
      
      Person.printData(firstName, lastName, age, height, weight);
    }
  }
}

```

Person.java
```java
class Person {
  public static void printData(String firstName, String lastName, int age, double height, double weight) {
    System.out.println("名前は" + fullName(firstName, lastName) + "です");
    System.out.println("年齢は" + age + "歳です");
    
    if (age >= 20) {
      System.out.println("成年者です");
    } else {
      System.out.println("未成年者です");
    }
    
    System.out.println("身長は" + height + "mです");
    System.out.println("体重は" + weight + "kgです");
    
    double bmi = bmi(height, weight);
    System.out.println("BMIは" + Math.round(bmi) + "です");
    isHealthy(bmi);
  }
  
  public static String fullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }
  
  public static double bmi(double height, double weight) {
    return weight / height / height;
  }
  
  public static void isHealthy(double bmi) {
    if (bmi >= 18.5 && bmi < 25 ) {
      System.out.println("健康です");
    } else {
      System.out.println("健康ではありません");
    }
  }
}
```

課題では複数人の記入ができるようにするため
繰り返し分を使用した。
以下処理記述時の気づき
```java

int count = scanner.nextInt();

for (int i = 0; i < count; i++){

 System.out.println(i + "人目");
 // 処理内容
}
```
上記のfor文の条件内容に i++ を入れているが、
これは**for文内の処理が完了したタイミングで足される**
条件内容になっているため、何人目といった文字出力を行う際に
0が出力されてしまう。
***
