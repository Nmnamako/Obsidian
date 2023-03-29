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
