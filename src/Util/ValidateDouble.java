package Util;

public class ValidateDouble {
    public static boolean isDoubleValid(String doubleToValidate){
        boolean numeric = true;
        //numeric = doubleToValidate.matches("-?\\d+(\\.\\d+)?");

        try {
            Double d = Double.parseDouble(doubleToValidate.trim());
        }catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }

    public static double returnDoubleValid(String doubleToValidate){
        Double d = Double.parseDouble(doubleToValidate.trim());
        return d;
    }
}
