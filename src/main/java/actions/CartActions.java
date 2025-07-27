package actions;

public interface CartActions {
    void addItemToCart(String itemName);
    void removeItemFromCart(String itemName);
    int getItemCountInCart();
    boolean isItemInCart(String itemName);
}