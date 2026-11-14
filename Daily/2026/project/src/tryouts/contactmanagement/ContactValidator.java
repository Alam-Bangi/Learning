package tryouts.contactmanagement;

public class ContactValidator {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.length() == 10
                && phone.chars().allMatch(Character::isDigit);
    }

    public static String normalizeName(String name) {
        return name.trim().toLowerCase();
    }
}
