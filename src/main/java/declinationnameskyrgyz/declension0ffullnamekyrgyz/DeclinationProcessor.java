package declinationnameskyrgyz.declension0ffullnamekyrgyz;

import java.util.List;

public class DeclinationProcessor {

    // атооч
    public static String gcaseNom = "nominative";
    // илик
    public static String gcaseGen = "genitive";
    // барыш
    public static String gcaseDat = "dative";
    // табыш
    public static String gcaseAcc = "accusative";
    // жатыш
    public static String gcaseIns = "instrumentative";
    // чыгыш
    public static String gcasePos = "prepositional";
    // иреттик сандар
    public static String gcaseOrdNuM = "ordinal number";


    static List<String> suffixes = List.of("нын", "га", "ны", "да", "дан");
    static List<String> suffixes2 = List.of("нин", "ге", "ни", "де", "ден");
    static List<String> suffixes3 = List.of("нун", "го", "ну", "до", "дон");
    static List<String> suffixes4 = List.of("нүн", "гө", "нү", "дө", "дөн");

    static List<String> suffixes5 = List.of("тын", "ка", "ты", "та", "тан");
    static List<String> suffixes6 = List.of("тин", "ке", "ти", "те", "тен");
    static List<String> suffixes7 = List.of("тун", "ко", "ту", "то", "тон");
    static List<String> suffixes8 = List.of("түн", "кө", "тү", "тө", "төн");

    static List<String> suffixes9 = List.of("дын", "га", "ды", "да", "дан");
    static List<String> suffixes10 = List.of("дин", "ге", "ди", "де", "ден");
    static List<String> suffixes11 = List.of("дун", "го", "ду", "до", "дон");
    static List<String> suffixes12 = List.of("дүн", "гө", "дү", "дө", "дөн");

    static List<String> suffixes13 = List.of("нун", "на", "ну", "нда", "нан");
    static List<String> suffixes14 = List.of("нын", "на", "ны", "нда", "нан");
    static List<String> suffixes18 = List.of("нүн", "нө", "нү", "ндө", "нөн");

    static List<String> suffixes15 = List.of("нун", "га", "ну", "да", "дан");
    static List<String> suffixes16 = List.of("дун", "га", "ду", "да", "дан");
    static List<String> suffixes17 = List.of("тун", "ка", "ту", "та", "тан");


    public static List<String> process(String endWith) {
        if ("аяы".equals(endWith)) {
            return suffixes;
        } else if ("эеи".equals(endWith)) {
            return suffixes2;
        } else if ("оё".equals(endWith)) {
            return suffixes3;
        } else if ("үө".equals(endWith)) {
            return suffixes4;
        } else if ("у".equals(endWith)) {
            return suffixes15;
        }
        throw new IllegalArgumentException("Unknown endWith: " + endWith);
    }


    public static List<String> process(String fullName, String endWith) {
        String secondLetter = fullName.substring(0, fullName.length() - 1);
        if ("птчксшцщ".equals(endWith)) {
            return getSuffixList(secondLetter, suffixes5, suffixes6, suffixes7, suffixes8, suffixes17);
        } else if ("бджгзмнңлрй".equals(endWith)) {
            return getSuffixList(secondLetter, suffixes9, suffixes10, suffixes11, suffixes12, suffixes16);
        }
        throw new IllegalArgumentException("Unknown declination: " + fullName);
    }

    public static List<String> processEndWithUuluKyzy(String fullName) {
        if (fullName.endsWith("ы"))
            return suffixes14;
        else if (fullName.endsWith("өкмөтү")) return suffixes18;
        else return suffixes13;
    }

    private static List<String> getSuffixList(String secondLetter, List<String> suffixes9, List<String> suffixes10, List<String> suffixes11, List<String> suffixes12, List<String> suffixes13) {
        while (secondLetter.matches(".*[|птчксшцщбджгзмнңлрй]")) {
            secondLetter = secondLetter.substring(0, secondLetter.length() - 1);
        }
        if (secondLetter.matches(".*[аяы]$")) {
            return suffixes9;
        } else if (secondLetter.matches(".*[эеи]$")) {
            return suffixes10;
        } else if (secondLetter.matches(".*[оё]$")) {
            return suffixes11;
        } else if (secondLetter.matches(".*[үө]$")) {
            return suffixes12;
        } else if (secondLetter.matches(".*у$")) {
            return suffixes13;
        }
        throw new IllegalArgumentException("Unknown declination: " + secondLetter);
    }

    public static String suffixOfOrdinalNumber(String number) {
        String vowelRegex = ".*[аыүи]$";
        String consonantRegex = ".*[птчксшцщбджгзмнңлрй]$";

        if (number.matches(vowelRegex)) {
            if (number.endsWith("ы") || number.endsWith("а")) {
                return number + "нчы";
            } else if (number.endsWith("и")) {
                return number + "нчи";
            } else if (number.endsWith("ү")) {
                return number + "нчү";
            }
        } else if (number.matches(consonantRegex)) {
            String num = number;
            while (num.matches(".*[птчксшцщбджгзмнңлрй]$")) {
                num = number.substring(0, number.length() - 1);
            }
            if (num.matches(".*[аяы]$")) {
                return number + "ынчы";
            } else if (num.matches(".*[еи]$")) {
                return number + "инчи";
            } else if (num.matches(".*[оу]$")) {
                return number + "унчу";
            } else if (num.matches(".*[үө]$")) {
                return number + "үнчү";
            }
        }
        throw new IllegalArgumentException("Unknown ordinal number: " + number);
    }


}
