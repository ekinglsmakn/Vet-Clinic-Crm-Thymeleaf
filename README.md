
 <h2><b>Vet Clinic CRM </b></h2>
<p>Bu proje veteriner klinik işlemleri için geliştirilmiştir. Rol tabanlı bir yetkilendirme yapısı bulunmaktadır. Tanımlanan yetkiye göre sisteme, evcil hayvan sahibi veya evcil hayvan eklenebilmektedir. Var olan kayıtlar üzerinde güncelleme yapılabilir, silinebilir ve incelenebilir. Ayrıca evcil hayvan adı ya da hayvan sahibi adı üzerinden arama yapılabilmektedir. Uygulama 8080 portunda çalışmaktadır</p>

<h4>Uygulamada Kullanılan Teknolojiler</h4>
<ul>
   <li>Java Spring Boot</li>
   <li>Spring Security</li>
   <li>Spring Data JPA</li>
   <li>Maven Plugin</li>
   <li>PostgreSql</li>
   <li>Thymeleaf</li>
   <li>Bootstrap</li>
   <li>Html/Css</li>
   <li>Hibernate</li>
 </ul>
 <hr>

 
&emsp;&emsp;:diamonds:  Projede PostgreSql Veri Tabanı kullanılmıştır. ER Diyagramı aşağıdaki gibidir.
 
 
 <img src="https://user-images.githubusercontent.com/36645298/196031925-c06bcf30-0d35-4e80-aabd-b8b74f5dfeae.png" width="950" height="650"  />
 
 <p>Uygulama sistemine göre;  bir evcil hayvan sahibinin n adet evcil hayvanı olabilir ancak bir evcil hayvanın yalnıca bir adet sahibi olabilir. Yani <i>"Pet"</i> ve <i>"PetOwner"</i> tabloları arasında <b>"manyToOne - oneToMany"</b>ilişkisi vardır. </p>
 <p><i>"User"</i> ve <i>"Role"</i> tabloları arasında ise <b>"manyToMany"</b> ilişki vardır. Bu ilişkiye göre; bir kullanıcı birden fazla yetkiye sahip olabilir ve  bir yetki(rol) birden fazla kullanıcıya ait olabilir. Bu ilişki sonucunda veri tabanında <i>"users_roles"</i> adlı bir tablo daha oluşturulmuştur. </p>
 
:diamonds: Entity classları 
 <ul>
   <li>Pet</li>
   <li>PetOwner</li>
   <li>User</li>
   <li>Role</li>
 </ul>
 
