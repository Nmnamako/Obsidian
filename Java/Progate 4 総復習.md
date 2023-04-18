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

***
