package agh.ii.prinjava.lab01.lst01_10;

import java.util.Objects;

public class HashCodeOK {
    private String s1;
    private String s2;

    public HashCodeOK(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * Generated by IntelliJ
     */
    @Override
    public String toString() {
        return "HashCodeOK{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }

    /**
     * Generated by IntelliJ (Objects.equals() utility method + defaults)<br>
     * <b>Question 2-4 :</b>
     * While 'equals' method is checking for the content and reference of two objects,
     * HashCode works a bit differently.<br>
     * <b>HashCode returns an integer representing the current instance of the class</b><br>
     * If two objects are equals then their hashcode will be indentical (=implies 'hasCode(o1) == etc.)
     * BUT, the opposite is not true. If two objects have a different location then they
     * will automatically have a different hashcodes.<br>
     * For example, two objects can represents two instances and not be equal because they dont
     * share the same reference, therefore their hashcode will be different. But if two objects
     * represents the same instance/have the same reference they will have the same hashCode
     * since they represent the same instance of the class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeOK that = (HashCodeOK) o;
        return Objects.equals(s1, that.s1) && Objects.equals(s2, that.s2);
    }

    /**
     * Generated by IntelliJ (Objects.hash() utility method + defaults)
     */
    @Override
    public int hashCode() {
        return Objects.hash(s1, s2);
    }

}