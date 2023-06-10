package org.example.funtionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("05000000001"));

        // Predicate
        Boolean isPhoneNumberValid = isPhoneNumberValidPredicate.test("07000000000");
        System.out.println(isPhoneNumberValid);

        Boolean isValidAndContains3 =  isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003");
        System.out.println(isValidAndContains3);

        Boolean isSameNumber = isEqual.test(1, 2);
        System.out.println(isSameNumber);
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static BiPredicate<Integer, Integer> isEqual = (a, b) -> a == b;

}
