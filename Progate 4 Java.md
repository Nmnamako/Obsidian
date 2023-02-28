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
```
class クラス名 {

}
```
上記の様に記述すると==空のクラスが作成できる==

```
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
```
new Person();
```
上記で、Personクラスのインスタンスを作成

```
Person person = new Person();
```
上記の様に、personの変数に代入することができる。
今までは変数を宣言する時に、データ型を宣言していたが、
今回は、Personでクラス宣言を行っている。

```
Person person1 = new Person();
Person person2 = new Person();
```
上記の様に、インスタンスは１つのクラスから何個でも作成することが可能
