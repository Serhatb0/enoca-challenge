# 1-MVC kavramını açıklar mısınız ? Neden ihtiyaç duyuluyor. Java’da nasıl kurgulanıyor.Object Oriented katmanları nelerdir ? 

Mvc, uygulama geliştirmede kullanılan mimari tasarım desenlerinden (design pattern) biridir,
Mvc (Model-View-Controller), yazdığımız uygulamanın iş mantığı ile (business logic) kullanıcı arayüzünü birbirinden ayrıştıran, uygulamanın farklı amaçlara hizmet eden kısımlarının birbirine girmesini engelleyen yazılım mimarisidir. Bununla yazılan kodu daha rahat geliştirebilir ve test edilebilir (yani daha az hata çıkartma potansiyeline sahip) hale getirmiş oluruz.

## Model
Model, verilerin saklandığı katmandır. Genellikle veritabanı veya xml/json dosyası formatındadır. Veri katmanını uygulamadan ayrı tutar, böylece diğer katmanların veri katmanı ile doğrudan iş yapmasına gerek kalmaz.

Model, kendi içerisinde birden fazla katmandan oluşabilir. Bu projenin büyüklüğüne veya geliştiricinin planlamasına kalmış bir durumdur.

## View
View, istemcinin gördüğü arayüzü içeren katmandır (kullanıcıların gördüğü kısım, arayüz) genellikle Model katmanındaki verinin kullanılması ile oluşturulur. View katmanının Model ve Controller katmanlarından ayrılması ile arayüz değişikliklerinin uygulamanın diğer katmanlarını değiştirmeye gerek kalmadan yapılabilmesi sağlanmıştır.

View katmanında HTML5 ve CSS3 gibi son versiyon teknolojiler kullanmak mümkündür.

## Controller
Controller, istemciden gelen isteği işlemek, Model ve View katmanları arasında köprü olmak gibi görevleri yerine getirir. Controller içerisinde bir veya daha fazla Action olabilir, genellikle her Action bir web sayfası üretmek için kullanılır.


# Java'da MVC

**Model:** Uygulamanın Veri Katmanını temsil eder. Veri değiştirilirse Controller güncelleme mantığını da içerebilen verileri taşıyan bir nesnedir.

**View:** Uygulamanın sunum katmanını temsil eder. Modelin içerdiği verileri görselleştirmek için kullanılır.

**Controller:** Hem model hem de View üzerinde çalışır. Uygulama akışını, yani model nesnesindeki veri akışını yönetmek ve veriler değiştiğinde görünümü güncellemek için kullanılır.

Java Programlamada, Model basit Java sınıflarını içerir, View verileri görüntülemek için kullanılır ve Controller sunucu uygulamalarını içerir,
ayrıca Spring MVC’nin yapısı istek tabanlıdır. Kullanıcıdan gelen her istek DispatcherServlet tarafından karşılanmaktadır. Gelen istek  handleRequest sayesinde ilgili Controller’e gider sonrasında gösterilecek olan veri yani ViewResolver sayesinde gösterilmeye hazır hale gelmektedir. Bu sayede view tarafında istenilen her türlü teknolojiyi kullanmayı sağlamakta ve bize esneklik sağlamaktadır.

# Object Oriented katmanları 
- Soyutlama (Abstraction)
* Kapsülleme (Encapsulation)
+ Miras Alma (Inheritance)
- Çok Biçimlilik (Polymorphism)



# 2-Birbirinden bağımsız iki platformun birbiriyle haberleşmesi nasıl sağlanabilir. Örneğin, X platformu Java ile yazılmış olsun, Y platform u C# ile. Bu iki platformun bir biri ile iletişim halinde request-response ilişkisi kurması gerekiyor. Bu yapıyı nasıl sağlarız
## Bunu üç Sekilde Yapabiliriz ama Ben Burda Sadece 1.sini Anlatacam
1. Request — Response (HTTP istekleri)
2. gRPC (Protobuf serialization altyapısını kullanan gRPC, programlar arası iletişimi sağlayan bir RPC(Remote Procedure Call) yöntemidir.)
3. Event Driven

## Request — Response (HTTP istekleri)

### Senkron (Synchronous) İletişim

