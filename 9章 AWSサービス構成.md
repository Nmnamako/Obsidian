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


1. 公式サイトのimage-magick-lambda-layerページにアクセスする
https://serverlessrepo.aws.amazon.com/applications/arn:aws:serverlessrepo:us-east-1:145266761615:applications~image-magick-lambda-layer

2. 「Deploy」をクリックする
3. バージョン画面が表示されるので、内容を読み右下のデプロイをクリックする

以上でレイヤーがデプロイされる


### Lambda関数作成方法
1. マネジメントコンソールで「AWS Lambda」を開く
2. 「関数の作成」を押下
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/8.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/8.png)

3. 作成したいLambda関数お情報を設定する

* 関数の作成：「一から作成」をクリックする
* 関数名：（任意の名前）を入力する
* ランタイム：「**Node.js 16.x**」を選択する
* 実行ロール：「**基本的なLambdaアクセス権限で新しいロールを作成**」を選択

4. 設定できたら「関数の作成」をクリック
これでLambda関数が作成される

次は、
「基本的なLambdaアクセス権限で新しいロールを作成」を選択する、デフォルトでCloudeWatch Logsへの書き込み権限が付与される。

この権限により、Lambda関数の変更履歴や実行結果がCloud Watch Logsへ保存される

権限に付与されているリソースは、「アクセス権限」で確認できる
「関数コード」欄には、サンプルコードが作成される

Lambda関数は、マネジメントコンソール上でテストできる

1. 「Test」プルダウンメニューの「Configure Test event」を選択
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/49.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/49.png)
2. 「イベント名」に任意の名前を入力し、「作成」を押下
3. 「Test」をクリックする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/51.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/51.png)
**Layers（Lambdaレイヤー）を使用する**
「レイヤーの追加」をクリック
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/39.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/39.png)
レイヤーで「バージョンARN」を確認しコピーする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/53.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/53.png)
1. 「ARNを指定」を選択する
2. 「ARNを指定」欄に、コピーしたバージョンARNを貼り付ける
3. 「追加」を押下
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/54.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/54.png)
**nude_moduleをアップロード**
使用するには、Node.jsのImageMagickモジュールをアップロードする必要がある
カリキュラムでは既存のモジュールを使用した
※以下Zipをダウンロードして、Lambdaにアップロードする
https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/zip_file.zip

1. 「アップロード元」のメニューで「.zipファイル」を選択する
2. 「.zip.file.zip」を選択し、「アップロード」する
※zipファイルを選択して「保存」すると、アップロードされる
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/56.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/56.png)
**Lambda関数のロールに、S3のアクセス権限を付与する**
Lambda関数のロールに、S3バケットへのアクセス権限を付与する
これによりIAMロールが作成され、Lambdaは該当ロールでS3にアクセスする
**AWSがAWSの他のサービスと連携する場合も、IAMロールや権限管理が必要になることを意識すること**
Lambda関数にアタッチされているロールは、「基本設定」で確認できる

1. 「実行ロール」のロール名をクリックする
	Lambda関数にアタッチされているロールに移動するため
	権限（ポリシー）を付与する必要がある

2. 「ポリシーをアタッチします」をクリックする
3. 「Amazon S3Full Access」を選択してアタッチする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/20.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/20.png)
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/21.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/21.png)
以上を行うとLambdaコンソールに戻ると、リソースの概要に「Amazon S3」が
追加されたことを確認できる。
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/22.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/22.png)
**トリガーを設定する**
ここでは「S3への画像アップロード」イベントが発生した時に、
Lambda関数が実行されるよう設定する

1. 「トリガーを追加」をクリックする

2. 以下の設定でトリガーを追加する
* トリガーの通知：「S3」を選択する
* バケット：「画像アップロード用のS3バケット」を選択する
* イベントタイプ：「PUT」を選択する
* サフィックス：「.jpg」を入力する
* トリガーの有効か：チェックをOFFにする

3. 設定できたら、「追加」をクリックする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/24.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/24.png)
作成したトリガーが表示される
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/25.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/25.png)
以上で完了


**関数コードを実装する**
Lambda関数を実装する

1. 「関数コード」欄に、以下のコードをコピーする
（「BUCKET NAME」は「リサイズ画像の保存用のS3バケット」で設定した名前に書き換えること）
※Lambda関数を作成した時に**Node.js**を選択したので、ここではJavascriptで実装する

関数コードを変更すると、右上の「Deploy」ボタンが有効になる

2. 「Deploy」をクリックして関数コードを保存する
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/26.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/26.png)

以下コピー
****

