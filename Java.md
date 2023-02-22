#### Progate Java学習まとめノート

### 基礎
class Main {
  public static void main(String[] args) {
    System.out.println("**Hello Java**");
  }
}

上記で文字の出力が可能

System.out.println("");
「()の中身を出力せよ」という命令Rubyのputsに該当する

クラス部分
class Main

メソッド部分
public static void main(String[] args) 

処理部分
System.out.println("**Hello Java**");

クラスの中にメソッド、メソッドの中に処理がある

**Javaでは文の終わりに;(セミコロン)が必要**、なければ動かない
// でコメントアウトが書ける



### 数値について
System.out.println(); では文字はダブルクォーテーションが必要だが
**数値には必要ない**

System.out.println(2 + 3); このように計算も可能
System.out.println("2 + 3"); これで文字列にすることも可能Rubyと同じ

System.out.println(1 + 1); 足し算
System.out.println(1 - 1); 引き算
System.out.println(1 * 1); 掛け算
System.out.println(1 / 1); 割り算
System.out.println(1 % 1); 割り算（余り）
### 文字の連結について

Javaの文字連結はRubyと同じ
System.out.println("こんにちは" + "世界");
System.out.println("38" + "19");
System.out.println(38 + 19);
### データ型について

"Hellow world" = String型
StringのSは大文字

3 = int型　
intのiは小文字

変数宣言するには最初に**データ型**を示し変数名を書く
int  number;
String  name;

データ型を宣言してから変数に値を入れ込む
number = 3;
name = "Sato";

下記の様に変数定義と変数宣言を同時に行うことが可能
これを変数の初期化という
int number = 3;


