package menu;
/**
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
/**
 * The interface Task.
 *
 * @param <T> the type parameter
 */
public interface Task<T> {
    /**
     * Run t.
     *
     * @return the t
     */
    T run();
}