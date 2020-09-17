package game;


/**
 * Counter class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Counter {
    private int number;

    /**
     * Instantiates a new Counter.
     * constractor.
     *
     * @param number the number
     */
    public Counter(int number) {
        this.number = number;
    }

    /**
     * Increase.
     * add number to current count.
     *
     * @param number1 the number
     */
    public void increase(int number1) {
        this.number = getValue() + number1;
    }

    /**
     * Decrease.
     * subtract number from current count.
     *
     * @param number1 the number
     */
    public void decrease(int number1) {
        this.number = getValue() - number1;
    }

    /**
     * Gets value.
     * get current count..
     *
     * @return the value
     */
    public int getValue() {
        return number;
    }

    /**
     * Sets counter.
     *
     * @param counter the counter
     */
    public void setCounter(int counter) {
        this.number = counter;
    }
}

