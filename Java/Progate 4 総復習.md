#### 1/10 見本
オブジェクト指向の学習になる
Progate参照のこと

***

#### 2/10 Bicycleクラス作成
Main.java
```java
class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ");
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + bicycle.getName());
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name;
  
  Bicycle(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name = name;
  }
}
```


躓くことはなかったが、クラス定義時の値入力先に悩んだ
``` java
Bicycle bicycle = new Bicycle(ここに値を入力)
```
***
#### 3/10 色を追加
Main.java
```java
class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    //System.out.println("【自転車の情報】");
    //System.out.println("名前：" + bicycle.getName());
    //System.out.println("色：" + bicycle.getColor());
    
    bicycle.printData();
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name;
  private String color;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
  }
}
```

printDataメソッドを作成時にミスがあった
==this.getName()== や ==this.getColor()== の箇所にて
this ではなく bicycle.メソッド名で記述していた。
printData呼び出し時の頭に、==bicycle.printData== と入力するので
thisで明示しなければならない。

``` java
public void printData() {
  System.out.println("【自転車の情報】");
  System.out.println("名前：" + this.getName());
  System.out.println("色：" + this.getColor());
}
```

***
#### 4/10 走行距離追加
Main.java
```java
class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    //System.out.println("【自転車の情報】");
    //System.out.println("名前：" + bicycle.getName());
    //System.out.println("色：" + bicycle.getColor());
    
    bicycle.printData();
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  // private String color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

上記作成時に問題はなかった
オラクル内にあった記述を試すと正常に動作した
``` java
private String name, color;
```
***
#### 5/10 自転車を走らせる
Main.java
```java
class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    //System.out.println("【自転車の情報】");
    //System.out.println("名前：" + bicycle.getName());
    //System.out.println("色：" + bicycle.getColor());
    
    bicycle.printData();
    System.out.println("-----------------");
    bicycle.run(10);
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```


上記作成時に以下のミスがあった
``` java
// 以下は正解
public void run(int distance) {
  System.out.println(distance + "km走ります");
  System.out.println("走行距離：" + distance + "km");
}

// 以下がミス
// メソッド定義時に返す値がないのに「int」を書いていた
public int run(int distance) {
  System.out.println(distance + "km走ります");
  System.out.println("走行距離：" + distance + "km");
}
```
***

#### 6/10 走る距離を入力させる
Main.java
```java
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    //System.out.println("【自転車の情報】");
    //System.out.println("名前：" + bicycle.getName());
    //System.out.println("色：" + bicycle.getColor());
    
    bicycle.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int i = scanner.nextInt();
    bicycle.run(i);
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

上記作成時に以下のミスがあった
変数宣言時に「public」を入れていた
「scanner.next()」は==文字列のみ受け付けるが、整数などは受け付けない==完全に忘れていた。
``` java
// 以下が正解
int i = scanner.nextInt();

// 以下が間違い
public int i = scanner.next();
```

入力受付時のスキャナーはおそらく、Main.javaに「import」で
外部ライブラリを呼び出しても他のファイル、「Person.java」「Bicycle」などの別ファイルで scanner.text() が使えない
試したがダメだった
***

#### 7/10 Carクラス作成

Main.java
```java
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    
    bicycle.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int i = scanner.nextInt(); 
    bicycle.run(i);
    
    System.out.println("=================");
    Car car = new Car("フェラーリ", "赤");
    car.printData();
  }
}
```

Car.java
```java
class Car {
  private String name, color;
  private int distance;
  
  Car(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run() {

  }
  
  public void printData() {
    System.out.println("【車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

Carクラス作成時に以下のミスがあった
コンストラクタ作成時にクラス名と同じ様に名前を明記すること
``` java
//以下のコンストラクタが正解
Car(String name, String color){
 this.name = name;
 this.color = color;
}

//以下のコンストラクタが間違い
car(String name, String color){
 this.name = name;
 this.color = color;
}
```

***
#### 8/10 ガソリン残量を表示
Main.java
```java
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    
    bicycle.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int i = scanner.nextInt(); 
    bicycle.run(i);
    
    System.out.println("=================");
    Car car = new Car("フェラーリ", "赤");
    car.printData();
  }
}
```

Car.java
```java
class Car {
  private String name, color;
  private int distance;
  private int fuel = 100;
  
  Car(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run() {

  }
  
  public int getFuel() {
    return this.fuel = fuel;
  }
  
  public void printData() {
    System.out.println("【車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
    System.out.println("ガソリン量：" + this.getFuel() + "L");
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

上記作成時にミスはなかったが、ここまでにセミコロンが抜けていることが多くあった。==いいかげん気をつけないといけない。==
***
#### 9/10 車を走らせる
Main.java
```java
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    
    bicycle.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int i = scanner.nextInt(); 
    bicycle.run(i);
    
    System.out.println("=================");
    Car car = new Car("フェラーリ", "赤");
    car.printData();
    
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int b = scanner.nextInt();
    car.run(b);
  }
}
```

Car.java
```java
class Car {
  private String name, color;
  private int distance;
  private int fuel = 100;
  
  Car(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    if (fuel > distance) {
      this.distance += distance;
      this.fuel -= distance;
      System.out.println(distance + "km走ります");
      System.out.println("走行距離：" + this.distance + "km");
      System.out.println("ガソリン量：" + this.fuel + "L");
    } else {
      System.out.println(distance + "km走ります");
      System.out.println("ガソリンが足りません");
      System.out.println("走行距離：" + this.distance + "km");
      System.out.println("ガソリン量：" + this.fuel + "L");
    }
  }
  
  public int getFuel() {
    return this.fuel = fuel;
  }
  
  public void printData() {
    System.out.println("【車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
    System.out.println("ガソリン量：" + this.getFuel() + "L");
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name, color;
  private int distance;
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  
  public String getColor() {
    return this.color = color;
  }
  
  public int getDistance() {
    return this.distance = distance;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
  }
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
  }
}
```

上記作成時に以下の注意点がある
carのrunメソッドに引数として変数を書いているが、これは
あくまでrunメソッド内でのみの扱い
``` java
// mainにて以下を記述
int b = scanner.nextInt();
car.run(b);

// carにて以下を記述
public void run(int distance) {
 if (fuel > distance) {
}
```
***
