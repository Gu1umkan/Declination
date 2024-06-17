package declinationnameskyrgyz.declension0ffullnamekyrgyz;

import java.util.List;

import static declinationnameskyrgyz.declension0ffullnamekyrgyz.DeclinationProcessor.suffixOfOrdinalNumber;

public class Declination {

    private String fullName;
    private String endWith;
    private static final String KYRGYZ_ALPHABET_REGEX = "^[АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнҢңОоӨөПпРрСсТтУуҮүФфХхЦцЧчШшЩщЫыьЭэЮюЯя ]+$";

    public Declination(String fullName) {
        this.fullName = сheckName(fullName);
        endWith = declineByEnding(this.fullName);
    }

    public Declination(String lastName, String firstName, String middleName) {
        this.fullName = сheckName(String.format("%s %s %s", lastName, firstName, middleName));
        endWith = declineByEnding(this.fullName);
    }

    String getFullName(String declinationName) {
        List<String> suffixes = getSuffixes();

        if (declinationName.equals(DeclinationProcessor.gcaseNom)) {
            return this.fullName;
        } else if (declinationName.equals(DeclinationProcessor.gcaseGen)) {
            return fullName + suffixes.getFirst();
        } else if (declinationName.equals(DeclinationProcessor.gcaseDat)) {
            return fullName + suffixes.get(1);
        } else if (declinationName.equals(DeclinationProcessor.gcaseAcc)) {
            return fullName + suffixes.get(2);
        } else if (declinationName.equals(DeclinationProcessor.gcaseIns)) {
            return fullName + suffixes.get(3);
        } else if (declinationName.equals(DeclinationProcessor.gcasePos)) {
            return fullName + suffixes.getLast();
        } else if (declinationName.equals(DeclinationProcessor.gcaseOrdNuM)) {
            return  suffixOfOrdinalNumber(fullName);
        }
        else throw new IllegalArgumentException("Invalid declination name: " + declinationName);
    }


    private String declineByEnding(String fullName) {
        if (fullName.endsWith("ь")) {
            fullName = fullName.substring(0, fullName.length() - 1);
        }

        String endingPatterns = "у|аяы|эеи|оё|үө|птчксшцщ|бджгзмнңлрй";
        for (String pattern : endingPatterns.split("\\|")) {
            if (fullName.matches(".*[" + pattern + "]$")) {
                return pattern;
            }
        }
        return fullName;
    }

    public static boolean endsWithKyzUulu(String fullName) {
        String[] suffixes = {"кызы", "уулу","району","облусу","айылы","өкмөтү","аймагы","шаары"};
        for (String suffix : suffixes) {
            if (fullName.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    private String сheckName(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("Empty declination name: " + name);
        if (!name.matches(KYRGYZ_ALPHABET_REGEX)) throw new IllegalArgumentException("Invalid alphabet: " + name);
        return name.strip();
    }

    private List<String> getSuffixes() {
        String vowelRegex = ".*[аоуыэөүияёе]$";
        if (fullName.endsWith("ь")) {
            fullName = fullName.substring(0, fullName.length() - 1);
        }
        if (endsWithKyzUulu(fullName)) {
            return DeclinationProcessor.processEndWithUuluKyzy(fullName);
        } else if (fullName.matches(vowelRegex)) {
            return DeclinationProcessor.process(endWith);
        } else
            return DeclinationProcessor.process(fullName, endWith);
    }
}
