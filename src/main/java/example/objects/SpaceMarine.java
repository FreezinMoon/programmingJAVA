package example.objects;


import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.util.Set;

/**
 * The SpaceMarine class represents a Space Marine.
 */
public class SpaceMarine implements Comparable<SpaceMarine> {
    private static int counter;
    private final ZonedDateTime creationDate;
    private final int id;
    private Set<Integer> usedIds;
    private final float health;
    private final String name;
    private final Coordinates coordinates;
    private final AstartesCategory category;
    private final Weapon weaponType;
    private final MeleeWeapon meleeWeapon;
    private Chapter chapter;

    /**
     * Constructor for the SpaceMarine class.
     *
     * @param name        The name of the Space Marine.
     * @param health      The health of the Space Marine.
     * @param coordinates The coordinates of the Space Marine.
     * @param category    The category of the Space Marine.
     * @param weaponType  The weapon type of the Space Marine.
     * @param meleeWeapon The melee weapon of the Space Marine.
     * @throws NullPointerException if any argument is null.
     */
    public SpaceMarine(String name, float health, Coordinates coordinates, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon) {
        this.creationDate = ZonedDateTime.now();
        this.id = ++counter;
        if (health > 0 && name.length() > 0 && coordinates != null && category != null && weaponType != null && meleeWeapon != null) {
            this.health = health;
            this.name = name;
            this.coordinates = coordinates;
            this.category = category;
            this.weaponType = weaponType;
            this.meleeWeapon = meleeWeapon;
        } else throw new NullPointerException("Every argument must be not-null");
    }

    /**
     * Constructor for the SpaceMarine class.
     *
     * @param name        The name of the Space Marine.
     * @param health      The health of the Space Marine.
     * @param coordinates The coordinates of the Space Marine.
     * @param category    The category of the Space Marine.
     * @param weaponType  The weapon type of the Space Marine.
     * @param meleeWeapon The melee weapon of the Space Marine.
     * @param chapter     The chapter of the Space Marine.
     * @throws NullPointerException if any argument is null.
     */
    public SpaceMarine(String name, float health, Coordinates coordinates, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this(name, health, coordinates, category, weaponType, meleeWeapon);
        this.chapter = chapter;
    }

    /**
     * Constructor for the SpaceMarine class.
     *
     * @param creationDate The creation date of the Space Marine.
     * @param id           The ID of the Space Marine.
     * @param health       The health of the Space Marine.
     * @param name         The name of the Space Marine.
     * @param coordinates  The coordinates of the Space Marine.
     * @param category     The category of the Space Marine.
     * @param weaponType   The weapon type of the Space Marine.
     * @param meleeWeapon  The melee weapon of the Space Marine.
     * @param chapter      The chapter of the Space Marine.
     */
    public SpaceMarine(ZonedDateTime creationDate, int id, float health, String name, Coordinates coordinates, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this(creationDate, id, health, name, coordinates, category, weaponType, meleeWeapon);
        this.chapter = chapter;
    }

    /**
     * Constructor for the SpaceMarine class.
     *
     * @param creationDate The creation date of the Space Marine.
     * @param id           The ID of the Space Marine.
     * @param health       The health of the Space Marine.
     * @param name         The name of the Space Marine.
     * @param coordinates  The coordinates of the Space Marine.
     * @param category     The category of the Space Marine.
     * @param weaponType   The weapon type of the Space Marine.
     * @param meleeWeapon  The melee weapon of the Space Marine.
     */
    public SpaceMarine(ZonedDateTime creationDate, int id, float health, String name, Coordinates coordinates, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon) {
        this.creationDate = creationDate;
        this.id = id;
        this.health = health;
        this.name = name;
        this.coordinates = coordinates;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        counter = Math.max(counter, id);
    }

    /**
     * Returns a string representation of the Space Marine.
     *
     * @return A string representation of the Space Marine.
     */
    @Override
    public String toString() {
        return "SpaceMarine{" + "creationDate=" + creationDate + ", id=" + id + ", health=" + health + ", name='" + name + "', " + coordinates.toString() + ", category=" + category + ", weaponType=" + weaponType + ", meleeWeapon=" + meleeWeapon + ", " + chapter.toString() + '}';
    }

    /**
     * Returns a string representation of the Space Marine in CSV format.
     *
     * @return A CSV string representation of the Space Marine.
     */
    public String getStringToCSV() {
        return creationDate.toString() + "," + id + "," + name + "," + health + "," + coordinates.getX() + "," + coordinates.getY() + "," + category + "," + weaponType + "," + meleeWeapon + "," + chapter.getName() + "," + chapter.getMarinesCount();
    }

    /**
     * Returns the chapter of the Space Marine.
     *
     * @return The chapter of the Space Marine.
     */
    public Chapter getChapter() {
        return chapter;
    }

    /**
     * Returns the melee weapon of the Space Marine.
     *
     * @return The melee weapon of the Space Marine.
     */
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    /**
     * Returns the weapon type of the Space Marine.
     *
     * @return The weapon type of the Space Marine.
     */
    public Weapon getWeaponType() {
        return weaponType;
    }

    /**
     * Returns the category of the Space Marine.
     *
     * @return The category of the Space Marine.
     */
    public AstartesCategory getCategory() {
        return category;
    }

    /**
     * Returns the coordinates of the Space Marine.
     *
     * @return The coordinates of the Space Marine.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Returns the name of the Space Marine.
     *
     * @return The name of the Space Marine.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health of the Space Marine.
     *
     * @return The health of the Space Marine.
     */
    public float getHealth() {
        return health;
    }

    /**
     * Returns the ID of the Space Marine.
     *
     * @return The ID of the Space Marine.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the creation date of the Space Marine.
     *
     * @return The creation date of the Space Marine.
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public int compareTo(@NotNull SpaceMarine sm) {
        return this.name.compareTo(sm.getName());
    }
}