Senkron iletişim, bir servisten diğerine bir istek attığımız zaman, ilgili servisin bu isteği işleyip geriye sonuç dönene kadar ki süreyi bekleyip sonucu alıp yola devam edilen iletişim şeklidir. Yani client bir servise request atar. Bekler. Responseunu alır.  Yoluna devam eder. Response gelene kadar thread blocklanır. Dolayısıyla iletişim kuran iki tarafında ayakta olması gerekir. Bu da haliyle ciddi performans problemlerini ortaya çıkarabilir.

Bir Mikroservis , verisine ihtiyaç duyduğu başka bir servise, bir http client üzerinden istekte bulunur.
Bu mimari de adından da anlaşılacağı üzere bir service, verisine ihtiyaç duyduğu bir diğer servise doğrudan istekte bulunur. Servislerimizin modern Rest servisleri olduğunu kabul edersek yapılan istekler, GET, POST, DELETE ve UPDATE isteklerinden olacaktır.


### Asenkron (Asynchronous) İletişim

Asenkron iletişimde ise aslında bahsettiğim gibi, request atıldığında servisten cevabın dönmesi beklenmeden clientın işlerine devam ettiği ve response hazır olduğunda aldığı iletişim yapısıdır. Haliyle bu da bize oldukça performans kazandırır. Buradaki anahtar nokta client threadinin response dönene kadar blocklanmamasdır.

Asenkron Request — Response şu şekilde çalışır ilk olarak üretici kuyruğa bir mesaj gönderir,
Tüketici bu mesajı eşzamansız olarak işleyecektir.Tüketici mesajı işledikten sonra, bir cevap mesajı oluşturacak ve onu tamamen farklı bir kuyruğa gönderecektir. Üretici daha sonra cevap kuyruğundaki cevap mesajını tüketecektir.




# 3-Bir web sayfasında ekran sürekli Backend’ den veya bir başka yapı tarafından güncelleniyor. Siz, web sayfasını refresh etmeden bu güncel bilgiyi anlık ekrana nasıl yansıtırsınız

Bünü Yampanın Bir Çok Yolu Var Ben React'dan useState Hook'unu  Kullanarak Yapcam



![Screenshot (6)](https://user-images.githubusercontent.com/77425377/206822787-2cca3324-15ed-4cf4-aea3-aaf7b05439ed.png)


# 5- Firmada çalışman için sana remote bir linux server verildi. Elinde ip adresi port bilgisi kullanıcı adi ve şifren var. Server a erişimi nasıl test edersin, Server a nasıl erişirsin, Server a nasıl dosya atarsın, Serverdan nasıl dosya çekersin

SSH ile Bağlantı Yaparım

## SSH Nedir?

SSH (Secure Shell) ağ üzerinde güvenli iletişim kurmamızı sağlayan protokoldür, client/server mimarisi ile çalışır. SSH sayesinde server ve client arasında authentication, dosya transferi, ve uzak makineye göndereceğimiz komutlar şifrelenerek ağ üzerindeki ataklardan korunur


**ssh -p {port numarası} {kullanıcı adı}@{sunucu adresi}** Uzak sucunuya ssh ile bağlanmak için

## SSH İLE DOSYA TRANSFERİ

### Serverdan dosya çekmek

“enoca” diye bir kullanıcımız olsun ve kendi bilgisayarımıza kayıt yapacağız. enoca’da bulunan masaüstünde deneme.txt dosyasını bizim home dizinine kopyalayalım.

**scp alınacak-dosya-yeri nereye-kaydedecek**

**scp enoca@192.168.10.1:/home/enoca/Masaüstü/deneme.txt /home/**

bu adımdan sonra enoca root şifresini isteyecek. Şifre giriş başarılı ise kopyalama başarılıdır diyecek.

### Serverdan dosya atmak

scp enoca.txt enoca@192.168.10.10:/home/enoca/Masaüstü/deneme.txt


# 7- Apache Solr servisine yazılacak bir query örneği Apache Solr kullanılan sql programlarından daha farklı runtime bir database. Solr a hali hazırda kayıtlı bir alan olduğunu düşünelim. Alanın ismi “updatedAt” long tipinde tutulan bir alan. Ben 2020 Ocak ayından sonraki verileri getir dediğimde solr a nasıl bir query yazılmalı. http://example?query= kısmını nasıl doldurmalıyım?


http://example?query=updatedAt:[NOW TO NOW]&NOW=1577829420000




