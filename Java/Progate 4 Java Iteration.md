#### オブジェクト指向
オブジェクトは「モノ」
指向は「〜を中心に」
Prpgate参照

***
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

    person1.hello();
    
    Person person2 = new Person();

    person2.hello();
    
  }
}
```

Person.java
```java
class Person {
  public void hello() {
    System.out.println("こんにちは");
  }
  
}
```


person1.hello();でメソッド呼び出し
ここでの問題はなかった

インスタンスメソッドを定義する方法は以下の通り
「static」が含まれていないが、後に解説とのこと
```java
class Person {
 public void hello() {
  System.out.println("こんにちは");
 }
}
```
***
#### 3/21 インスタンスフィールド
インスタンスフィールドは情報を格納する変数に過ぎない
その変数はクラスの一番上に定義する。

Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person();
    person1.hello();
    
    person1.name = "Kate Jones";
    
    System.out.println(person1.name);

    Person person2 = new Person();
    person2.hello();
    
    person2.name = "John Christopher Smith";
    
    System.out.println(person2.name);
    
  }
}

```

Person.java
```java
class Person {
  // インスタンスフィールドnameを定義してください
  public String name;

  public void hello() {
    System.out.println("こんにちは");
  }
}

```

インスタンスフィールドの定義方法は以下の通り
```java
class Person {
 public String name;
}
```

インスタンスフィールドに代入するには以下の通り
```java
person1.name = "test1";
```

インスタンスフィールドの出力方法は以下の通り
```java
System.out.println(person1.name);
```
***
#### 4/21 this

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person();
    person1.name = "Kate Jones";
    person1.hello();

    Person person2 = new Person();
    person2.name = "John Christopher Smith";
    person2.hello();
  }
}

```

Person.java
```java
class Person {
  public String name;
  public void hello() {
    System.out.println("こんにちは、私は" + this.name + "です");
  }
}

```

thisはクラス内のメソッドの定義の中でのみ使用可能
thisはメソッドが呼び出さレた時に、そのメソッドを**呼び出しているインスタンスに置き換えられる**
***
#### 5/21 インスタンスフィールドへの値セット
Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person();
    Person person2 = new Person();
  }
}

```

Perosn.java
``` java
class Person {
  public String name;

  // コンストラクタを定義する
  Person(){
    System.out.println("インスタンスが生成されました");
  }

  public void hello() {
    System.out.println("こんにちは、私は" + this.name + "です");
  }
}

```

コンストラクタとは
コンストラクタは、newを使ってインスタンスを生成した後に
**自動で呼び出される**特別なメソッド
コンストラクタの定義方法は以下の通り
``` java
class クラス名 {
 クラス名() {
  // インスタンス生成時に実行したい処理
 }
}
```
コンストラクタの定義方法は決まっている。
①コンストラクタ名はクラス名と同じにする
②戻り値を書いてはいけない(voidも書かない)
