### オブジェクト指向について
オブジェクトは、人間が「楽をするため」の工夫である

Progateでは、クラスとインスタンスを人間の振る舞い方で表している。
インスタンスは、情報と振る舞いを持っている。

クラスとインスタンスについて
インスタンスはオブジェクトの別名である

クラスはインスタンスの設計図である

設計図 = クラス
実態 = インスタンス

人間の情報と振る舞いは、==設計図であるクラスに定義する==
例：
「名前」「年齢」は情報
「挨拶をする」「歩く」は振る舞い

上記を持つ人間のインスタンスを作るのであれば、Personというクラスに
それらの情報と振る舞いを定義する。
※PersonはProgate内で扱っているクラス名のこと


### クラスの定義方法
```java
class クラス名 {

}
```
上記の様に記述すると==空のクラスが作成できる==

```java
class Main {
	public static void main(String[] args) {
		new Person();
		Person person = new Person();
		Person person1 = new Person();
		Person person2 = new Person();
	}
}
```
クラスからインスタンスを作成するには「new クラス名()」とする
```java
new Person();
```
上記で、Personクラスのインスタンスを作成

```java
Person person = new Person();
```
上記の様に、personの変数に代入することができる。
今までは変数を宣言する時に、データ型を宣言していたが、
今回は、Personでクラス宣言を行っている。

```java
Person person1 = new Person();
Person person2 = new Person();
```
上記の様に、インスタンスは１つのクラスから何個でも作成することが可能

**インスタンスフィールド**
インスタンスの情報に当たるものをそう呼ぶ
```java
class Person {
	public String name;
}
```
上記で、インスタンスフィールドの定義
==public データ型 変数名==
インスタンスフィールドも各インスタンスに属している。
```java
Person person1 = new Person();
person1.name = "Suzuki";
System.out.println(person1.name);
```
各インスタンスに属しているため上記の様に呼び出し、
代入する際も同様である。

**インスタンスメソッド**
振る舞いに当たるものをそう呼ぶ
インスタンスメソッドの定義法は
```java
public void hello() {
	System.out.println("こんにちは");
}
```
上記の様に行う
メソッドでは
```java
public static void hello() {

}
```
上記のような違いがある

Personクラスないでインスタンスメソッドを宣言したら
main.javaでは、
```java
person1.hello();
```
上記の様に、インスタンスメソッドを呼び出す際はperson1を頭につけなければいけない。
progateでは、==「クラスに定義しても、実際は各インスタンスに属している」
というイメージを持てとのこと==
person1に対してhello();メソッドを呼び出している状況

一連の流れのスクショ
![[スクリーンショット 2023-02-28 17.11.54.png]]

![[スクリーンショット 2023-02-28 17.12.10.png]]

### this
メソッド内でインスタンスフィールドにアクセスするには「this」を
使用する必要がある。

「this」はクラス内メソッドの定義の中でのみ使用可能
```java
class Person {
 public String name;
 public void hello() {
  System.out.println("こんにちは、私は" + this.name + "です");
 }
}
```
上記の様に「this」を使うと、そのメソッドが呼び出しているインスタンスに置き換えられる。

### コンストラクタについて
クラスには、コンストラクタなるものが存在する。
newを使ってインスタンスを生成した後に自動で
呼び出される特別なメソッド。

**コンストラクタ定義法**
コンストラクタにはルールがあり
1. コンストラクタ名はクラス名と同じでなければならない
2. 戻り値を書いてはいけない(voidも書かない)
```java
calss クラス名 {
 クラス名() {
  // インスタンスの生成時に行いたい処理
 }
}
```
上記でコンストラクタを定義する

person.java内での記述
```java
Person(String name) {
 System.out.println("インスタンスが生成されました");
 this.name = name;
}
```
Person(==String name==)を入れることで
main.java内で書いている
```java
Person person1 = new Person("Kate Jones");
```
("Kate Jones")をコンストラクタに移動させることが可能になる

以下はJava3にて作ったメソッド
firstName変数はmainにて作成
```java
class Person {
 public static String fullName(String firstName...) {
  return firstName + ...;
 }
}
```

以下はJava4にて作ったメソッド
```java
class Person {
 public String firstName;
 public String fullName() {
  return this.firstName + ...;
 }
}
```


