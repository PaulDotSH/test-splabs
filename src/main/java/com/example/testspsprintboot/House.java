package com.example.testspsprintboot;

abstract class House {
    abstract String decode(Message m);
}

abstract class CaesarHouse extends House {
    abstract int getShift();
    @Override
    String decode(Message m) {
        String message = m.message;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (currentChar == '\"') {
                decryptedText.append(' ');
            } else {
                char decryptedChar = (char) (currentChar + getShift());
                decryptedText.append(decryptedChar);
            }
        }
        return decryptedText.toString();
    }
}


class Harkonnen extends CaesarHouse {
    @Override
    int getShift() {
        return -2;
    }
}

class Atreides extends CaesarHouse {
    @Override
    int getShift() {
        return 3;
    }
}