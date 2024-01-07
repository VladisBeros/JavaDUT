package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String encryptedMessage1 = "t2st3ng";
        String encryptedMessage2 = "vetviph";

        System.out.println(decodeMessage(encryptedMessage1));
        System.out.println(decodeMessage(encryptedMessage2));
    }

    public static String decodeMessage(String encryptedMessage) {
        String vowelEncodingPattern = "[aeiou]";
        String consonantEncodingPattern = "[bcdfghjklmnpqrstvwxyz]";

        StringBuilder decodedMessage = new StringBuilder();
        String[] words = encryptedMessage.split("\\s+");

        for (String word : words) {
            if (word.matches(vowelEncodingPattern)) {
                decodedMessage.append(decodeVowelEncoding(word)).append(" ");
            } else if (word.matches(consonantEncodingPattern)) {
                decodedMessage.append(decodeConsonantEncoding(word)).append(" ");
            } else {
                decodedMessage.append(word).append(" ");
            }
        }

        return decodedMessage.toString().trim();
    }

    private static String decodeVowelEncoding(String word) {
        return word.replaceAll("a", "1")
                .replaceAll("e", "2")
                .replaceAll("i", "3")
                .replaceAll("o", "4")
                .replaceAll("u", "5");
    }

    private static String decodeConsonantEncoding(String word) {
        StringBuilder decodedWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if ("bcdfghjklmnpqrstvwxyz".indexOf(c) != -1) {
                decodedWord.append(findNextConsonant(c));
            } else {
                decodedWord.append(c);
            }
        }

        return decodedWord.toString();
    }

    private static char findNextConsonant(char consonant) {
        String consonantSequence = "bcdfghjklmnpqrstvwxyz";
        int index = consonantSequence.indexOf(consonant);
        return consonantSequence.charAt((index + 1) % consonantSequence.length());
    }
}