Progateの課題では以下のように記述
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
  
  // printDataメソッドを定義してください
  public void printData() {
    System.out.println("私の名前は" + fullName() + "です");
    System.out.println("年齢は" + this.age + "歳です");
    System.out.println("BMIは" + Math.round(bmi()) + "です");
  }
}
```
thisを抜いたfirstNameだと出力結果は「null」で帰ってきた

```java
public void printData() {}
```
ここのデータ型は戻り値がないので「void」にしている
[[Progate 3 Java]]にてメソッドの作り方が載っている


Main.javaにはいかが記述されている
```java
class Main {
  public static void main(String[] args) {
    Person person1 = new Person("Kate", "Jones", 27, 1.6, 50.0);
    
    person1.printData();
  }
}
```

### クラスフィールドについて
クラスに属するクラスフィールドが存在する
クラスフィールドは「static」をつける
```java
class Person {
 public static データ型 変数名 ;
}
```

**クラスフィールドの具体例**
Progateではインスタンスを作成した数を数えるために「count」という
フィールドで、インスタンスの生成数を保存するコードを作った。
また、countは個々のインスタンスにあるのではなく
大元のクラスの中に含めればいい。

Progateでは以下のようにクラスフィールドを作成
```java
class Person {
 public static int count = 0;
}
```

**オーバーロード**
※インスタンスフィールドに戻る
Progateでは、インスタンスにmiddleNameというフィールドを持たせた
[[Progate 4 Java### クラスの定義方法]]

ただし、コンストラクタの引数に不用意にmiddleNameを追加すると
middleNameを持たない対処であった場合インスタンスを生成時に
エラーが発生してしまう。(引数が6個必要なのに、5個しか登録してない
場合などがある)

コンストラクタは以下の箇所
```java
1.  class クラス名 {
3.   //コンストラクタ（インスタンス生成時に実行される）
4.   public クラス名(){
5.    初期化処理など
6.   }
7.  }
```

middlename追加は、
```java
class Person {
 public String middleName;
 Person(String firstName, String middleName, String lastName...);
}
```

上記の問題を解決するのが、オーバーロード
```java
Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  
  // middleNameを受け取るコンストラクタを定義してください
  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
```
上記のように2つのコンストラクタを作成することで、
オーバーロードさせる。

しかし、上記のやり方だと「firstName」などの変数名を変更する場合
2つのコンストラクタを変更しなければならない。
この問題を解決するのが以下のコード
```java
Person(String firstName, String lastName, int age, double height, double weight) {
    Person.count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
  
  // middleNameを受け取るコンストラクタを定義してください
  Person(String firstName, String middleName, String lastName, int age, double height, double weight) {
    
    this(firstName, lastName, age, height, weight);
    
    this.middleName = middleName;
  }
```
this();でPersonコンストラクタを呼び出し各変数を呼び出すことが可能

ちなみに、fullName();メソッドではif構文にてmiddleNameの中身がnullで
結果を分岐して対応

### カプセル化について
カプセル化とは、オブジェクト指向の重要な機能の一つで、
使い手に必要ないものを隠すことを指している。

カプセル化のイメージ
パソコンなど中の回路はフレームで隠されていおり
ユーザーはキーボードのみ操作することができている。
回路が露出している状態だと破損などのトラブルが起きる可能性がある。

Javaのカプセル化は、フィールドやメソッドへのアクセスを制限すること
クラスの外部からアクセス可能にするのは「public」
クラスの外部からアクセス不可にするのは「private」

フィールドのアクセス権をprivateにすると、フィールドにクラスの外から
アクセスすることができない。
==クラス内であれば、privateでも、アクセス可能==

private,publicどちらでコードを書くか迷うがProgateでは

フィールド...private
メソッド...public

****
**ゲッター**
privateにしたフィールドの情報を取り出すため
フィールドの値を返すだけのメソッドを定義する。
これを「ゲッター」と呼ぶ。
「getフィールド名」とすることが一般的
Progateでは以下を作成

Person.java
```java
public String getMiddleName() {
 return this.middleName;
}
```

Main.java
```java
System.out.println("person2のミドルネームは" + person2.getMiddleName() + "です");
```

****
**セッター**
フィールドをprivateに変更すると当然外部から中身を変更することも
できなくなる。
そこで、フィールドの値を変更するメソッドを作成する。
これを「セッター」と呼ぶ。
「setフィールド名」とすることが一般的

Main.java
```java
person1.setMiddleName("Claire");
```

Person.java
```java
private String middleName;

public void setMiddleName(String middleName) {
 this.middleName = middleName;
}
```

****
