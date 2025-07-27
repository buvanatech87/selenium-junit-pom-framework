package utils;

public interface TestData {
	

    // Valid credentials
    String VALID_USERNAME = "standard_user";
    String VALID_PASSWORD = "secret_sauce";

    // Invalid credentials
    String INVALID_USERNAME = "invalid_user";
    String INVALID_PASSWORD = "wrongpass";

    // Locked out user
    String LOCKED_OUT_USERNAME = "locked_out_user";

    // Case sensitivity
    String CASE_SENSITIVE_USERNAME = "STANDARD_USER";

    // SQL Injection
    String SQL_INJECTION_USERNAME = "' OR '1'='1";
    String SQL_INJECTION_PASSWORD = "anything";

    // Blank credentials
    String EMPTY_STRING = "";

}