'use strict';
console.log('Loading function');
// 画像加工に必要なライブラリを読み込む
const fs = require('fs');
const im = require('imagemagick');
// プログラムからAWSサービスを操作できる開発キットの読み込み
const aws = require('aws-sdk');
const s3 = new aws.S3({ apiVersion: '2006-03-01' });
// Node.js の AWS Lambda 関数ハンドラ
exports.handler = (event, context, callback) => {
    // s3からobjectを取得（s3.getObject）するために必要な情報を取得
    const bucket = event.Records[0].s3.bucket.name;
    const key = decodeURIComponent(event.Records[0].s3.object.key.replace(/\+/g, ' '));
    const params = {
        Bucket: bucket,
        Key: key,
    };
    s3.getObject(params, (err, data) => {
        // param: err = s3からobjectの取得に失敗した場合、エラー情報が格納されている（存在しないファイルを取り出そうとしたした、など）
        // param: data = s3から取得したobjectが格納されている  
        if (err) {
        // s3.getObject 失敗
            console.log(err);
            const message = `Error getting object ${key} from bucket ${bucket}. Make sure they exist and your bucket is in the same region as this function.`;
            console.log(message);
            callback(message);
        } else {
        // s3.getObject 成功
        // data から必要な情報を取得
            const contentType = data.ContentType;
            const extension = contentType.split('/').pop();
            console.log(extension);
        // リサイズ処理実行
            im.resize({
                srcData: data.Body,
                format: extension,
                width: 100
            }, function(err, stdout, stderr) {
                if (err) {
                // リサイズ処理失敗
                    context.done('resize failed', err);
                } else {
                // リサイズ処理成功
                    const thumbnailKey = key.split('.')[0] + "-thumbnail." + extension;
                // リサイズされたファイルを、指定したバケットへ put する
                    s3.putObject({
                        Bucket: 'BUCKET_NAME',
                        Key: thumbnailKey,
                        Body: Buffer.from(stdout, 'binary'),
                        ContentType: contentType
                    }, function(err, res) {
                        if (err) {
                        // s3 put 失敗
                            context.done('error putting object', err);
                        } else {
                        // s3 put 成功
                            callback(null, "success putting object");
                        }
                    });
                }
            });
        }
    });
};

****

以上入力できたらテストを実行する

3. 「Configure Text event」を選択する
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/27.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/27.png)
4. 「新しいテストイベントの作成」を選択して「イベントテンプレート」に「Amazon S3 Put」を選択
[![](https://wals.s3-ap-northeast-1.amazonaws.com/curriculum/cloud/event_template_s3put.png)](https://wals.s3-ap-northeast-1.amazonaws.com/curriculum/cloud/event_template_s3put.png)
5. 「イベント名」に任意のイベント名を入力して、下記のコードを記述する

****

{
  "Records": [
    {
      "eventVersion": "2.0",
      "eventSource": "aws:s3",
      "awsRegion": "ap-northeast-1",
      "eventTime": "1970-01-01T00:00:00.000Z",
      "eventName": "ObjectCreated:Put",
      "userIdentity": {
        "principalId": "EXAMPLE"
      },
      "requestParameters": {
        "sourceIPAddress": "127.0.0.1"
      },
      "responseElements": {
        "x-amz-request-id": "EXAMPLE123456789",
        "x-amz-id-2": "EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH"
      },
      "s3": {
        "s3SchemaVersion": "1.0",
        "configurationId": "testConfigRule",
        "bucket": {
          "name": "BUCKET_NAME",
          "ownerIdentity": {
            "principalId": "EXAMPLE"
          },
          "arn": "arn:aws:s3:::BUCKET_NAME"
        },
        "object": {
          "key": "sample_1.jpg",
          "size": 1024,
          "eTag": "0123456789abcdef0123456789abcdef",
          "sequencer": "0A1B2C3D4E5F678901"
        }
      }
    }
  ]
}

****
"name"と"arn"のBUCKET NAMEには、「画像アップロード用のS3バケット」で
指定したバケット名を入力する。
"key"には、テスト用の画像（S3の準備でアップロードした画像）を指定する

これでアップロードのテストが完了した

6. 「Test」をクリックする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/29.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/29.png)
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/30.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/30.png)
7. S3バケットを確認する
画像欄に「リサイズ画像の保存用のS3バケット」で指定した画像名が表示されることを確認する

[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/31.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/31.png)
**エラーが出た場合の対処法**
「RunTimeError」が表示された場合は、以下の方法で対処する
* 大きい画像を扱いたい場合は、メモリ（MB）を増やす
	メモリサイズによって、課金が発生する

* 処理時間が足りない場合は、「タイムアウト」の時間を増やす
	無料、最大15分まで設定可能


1. 一般設定の編集をクリックする
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/32-1.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/32-1.png)
2. 基本設定の編集を行う
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/32.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/32.png)

**S3とLambdaの連携を確認する**
S3マネジメントコンソールから画像をアップロードすることで、
Lambda関数が動作するかどうかを確認する。

1. 任意の画像をS3マネジメント管理コンソールでアップロードする
	（アップロード先は「画像アップロード用のS3バケット」）

==カリキュラムでは「sample_2.jpg」というアップロードする==
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/34.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/34.png)

2. リサイズされた画像が保存されていることを確認する（保存先は「リサイズ画像の保存用のS3バケット」）
[![](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/35.png)](https://wals.s3-ap-northeast-1.amazonaws.com/uploads/CloudContents/chap07/img/35.png)
Lambdaの実践は以上。  
EC2（サーバー）を起動することなく、プログラムを動かすことができる。

