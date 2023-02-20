#### AWS Lambda
仮想ネットワークをVPCとサブネットで構築してEC2インスタンスを起動し
nginxなどのミドルウェアやRubyなどのプログラミング言語をインストールしたが
Lambdaは、これらの環境を準備することなく、プログラムを用意するだけで
構築できるサーバーレスのサービス

#### サーバーレスについて
クラウドサービス特有の構造で、運用時に必要なサーバーの構築や保守などの管理をAWSに任せる仕組み。
多くは、可用性と耐障害性に対処する機能も追加されている。
「サーバーレスコンピューティング」「サーバーレスアーキテクチャ」と呼ばれる

プログラムだけ作れば、すぐにクラウド上で実行できる。
インフラの構築や運用にかかるコストを抑えられるので
開発者はプログラムの開発に集中できる。




#### AWSのサーバーレスサービス

**AWS Lambda**
サーバーの起動や管理なしで、コード(Lambda関数)を自動実行できるサービス

**Amazon Simple Storage Service(Amazon S3)**
高機能のストレージサービス（S3もサーバーレスサービスに分類される）

**Amazon Dynamo DB**
NoSQL（Not only SQL）型のデータベースサービス

**Amazon API Gateway**
APIの作成、配布、保守、監視、保護が行えるサービス


#### Lambdaの特徴
サーバーの起動や管理なしで、コード（Lambda関数）を自動実行できるサービス
コードのモニタリングやログの記録、システムのメンテナンス、容量のスケーリングなどの管理も自動的に行われる。

S3のイベントをトリガーにしてコードを実行したり、Amazon API Gatewayの
HTTPリクエストに応答してコードを実行するなど別のサービスと組み合わせることが可能である。

**Lambda使用料金**
Lambdaでは利用した分のみ料金が発生する。
関数へのリクエスト回数や実行時間によって課金される。
料金表は以下参照
https://aws.amazon.com/jp/lambda/pricing/

**Lambda無料枠**
100万件数/月の無料リクエスト、1ヶ月あたり最大320万秒のコンピューティング時間を利用できる。
詳細は以下参照
https://aws.amazon.com/jp/free/


#### Lambda管理コンソール
コンソールではいろんな設定が可能

**関数の概要**
* トリガー追加
指定したイベントが発生した場合、Lambda関数を実行する
例：「S3にファイルがアップロードされた」というイベントが発生した場合
ファイル名を変えて保存するコードを実行する。

* Layers
複数のLambda関数で、共通して使いたいコードを作成できる。
テンプレートか？

* 送信先のコード
Lambdaの実行結果に従って、次のアクション（他のサービスを実行するなど）を
指定することができる。
例：Lambda実行後、AWSのSNSサービス（メッセージ通知サービス）を
実行する。
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/1.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/1.png)
==設定 > アクセス権限==
アクセス権限では、Lambdaと他サービスとのアクセス許可を設定する
Cloud Watch Logsは、デフォルトで設定されている。

[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/2.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/2.png)

==モニタリング==
モニタリングでは、Lambdaに関するメトリクスをモニタリングする。
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/3.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/3.png)
==関数コード==
関数コードでは、ブラウザ上でLambda関数を記述できる。
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/4.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/4.png)

### AWS Lambda使用方法

処理の流れ
![](https://wals.s3-ap-northeast-1.amazonaws.com/curriculum/cloud/lambda_s3_process.png)

1. 画像をS3へアップロードする
2. S3に画像をアップロードすると、Lambda関数が実行される
3. アップロードされた画像をリサイズし、別のS3へ保存する

**以下カリキュラムの内容**
-   画像アップロード用のS3バケット（img-files-original）
-   リサイズ画像の保存用のS3バケット（img-files-resize）
Amazon S3バケットの名前は「グローバルで一意」でなければならない

作成例[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/44.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/44.png)

「画像アップロード用のS3バケット」 にテスト用の画像をアップロードして、Lambda関数との連携を確認できるようにしておく。

[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/45.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/45.png)
以上が事前準備

**Lambdaレイヤーを作成する**
コードやライブラリをあらかじめ用意（共通化）して、
Lambda関数に組み込めるサービス

![](https://wals.s3-ap-northeast-1.amazonaws.com/curriculum/cloud/lambda_layer.png)



