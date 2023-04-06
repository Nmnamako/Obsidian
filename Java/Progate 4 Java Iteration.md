#### オブジェクト指向
オブジェクトは「モノ」
指向は「〜を中心に」
Prpgate参照

#### 1/21 クラスとインスタンス
Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person = new Person();
    person.hello();
  }
}

```

Person.java
```java
class Person {
  public void hello() {
    // 「こんにちは」と出力されるように書き換えてください
    System.out.println("こんにちは");
  }
}

```

Main.javaのクラス定義が何のために行うのかわからない
Person = クラス定義
person = 変数
new Person() = スキャナーみたく初期化している？
```java
Person person = new Person();
```

***
#### 2/21 インスタンスメソッド
Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person();
    // person1に対して、helloメソッドを呼び出してください
    person1.hello();
    
    Person person2 = new Person();
    // person2に対して、helloメソッドを呼び出してください
    person2.hello();
    
  }
}

```

Person.java
```java
class Person {
  // インスタンスメソッドhelloを定義してください
  public void hello() {
    System.out.println("こんにちは");
  }
  
}
```

person1.hello();でメソッド呼び出し
ここでの問題はなかった
***
