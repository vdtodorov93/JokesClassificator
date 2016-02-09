# JokesClassificator  
steps to run:  
-Make a mysql schema called "jokes"  
-in application.properties uncomment "hibernate.hbm2ddl.auto=create" so that the schema is automatically created and comment the one under it  
-You need Java 8  
-In eclipse download the plugin "Gradle Integration for Eclipse 3.7.2 RELEASE" (this is on Eclipse MARS)  
-Import the the WebCrawler project as a gradle project  
-Right click on project -> Gradle -> Refresh Dependencies  
-In application.properties set page_start and page_end. For example values 400 and 402 will crawl pages 400, 401 and 402 from the forum topic with jokes.  
Take note, that in current version crawling one page takes around 2 minutes. We need to run it during the night probably :D  
-You can start it as normal java application from the main in Application.java  
  
Aide ba4kaite sq i vie malko  
