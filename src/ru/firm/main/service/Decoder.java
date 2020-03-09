package ru.firm.main.service;

public class Decoder {

    public void decryptText(String encryptedText, String alphabet) {
        for (int i = 1; i <= alphabet.length() - 1; i++) {
            System.out.print("Decrypted text with shift value " + i + ": ");
            System.out.println(decryptTextDependingOnShift(encryptedText, alphabet, i));
        }
    }

    private String decryptTextDependingOnShift(String encryptedText, String alphabet, int shiftValue) {
        StringBuilder decryptedText = new StringBuilder();
        String[] splitEncryptedText = encryptedText.split(" ");
        for (String currentWord : splitEncryptedText) {
            decryptedText.append(decryptWordDependingOnShift(currentWord, alphabet, shiftValue));
            decryptedText.append(" ");
        }
        decryptedText.deleteCharAt(decryptedText.length() - 1);
        return decryptedText.toString();
    }

    private String decryptWordDependingOnShift(String encryptedWord, String alphabet, int shiftValue) {
        char[] encryptedWordChars = encryptedWord.toCharArray();
        StringBuilder decryptedWord = new StringBuilder();

        for (char currentLetter : encryptedWordChars) {
            char letterToAppend;
            int indexOfCurrentLetterInAlphabet;
            String currentAlphabet;

            if (Character.isUpperCase(currentLetter)) {
                currentAlphabet = alphabet.toUpperCase();
            } else {
                currentAlphabet = alphabet;
            }

            indexOfCurrentLetterInAlphabet = currentAlphabet.indexOf(currentLetter);

            if (currentLetter == ',' || currentLetter == '.') {
                letterToAppend = currentLetter;
            } else if (indexOfCurrentLetterInAlphabet >= shiftValue && indexOfCurrentLetterInAlphabet <= currentAlphabet.length()) {
                letterToAppend = currentAlphabet.charAt(indexOfCurrentLetterInAlphabet - shiftValue);
            } else {
                letterToAppend = currentAlphabet.charAt(currentAlphabet.length() - shiftValue + indexOfCurrentLetterInAlphabet);
            }
            decryptedWord.append(letterToAppend);
        }

        return decryptedWord.toString();
    }
}
