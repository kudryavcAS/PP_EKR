package lab.xml.pp_ekr;

public class CaesarCipher {

    public String encrypt(String text, int shift) {
        if (text == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character >= 'A' && character <= 'Z') {
                result.append(shiftChar(character, shift, 'A', 26));
            } else if (character >= 'a' && character <= 'z') {
                result.append(shiftChar(character, shift, 'a', 26));
            } else if (character >= 'А' && character <= 'Я') {
                result.append(shiftChar(character, shift, 'А', 32));
            } else if (character >= 'а' && character <= 'я') {
                result.append(shiftChar(character, shift, 'а', 32));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    private char shiftChar(char c, int shift, char base, int alphabetSize) {
        int distinctShift = shift % alphabetSize;
        int newCharIndex = (c - base + distinctShift) % alphabetSize;
        if (newCharIndex < 0) {
            newCharIndex += alphabetSize;
        }
        return (char) (base + newCharIndex);
    }
}