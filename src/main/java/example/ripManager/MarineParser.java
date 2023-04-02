package example.ripManager;

import example.objects.*;
import org.jetbrains.annotations.NotNull;


public class MarineParser {

    /**
     * Parses a CSV string into a SpaceMarine object.
     *
     * @param line The CSV string to parse.
     * @return The parsed SpaceMarine object.
     * @throws IllegalArgumentException if the CSV string does not contain enough values to create a SpaceMarine.
     * @throws NullPointerException     if the CSV string is null or contains null values.
     */
    public static SpaceMarine parseSpaceMarine(@NotNull String line) throws IllegalArgumentException, NullPointerException {
        String[] values = line.split(",");

        if (values.length < 7) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }


        String name = values[0];
        float health = Float.parseFloat(values[1]);

        Coordinates coordinates = new Coordinates(values[2], values[3]);
        AstartesCategory category = AstartesCategory.valueOf(values[4]);

        Weapon weaponType = Weapon.valueOf(values[5]);
        MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(values[6]);

        if (values.length == 7) {
            return new SpaceMarine(name, health, coordinates, category, weaponType, meleeWeapon);
        }

        Chapter chapter;
        if (values.length == 8) {
            chapter = new Chapter(values[7]);
        } else {
            chapter = new Chapter(Long.parseLong(values[8]), values[7]);
        }
        return new SpaceMarine(name, health, coordinates, category, weaponType, meleeWeapon, chapter);
    }
}
