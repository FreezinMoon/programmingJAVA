package example.ripManager;

import example.objects.AstartesCategory;
import example.objects.MeleeWeapon;
import example.objects.Weapon;

import java.util.Scanner;

public class MarineReader {
    /**
     * Prompts the user for input to create a string representation of a SpaceMarine object.
     *
     * @param scanner    The Scanner object to read input from.
     * @param isInScript A boolean indicating whether the program is running in script mode.
     * @return A string representation of a SpaceMarine object.
     */
    public static String initSpaceMarine(Scanner scanner, boolean isInScript) {
        String name;
        boolean flag1;
        do {
            if (!isInScript) {
                System.out.print("name: ");
            }
            name = scanner.nextLine();
        } while (name.length() < 1);

        String health;
        float fHealth;
        do {
            if (!isInScript) {
                System.out.print("health: ");
            }
            health = scanner.nextLine();
            try {
                fHealth = Float.parseFloat(health);
            } catch (Exception e) {
                fHealth = 0f;
                System.out.println("Health must be above zero");
            }
        } while (fHealth <= 0);

        if (!isInScript) {
            System.out.println("coordinates (x y) ");
        }
        String x;
        double fx;
        do {
            if (!isInScript) {
                System.out.print("x: ");
            }
            x = scanner.nextLine();
            try {
                fx = Double.parseDouble(x);
            } catch (Exception e) {
                fx = -892.;
                System.out.println("x must be above -892");
            }
        } while (fx <= -892);

        String y;
        do {
            if (!isInScript) {
                System.out.print("y: ");
            }
            y = scanner.nextLine();
            try {
                Float.parseFloat(y);
                flag1 = true;
            } catch (Exception e) {
                flag1 = false;
                System.out.println("y can't be null");
            }
        } while (!flag1);


        String category;
        do {
            if (!isInScript) {
                System.out.print("Astartes category(ASSAULT, INCEPTOR, CHAPLAIN, APOTHECARY): ");
            }
            category = scanner.nextLine();
            try {
                AstartesCategory.valueOf(category);
                flag1 = true;
            } catch (Exception e) {
                flag1 = false;
                System.out.println("No such category");
            }
        } while (!flag1);

        String weapon;
        do {
            if (!isInScript) {
                System.out.print("Weapon type(BOLTGUN, HEAVY_BOLTGUN, COMBI_FLAMER, GRAV_GUN, MULTI_MELTA): ");
            }
            weapon = scanner.nextLine();
            try {
                Weapon.valueOf(weapon);
                flag1 = true;
            } catch (Exception e) {
                flag1 = false;
                System.out.println("No such category");
            }
        } while (!flag1);

        String melee;
        do {
            if (!isInScript) {
                System.out.print("Melee weapon type(POWER_SWORD, MANREAPER, LIGHTING_CLAW): ");
            }
            melee = scanner.nextLine();
            try {
                MeleeWeapon.valueOf(melee);
                flag1 = true;
            } catch (Exception e) {
                flag1 = false;
                System.out.println("No such category");
            }
        } while (!flag1);


        StringBuilder marine = new StringBuilder(name + ',' + health + ',' + x + ',' + y + ',' + category + ',' + weapon + ',' + melee);
        Long fCount;
        String chName;
        String count;
        boolean flag2 = true;
        if (!isInScript) {
            System.out.println("Chapter (name count): ");
            System.out.print("Chapter name: ");
        }
        chName = scanner.nextLine();
        if (chName.length() == 0) {
            flag2 = false;
        }
        if (flag2) {
            marine.append(",").append(chName);
            if (!isInScript) {
                System.out.print("Count: ");
            }
            count = scanner.nextLine();
            if (count.length() == 0) {
                flag2 = false;
            }
            if (flag2) {
                do {
                    try {
                        fCount = Long.parseLong(count);
                        if (fCount > 0 && fCount <= 1000) {
                            marine.append(",").append(count);
                            flag1 = true;
                        } else {
                            System.out.println("Illegal argument");
                            flag1 = false;
                            System.out.print("Count: ");
                            count = scanner.nextLine();
                        }
                    } catch (Exception e) {
                        System.out.println("Illegal argument");
                        flag1 = false;
                    }
                } while (!flag1);
            }
        }
        return marine.toString();
    }
}
