package ru.padwicki.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import ru.padwicki.test.service.exceptions.customExceptions.IncorrectStringLineException;
import ru.padwicki.test.service.exceptions.customExceptions.TooBigLineException;
import ru.padwicki.test.service.serviceImpl.LineService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;


class TestApplicationTests {

    @Test
    void findCountOfLetters_shouldReturnSortedMapByValue() {
        final String line = "aaaaaabbbc";

        LineService method = new LineService();
        String actual = method.findCountOfLetters(line);

        Assert.assertEquals("a=6, b=3, c=1", actual);
    }
    @Test
    void findCountOfLetters_shouldReturnNothing() {
        final String line = "         ";

        LineService method = new LineService();
        String actual = method.findCountOfLetters(line);

        Assert.assertEquals("", actual);
    }

    @Test
    void findCountOfLetters_shouldReturnSortedMapByValue_rolledLine() {
        final String line = "aaaabbccccccrrrrrr12333333z";

        LineService method = new LineService();
        String actual = method.findCountOfLetters(line);

        Assert.assertEquals("r=6, c=6, 3=6, a=4, b=2, 1=1, 2=1, z=1", actual);
    }


    @Test
    void findCountOfLetters_shouldReturnTooBigException() {
        final String line = "I awoke from The Sickness at the age of forty-five, calm and sane, and in reasonably " +
                "good health except for a weakened liver and the look of borrowed flesh common to all who survive. " +
                "The Sickness... Most survivors do not remember the delirium in detail. " +
                "I apparently took detailed notes on sickness and delirium. " +
                "I have no precise memory of writing the notes which have now been published under the title   " +
                "Naked Lunch. The title was suggested by Jack Kerouac. " +
                "I did not understand what the title meant until my recent recovery. " +
                "The title means exactly what the words say: " +
                "NAKED Lunch --a frozen moment when everyone sees what is on the end of every fork. " +
                "The Sickness is drug addiction and I was an addict for fifteen years. " +
                "When I say addict I mean an addict to junk (generic term for opium and/or derivatives " +
                "including all synthetics from demerol to palfium). " +
                "I have used junk in many forms: morphin, heroin, dilaudid, eukodol, pantopon, " +
                "diocodid, diosane, opium, demerol, dolophine, palfium. I have smoked junk, sniffed it, " +
                "injected it in vein-skinmuscle, inserted it in rectal suppositories. The needle is not important. " +
                "Whether you sniff it smoke it eat it or shove it up you ass the result is the same: addiction. " +
                "When I speak of drug addiction I do not refer to keif, marijuana or any preparation of hashish," +
                " mescaline,  Bannisteria Caapi,  LSD6, Sacred Mushrooms or any other drug of the hallucinogen " +
                "group... There is no evidence that the use of any hallucinogen results in physical dependence. " +
                "The action of these drugs is physiologically opposite to the action of junk. " +
                "A lamentable confusion between the two classes of drugs has arisen owing to the zeal of the U.S. " +
                "and other narcotic departments.\n" +
                "\n" +
                "\n" +
                "I have seen the exact manner in which the junk virus operates through fifteen years of addiction. " +
                "The pyramid of junk, one level eating the level below (it is no accident that junk higher-ups are " +
                "always fat and the addict in the street is always thin) right up to the top or tops since there " +
                "are many junk pyramids feeding on peoples of the world and all built on basic principles of " +
                "monopoly : 1 Never give anything for nothing.\n" +
                "\n" +
                "\n" +
                "2 Never give more than you have to give (always catch the buyer hungry and always make him wait).\n" +
                "\n" +
                "\n" +
                "3 Always take everything back if you possibly can.\n" +
                "\n" +
                "\n" +
                "The Pusher always get it all back. The addict needs more and more junk to maintain a human form... " +
                "buy off the Monkey.\n" +
                "\n" +
                "\n" +
                "Junk is the mold of monopoly and possession. The addict stands by while his junk legs carry " +
                "him straight in on the junk beam to relapse. Junk is quantitative and accurately mesurable. " +
                "The more junk you use the less you have and the more you have the more you use. " +
                "All the hallucinogen drugs are considered sacred by those who use them --there " +
                "are Peyote Cults and Bannisteria Cults, Hashish Cults and Mushroom Cults - \"the Sacred Mushrooms" +
                " of Mexico enable a man to see God\" --but no one ever suggested that junk is sacred. " +
                "There are no opium cults. Opium is profane and quantitative like money. I have heard that " +
                "there was once a beneficent non-habit-forming junk in India. " +
                "It was called  soma and is pictured as a beautiful blue tide. " +
                "If   soma ever existed the Pusher was there to bottle it and monopolize it and sell it and it " +
                "turned into plain old time JUNK. Junk is the ideal product... the ultimate merchandise." +
                " No sales talk necessary. The client will crawl through a sewer and beg to buy... " +
                "The junk merchant does not sell his product to the 4";


        LineService method = new LineService();
        assertThrows(TooBigLineException.class, () -> method.findCountOfLetters(line));

    }

    @Test
    void findCountOfLetters_shouldReturnIncorrectLineException() {
        final String line = "  \r\f\b\t\n\\\'\"\f\b\t\f\b\t\'\"\f\b    \'\"\f\b";

        LineService method = new LineService();

        assertThrows(IncorrectStringLineException.class, () -> method.findCountOfLetters(line));
    }

    @Test
    void findCountOfLetters_shouldReturnSortedMapByValueWithDifferentCharacters() {
        final String line = "異體字ﺕﺙﺏ異體字Kāngxī Zìdiǎn tǐ Канси Цзыдянь ти";

        LineService method = new LineService();
        String actual = method.findCountOfLetters(line);

        Assert.assertEquals("體=2, 字=2, n=2, 異=2, и=2, н=2, ā=1, с=1, т=1, K=1, ы=1, ь=1, ǎ=1, ﺏ=1, я=1, " +
                "ǐ=1, ﺕ=1, ﺙ=1, Z=1, К=1, d=1, Ц=1, g=1, i=1, ī=1, ì=1, а=1, t=1, д=1, з=1, x=1", actual);
    }
    @Test
    void findCountOfLetters_shouldReturnNullException() {
        final String line = null;

        LineService method = new LineService();
        assertThrows(NoSuchElementException.class, () -> method.findCountOfLetters(line));
    }

}