:diamonds: Veri Tabanı Tabloları
  <ul>
   <li>Pet</li>
   <li>PetOwner</li>
   <li>User</li>
   <li>Role</li>
   <li>Users_Roles</li>
 </ul>
 
 <hr/>
 
 <h3>Login Sayfası</h3>
 <p>Spring Security'nin sağladığı default login sayfası customize edilerek aşağıdaki Login Sayfası oluşturulmuştur. Bu sayfaya uygulama ayağa kaldırıldıktan sonra web browser üzerinden <i><b>"http://localhost:8080/login"</b></i> url'i ile ulaşılabilmektedir.</p>
 
 <img src="https://user-images.githubusercontent.com/36645298/196038614-c3c8b7ca-8767-4932-ada8-8a3f699be978.png" width="1000" height="530"  />
 <p>Spring Security ayarları için öncelikle <i>"pom.xml"</i> içine gerekli dependency'ler eklenmelidir. Gerekli configurasyon ayarları <i>"SecurityConfiguration"</i> klasörü altında <i>"WebSecurityConfig"</i> classı içinde yapılmıştır.</p>
 
 <hr/>

 
 <h3>Ana Sayfa</h3>
 <p>Ana Sayfada giriş yapan kullanıcının sahip olduğu kullanıcı adı ve rolü görünmektedir.</p>
 
 :diamonds: <b>Admin</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
 
  <img src="https://user-images.githubusercontent.com/36645298/196039342-8b42d0d9-2eb2-4c20-8c68-cb28aac8f520.png" width="1000" height="530"   /><br><br>

  :diamonds: <b>User</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
  
  <img src="https://user-images.githubusercontent.com/36645298/196039541-ae655355-e578-41a9-b38e-e198e7c9e66b.png" width="1000" height="530"   />
  <hr/>
 
 
  <h3>Yetkilendirme ( Rol Bazlı Sistem )</h3>
  <p><b>"ADMIN"</b> rolüne sahip kullanıcı tüm yetkilere sahiptir. Hayvan ve Sahip ekleyebilir, silebilir, güncelleyebilir ve inceleyebilir. Ancak sadece <b>"USER"</b> rolüne sahip kullanıcıların yetkileri kısıtlanmıştır. Silme işlemi gerçekleştiremezler. Hem <b>"ADMIN"</b> hem de <b>"USER"</b> yetkisine sahip kullanıcılar da tüm yetkilere sahip olabilmektedir. <i>User</i> ve <i>Role</i> tabloları arasında <b>manyToMany</b> ilişki bulunduğu için bir kullanıcı aynı anda iki role sahip olabilmektedir.</p>
  
  &emsp;&emsp; :diamonds: <b>ADMIN</b> rolüne sahip kullanıcı tarafından görüntülenen evcil hayvan ve sahip sayfaları (Tüm butonlar aktif)
  
  <img src="https://user-images.githubusercontent.com/36645298/196268327-16265960-f5bb-40db-ada2-c9c54fe7a4b4.png" width="1000" height="530"  />
 
  <img src="https://user-images.githubusercontent.com/36645298/196268473-ee036673-82fd-42de-b337-651745b641c1.png" width="1000" height="530"  /><br><br>
  
  
  &emsp;&emsp; :diamonds: <b>USER</b> rolüne sahip kullanıcı tarafından görüntülenen evcil hayvan ve sahip sayfaları (Sil Butonunu göremezler)
  &emsp;&emsp;
  
  <img src="https://user-images.githubusercontent.com/36645298/196271411-7494767f-e809-4333-97d9-344e89dea7f1.png" width="1000" height="530"  />
  <img src="https://user-images.githubusercontent.com/36645298/196271468-856cd3bf-3ff4-4d7b-881a-a79a55ce90d2.png" width="1000" height="530"  /><br><br>
  
  <p><b>USER</b> rolüne sahip kullanıcılar menude yer alan (navbarda yer alan) <i>"Kullanıcılar"</i> sayfasına da erişemezler. Sistemdeki kayıtlı kullanıcılar ancak <b>ADMIN</b> rolüne sahip kullanıcılar görebilmektedirler. User rolündeki kullanıcı menudeki <i>"Kullanıcılar"</i> linkine tıklarsa "<i>"Access Denied"</i>" sayfasına yönlendirilirler. Bu sayfa 403 hatasının spring security ile customize edilmesi ile elde edilmiştir.</p>
  
   &emsp;&emsp; :diamonds: <b>USER</b> rolüne sahip kullanıcı tarafından görüntülenen menudeki <i>"Kullanıcılar"</i> linki<br>
    &emsp;&emsp;
   <img src="https://user-images.githubusercontent.com/36645298/196540240-3b0f7bb2-853c-4cfc-81c0-953f248d4caf.png" width="1000" height="530"  /><hr><br>
   
   
  
 <h3>Evcil Hayvan - Sahip İlişkisi </h3>
  &emsp; <p> :diamonds: Her evcil hayvanın bir sahibi olmak zorundadır. Ayrıntılı bilgilere hem evcil hayvan sayfasındaki <i>İncele</i> butonundan, hem de sahip listesi sayfasındaki <i>İncele</i> butonundan ulaşılabilmektedir. </p>
 
   <img src="https://user-images.githubusercontent.com/36645298/196046129-149bca02-4b37-422d-8b24-e525013267aa.png" width="1000" height="530"   /><br><br>
   <img src="https://user-images.githubusercontent.com/36645298/196046164-2f545009-5ad0-4534-a97d-1233ebc9ae68.png" width="1000" height="530"   />
   
   &emsp;<p> :diamonds: Eğer evcil hayvan eklenmiş fakat sahip ataması yapılmamışsa (sistemde sahipsiz görünüyorsa) incele butonuna tıklandığında aşağıdaki sayfa görüntülenecektir. Çünkü uygulamada kurulan mimariye göre her evcil hayvanın sahibi olmak zorundadır.</p>
   <img src="https://user-images.githubusercontent.com/36645298/196046183-9eb73ab5-48ca-4bbb-bda8-88584c8d6e15.png" width="1000" height="530"   /><hr>
   
  &emsp;<p> :diamonds:Yeni Evcil Hayvan Oluşturma </p><p>JPA save methodu ile oluşturulan kaydetme işlemidir.Form içerisinde evcil hayvan bilgileri alındıktan sonra <i>PetOwner</i> bilgileri açılır menu içerisinde listelenip sahip seçimi yapılmaktadır. Seçilen Sahibin id'si <i>Pet</i> tablosunda foreign key olduğu için evcil hayvanın sahibi de atanmış olmaktadır.</p>
  
   <img src="https://user-images.githubusercontent.com/36645298/196047259-b64e2147-2537-46f1-866a-77ada6f29179.png" width="1000" height="530"   /><hr>
    
  &emsp;<p> :diamonds:Var Olan Evcil Hayvanı Güncelleme</p><p>Güncellenecek olan data seçildiğinde id'sine göre veri tabanında bir karşılaştırma yapılır ve yeni veriler JPA save methodu ile tekrar kaydedilir</p>
    <img src="https://user-images.githubusercontent.com/36645298/196047311-6ed1de6e-464e-4836-ad44-8b72350c5906.png" width="1000" height="530"   /><hr>
    
  &emsp;<p> :diamonds:Yeni Sahip Oluşturma</p><p>Yeni sahip bilgileri form içerisinde alındıktan sonra JPA save methodu call edilir ve veritabanına kayıt işlemi yapılır.</p>
    <img src="https://user-images.githubusercontent.com/36645298/196047543-44f11608-58fc-4a80-a44b-a9489657c81f.png" width="1000" height="530"   /><hr>
    
  &emsp;<p> :diamonds:Sahip Güncelleme</p><p>Güncellenecek olan data seçildiğinde id'sine göre veri tabanında bir karşılaştırma yapılır ve yeni veriler JPA save methodu ile tekrar kaydedilir</p>
  <p></p>
    <img src="https://user-images.githubusercontent.com/36645298/196047624-daaf59b0-f701-46eb-94d2-67e01e955e00.png" width="1000" height="530"  /><hr>
    
  &emsp;<p> :diamonds:Hakkımızda Sayfası</p>
    <img src="https://user-images.githubusercontent.com/36645298/196047661-caa538c0-7d85-4b39-aa43-a8f6aae822bc.png" width="1000" height="530"   /><hr>
 

    




   
 

 


 
 
 
 
  
 


 
