package dnd.api;

/**
 * Created by marius on 27.06.16.
 */
public interface Monster {
    double getDamage();
    double getHealth();
    boolean decreaseHealth(double damage);
    int getExperience();
    String getDescription();
    String getName();
    Weapon getWeapon();
}