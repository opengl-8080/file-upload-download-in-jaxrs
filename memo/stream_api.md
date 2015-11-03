Why Streaming?
なぜ Streaming ？

The traditional API, which is described in the User Guide, assumes, that file items must be stored somewhere, before they are actually accessable by the user.
ユーザーガイドにあるような伝統的な API は、ユーザーが実際にファイルにアクセスする前に、ファイルアイテムをどこかに保存しなければならなかった。

This approach is convenient, because it allows easy access to an items contents. 
このアプローチは便利です。なぜなら、アイテムの内容に簡単にアクセスできるからです。

On the other hand, it is memory and time consuming.
言い換えると、これはメモリと時間のトレードオフです。

The streaming API allows you to trade a little bit of convenience for optimal performance and a low memory profile. 
Streaming API は、ほんのわずかな便利さと引き換えに、最適なパフォーマンスと少量なメモリを提供します。

Additionally, the API is more lightweight, thus easier to understand.
加えて、 API はより軽量で、理解するのが簡単です。



How it works
どのようにして使う？

Again, the FileUpload class is used for accessing the form fields and fields in the order, in which they have been sent by the client. However, the FileItemFactory is completely ignored.
再び、 FileUpload クラスが、クライアントから送られてくるフォームのフィールドにアクセスするために使われます。
しかしながら、 FileItemFactory はもう必要ありません。

Parsing the request
リクエストのパース

First of all, do not forget to ensure, that a request actually is a a file upload request.
まず最初に忘れてはいけないのは、リクエストが本当にファイルアップロードなのかということです。

This is typically done using the same static method, which you already know from the traditional API. 
これは典型的に、同じ static メソッドを使います。これは、伝統的な API として既にあなたは知っています。

Now we are ready to parse the request into its constituent items. Here's how we do it: 
いま、私たちはリクエストをパースする準備が整いました。ここに、どのようにするか書きます。

That's all that's needed. Really! 
必要なのはこれだけ！ 本当です！

