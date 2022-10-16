
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
 
 
 <img src="https://user-images.githubusercontent.com/36645298/196031925-c06bcf30-0d35-4e80-aabd-b8b74f5dfeae.png" width="700" height="550" />
 
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
 <img src="https://user-images.githubusercontent.com/36645298/196038614-c3c8b7ca-8767-4932-ada8-8a3f699be978.png" width="970" height="520" />
 <p>Spring Security ayarları için öncelikle <i>"pom.xml"</i> içine gerekli dependency'ler eklenmelidir. Gerekli configurasyon ayarları <i>"SecurityConfiguration"</i> klasörü altında <i>"WebSecurityConfig"</i> classı içinde yapılmıştır.</p>
 
 <hr/>
 <br>
 
 <h3>Ana Sayfa</h3>
 <p>Ana Sayfada giriş yapan kullanıcının sahip olduğu kullanıcı adı ve rolü görünmektedir.</p>
 
 :diamonds: <b>Admin</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
 
  <img src="https://user-images.githubusercontent.com/36645298/196039342-8b42d0d9-2eb2-4c20-8c68-cb28aac8f520.png" width="970" height="520" /><br><br>

  :diamonds: <b>User</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
  
  <img src="https://user-images.githubusercontent.com/36645298/196039541-ae655355-e578-41a9-b38e-e198e7c9e66b.png" width="960" height="520" />
  <hr/>
  <br>
  
  <h3>Evcil Hayvan Sayfası</h3>
 <p>Menu bar yapısında bulunan <i> "Hayvan Listesi"</i> linki ile ulaşılan evcil hayvan sayfasında, veritabanında kayıtlı bulunan evcil hayvanlar listelenmektedir. Tabloda bulunan <i>"İncele"</i> butonu hariç; <i>"Kayıt Ekle", "Güncelle", "Sil"</i> butonları yalnızca <b>ADMIN</b> yetkisine sahip kullanıcılar tarafından görülebilmektedir. Sisteme <b>USER</b> olarak giriş yapan bir kişi bu butonlardan sadece <i>"İncele"</i> butonunu görebilmektedir. Bu durumda User olarak kimlik doğrulama yapan kişi ayrıntılı hayvan bilgilerine ulaşabilecek fakat ekleme, güncelleme ve silme işlemleri yapamayacaktır. </p>
 
 <img src="https://user-images.githubusercontent.com/36645298/196045356-9124f8ec-8b58-44b6-97ab-53e5d66689d2.png" width="960" height="520" />
 
  <hr/>
  <br>
  
   <h3>Sahip Sayfası</h3>
 <p>Menu bar yapısında bulunan <i> "Sahip Listesi"</i> linki ile ulaşılabilmektedir. bu sayfada veri tabanından çekilen evcil hayvan sahiplerinin bilgileri yer almaktadır. Bu sayfada da yetki bazlı işlemler bulunmaktadır. Tabloda bulunan <i>"İncele"</i> butonu hariç; <i>"Kayıt Ekle", "Güncelle", "Sil"</i> butonları yalnızca <b>ADMIN</b> yetkisine sahip kullanıcılar tarafından görülebilmektedir. Sisteme <b>USER</b> olarak giriş yapan bir kişi bu butonlardan sadece <i>"İncele"</i> butonunu görebilmektedir. Bu durumda User olarak kimlik doğrulama yapan kişi ayrıntılı hayvan bilgilerine ulaşabilecek fakat ekleme, güncelleme ve silme işlemleri yapamayacaktır. </p>
 
 <img src="https://user-images.githubusercontent.com/36645298/196045817-132b8371-1081-498c-a2d8-9dcec5d2e7eb.png" width="960" height="520" /><br>
 
  &emsp; <p> :diamonds: Her evcil hayvanın bir sahibi olmak zorundadır. Ayrıntılı bilgilere hem evcil hayvan sayfası incele butonundan, hem de sahip listesi sayfasındaki incele butonundan ulaşılabilmektedir. </p><br>
 
   <img src="https://user-images.githubusercontent.com/36645298/196046129-149bca02-4b37-422d-8b24-e525013267aa.png" width="960" height="520" /><br><br><br>
   <img src="https://user-images.githubusercontent.com/36645298/196046164-2f545009-5ad0-4534-a97d-1233ebc9ae68.png" width="960" height="520" /><br>
   
   &emsp;<p> :diamonds: Eğer evcil hayvan eklenmiş fakat sahip ataması yapılmamışsa (sistemde sahipsiz görünüyorsa) incele butonuna tıklandığında aşağıdaki sayfa görüntülenecektir. </p><br>
   <img src="https://user-images.githubusercontent.com/36645298/196046183-9eb73ab5-48ca-4bbb-bda8-88584c8d6e15.png" width="960" height="520" /><br>



   
 

 


 
 
 
 
  
 


 
