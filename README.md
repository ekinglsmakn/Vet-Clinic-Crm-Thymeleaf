
 <h2><b>Vet Clinic CRM </b></h2>
<p>Bu proje veteriner klinik işlemleri için geliştirilmiştir. Rol tabanlı bir yetkilendirme yapısı bulunmaktadır. Tanımlanan yetkiye göre sisteme, evcil hayvan sahibi veya evcil hayvan eklenebilmektedir. Var olan kayıtlar üzerinde güncelleme yapılabilir, silinebilir ve incelenebilir. Ayrıca evcil hayvan adı ya da hayvan sahibi adı üzerinden arama yapılabilmektedir.</p>

 
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
 
 
 
 
