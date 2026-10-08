import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        Scanner input = new Scanner(System.in);

        // Ask the user to enter their first and last name and pass these
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();

        // values to the generateUsername method and save the returned result.
        String username = generateUsername(firstName, lastName);

        System.out.println("Username: " + username);
        System.out.println(" ");

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        // The validatePassword method will check if the password meets the criteria:
        boolean isValidPassword = validatePassword(password);

        System.out.println(isValidPassword);

        System.out.println(" ");

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.

        String creditCard = " ";

        String userCreditCard = " ";

        if (isValidPassword) {
            System.out.print("Enter your credit card number: ");
            creditCard = input.nextLine();
            userCreditCard = maskCreditCard(creditCard);
            System.out.println(userCreditCard);
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

        System.out.println(" ");
        System.out.println("Final Details: ");
        System.out.println("Username: " + username);
        System.out.println("Credit Card: " + userCreditCard);

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String firstNamePart;
        String lastNamePart;

        // If the firstName is lesser than 3 character it will be name itself
        if(firstName.length() < 3)
        {
            firstNamePart = firstName;
        }

        // If not then pick on the first letters
        else
        {
            firstNamePart = firstName.substring(0, 3);
        }

        // If the lastName is lesser than 3 character it will be name itself
        if(firstName.length() < 3)
        {
            lastNamePart = lastName;
        }

        // If not then pick on the first letters
        else
        {
            lastNamePart = lastName.substring(0, 3);
        }

        return (firstNamePart + lastNamePart).toLowerCase();
    }

    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        boolean isPasswordValid = true;

        if (password.length() < 8)
        {
            System.out.println("Password must be at least 8 digits long");
            isPasswordValid = false;
        }

        if (password.equals(password.toLowerCase())) {
            System.out.println("Invalid password: must contain at least one uppercase letter.");
            isPasswordValid = false;
        }

        if (!containsDigit(password)) {
            System.out.println("Invalid password: must contain at least one digit.");
            isPasswordValid = false;
        }

        return isPasswordValid;
    }

    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        if (creditCardNumber.length() == 16 && allDigits((creditCardNumber)))
        {
            return "**** **** **** " + creditCardNumber.substring(12);
        }

        else{
            return "N/A";
        }
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
