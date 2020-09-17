package menu;

import animation.Animation;
/**
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The interface Menu.
 *
 * @param <T> the type parameter
 */
public interface Menu<T> extends Animation {
    /**
     * Add selection.
     *
     * @param key       the key
     * @param message   the message
     * @param returnVal the return val
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * Add sub menu.
     *
     * @param key       the key
     * @param message   the message
     * @param returnVal the return val
     */
    void addSubMenu(String key, String message, Menu<T> returnVal);

    /**
     * Gets status.
     *
     * @return the status
     */
    T getStatus();

    /**
     * Reset.
     */
    void reset();
}