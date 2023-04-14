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

#### 6/21 コンストラクタ
newでインスタンスを作る際に「new クラス名()」の()には
引数を渡すことができ、その引数は呼び出される直後に
コンストラクタに受け渡される。


Main.java
```java
class Main {
  public static void main(String[] args) {
    // newの引数に「Kate Jones」を渡す
    Person person1 = new Person("Kate Jones");
    person1.hello();
    
    // newの引数に「John Christopher Smith」を渡す
    Person person2 = new Person("John Christopher Smith");
    person2.hello();
  }
}

```

Person.java
```java
class Person {
  public String name;

  // コンストラクタがString型の引数を受け取る
  Person(String name) {
    System.out.println("インスタンスが生成されました");
    // インスタンスフィールドnameに値をセット
    this.name = name;
    
  }

  public void hello() {
    System.out.println("こんにちは、私は" + this.name + "です");
  }
}

```

下記の記述でインスタンス生成時にインスタンスフィールドに
渡したい引数をセットする
``` java
Person perosn = new Person("test1");
```

コンストラクタでも、thisを用いてインスタンスを利用することができる。引数を受け取りさいは、**変数宣言が必要**
``` java
class Person {
 public String name;
 
 Person(String name) {
  this.name = name;
 }
}
```

***
#### 7/21 フィールドとコンストラクタ

Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person();
    Person person2 = new Person();
  }
}

```

Person.java
``` java
class Person {
  public String name;

  // コンストラクタを定義
  Person(){
    System.out.println("インスタンスが生成されました");
  }

  public void hello() {
    System.out.println("こんにちは、私は" + this.name + "です");
  }
}

```

インスタンスフィールド定義方法を忘れていた
``` java
public String name;
```


***
#### 8/21 インスタンスメソッド
Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);

    System.out.println(person1.fullName());
    System.out.println(person1.age);
    System.out.println(person1.bmi());
  }
}

```

Person.java
```java
class Person {
  public String name;

  // コンストラクタがString型の引数を受け取る
  Person(String name) {
    System.out.println("インスタンスが生成されました");
    // インスタンスフィールドnameに値をセット
    this.name = name;
  }

  public void hello() {
    System.out.println("こんにちは、私は" + this.name + "です");
  }
}

```
***
#### 9/21 本章は確認のためスキップ

#### 10/21 フィールドとコンストラクタ
Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    
    System.out.println(person1.firstName);
    System.out.println(person1.lastName);
    System.out.println(person1.age);
    System.out.println(person1.height);
    System.out.println(person1.weight);
  }
}

```

Person.java
```java
class Person {
  public String firstName;
  public String lastName;
  public int age;
  public double height;
  public double weight;
  
  Person(String firstName, String lastName, int age, double height, double weight) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}

```

***
#### 11/21 インスタンスメソッド(1)

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);

    System.out.println(person1.fullName());
    System.out.println(person1.age);
    System.out.println(person1.bmi());
  }
}

```

Person.java
```java
class Person {
  public String firstName;
  public String lastName;
  public int age;
  public double height;
  public double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  
  // fullNameメソッドを定義
  public String fullName() {
    return this.firstName + " " + this.lastName;
  }
  
  // bmiメソッドを定義
  public double bmi() {
    return this.weight / this.height / this.height;
  }
  
}

```

メソッド内にthisを入れなければならなかった

今回はインストラクタが存在するので、メソッドの()内には
何も記述する必要がない
また、Java3で作成したメソッドには「static」が入っていたが
今回は入れていない。（staticに関する説明はまだない）
``` java
class Person {
 public String name;
 
 Person(String firstName, String lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
 }

 public String fullName() {
  return this.firstName + " " + this.lastName;
 }
}
```
***
#### 12/21 インスタンスメソッド(2)
Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
  }
}

```

Person.java
```java
class Person {
  public String firstName;
  public String lastName;
  public int age;
  public double height;
  public double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public String fullName() {
    return this.firstName + " " + this.lastName;
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }
  
  // printDataメソッドを定義
  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }
  
}

```

thisを使えばメソッド内で、他のメソッドを呼び出すことが可能
``` java
class Person {
 public String firstName;
 public String lastName;

 Person(String firstName, String lastName){
  this.firstName = firstName;
  this.lastName = lastName;
 }
 public String fullName() {
  return firstName + " " + lastName;
 }

 public void printData() {
  System.out.println("名前は" + this.fullName() + "です。");
 }
}
```

***
