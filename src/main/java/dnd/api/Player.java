package dnd.api;

/**
 * Created by Tobias on 05.07.16.
 * @version 0.1
 */
public interface Player {
    int getExperience();
    double getHealth();
    boolean getDamage(double damage);
    Weapon getWeapon();
    void setNewWeapon(Weapon weapon);


}
