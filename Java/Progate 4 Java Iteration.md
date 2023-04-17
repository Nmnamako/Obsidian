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
#### 13/21 クラスフィールド

**クラスフィールド**
クラスフィールドの定義は以下の通り
``` java
// クラスフィールド名
public static int count;
```
クラスフィールへのアクセスは以下の通り
``` java
クラス名.クラスフィールド名
```


**インスタンスフィールド**
インスタンスフィールドの定義は以下の通り
``` java
public String firstName;
```

**二つの違い**
定義位置：クラスフィールドはクラスレベルで定義され、
クラス内のどのメソッドからも直接アクセスすることができる。
一方インスタンスフィールドはインスタンスレベルで定義され
インスタンス(オブジェクト)が作成された際にそれぞれのオブジェクトに対して独立したメモリ領域に割り当てられる。

Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    
    Person person2 = new Person("John", "Smith", 65, 1.75, 80.0);
    person2.printData();
    
    // 「合計◯◯人です」と出力
    System.out.println("合計" + Person.count + "人です");
    
  }
}

```

Person.java
``` java
class Person {
  // int型のクラスフィールドcountを定義し、0を代入
  public static int count = 0;
  
  public String firstName;
  public String lastName;
  public int age;
  public double height, weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    // 変数countに1を足す
    Person.count++;
    
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
  
  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }
}

```

クラスフィールドでcountを定義しているので、
インスタンスが作成されるたびに、Person()コンストラクタが呼び出され、countが1足されていく
***
#### 14/21 クラスメソッド

クラスメソッドの定義は以下の通り
クラスフィールドと同じで、staticをつけるだけでいい
``` java
class Person {
 public static 戻り値の型 メソッド名() {
  //処理を記述
 }
}
```

Java3で作ったメソッドは全てクラスメソッド
``` java
class Main {
 public static void main(String[] args){
  Person.printCount();
  Person person1 = new Person(...);
  Person.printCount();
 }
}

//コンソール結果は以下の通り

```

Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    
    Person person2 = new Person("John", "Smith", 65, 1.75, 80.0);
    person2.printData();
    
    // printCountメソッドを呼び出す
    Person.printCount();
    
  }
}

```

Person.java
``` java
class Person {
  public static int count = 0;
  public String firstName, lastName;
  public int age;
  public double height, weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public String fullName() {
    return this.firstName + " " + this.lastName;
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  // クラスメソッドprintCount()を定義
  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
  
}

```


コード作成次に以下のコードミスがあった
this.countではクラスフィールドを呼び出せない
``` java
//正解
public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }

//間違い
public static void printCount() {
 System.out.println("合計" + this.count + "人です");
}
```

***
#### 15/21 コンストラクタのオーバーロード
コンストラクタのオーバーロードは
```java
Person person1 = new Person(....);
```
上記の様に、person1に引数を渡している。
引数の数や型が違えば同名のメソッドを定義することができる仕組み
``` java
Person(String name){
 //処理記述
}
Person(int number){
 //処理記述
}
```

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    
    // middleNameとして「Christopher」を追加
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();
    
    Person.printCount();
  }
}

```

Person.java
```java
class Person {
  public static int count = 0;
  public String firstName;
  // インスタンスフィールドmiddleNameを定義
  public String middleName;
  
  public String lastName;
  public int age;
  public double height, weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  
  // middleNameを受け取るコンストラクタを定義
  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public String fullName() {
    return this.firstName + " " + this.lastName;
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

***
#### 16/21 他のコンストラクタを呼び出す
コンストラクタをただオーバーロードすると
同じ内容のものが重複してしまう。
```java
Person(String firstName, String lastName, int age){
 this.firstName = firstName;
 this.lastName = lastName;
 this.age = age;
}

Person(String firstName, String middleName, String lastName, int age){
 this.firstName = firstName;
 this.middleName = middleName;
 this.lastName = lastName;
 this.age = age;
}
```
上記の様に、middleName以外が重複している。
この場合以下の様に記述すると記述量を減らせる
```java
Person(String firstName, String lastName, int age){
 this.firstName = firstName;
 this.lastName = lastName;
 this.age = age;
}

Person(String firstName, String middleName, String lastName, int age){
 this(firstName, lastName, age);
 this.middleName = middleName;
}
```
上記の様に、this(重複した引数)を書くと省略できる。
また、this()はコンストラクタの**先頭にしか記述できない**

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();
    Person.printCount();
  }
}

```

Person.java
```java
class Person {
  public static int count = 0;
  public String firstName;
  public String middleName;
  public String lastName;
  public int age;
  public double height, weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    // this()を用いて、コンストラクタを呼び出す
    this(firstName, lastName, age, height, weight);
    
