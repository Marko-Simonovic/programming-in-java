package agh.ii.prinjava.lab02.lst02_04;

/**
 * Just for help in the understanding of the internals of enum types
 */
final class ThreeColorsEnumLike {
    public final static ThreeColorsEnumLike BLUE =
            new ThreeColorsEnumLike("BLUE", new Actor("Juliette", "Binoche"));

    public final static ThreeColorsEnumLike WHITE =
            new ThreeColorsEnumLike("WHITE", new Actor("Zbigniew", "Zamachowski"));

    public final static ThreeColorsEnumLike RED =
            new ThreeColorsEnumLike("BLUE", new Actor("Irene", "Jacob"));

    // The constructors Should be private
    private ThreeColorsEnumLike(String name, Actor leadingActor) {
        this.name = name;
        this.leadingActor = leadingActor;
    }

    // Why this should be static?
    // Because ThreeColorsEnumLike is not a real enum class while enum classes
    // are always final and static. Here, the array needs to work the same.
    private final static ThreeColorsEnumLike[] values = {BLUE, WHITE, RED};

    public static ThreeColorsEnumLike[] values() {
        return values;
    }

    // And why this should not?
    private final String name;

    public String name() {
        return name;
    }

    private final Actor leadingActor;

    public Actor getLeadingActor() {
        return leadingActor;
    }
}
