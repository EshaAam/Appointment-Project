public class MonthValidation implements Validation {
    private static final String[] VALID_MONTHS = { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

    @Override
    public boolean validate(String value) {
        for (String validMonth : VALID_MONTHS) {
            if (value.equalsIgnoreCase(validMonth)) {
                return true;
            }
        }
        return false;
    }
}