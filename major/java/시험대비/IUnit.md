```java
public abstract class Unit {
    protected int strength;
    protected int strikingPower;
    protected String name;
    protected Brood brood;

    public Unit(int strength, int strikingPower, String name) {
        this.strength = strength;
        this.strikingPower = strikingPower;
        this.name = name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getStrkingPower() {
        return this.strikingPower;
    }

    public String getName() {
        return name;
    }

    public void decreaseStrength(int strikingPower) {
        this.strength -= strikingPower;
    }











}
```