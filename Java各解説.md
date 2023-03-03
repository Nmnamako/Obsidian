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
