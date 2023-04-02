package example.ripManager;

import example.objects.*;

import java.time.ZonedDateTime;


public class MarineParserCSV {

    /**
     * Parses a CSV string into a SpaceMarine object.
     *
     * @param line The CSV string to parse.
     * @return The parsed SpaceMarine object.
     * @throws IllegalArgumentException if the CSV string does not contain enough values to create a SpaceMarine.
     * @throws NullPointerException     if the CSV string is null or contains null values.
     */
    public static SpaceMarine parseSpaceMarine(String line) throws IllegalArgumentException, NullPointerException {
        String[] values = line.split(",");

        if (values.length < 9) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        ZonedDateTime creationDate = ZonedDateTime.parse(values[0]);

        int id = Integer.parseInt(values[1]);

        String name = values[2];

        float health = Float.parseFloat(values[3]);

        Coordinates coordinates = new Coordinates(values[4], values[5]);
        AstartesCategory category = AstartesCategory.valueOf(values[6]);

        Weapon weaponType = Weapon.valueOf(values[7]);
        MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(values[8]);

        if (values.length == 9) {
            return new SpaceMarine(creationDate, id, health, name, coordinates, category, weaponType, meleeWeapon);
        }

        Chapter chapter;
        if (values.length == 10) {
            chapter = new Chapter(values[9]);
        } else {
            chapter = new Chapter(Long.parseLong(values[10]), values[9]);
        }
        return new SpaceMarine(creationDate, id, health, name, coordinates, category, weaponType, meleeWeapon, chapter);
    }
}
