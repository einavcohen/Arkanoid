package construction;

/**
 * The interface animation.
 *
 * @param <T> the type parameter
 * @author Einav Cohen
 * @version 24 may 2018
 */
public class MenuSelection<T> {
    private String key;
    private String name;
    private T returnVal;
    private boolean isSubMenu;

    /**
     * Instantiates a new Menu selection.
     *
     * @param key       the key
     * @param name      the name
     * @param returnVal the return val
     * @param isSubMenu the is sub menu
     */
    public MenuSelection(String key, String name, T returnVal, boolean isSubMenu) {
        this.key = key;
        this.name = name;
        this.returnVal = returnVal;
        this.isSubMenu = isSubMenu;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key1 the key
     */
    public void setKey(String key1) {
        this.key = key1;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name1 the name
     */
    public void setName(String name1) {
        this.name = name1;
    }

    /**
     * Gets return val.
     *
     * @return the return val
     */
    public T getReturnVal() {
        return returnVal;
    }

    /**
     * Sets return val.
     *
     * @param returnVal1 the return val
     */
    public void setReturnVal(T returnVal1) {
        this.returnVal = returnVal1;
    }

    /**
     * Is sub menu boolean.
     *
     * @return the boolean
     */
    public boolean isSubMenu() {
        return isSubMenu;
    }

    /**
     * Sets sub menu.
     *
     * @param subMenu the sub menu
     */
    public void setSubMenu(boolean subMenu) {
        isSubMenu = subMenu;
    }
}