    this.middleName = middleName;
  }

  public String fullName() {
    return this.firstName + " " + this.lastName;
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

***
#### 17/21 fullNameメソッドの中身について
firstName, lastName
firstName, midlleName, lastName
上記の様に引数の数が違うとfullNameメソッドがうまく動かない
正確にはmiddleNameの中身が表示されない。

解決方法としては以下の通り
``` java
if (middleName == null) {
 firstName + " " + lastName;
} else {
 firstName + " " + middleName + " " + lastName;
}
```
上記の様にif文で分岐させればOK
middleNameに値が無ければデフォルトで「null」が入れられる
初期値は以下の通り
``` java
String = null;
int = 0;
double = 0.0;
boolean = false;
```


Main.java
``` java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();
    Person.printCount();
  }
}

```

Person.java
```java
class Person {
  public static int count = 0;
  public String firstName;
  public String middleName;
  public String lastName;
  public int age;
  public double height;
  public double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    this(firstName, lastName, age, height, weight);
    this.middleName = middleName;
  }

  public String fullName() {
    // 以下を、middleNameがない場合とある場合で条件分岐を追加
    if (middleName == null) {
      return this.firstName + " " + this.lastName;
    } else {
      return this.firstName + " " + this.middleName + " " + this.lastName; 
    }
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("身長は" + this.height + "mです");
    System.out.println("体重は" + this.weight + "kgです");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

***
#### 18/21 カプセル化
カプセル化は、フィールドやメソッドへのアクセスを
制限すること
クラスの外部からアクセスできる様にするのは「public」
その逆が「private」

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();
    Person.printCount();
  }
}

```

Person.java
```java
class Person {
  // 以下をすべてprivateなフィールドに書き換えてください
  private static int count = 0;
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;
  private double height;
  private double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    this(firstName, lastName, age, height, weight);
    this.middleName = middleName;
  }

  public String fullName() {
    if (this.middleName == null) {
      return this.firstName + " " + this.lastName;
    } else {
      return this.firstName + " " + this.middleName + " " + this.lastName;
    }
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

***
#### 19/21 ゲッター
カプセル化で情報を直接取り出すことはできない
``` java
Person2.middleName;
```

カプセル化されたフィールドから情報を取り出すには
ゲッターという情報を取り出すためだけのメソッドを
作る必要がある
``` java
public String getMiddleName(){
 return this.middleName;
}
```

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();

    System.out.println("----------------------");
    // person2に対して、getMiddleNameメソッドを呼び出し、「person2のミドルネームは◯◯です」と出力してください
    System.out.println("person2のミドルネームは" + person2.getMiddleName() + "です");
    
  }
}

```

Person.java
```java
class Person {
  private static int count = 0;
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;
  private double height;
  private double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    this(firstName, lastName, age, height, weight);
    this.middleName = middleName;
  }

  // middleNameフィールドのゲッターを定義
  public String getMiddleName() {
    return this.middleName;
  }

  public String fullName() {
    if (this.middleName == null) {
      return this.firstName + " " + this.lastName;
    } else {
      return this.firstName + " " + this.middleName + " " + this.lastName;
    }
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

***
#### 20/21 セッター
privateで定義されているフィールドに値を入れようとすると
ゲッター同様にそれ専用にメソッドを作らなければならない

Main.java
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    person1.printData();
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0);
    person2.printData();

    System.out.println("----------------------");
    // person1のmiddleNameフィールドの値に入れる
    person1.setMiddleName("Claire");
    
    System.out.println("ミドルネームを" + person1.getMiddleName() + "に変更しました");
    person1.printData();
  }
}

```

Person.java
```java
class Person {
  private static int count = 0;
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;
  private double height;
  private double weight;

  Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    this(firstName, lastName, age, height, weight);
    this.middleName = middleName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  // middleNameフィールドのセッターを定義
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String fullName() {
    if (this.middleName == null) {
      return this.firstName + " " + this.lastName;
    } else {
      return this.firstName + " " + this.middleName + " " + this.lastName;
    }
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

セッター定義時に以下のミスがあった
入力されたmiddleNameをメソッドに入る様にしないといけない
メソッドに入れる引数を指定していなかった
``` java
public void setMiddleName(){
 this.middleName = middleName;
}

//以下が正解
public void setMiddleName(String middleName) {
 this.middleName = middleName;
}
```

また、渡す値の記入方法のミスがあった
``` java
person1.middleName = setMiddleName("test1");

//以下が正解
person1.middleName = "test1";
```
***
#### 21/21 最終課題
Main.java
```java
class Main {
  public static void main(String[] args) {
    // 仕事を「医者」にしてください
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0, "医者");
    person1.printData();
    // 仕事を「教師」にしてください
    Person person2 = new Person("John", "Christopher", "Smith", 65, 1.75, 80.0, "教師");
    person2.printData();
    System.out.println("----------------------");
    // person1の仕事を「獣医」に変更してください
    person1.setJob("獣医");
    
    // 「person1の仕事を◯◯に変更しました」と出力されるようにしてください
    System.out.println("person1の仕事を" + person1.getJob() + "に変更しました");
    
    person1.printData();
  }
}

```

Person.java
```java
class Person {
  private static int count = 0;
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;
  private double height;
  private double weight;
  // インスタンスフィールド「job」を追加してください
  private String job;
  
  // コンストラクタを書き換えてください
  Person(String firstName, String lastName, int age, double height, double weight, String job) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.job = job;
  }
  
  // コンストラクタを書き換えてください
  Person(String firstName, String middleName, String lastName, int age, double height, double weight, String job) {
    this(firstName, lastName, age, height, weight, job);
    this.middleName = middleName;
  }

  public String getMiddleName() {
    return this.middleName;
  }
  
  // jobのゲッターを定義してください
  public String getJob() {
    return this.job;
  }


  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }
  
  // jobのセッターを定義してください
  public void setJob(String job) {
    this.job = job;
  }
  

  public String fullName() {
    if (this.middleName == null) {
      return this.firstName + " " + this.lastName;
    } else {
      return this.firstName + " " + this.middleName + " " + this.lastName;
    }
  }

  public void printData() {
    System.out.println("私の名前は" + this.fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(this.bmi()) + "です");
    // 「仕事は◯◯です」と出力してください
    System.out.println("仕事は" + this.job + "です");
    
  }

  public double bmi() {
    return this.weight / this.height / this.height;
  }

  public static void printCount() {
    System.out.println("合計" + Person.count + "人です");
  }
}

```

問題なく完了
復習して記憶定着を図ること
***
