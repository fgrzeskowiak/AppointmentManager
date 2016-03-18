# ProjectSite
Jest to projekt strony polegającej na wyświetlaniu dodawanych linków przez zalogowanych użytkowników oraz głosowania na 
nie. Na potrzeby tego zaimplementowany został mechanizm rejestracji, logowania, dodawania nowych treści oraz głosowania.
Rejestrowany użytkownik jest automatycznie logowany. Dodawanie treści oraz głosowanie jest możliwe tylko dla zalogowanych 
użytkowników. Można oddać tylko jeden głos na dany link, pozytywny bądź negatywny. 

Do realizacji projektu wykorzystany został MySQL, Spring Framework JDBC oraz wzorzec DAO. Aplikacja uruchamiana jest na 
serwerze Tomcat.

Kody poszczególnych stron znajdują się w folderze "WebContent/WEB-INF/", kody servletów i klas odpowiedzialnych za 
komunikację z bazą danych znajdują się w folderze "src/com/projectsite" 

W pakiecie "controller" znajdują się wszystkie servlety odpowiedziane za obsługę poszczególnych stron: głównej, logowania, 
rejestracji oraz mechanizmu głosowania. 

Pakiet "dao" zawiera wszystkie klasy wg wzorca DAO odpowiadające za komunkację z bazą danych.

W pakiecie "model" umieszczone są wszystkie klasy użytkownika, wrzuconego linku, oraz głosu.

Klasy w pakiecie "service" pośredniczą między servletami a fabrykami DAO.

Filtr zawarty w pakiecie "filter" sprawdza przed przejściem do każdej strony czy użytkownik się zalogował. Jeżeli tak, 
zapisuje go na poziomie sesji, pobierając go z bazy danych.

Pakiet "util" zawiera klasę odpowiedzialną za tworzenie połączenie z bazą danych.
