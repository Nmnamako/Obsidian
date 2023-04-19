#### 1/12 目標物確認
Progate 4 Java にて作成した記述を継承する
Progate参照
***

#### 2/12 継承
現在作成した記述内容は「車」と「自転車」だが
中身が被っている
``` java
//以下のコードはCarとBycycleと被っている
class Car {
 private String name, color;
 private int distance;

 public void printData(){
  // 処理内容
 }
}
```
現状だと「修正・改善」などで手間がかかる
この問題を「継承」で解決する。

重複している内容を、Vehicleクラス(乗り物)に定義し、
そのクラスをCarクラスとBicycleクラスに引き継げれば
重複をなくすことができる。以下は用語に当たる。

**スーパークラス**
継承されるクラスを「スーパークラス」と呼ぶ。

**サブクラス**
継承し、作成するクラスを「サブクラス」と呼ぶ

今回は「Vehicle」が「スーパークラス」
「CarとBicycle」が「サブクラス」になる

継承方法は以下の通り

スーパークラス.java
``` java
class スーパークラス名 {
 //重複しているコードを記載
}
```

サブクラス.java
``` java
class サブクラス extends スーパークラス {
 //重複しているコードをスーパークラスへ移動
}
```


Main.java
```java
class Main {
  public static void main(String[] args) {
    Car car = new Car();
    Bicycle bicycle = new Bicycle();
  }
}

```

Vehicle.java
```java
class Vehicle {
  private String name;
  private String color;
  private int distance = 0;

  public String getName() {
    return this.name;
  }
  public String getColor() {
    return this.color;
  }
  public int getDistance() {
    return this.distance;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("色：" + this.color);
    System.out.println("走行距離：" + this.distance + "km");
  }
}
```

Car.java
```java
class Car extends Vehicle {
 //重複コードはスーパークラスに移動
}
```

Bicycle.java
```java
class Bicycle extends Vehicle {
 //重複コードはスーパークラスに移動
}
```

***
#### 3/12 スーパークラスのメソッド
Main.java
```java
class Main {
  public static void main(String[] args) {
    Car car = new Car();
    
    car.setName("フェラーリ");
    
    car.setColor("赤");
    
    Bicycle bicycle = new Bicycle();

    bicycle.setName("ビアンキ");
    
    bicycle.setColor("緑");
    
    System.out.println("【車の情報】");
    car.printData();

    System.out.println("=================");
    System.out.println("【自転車の情報】");
    bicycle.printData();
  }
}

```

Vehicle.java
``` java
class Vehicle {
  private String name;
  private String color;
  private int distance = 0;

  public String getName() {
    return this.name;
  }
  public String getColor() {
    return this.color;
  }
  public int getDistance() {
    return this.distance;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("色：" + this.color);
    System.out.println("走行距離：" + this.distance + "km");
  }
}
```

Car.java
```java
class Car extends Vehicle {
}
```

Bicycle.java
```java
class Bicycle extends Vehicle {
}
```

上記作成時に問題はなかった

***
#### 4/12 サブクラスのカスタマイズ
Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Car car = new Car();
    car.setName("フェラーリ");
    car.setColor("赤");
    Bicycle bicycle = new Bicycle();
    bicycle.setName("ビアンキ");
    bicycle.setColor("緑");

    System.out.println("【車の情報】");
    car.printData();
    
    System.out.println("ガソリン量：" + car.getFuel() + "L");
    
    System.out.println("-----------------");
    System.out.print("給油する量を入力してください：");
    int litre = scanner.nextInt();
    
    car.charge(litre);

    System.out.println("=================");
    System.out.println("【自転車の情報】");
    bicycle.printData();
  }
}

```

Vehicle.java
``` java
class Vehicle {
  private String name;
  private String color;
  private int distance = 0;

  public String getName() {
    return this.name;
  }
  public String getColor() {
    return this.color;
  }
  public int getDistance() {
    return this.distance;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("色：" + this.color);
    System.out.println("走行距離：" + this.distance + "km");
  }
}
```

Car.java
```java
class Car extends Vehicle {
  private int fuel = 50;
  
  public int getFuel() {
    return this.fuel = fuel;
  }
  
  public void charge(int litre) {
    System.out.println(litre + "L給油します");
    if (litre <= 0) {
      System.out.println("給油できません");
    } else if (litre + this.fuel >= 100) {
      System.out.println("満タンまで給油します");
      this.fuel = 100;
    } else {
      this.fuel += litre;
    }
    System.out.println("ガソリン量：" + this.fuel + "L");
  }
  
}

```

Bicycle.java
```java
class Bicycle extends Vehicle {
}
```

上記作成時に以下のミスがあった（すぐ解決した）
getFuel()メソッドはサブクラスであるCarに作られている。
getFuel()呼び出し時に頭に「car」をつける必要がある
``` java
// 以下正解
System.out.println("ガソリン量：" + car.getFuel() + "L");

// 以下間違い
System.out.println("ガソリン量：" + getFuel() + "L");
```

***