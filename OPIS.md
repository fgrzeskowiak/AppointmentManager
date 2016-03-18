# ProjectSite
Jest to projekt strony polegającej na wyświetlaniu dodawanych przez użytkowników linków oraz głosowaniu na nie. Na potrzeby tego zaimplementowany został mechanizm rejestracji, logowania, dodawania nowych treści oraz głosowania.
Rejestrowany użytkownik jest automatycznie logowany. Dodawanie treści oraz głosowanie jest możliwe tylko dla zalogowanych użytkowników. Można oddać tylko jeden głos na dany link, pozytywny bądź negatywny. 

Do realizacji projektu wykorzystany został MySQL, Spring Framework JDBC oraz wzorzec DAO. Aplikacja uruchamiana jest na serwerze Tomcat.

Kody poszczególnych stron znajdują się w folderze "WebContent/WEB-INF/", kody servletów i klas odpowiedzialnych za komunikację z bazą danych znajdują się w folderze "src/com/projectsite/" 
