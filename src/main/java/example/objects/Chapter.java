package example.objects;

/**
 * The Chapter class represents a chapter in the Space Marine universe.
 */
public class Chapter {
    private final String name;
    private Long marinesCount;

    /**
     * Constructor for the Chapter class.
     *
     * @param marinesCount The number of marines in the chapter.
     * @param name The name of the chapter.
     */
    public Chapter(Long marinesCount, String name) {
        this.name = name;
        this.marinesCount = marinesCount;
    }

    /**
     * Constructor for the Chapter class.
     *
     * @param name The name of the chapter.
     */
    public Chapter(String name) {
        this.name = name;
    }

    /**
     * Returns the number of marines in the chapter.
     *
     * @return The number of marines in the chapter.
     */
    public Long getMarinesCount() {
        return marinesCount;
    }

    /**
     * Returns the name of the chapter.
     *
     * @return The name of the chapter.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the chapter.
     *
     * @return A string representation of the chapter.
     */
    @Override
    public String toString() {
        return "Chapter{" + "name='" + name + '\'' + ", marinesCount=" + marinesCount + '}';
    }
}