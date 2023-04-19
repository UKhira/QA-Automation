# QA-Automation
 Quality Assuarance Auomation done for a certain web as coursework


Tips:

Go to src/main > java > team35QA

make sure you have installed Google Chrome on your pc and have a stable internet connection before run this 

If chrome is not installed ,
   
     Open pom.xml and change
         
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>4.8.1</version>
        </dependency>
        
        in line number 53-58
        
        in whatever browser installed in your pc/you want to execute this program by 
        
        1. Go to https://mvnrepository.com/
        2. Search by browser name you want to execute automation
        3. Select suitable version (recommend to use latest version, due to browser updatea)
        4. after selection you'll be redirected to specific page which has a code like code in above(line 53-58)
        5. Copy it and replace it with what is on mines(in lines 53-58)
        6. make sure to sync changes after you done process
        7. now go to team35QA.java and change every single "chrome" to which you import(what browser you set under dependancy) 
               ex: if you set edge in your pom.xml as your browser. replace "edge" instead "chrome"
        8. Now all set you may run the automation
        
        
If you come up with any problems feel free to contact me via contact method on my profile. :)
                            
