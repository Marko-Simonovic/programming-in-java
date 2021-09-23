package agh.ii.prinjava.lab01.lst01_01;

/**
 * Encapsulation is often referred to as one of the following:
 * <ul>
 *     <li>bundling together of publicly accessible methods and privately accessible data</li>
 *     <li>data hiding (controversial, see link below)</li>
 *     <li>controlled access to the object properties</li>
 * </ul>
 * <p>
 * Note: it is the object state (the snapshot of values of object properties) that is encapsulated
 *
 * @see <a href="https://www.infoworld.com/article/2075271/encapsulation-is-not-information-hiding.html">
 * Encapsulation is not information hiding</a></li>
 */
public class HelloEncapsulation {
    private int propVal; // the encapsulated state

    public HelloEncapsulation(int prop) {
        this.propVal = prop;
    }

    /**
     * Accessor methods (including <i>getters</i>) do not change the state of an object
     * (compare to {@code const} member functions in C++)<br>
     * When we want to prevent a foreign class from having access to an attribute, we use private.<br>
     * In this case when we want to access to an attribute from a foreign class, we use
     * a getter method, which returns the value of the attribute
     */
    public int getPropVal() {
        return propVal;
    }

    /**
     * Mutator methods (including <i>setters</i>) change the state of an object<br>
     * A Mutator helps changing the value of a private attribute.<br>
     * When we want to prevent a foreign class to change the attributes freely we indicate
     * them as private.<br> Therefore, we use a setter method to change the value.
     */
    public void setPropVal(int propVal) {
        this.propVal = propVal;
    }

    /**
     * If a property (or a method result) is of the {@code boolean} type,
     * the corresponding "getter" is usually named {@code isSth()} and not {@code getSth()}
     */
    public boolean isEncapsulated() {
        return true; // Of course, it is
    }
}
