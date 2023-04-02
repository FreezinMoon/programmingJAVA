package example.managers;

/**
 * The Product class represents a product with a result and a success value.
 */
public class Product {
    // The result of the product operation
    String result;

    // Whether the operation was successful or not
    boolean success;

    /**
     * Constructor for the Product class.
     *
     * @param result  The result of the product operation.
     * @param success Whether the operation was successful or not.
     */
    public Product(String result, boolean success) {
        this.result = result;
        this.success = success;
    }

    /**
     * Returns the result of the product operation.
     *
     * @return The result of the product operation.
     */
    public String getResult() {
        return result;
    }

    /**
     * Returns whether the operation was successful or not.
     *
     * @return True if the operation was successful, false otherwise.
     */
    public boolean isSuccess() {
        return success;
    }
}