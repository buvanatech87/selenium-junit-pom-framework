package actions;

public interface CheckoutActions {
    void startCheckout();
    void enterCheckoutInformation(String firstName, String lastName, String postalCode);
    void finishCheckout();
    boolean isCheckoutComplete();
}
