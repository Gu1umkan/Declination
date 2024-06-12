package declinationnameskyrgyz.declension0ffullnamekyrgyz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Declension0fFullNameKyrgyzApplicationTests {

    @Test
    void test() {
        Declination name = new Declination("Акпаралиев Санжар Таалайбекович");
        assertEquals("Акпаралиев Санжар Таалайбековичтин", name.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Акпаралиев Санжар Таалайбековичке", name.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Акпаралиев Санжар Таалайбековичти", name.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Акпаралиев Санжар Таалайбековичте", name.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Акпаралиев Санжар Таалайбековичтен", name.getFullName(DeclinationProcessor.gcasePos));
    }

    @Test
    void testDeclinationWithNameEndsWithConsonant() {
        Declination declination = new Declination("Акжол", "кызы", "Айзат");
        assertEquals("Акжол кызы Айзат", declination.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Акжол кызы Айзаттын", declination.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Акжол кызы Айзатка", declination.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Акжол кызы Айзатты", declination.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Акжол кызы Айзатта", declination.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Акжол кызы Айзаттан", declination.getFullName(DeclinationProcessor.gcasePos));
    }

    @Test
    void testDeclinationWithAnotherFullName() {
        Declination declination1 = new Declination("Шахзада Стамова");
        assertEquals("Шахзада Стамова", declination1.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Шахзада Стамованын", declination1.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Шахзада Стамовага", declination1.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Шахзада Стамованы", declination1.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Шахзада Стамовада", declination1.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Шахзада Стамовадан", declination1.getFullName(DeclinationProcessor.gcasePos));
    }

    @Test
    void testDeclinationWithFullName() {
        Declination declination = new Declination("Акылбекова Асель");
        assertEquals("Акылбекова Асель", declination.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Акылбекова Аселдин", declination.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Акылбекова Аселге", declination.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Акылбекова Аселди", declination.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Акылбекова Аселде", declination.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Акылбекова Аселден", declination.getFullName(DeclinationProcessor.gcasePos));
    }
    @Test
    void testDeclinationWithSingleName() {
        Declination name = new Declination("Асан Степанё");
        assertEquals("Асан Степанё", name.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Асан Степанёнун", name.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Асан Степанёго", name.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Асан Степанёну", name.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Асан Степанёдо", name.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Асан Степанёдон", name.getFullName(DeclinationProcessor.gcasePos));
    }

    @Test
    void testDeclinationWithThreePartName() {
        Declination declination3 = new Declination("Арстанилев", "Исламбек", "Абдирасулович");
        assertEquals("Арстанилев Исламбек Абдирасулович", declination3.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Арстанилев Исламбек Абдирасуловичтин", declination3.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Арстанилев Исламбек Абдирасуловичке", declination3.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Арстанилев Исламбек Абдирасуловичти", declination3.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Арстанилев Исламбек Абдирасуловичте", declination3.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Арстанилев Исламбек Абдирасуловичтен", declination3.getFullName(DeclinationProcessor.gcasePos));
    }

    @Test
    void testDeclinationEndWithUuluKyzy() {
        Declination declination1 = new Declination("Акжуурат", "Өмур", "кызы");
        assertEquals("Акжуурат Өмур кызы", declination1.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Акжуурат Өмур кызынын", declination1.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Акжуурат Өмур кызына", declination1.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Акжуурат Өмур кызыны", declination1.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Акжуурат Өмур кызында", declination1.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Акжуурат Өмур кызынан", declination1.getFullName(DeclinationProcessor.gcasePos));

        Declination declination2 = new Declination("Мирлан", "Керим", "уулу");
        assertEquals("Мирлан Керим уулу", declination2.getFullName(DeclinationProcessor.gcaseNom));
        assertEquals("Мирлан Керим уулунун", declination2.getFullName(DeclinationProcessor.gcaseGen));
        assertEquals("Мирлан Керим уулуна", declination2.getFullName(DeclinationProcessor.gcaseDat));
        assertEquals("Мирлан Керим уулуну", declination2.getFullName(DeclinationProcessor.gcaseAcc));
        assertEquals("Мирлан Керим уулунда", declination2.getFullName(DeclinationProcessor.gcaseIns));
        assertEquals("Мирлан Керим уулунан", declination2.getFullName(DeclinationProcessor.gcasePos));
    }
}
