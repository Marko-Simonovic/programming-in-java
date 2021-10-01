package agh.ii.prinjava.lab02.lst02_04;

record Actor(String name, String surname) { // record create an immutable object with auto-generated methods
    @Override
    public String toString() {
        return name + " " + surname;
    } //we redefine the generated toString()
}
