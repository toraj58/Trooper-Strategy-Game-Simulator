package CyclicBarrier_TrooperGame;

/**
 * Created by toraj on 01/05/2017.
 */
public class Trooper {

    String name;
    int strength;
    short mana;
    short health;
    short armor;
    int ammo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public short getMana() {
        return mana;
    }

    public void setMana(short mana) {
        this.mana = mana;
    }

    public short getHealth() {
        return health;
    }

    public void setHealth(short health) {
        this.health = health;
    }

    public short getArmor() {
        return armor;
    }

    public void setArmor(short armor) {
        this.armor = armor;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "CyclicBarrier_TrooperGame.Trooper{" +
                "name='" + name + '\'' +
                ", strength='" + strength + '\'' +
                ", mana='" + mana + '\'' +
                ", health='" + health + '\'' +
                ", armor=" + armor +
                ", ammo=" + ammo +
                '}';
    }
}
