##### Progate課題
Main.java
```java
class Main {
  public static void main(String[] args) {

	//
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
  
  // インスタンスの生成時にフィールドに値をセットできるよう、コンストラクタを用意
  Bicycle(String name) {
    this.name = name;
  }
  
  // Mainクラスからnameフィールドの値を取得するためにゲッターを定義
  public String getName() {
    return this.name;
  }
}
```
### Progate課題2解説
Main.java
```java
class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    bicycle.printData();
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name;
  private String color;
  
  //printDataは元々作られておらず、Mainに出力をバラで書き込んでいた。
  //その際は、bicycle.getName()で書いていたが、
  //Bicycle.javaに移動させたため、this.getName()に変えている。
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
  }

  //Bicycleに情報を持たせるには以下必須
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
}
```

##### クラス
Main.java
```java
Person person = new Person();
person.hello();
```

Person.java
```java
class Person {
	public void hello() {
		System.out.println("こんにちは");
	}
}
```

##### メソッド
```java
public static void hello() {
 System.out.println("こんにちは");
}
```

### 引数を受け取るメソッド

main.Java
```java
printData("Kate Jones");
printData();
```

sub.java
```java
public static void printData(String name) {
 System.out.println("私の名前は" + name + "です");
}
```

### 複数の引数を受け取るメソッド
main.java
```java
printData("Kate Jones",26);
```

sub.java
```java
public static void printData(String name, int age) {
 System.out.println("私の名前は" + name + "です");
 System.out.println("年齢は" + age + "歳です");
}
```

### 戻り値のあるメソッド

returnがある場合は void ⇨ String や int などのデータ型に変更
```java
public static String fullName(String firstName, String lastName) {
 return firstName + " " + lastName;
}
```

### 同じメソッド名

1つ目のメソッド
```java
//出力場所
printData(fullName("Kate", "Jones"), 27);

public static String fullName(String firstName, String lastName) {
 return firstName + " " + lastName;
}
```

2つ目のメソッド
```java
//出力場所
printData(fullName("John", "Christopher", "Smith"), 65);

public static String fullName(String firstName, String middleName, String lastName) {
 return firstName + middleName + lastName;
}
```
