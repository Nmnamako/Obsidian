#### ActiveStorage使用方法
コンソール内で以下実行
```
rails active_storage:install
```
インストール実行後 db/migrateのディレクトリ内に
マイグレーションファイルが作成されている

ファイルが確認できたら以下実行
```
rails db:migrate
```

マイグレート完了後以下をモデルに追加
```ruby
class List < ApplicationRecord
  has_one_attached :image
end
```
上記でListの「title」「body」のほかに「image」カラムが追加される

```java
<%= f.file_field :image, accept: "image/*" %>
```
上記でカラムに画像を保存する

```ruby
private
  def list_params    params.require(:list).permit(:title, :body, :image)  end
```
画像を保存を許可するためにパラメータに「:image」を追加
