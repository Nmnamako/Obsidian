#### pluckメソッド
```ruby
モデル名.pluck(:カラム名)
```
データベースから直接データを取得できる

モデル名「owners」があるとする。
レコード内に「name」カラムが存在するとする。
「name」に「田中」「佐藤」「鈴木」「木村」があるとする。

```ruby
Owners.pluck(:name)
		↓
結果:[田中,佐藤,鈴木,木村]
```
上記のように配列として出力する。

```ruby
Owners.pluck(:id, :name)
		↓
結果:[[1,田中][2,佐藤][3,鈴木][4,木村]]
```
上記のように2つのカラムを指定すると両方を==二次元配列==で出力

[[https://pikawaka.com/ruby/array#%E4%BA%8C%E6%AC%A1%E5%85%83%E9%85%8D%E5%88%97%E3%81%A8%E3%81%AF%EF%BC%9F|二次元配列はここを参照]]

```ruby
Owner.pluck(:age)
		↓
結果:[23, 44, 65, 23] # 返り値

Owner.distinct.pluck(:age)
		↓
結果:[23, 44, 65] # 返り値
```
上記のように「distinct」メソッドを使うことで、重複する値を
取り除いてユニークの値を取り出すことができる。
#### whereメソッド
```ruby
モデル名.where("条件")
```
特定のレコードだけ取得したり、検索機能を実装したりするときに使用するメソッド

whereメソッドは「シンボル指定」「文字列指定」の二つの記述方法があるが、基本は「シンボル指定」でいい。

シンボル指定
```ruby
モデル名.where(カラム名: 条件)

User.where(name: "たけし")
		↓
結果:id:3, name:"たけし", age:25
```

文字列指定
```ruby
モデル名.where("カラム名 = 条件")

User.where("name = 'ぴっか'")
		↓
結果:id:3, name:"たけし", age:25
```

#### where.notメソッド
whereと一緒に使用し条件に合わないものを取り出す。
```ruby
User.where("gender != male")

users = User.where.not(gender: "male")
```
上記コードは、二つとも同じ

```ruby
  
users = User.where.not(gender: "male").where.not(age: nil)
```
繋げて使用することも可能

#### mapメソッド
配列の要素だけブロック内で処理を繰り返して、新しい配列を返す

```ruby
配列.map { |変数| 実行する処理 }

配列.map do |変数|
  実行する処理
end
```

```ruby
number = [1,2,3,4]

new_number = number.map{|n| n * 2 }
				↓
結果:[20,40,60,80]
```
上記のように配列内の要素の左から処理を行なっている。

配列以外にもハッシュなどでも使用可能
しかし、返り値は==「配列」==になるので注意
返り値をハッシュで返す場合は、==to_h==メソッドで返せる
```ruby
h = {BANANA: 100, ORANGE: 200, MELON: 300}

h.map{|key, value|[key.downcase, value]}.to_h
					↓
結果:{:banana=>100, :orange=>200, :melon=>300}
```
