package Util;

public class ValidateInteger {
    public static boolean isIntegerValid(String doubleToValidate){
        boolean numeric = true;
        //numeric = doubleToValidate.matches("-?\\d+(\\.\\d+)?");

        try {
            Integer d = Integer.parseInt(doubleToValidate.trim());
        }catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }

    public static int returnIntegerValid(String doubleToValidate){
        Integer d = Integer.parseInt(doubleToValidate.trim());
        return d;
    }
}
