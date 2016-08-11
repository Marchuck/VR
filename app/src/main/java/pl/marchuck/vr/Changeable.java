package pl.marchuck.vr;

/**
 * @author Lukasz Marczak
 * @since 11.08.16.
 */
public interface Changeable {
    void onChange(int change);
    int getLastChange();
}
