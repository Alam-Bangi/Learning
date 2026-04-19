class AuthenticationLogin {
    public static void main(String[] args) {

        AuthService auth;

        auth = new EmailAuth();
        auth.login("bangialam12@gmail.com", "1234");

        auth = new OTPAuth();
        auth.login("9876543210", "9999");

        auth = new GoogleAuth();
        auth.login("bangialam12@gmail.com", "google_login_mail");
    }
}

interface AuthService {
    boolean login(String identifier, String credential);
}

class EmailAuth implements AuthService {
    public boolean login(String email, String password) {
        if (email.equals("bangialam12@gmail.com") && password.equals("1234")) {
            System.out.println("Email Login Successful!");
            return true;
        }
        System.out.println("Email Login Failed!");
        return false;
    }
}

class OTPAuth implements AuthService {
    public boolean login(String mobile, String otp) {
        if (otp.equals("9999")) {
            System.out.println("OTP Login Successful!");
            return true;
        }
        System.out.println("OTP Login Failed!");
        return false;
    }
}

class GoogleAuth implements AuthService {
    public boolean login(String email, String token) {
        if (token.equals("google_login_mail")) {
            System.out.println("Google Login Successful for " + email);
            return true;
        }
        System.out.println("Google Login Failed!");
        return false;
    }
}
