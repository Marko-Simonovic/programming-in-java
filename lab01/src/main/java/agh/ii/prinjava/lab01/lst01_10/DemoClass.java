package agh.ii.prinjava.lab01.lst01_10;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class C1 {
    private int i;
    private long l;
    private String s;

    public C1(int i, long l, String s) {
        this.i = i;
        this.l = l;
        this.s = s;
    }

    @Override
    public String toString() {
        return "C1{" +
                "i=" + i +
                ", l=" + l +
                ", s='" + s + '\'' +
                '}';
    }

    /**
     * <u>PART 5</u><br>
     * <b>Question 1 :</b><br><br>
     * Not only '==' is an operator and 'equals' is a method, they don't work the same.
     * Actually, the '==' operator is used when we compare either the <b>value of
     * primitive types</b> or the <b>reference/memory location of objects</b>.<br>
     * On the other hand, the 'equals' method compare the two state of an object.
     * In other words, it will <b>check the reference/memory location</b>
     * (if yes they are considered equals).<br><br>
     * Therefore, the 'equals' method has the possibility to be overrided.
     * As <i>java.lang.Object</i> is the class parent for every object,
     * <b>the 'equals' method can be overrided in order to implement how we check the
     * equality of the objects : it gives more flexibility.</b>.
     * For example, the String's equals method compare a String character by character
     * to define if it's equal or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C1 c1 = (C1) o;
        return i == c1.i && l == c1.l && Objects.equals(s, c1.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, l, s);
    }
}

public class DemoClass {
    private double d;
    private List<Double> dbls;
    private int[] is;
    private C1 c1;

    @Override
    public String toString() {
        return "DemoClass{" +
                "d=" + d +
                ", dbls=" + dbls.toString() +
                ", is=" + Arrays.toString(is) +
                ", c1=" + c1.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoClass demoClass = (DemoClass) o;
        return Double.compare(demoClass.d, d) == 0 &&
                Objects.equals(dbls, demoClass.dbls) &&
                Arrays.equals(is, demoClass.is) &&
                Objects.equals(c1, demoClass.c1);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(d, dbls, c1);
        result = 31 * result + Arrays.hashCode(is);
        return result;
    }
}
