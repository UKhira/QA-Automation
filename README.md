# QA-Automation
 Quality Assuarance Auomation done for a certain web as coursework

* You need a suitable IDLE for run this (what I used was InteliJ IDEA)

Open this project from it.

Tips:

* make sure you have installed Google Chrome on your pc and have a stable internet connection before run this 

* If you already have chrome installed Go to (src > main > java > team35QA.java and run the program.

* If chrome is not installed or you want to run automation using another browser follow below steps
   
+ Open pom.xml and change
 
  ![mv4](https://user-images.githubusercontent.com/106836713/236637682-b88d5425-82a6-4d3f-bb8e-c0ed3435f732.PNG)

+ in line number 53-58
         
         <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver -->
         <dependency>
             <groupId>org.seleniumhq.selenium</groupId>
             <artifactId>selenium-chrome-driver</artifactId>
             <version>4.8.1</version>
         </dependency>

+ in whatever browser installed in your pc/you want to execute this program by 

1. Go to https://mvnrepository.com/

2. Search by browser name you want to execute automation
 Search it as : selenium <browser name> driver
 ex: for Edge --> 'Selenium edge driver'
 
 ![mv1](https://user-images.githubusercontent.com/106836713/236637302-b7b65629-44d7-40b0-9034-a38890783d3b.PNG)
 
3. Select suitable version (recommend to use latest version, due to browser updatea)

![mv2](https://user-images.githubusercontent.com/106836713/236637312-283a7929-788c-4855-b279-dbbe5381097d.PNG)

4. after selection you'll be redirected to specific page scroll down till you find a code like below 

![mv3](https://user-images.githubusercontent.com/106836713/236637355-0fbf8824-dff3-4cd3-837a-97fc786e49f6.PNG)

5. Copy it and replace it with what is on mines(in lines 53-58)

6. make sure to sync changes after you done process

This is how you do it in InteliJ

![mv5](https://user-images.githubusercontent.com/106836713/236637699-590ecd0e-9984-4ccb-a91c-3e1601574e76.PNG)

7. now go to team35QA.java(src/main > java > team35QA and change every single "chrome" to which you import(what browser you set under dependancy) 

 ex: if you set edge in your pom.xml as your browser. replace "edge" instead "chrome"
 
8. Now all set you may run the automation


If you come up with any problems feel free to contact me via contact method on my profile. :)
                     
      
