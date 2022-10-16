
 <h2><b>Vet Clinic CRM </b></h2>
<p>Bu proje veteriner klinik işlemleri için geliştirilmiştir. Rol tabanlı bir yetkilendirme yapısı bulunmaktadır. Tanımlanan yetkiye göre sisteme, evcil hayvan sahibi veya evcil hayvan eklenebilmektedir. Var olan kayıtlar üzerinde güncelleme yapılabilir, silinebilir ve incelenebilir. Ayrıca evcil hayvan adı ya da hayvan sahibi adı üzerinden arama yapılabilmektedir. Uygulama 8080 portunda çalışmaktadır</p>

 
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
 <img src="https://user-images.githubusercontent.com/36645298/196038614-c3c8b7ca-8767-4932-ada8-8a3f699be978.png" width="960" height="520" />
 <p>Spring Security ayarları için öncelikle <i>"pom.xml"</i> içine gerekli dependency'ler eklenmelidir. Gerekli configurasyon ayarları <i>"SecurityConfiguration"</i> klasörü altında <i>"WebSecurityConfig"</i> classı içinde yapılmıştır.</p>
 
 <hr/>
 
 <h3>Ana Sayfa</h3>
 <p>Ana Sayfada giriş yapan kullanıcının sahip olduğu kullanıcı adı ve rolü görünmektedir.</p>
 
 :diamonds: <b>Admin</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
 
  <img src="https://user-images.githubusercontent.com/36645298/196039342-8b42d0d9-2eb2-4c20-8c68-cb28aac8f520.png" width="960" height="520" /><br><br>

  :diamonds: <b>User</b> rolüne sahip kullanıcının giriş yaptığı ana sayfa
  
  <img src="https://user-images.githubusercontent.com/36645298/196039541-ae655355-e578-41a9-b38e-e198e7c9e66b.png" width="960" height="520" />
  
 


 
 
 
 
  
 


 
