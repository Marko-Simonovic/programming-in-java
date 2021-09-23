package agh.ii.prinjava.lab01.lst01_02;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class RichDad {
    private String name;
    private List<String> contacts;
    protected BigDecimal fortune;

    // Note that in general protected fields are not welcome, but this is just a toy example...
    protected String surname;
    // ...

    protected void setUpSuccessfulCompany() {
    }

    protected void increaseWealth() {
    }
    // ...

    /**
     * Question 2 :<br>
     * <b>this</b> : indicate the pointer of the attribute of the current class, while...<br>
     * <b>super</b> : indicate the mother class. It's usually used like this 'super()' which
     * refers to the constructor of the parent class
     */
    // Constructor
    public RichDad(String name, String surname, BigDecimal fortune, List<String> contacts) {
        this.name = name;
        this.surname = surname;
        this.fortune = fortune;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    protected List<String> getContacts() {
        Predicate<String> toBeShared = s -> true; // to keep it simple -- take all
        return contacts.stream().filter(toBeShared).toList();
    }

    public BigDecimal getFortune() {
        // some logic here...
        return fortune; // again, to keep it simple
    }
}
