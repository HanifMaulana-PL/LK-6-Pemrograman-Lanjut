public class Auth {
    private final String defaultUser = "default";
    private final String adminUser = "admin";

    private final String passwordDefault = "normal";
    private final String passwordAdmin = "abnormal";

    private boolean isLoggedIn = false;

    public boolean authenticate(String username, String password){
        if (username.equals(defaultUser)) {
            if (password.equals(passwordDefault)) {
                isLoggedIn = true;
                return true;
            } else {
                System.out.println("Password salah!");
            }
        } 
        else if (username.equals(adminUser)) {
            if (password.equals(passwordAdmin)) {
                isLoggedIn = true;
                return true;
            } else {
                System.out.println("Password admin salah!");
            }
        } 
        else {
            System.out.println("User tidak ada di sistem woy!");
        }

        return false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void logout() {
        isLoggedIn = false;
    }
}
