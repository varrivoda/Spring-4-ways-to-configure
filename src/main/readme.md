This compendium is meant to remind me about 4 kinds of Spring configuration. 
Written from video lecture about Spring by Sai Padhyayula 
https://github.com/SaiUpadhyayula

# PART 1, introduction to IoC, creating project

Let's create a simple EmailApplication, and also we need two other classes- EmailClient, interface SpellChecker.SpellChecker has two implementations - BasicSpelllChecker and AdvancedSpellChecker  

im main() method we create instances of needed classes by simple "new" operator.
That's no good, because in case of using by Client another version of dependency, he have to edit our service code. 

oops, we are creating only aEmailClient
after this we are calling method sendEmail("...") twice 

go into EmailClient
here is method sendEmail() where is used a member basicSpellChecker.chechSpelling(message). That basicSpellChecker is declared and set-up in a constructor.

go into BasicSpellChecker

if(message!=null){println("...");} else {throw new RuntimeException("...");}

go back to Client and see how the design of our application is bad, because Cliend is tightly coupled with BasicSpellCheker. To demonstratethis, weshall xreate another class- AdvancedSpellChecker. If we want touse it, we туувещ change the cone in EailClient. Another problem is that this kind of dependencies is hard to test - when the tested class invokes methods of some other classes (..) we cannot replace this class with some mock class.

The first way to uncouple our classes is to create interface SpellChecker, and declare and use it instead of any kind of base spell checkers. 

The second step is to inject our spellchecker by constructor when MailClient is being created: declare only interface, and define inside of the coinstructor. Now if wewant to use AdvancedSpellChecker we need to change the implementation inside of main(). Inother words, we are providing the dependencies of the EmailClient class instead of creating it directly inside of Client class.

But is is enough when we have only two these dependencies, but what about hundreds and thouthands of classes? Its better to have some kind of framework, which will inject and all of them instead of us. The most popular tool is Spring framework.

# PART 2, Spring XML-configured DI

The first is to add dependency to pom.xml, and donot forget to press "refresh maven" button, now the springframework must appear in the list of External Libraries. Now we can delete all code in main() and write instead of it

    ApplicationContext context = new ClassPathXmlApplicationContext();

Параметром надо передать путь до файла конфигурации - кстати, создадим его (в папке resources). Содержимое возьмем из документации Спринга или из гитхаба автора видео  ;)

В теге <bean> мы указываем id="имя бина" и class="полное имя класса"
Внутри тега бина emailClient укажем конструктор, в котором укажем id другого бина (спеплчекер) 

    <constructor-arg ref="basicSpellChecker"/> 

теперьмы можем решать, какую используем имплементацию, без какого-либо вмешательства в наш код, вставляя id нужного бина в тег конструктора клиента.

Но! еще надо прочитать этот xml и получить доступ к бинам.

передадим строку "beans.xml" в коонструктор ClassPAthXmlApplicationContext

теперь, чтобы получить бин, попросим об этом контекст 
    AplicationContext.getBean("emailClient", EmailClient.class)

И! мы уже сейчас можем использовать этот готовый объект
    emailClient.sendEmail("third email");

# ЧАСТЬ 3. Java-корнфигурация
