package chapter20;

public class PasswordUtils {
    @UseCase(id = 47, description = "lala")
    public boolean v(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String e(String password) {
        return password;
    }

    @UseCase(id = 49, description = "lele")
    public boolean c(String s) {
        return s.equals("lele");
    }
}
