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
