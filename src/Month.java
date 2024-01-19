public enum Month {
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

    private final int monthNumber;

    Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public static Month fromString(String month) {
        switch (month.toLowerCase()) {
            case "jan": return JAN;
            case "feb": return FEB;
            case "mar": return MAR;
            case "apr": return APR;
            case "may": return MAY;
            case "jun": return JUN;
            case "jul": return JUL;
            case "aug": return AUG;
            case "sep": return SEP;
            case "oct": return OCT;
            case "nov": return NOV;
            case "dec": return DEC;
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
