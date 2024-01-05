This cource is about Spring. Actually, ido this only for understanding of Spring's configuration by XML
And this was the only video I found, where it was good described. Xml configuration is discovered in Part 3, so we need to go through part1 and part2 before))
Also I must stay focused at the main purpose - "Spring-the-ripper"-2014, where XML-configuration itself was used...

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

