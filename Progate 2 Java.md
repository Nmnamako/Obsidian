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


### Java内でのif文と各構文
if () {
	System.out.println("xxxx");
} else if (条件) {
	System.out.println("xxxx");
}
上記でif文、else if の書き方

**switch文**
switch (条件) {
	case 値 1 :
		処理 1 ;
		break ;
	case 値 2 :
		処理 2 ;
		break ;
	case 値 3 :
		処理 3 ;
		break ;
}
caseの値が一致すれば処理を実行する
caseの横の==:(セミコロン)==に注意

**default**が存在するがRubyのelseと同じ
以下例文
switch (n) {
	case 1 :
		System.out.println("大吉");
		break;
	case 2 :
		System.out.println("吉");
		break;
	default :
		System.out.println("凶");
		break;
}

**while分**
以下while文の参考

int i = 1;
while (i <= 10) {
	System.out.println(i + "回目のループ");
	i++;
}

**for文**
以下for文の参考

for (int i = 1; i <= 10; i++) {
	System.out.println(i + "回目のループ");
}

for 内のi++の後に ; は不要に注意

**breakについて**
繰り返し処理を終了させるには、falseを渡すか
breakで強制終了を行う ifと組み合わせて扱うこともある
for (int i = 1; i <= 10; i++) {
	if (i > 5) {
		break;
	}
}
上記は if で i が6以上になったら強制終了

**continue**
対処の箇所の処理をスキップさせる

for (int i = 1; i <= 10; i++) {
	if(i % 3 == 0) {
		continue;
	}
	System.out.println( i );
}
上記は i が3の倍数の時処理をスキップする


### 配列について

