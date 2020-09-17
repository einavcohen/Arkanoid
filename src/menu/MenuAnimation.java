package menu;

import animation.AnimationRunner;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import construction.MenuSelection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
/**
 * The type Menu animation.
 * @param <T> the MenuAnimation.
 */
public class MenuAnimation<T> implements Menu<T> {

    private AnimationRunner runner;
    private String menuName;
    private List<MenuSelection<T>> selections;
    private List<Menu<T>> subMenus;
    private KeyboardSensor keyboardSensor;
    private T returnValue;
    private boolean stop;
    private boolean isSubMenu;

    /**
     * Instantiates a new Menu animation.
     *
     * @param menuName1       the menu name 1
     * @param keyboardSensor1 the keyboard sensor 1
     * @param runner          the runner
     */
    public MenuAnimation(String menuName1, KeyboardSensor keyboardSensor1, AnimationRunner runner) {
        this.menuName = menuName1;
        this.selections = new ArrayList<>();
        this.subMenus = new ArrayList<>();
        this.keyboardSensor = keyboardSensor1;
        this.stop = false;
        this.returnValue = null;
        this.isSubMenu = isSubMenu;
        this.runner = runner;
    }

    @Override
    public void addSelection(String key, String message, T returnVal) {
        MenuSelection<T> menuSelection = new MenuSelection<>(key, message, returnVal, false);
        selections.add(menuSelection);
    }

    @Override
    public void addSubMenu(String key, String message, Menu<T> subMenu) {
        this.selections.add(new MenuSelection<>(key, message, null, true));
        subMenus.add(subMenu);
    }

    @Override
    public T getStatus() {
        return this.returnValue;
    }

    @Override
    public void reset() {
        this.stop = false;
        this.returnValue = null;
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.pink);
        d.fillRectangle(0, 0, 800, 600);

        d.setColor(Color.BLACK);
        d.drawText(250, 100, this.menuName, 36);

        int x = 250;
        int y = 250;
        for (MenuSelection<T> ms : this.selections) {

            String message = "(" + ms.getKey() + ") " + ms.getName();
            d.drawText(x, y, message, 24);
            y += 50;
            if (checkIfSomethingWasPressed(ms)) {
                break;
            }
        }
    }

    /**
     * checkIfSomethingWasPressed func.
     * @param ms the ms menu.
     * @return the boolean val of checkIfSomethingWasPressed func.
     */
    private boolean checkIfSomethingWasPressed(MenuSelection<T> ms) {
        if (this.keyboardSensor.isPressed(ms.getKey())) {
            if (!ms.isSubMenu()) {
                this.returnValue = ms.getReturnVal();
                this.stop = true;
                return false;
            } else {
                Menu<T> subMenu = this.subMenus.get(this.selections.indexOf(ms));
                this.runner.run(subMenu);
                this.returnValue = subMenu.getStatus();
                this.stop = true;
                subMenu.reset();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
