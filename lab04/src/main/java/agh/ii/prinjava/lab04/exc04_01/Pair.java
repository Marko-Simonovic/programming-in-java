package agh.ii.prinjava.lab04.exc04_01;

import java.util.Objects;

public class Pair<F,S> implements Cloneable {
    F fst;
    S snd;

    Pair (F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public Pair clone() {
        try {
            Pair p = (Pair) super.clone();
            return p;
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Exception was catched !");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "fst=" + fst +
                ", snd=" + snd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pair<F, S> pair = (Pair<F, S>) o; // This is a cast
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }
}
