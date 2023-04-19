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
