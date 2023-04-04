#### 1/11 実際の挙動
どのように動いているか確認
Progate参照
***

#### 2/11 文字列表示
```java
class Main {
  public static void main(String[] args) {
    System.out.println("名前はKate Jonesです");
  }
}

```

***
#### 3/11 入力受け取り
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("名前：");
    String firstName = scanner.next();
    
    System.out.println("名前は" + firstName + "です");
  }
}

```

スキャナー関連の記述が記憶定着していなかった。
やることは記憶できているが、
書き入れる内容が思い出せていない
***
