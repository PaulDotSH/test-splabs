package com.example.testspsprintboot;

abstract class House {
    abstract String decode(Message m);
}

class Harkonnen extends House {
    //Caesar cu shift de 24 (adica -2 pt decodare)
    @Override
    String decode(Message m) {
        String message = m.message;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (currentChar == '\"') {
                decryptedText.append(' ');
            } else if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) (currentChar - 2);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }
}

class Atreides extends House {
    // Un fel de caesar cu shift de 1
    @Override
    String decode(Message m) {
        String message = m.message;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (currentChar == '\"') {
                decryptedText.append(' ');
            } else {
                char decryptedChar = (char) (currentChar + 3);
                decryptedText.append(decryptedChar);
            }
        }

        return decryptedText.toString();
    }
}
