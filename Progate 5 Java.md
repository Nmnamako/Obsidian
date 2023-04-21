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
#### 5/12 メソッドのオーバーライド

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
    return this.fuel;
  }
  
  public void printData() {
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + this.getDistance() + "km");
    System.out.println("ガソリン量：" + this.getFuel() + "L");
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


上記作成時に以下を注意
以下のコードはスーパークラスに存在するprintDataメソッドを
上書きしている（オーバーライド）
CarクラスでprintDataメソッドを作成しているので、
名前や色などのインスタンスフィールドはprivateで作成されているので、ゲッターを使用しなければならない
Car.java
``` java
public void printData() {
 System.out.println("名前：" + this.getName());
 System.out.println("色：" + this.getColor());
 System.out.println("走行距離：" + this.getDistance() + "km");
 System.out.println("ガソリン量：" + this.getFuel() + "L");
}
```
***
#### 6/12 super


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
    return this.fuel;
  }

  public void printData() {
    // superを用いて、以下の重複部分を書き換える
    super.printData();
    //System.out.println("名前：" + this.getName());
    //System.out.println("色：" + this.getColor());
    //System.out.println("走行距離：" + this.getDistance() + "km");
    System.out.println("ガソリン量：" + this.fuel + " L");
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

上記作成時に問題はなかった
***
#### 7/12 コンストラクタとsuper()
Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Car car = new Car("フェラーリ", "赤");
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");

    System.out.println("【車の情報】");
    car.printData();
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
  
  // Vehicleクラスのコンストラクタを定義
  Vehicle(String name, String color) {
    this.name = name;
    this.color = color;
  }

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
  
  // Carクラスのコンストラクタを定義し、
  // superを用いてスーパークラスのコンストラクタを呼び出す
  Car(String name, String color) {
    super(name, color);
  }

  public int getFuel() {
    return this.fuel;
  }

  public void printData() {
    super.printData();
    System.out.println("ガソリン量：" + this.fuel + "L");
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
  // Bicycleクラスのコンストラクタを定義し、
  // superを用いてスーパークラスのコンストラクタを呼び出す
  Bicycle(String name, String color) {
    super(name, color);
  }
  
}

```

上記作成時に問題はなかった
以下に注意、スーパークラスのコンストラクタを呼び出すには
以下の通り。しかし、以下の記述を行なった際に「car.java」に書き込んだが「Bicycle.java」には以下の記述を入れず実行すると
エラーが発生した。
Vehicle.java
``` java
class Vehicle {
 Vehicle(String name, String color) {
  this.name = name;
  this. color = color;
 }
}
```

Car.java
``` java
class Car {
 Car(String name, String color) {
  //スーパークラスのコンストラクタを呼び出している。
  super(name, color);
 }
}
```

***
#### 8/12 protected

**protectedについて**
インスタンスフィールドをprivateにしているとサブクラスでも
アクセスすることができない。ゲッターやセッターを使わない限りは不可能。それ以外で解決するにはprivateではなくprotectedで
インスタンスフィールドを定義すること。
protectedは、==クラス内とサブクラスのみアクセス可能==にする。

Main.java
``` java
class Vehicle {
 // クラス内,サブクラスからアクセス可能
 protected int distance = 0;
}
```

Car.java
``` java
class Car {
 public void run(int distance) {
 // アクセス可能なので、エラーが起きない
  this.distance += distance;
 }
}
```

**以下アクセス権まとめ**
「public」
クラス内「○」サブクラス内「○」クラス、サブクラス外「○」

「private」
クラス内「○」サブクラス内「X」クラス、サブクラス外「X」

「protected」
クラス内「○」サブクラス内「○」クラス、サブクラス外「X」


Main.java
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Car car = new Car("フェラーリ", "赤");
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");

    System.out.println("【車の情報】");
    car.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int carDistance = scanner.nextInt();
    // runメソッドを呼び出して、引数にcarDistanceを渡す
    car.run(carDistance);
    
    System.out.println("-----------------");
    System.out.print("給油する量を入力してください：");
    int litre = scanner.nextInt();
    car.charge(litre);
    
    System.out.println("=================");
    System.out.println("【自転車の情報】");
    bicycle.printData();
    System.out.println("-----------------");
    System.out.print("走る距離を入力してください：");
    int bicycleDistance = scanner.nextInt();
    // runメソッドを呼び出して、引数にbicycleDistanceを渡す
    bicycle.run(bicycleDistance);
    
  }
}

```

Vehicle.java
``` java
class Vehicle {
  private String name;
  private String color;
  // privateからprotectedに変更
  protected int distance = 0;

  Vehicle(String name, String color) {
    this.name = name;
    this.color = color;
  }

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
public int getFuel() {
    return this.fuel;
  }

  public void printData() {
    super.printData();
    System.out.println("ガソリン量：" + this.fuel + "L");
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    if (distance <= this.fuel) {
      this.distance += distance;
      this.fuel -= distance;
    } else {
      System.out.println("ガソリンが足りません");
    }
    System.out.println("走行距離：" + this.distance + "km");
    System.out.println("ガソリン量：" + this.fuel + "L");
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
  Bicycle(String name, String color) {
    super(name, color);
  }

  public void run(int distance) {
    System.out.println(distance + "km走ります");
    this.distance += distance;
    System.out.println("走行距離：" + this.distance + "km");
  }
}

```

***
#### 9/12 抽象メソッドと抽象クラス
現状Vehicleは乗り物という大まかなクラスを作り
次にサブクラス（乗り物の種類）と構成している。
乗り物には走行距離のrun()メソッドを全て適用しなければならないが、乗り物ごとに走行方法が違うためスーパークラスにrun()メソッドが適用させずらい問題がある。
それを解決するために以下の方法がある。

**抽象メソッド**
抽象メソッドは、==処理が未定のメソッドを定義する==
抽象メソッドは、==中身の処理内容を書かない==
abstractは、「抽象的な」という意味
具体的な処理が決まっていないメソッドである。
また、抽象メソッドはサブクラスがそのメソッドを
==オーバーライドしなければエラーになる。==
あるサブクラスに、あるメソッドを必ず持たせたい場合は
スーパークラスに抽象メソッドとして定義することが大事。
``` java
class Vehicle {
 public abstract void run(int distance);
}
```

**抽象クラス**
クラス内で、抽象メソッドが==1つでも存在する場合==は、抽象クラスと呼ばれクラス名の前に「abstract」をつける必要がある。
また、抽象クラスからはインスタンスを作成できない。
抽象メソッドを持つ、抽象クラスは未完成である。
なので、未完成のクラスからはインスタンスを作成できない。

Vehicle.main
``` java
abstract class Vehicle {
  private String name;
  private String color;
  protected int distance = 0;

  Vehicle(String name, String color) {
    this.name = name;
    this.color = color;
  }

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
  
  // 抽象メソッドrunを定義
  public abstract void run(int distance);
  
}
```

上記作成で以下のミスがあった。
抽象メソッドを書く場合は {} が不要であり、セミコロンが必要
``` java
// 以下正解
public abstract void run(int distance);

// 以下間違い
public abstract void run(int distance) {

}
```

***
#### 10/12 クラス型のフィールド
乗り物の所有者を定義する記述
Java4で作った「person」を使用し所有者を定義する
インスタンスフィールドにクラス型の変数定義することで、
フィールドにインスタンスを持つことが可能
``` java
abstract Vehicle {

 //Person型のownerフィールドを追加
 private Person owner;
}
```

ownerフィールドがprivateなので、ゲッターとセッターが必要
クラス型なので書き方が少し変わる
``` java
abstract class Vehicle {

 //ゲッターはデータ型の箇所をクラス型にする必要がある
 public Person getOwner() {
  return this.owner;
 }

 //セッターは引数にクラス型(Person)が必要
 public void setOwner(Person person) {
  this.owner = person;
 }
}

```



Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);

    Car car = new Car("フェラーリ", "赤");
    // setOwnerを用いて、carの所有者をperson1にする
    car.setOwner(person1);
    
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    // setOwnerを用いて、bicycleの所有者をperson2にする
    bicycle.setOwner(person2);

    System.out.println("【車の情報】");
    car.printData();
    System.out.println("-----------------");
    System.out.println("【車の所有者の情報】");
    // getOwnerメソッドを用いてcarのownerを取得し、
    // さらにprintDataメソッドを用いてownerの情報を出力
    car.getOwner().printData();

    System.out.println("=================");
    System.out.println("【自転車の情報】");
    bicycle.printData();
    System.out.println("-----------------");
    System.out.println("【自転車の所有者の情報】");
    // getOwnerメソッドを用いてbicycleのownerを取得し、
    // さらにprintDataメソッドを用いてownerの情報を出力
    bicycle.getOwner().printData();
    
  }
}

```

Vehicle.java
``` java
abstract class Vehicle {
  private String name;
  private String color;
  protected int distance = 0;
  // インスタンスフィールドownerを定義
  private Person owner;

  Vehicle(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return this.name;
  }
  public String getColor() {
    return this.color;
  }
  public int getDistance() {
    return this.distance;
  }
  
  // ownerフィールドのゲッターを定義
  public Person getOwner(){
    return this.owner;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  public void setColor(String color) {
    this.color = color;
  }
  
  // ownerフィールドのセッターを定義
  public void setOwner(Person person) {
    this.owner = person;
  }

  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("色：" + this.color);
    System.out.println("走行距離：" + this.distance + "km");
  }

  public abstract void run(int distance);
}

```

上記作成時に以下のミスがあった
``` java
//セッターは以下が正解
public void setOwner(Person person){
 // 処理内容
}

// ゲッターの名残でデータ型をつけてしまっている。
//リターンがないのにvoidが抜けている。
public Person setOwner(Person person) {
 // 処理内容
}
```

考えてすぐ気づいたミス
このミスはゲッターが何を持ってくるか考えればすぐに解決した
``` java
//正解
bicycle.getOwner().printData();

//間違い
person2.getOwner().printData();
```
***
