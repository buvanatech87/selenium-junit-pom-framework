package actions;

public interface LoginActions {
	
    void login(String username, String password);
    String getErrorMessage();
    boolean isLoginSuccessful();

}
