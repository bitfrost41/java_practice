package exercises.codility;

public class HiddenDigitsLatestDate {
    public static void main(String[] args) {

        String result = findLatestDate("0?-3?");
        System.out.println(result);
    }

    private static String findLatestDate(String s) {

        // Map out max days per month
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        char[] chars = s.toCharArray();

        // Months tens
        if (chars[0] == '?') {
            chars[0] = (chars[1] == '?' || Integer.parseInt(String.valueOf(chars[1])) < 3) ? '1' : '0';
        }

        // Months ones
        if (chars[1] == '?') {
            chars[1] = chars[0] == '1' ? '2' : '9';
        }

        // Find in month array (subtract 1 to convert to index)
        int resultMonth = Integer.parseInt(new StringBuilder().append(chars[0]).append(chars[1]).toString());
        int maxDays = 0;
        // get max date by index
        if (resultMonth < 13) {
            maxDays = months[resultMonth - 1];

            if (maxDays == 30) {
                // Days tens
                if (chars[3] == '?') {
                    chars[3] = (chars[4] == '?' || Integer.parseInt(String.valueOf(chars[4])) < 1) ? '3' : '2';
                }
                // Days ones
                if (chars[4] == '?') {
                    if (chars[3] == '3') {
                        chars[4] = '0';
                    } else if (Integer.parseInt(String.valueOf(chars[3])) < 3) {
                        chars[4] = '9';
                    } else {
                        return "XX-XX"; // not possible
                    }
                }
            } else if (maxDays == 31) {
                // Days tens
                if (chars[3] == '?') {
                    chars[3] = (chars[4] == '?' || Integer.parseInt(String.valueOf(chars[4])) < 2) ? '3' : '2';
                }
                // Days ones
                if (chars[4] == '?') {
                    if (chars[3] == '3') {
                        chars[4] = '1';
                    } else if (Integer.parseInt(String.valueOf(chars[3])) < 3) {
                        chars[4] = '9';
                    } else {
                        return "XX-XX"; // not possible
                    }
                }
            } else if (maxDays == 28) {
                // Days tens
                if (chars[3] == '?') {
                    chars[3] = (chars[4] == '?' || Integer.parseInt(String.valueOf(chars[4])) < 9) ? '2' : '1';
                }
                // Days ones
                if (chars[4] == '?') {
                    if (chars[3] == '2') {
                        chars[4] = '8';
                    } else if (Integer.parseInt(String.valueOf(chars[3])) < 2) {
                        chars[4] = '9';
                    } else {
                        return "XX-XX"; // not possible
                    }
                }
            }
        } else {
            return "XX-XX";
        }

        int resultDay = Integer.parseInt(new StringBuilder().append(chars[3]).append(chars[4]).toString());
        if (resultDay > maxDays) {
            return "XX-XX";
        } else {
            return new String(chars);
        }

    }

}