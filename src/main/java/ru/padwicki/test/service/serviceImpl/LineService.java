package ru.padwicki.test.service.serviceImpl;

import org.springframework.stereotype.Service;
import ru.padwicki.test.service.exceptions.customExceptions.IncorrectStringLineException;
import ru.padwicki.test.service.exceptions.customExceptions.TooBigLineException;
import ru.padwicki.test.service.serviceInterfaces.LineServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class LineService implements LineServiceInterface {
    @Override
    public String findCountOfLetters(String line) {
        exceptionChecker(line);
        List<Character> charactersOfLine = line.chars().mapToObj(x-> (char) x).toList();
        Map<Character, Integer> lettersCounts = charactersOfLine.stream().collect(HashMap::new, (map, character) -> {
            if (character != ' ') {
                if (!map.containsKey(character)) {
                    map.put(character,1);
                } else {
                    map.put(character, map.get(character) + 1);
                }
            }
        }, HashMap::putAll);

        List<Map.Entry<Character,Integer>> listOfLine= lettersCounts.entrySet().stream()
                .sorted(Map.Entry.<Character,Integer> comparingByValue()
                        .reversed()).toList();
        return convertLineForAnswer(listOfLine.toString());
    }
    private void exceptionChecker(String line) {
        if (line == null) {
            throw new NoSuchElementException("String is null");
        }
        if (line.contains("\n") || line.contains("\b") || line.contains("\r") ||
                line.contains("\f") || line.contains("\t")) {
            throw new IncorrectStringLineException("Wrong string line");
        }
        if (line.length() > 150) {
            throw new TooBigLineException("Too big string line, must be less than 101");
        }
    }
    private String convertLineForAnswer(String line) {
        line = line.replace("[","");
        line = line.replace("]","");
        return line;
    }
}
