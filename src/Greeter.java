import java.text.MessageFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Greeter is a very simple prompt to demonstrate that your Java setup is
 * working as expected
 *
 * @author Jan Modun (2281031)
 * @date 2025-09-02
 */
public class Greeter {
    /**
     * Greet the programmer
     */
    void greet() {
        System.out.println("Hello, Jan Modun!");
        System.out.println("Good luck in the course Programming: Enjoy!");
    }

    /**
     * In the old Julian calendar, a leap year was a year that is divisible by four. As a result, the average
     * year length was about 1
     * 100 th longer than one orbit of the earth around the sun. Therefore, in the
     * current Gregorian calendar, this is compensated by not having a leap year when it is a century
     * year, i.e., divisible by 100. However, this makes the year a bit too short. To solve that problem,
     * the century years 1600, 2000, etc., do get counted as leap years.
     * Write a program that stores a year as a number in a variable called year and then determines
     * with a single boolean expression whether that year is a leap year or not in the Gregorian calendar.
     * Store the value of that boolean expression in a boolean variable called leapYear. For year x,
     * depending on the value of that variable leapYear, your program outputs either
     * • The statement 'x is a leap year ' is true
     * or
     * • The statement 'x is a leap year ' is false
     * Note: For this exercise, you’re not allowed to use an if-statement.
     * Hint: The operator % gives the remainder after division. Hence, n % d is 0 if and only if n
     * is divisible by d.
     * @param year
     */
    void checkLeapYear(int year) {
        boolean isLeapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        String outputString = "The statement '" + year + " is not a leap year is " + !isLeapYear;
        System.out.println(outputString);
    }

    Scanner scanner = new Scanner(System.in);

    /**
     *
     * A simple function that prints a question requesting user input and returns it as a double to use in the calling function
     *
     * @param inputQuestion
     * @return double
     */
    double userDoubleInput(String inputQuestion){
        System.out.println(inputQuestion);
        return scanner.nextDouble();
    }

    /**
     *
     * A simple function that prints a question requesting user input and returns it as an integer to use in the calling function
     *
     * @param inputQuestion
     * @return int
     */
    int userIntegerInput(String inputQuestion){
        System.out.println(inputQuestion);
        return scanner.nextInt();
    }

    /**
     *
     * The tax rate problem, to long to post tbh
     */
    void calculateIntrest() {
        double balance;
        double rate;
        double taxRate;
        double postInterestBalance;
        double interest;
        double taxesPaid;

        balance = userDoubleInput("Give starting balance as a decimal: ");
        rate = userDoubleInput("Give interest rate as a percentage: ");
        taxRate = userDoubleInput("Give the text rate for the current year as a percentage: ");
        interest = balance * rate / 100.0;
        postInterestBalance = balance + interest;
        taxesPaid = postInterestBalance * taxRate / 100.0;

        System.out.println(
                "After a year , you have earned €"
                        + interest
                        + " from interest "
                        + "and have paid €"
                        + taxesPaid
                        + " in taxes, leaving you with €"
                        + (postInterestBalance - taxesPaid)
        );

    }

    /***
     * Write a program that calculates a person’s age in years. The program should ask the user to
     * enter their date of birth and also the current date. The user should enter dates in the format
     * “yyyymmdd”. For example, May 6th, 2022 should be entered as 20220506.
     * Put together, your program should follow the following example run:
     * Date of birth : 19930523
     * Current date : 20140524
     * You are 21 years old
     * Testing
     * Before you start programming, write all the test cases you need for a minimal test set that tests
     * your program for all possible behaviors. Only testing the example run is not enough.
     */
    void ageFinder(){
        int userBirthday = userIntegerInput("Give your birthdate in yyyymmdd form: ");
        int currentDate = userIntegerInput("Give the current date in yyyymmdd form: ");

        if (currentDate < userBirthday) {
            System.out.println("An error occurred, please check the inputs and try again!");
            ageFinder();
            return;
        }

        DateNumber structuredBirthday = structureAndGetDate(userBirthday);
        DateNumber structuredCurrentDay = structureAndGetDate(currentDate);

        int yearDiff = structuredCurrentDay.year - structuredBirthday.year;
        int monthDiff = structuredCurrentDay.month - structuredBirthday.month;

        if (monthDiff < 0){
            yearDiff--;
        }
        else {
            int dayDiff = structuredCurrentDay.day / structuredBirthday.day;
            if ( monthDiff==0 && dayDiff < 0) {
                yearDiff--;
            }
        }

        System.out.println("You are " + yearDiff + " years old");
    }

    /***
     * A class made for inputting and storing date value
     */
    class DateNumber {
        int year;
        int month;
        int day;

        public DateNumber(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }


    /***
     * A simple factory function for the DateNumber class which enables creating the class forma  simple integer
     *
     * @param initialDate
     * @return
     */
    DateNumber structureAndGetDate(int initialDate) {
        int year = initialDate / 10000;
        int month = (initialDate % 10000) / 100;
        int date = initialDate % 100;

        return new DateNumber(year, month, date);
    }

    public static void main(String[] args) {
        Greeter runner = new Greeter();

        runner.greet();
        runner.checkLeapYear(401);
        runner.ageFinder();
        runner.calculateIntrest();
    }
}