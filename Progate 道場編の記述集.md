
Main.java
```java
// importで入力を読み込み
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Bicycle bicycle = new Bicycle("ビアンキ", "緑");
    System.out.println("【自転車の情報】");
    bicycle.printData();
    System.out.println("-----------------");

	// ここでScannerの初期化を行う
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("走る距離を入力してください：");
    int i = scanner.nextInt();
    bicycle.run(i);
  }
}
```

Bicycle.java
```java
class Bicycle {
  private String name;
  private String color;
  private int distance = 0;
  
  public void printData() {
    System.out.println("【自転車の情報】");
    System.out.println("名前：" + this.getName());
    System.out.println("色：" + this.getColor());
    System.out.println("走行距離：" + distance + "km");
  }
  
  Bicycle(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public String getName() {
    return this.name = name;
  }
  public String getColor() {
    return this.color = color;
  }
  
  public void run(int distance) {
    System.out.println(distance + "km走ります");
    System.out.println("走行距離：" + distance + "km");
    // System.out.println(distance + "km走ります");
    // this.distance += distance;
    // System.out.println("走行距離：" + this.distance + "km");
  }
}
```
