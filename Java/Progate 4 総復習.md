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
