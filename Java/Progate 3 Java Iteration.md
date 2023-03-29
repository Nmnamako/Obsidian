#### 1/13 メソッドとクラス
```java
class Main {
 public static void main(String[] args){
  hello();
 }

 public static void hello() {
  System.out.println("Hello Java");
 }
}
```
上記でhello()メソッドを構築し、mainメソッドでhello()メソッドを呼び出している。
***
#### 2/13 メソッドの定義
```java
class Main {
 public static void main(String[] args) {
  printData();
 }
 public static void printData() {
  System.out.println("私の名前はTEST1です");
 }
}
```

メソッドの定義方法が以下の通り
```java
class Main {
 public static void メソッド名(ブロック内) {処理}
}
```
メソッド定義は必ず**クラス内で行う**

***
#### 3/13 引数について
```java
class Main {
 public static void main(Strng[] args) {
  printData("test1");
  printData("test2");
 }
 public static void printData(String name){
  System.out.println("私の名前は" + name + "です")
 }
}
```

メソッドのブロックに「データ型」「仮引数名」を指定すると
その仮引数名に引数を渡すことができる。
```java
class Main {
 printData("test1");
 public static void printData(データ型 仮引数名) {
  // 処理内容
 }
}
```
***
