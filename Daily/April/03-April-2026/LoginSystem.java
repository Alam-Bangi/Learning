import java.util.Scanner;

class LoginSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String storedUsername = "alam";
        String storedPassword = "Alam@123";

        System.out.print("Enter Username: ");
        String inputUsername = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        inputUsername = inputUsername.trim();
        inputUsername = inputUsername.toLowerCase();

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            System.out.println("Fields cannot be empty");
            sc.close();
            return;
        }

        if (inputUsername.equals(storedUsername)) {
            System.out.println("Username matched");
        } else {
            System.out.println("Invalid username");
        }

        if (inputPassword.equals(storedPassword)) {
            // System.out.println("Password correct");
        } else {
            System.out.println("Wrong password");
        }

        if (inputPassword.length() >= 8) {
            System.out.println("Password length is valid");
        }

        if (inputPassword.contains("@")) {
            System.out.println("Password contains special character");
        }

        String maskedPassword = inputPassword.replaceAll(".", "*");
        System.out.println("Masked Password: " + maskedPassword);

        StringBuilder login = new StringBuilder();
        login.append("Login attempt by: ").append(inputUsername);

        System.out.println(login);

        sc.close();
    }
}