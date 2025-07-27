package actions;

public interface ProductActions {
    void sortProductsBy(String sortOption);
    boolean isProductDisplayed(String productName);
    void openProductDetails(String productName);
}