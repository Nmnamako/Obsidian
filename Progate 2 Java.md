### Javaでの真偽
Java内での真偽のデータ型は**boolean**

**比較演算子**
1 == 1  true 
1 == 2  false

1 != 1  false
1 != 2  true

真偽値は出力することも可能
System.out.println(true);
System.out.println(false);
System.out.println(6 + 2 == 5);  false
System.out.println(6 + 2 != 5);  true

変数初期化でも真偽値で評価することも可能
boolean bool = 1+1 == 2 ;

**代償比較**
x < y　　yの方が大きい
x <= y　  yの方が大きいまたは等しい
x > y　　xの方が大きい
X >= y　 xの方が大きいまたは等しい

**理論演算子**
&& かつ  
1つ目がこうであって「かつ」こっちもこうであれば
条件1 && 条件2
両方trueでないとtrue判定にならない

|| または
1つ目がこうであれば「または」こっちもこうであれば
条件1 || 条件2
どちらか片方がtrueであればtrue判定

! 〜でない
x = 20;
! ( x >= 30 )
xの値が30以上ではない場合は==true==
xの値が30以上であった場合は==false==


### Java内でのif文
if () {
	System.out.println("xxxx");
} else if (条件) {
	System.out.println("xxxx");
}
上記でif文、else if の書き方
