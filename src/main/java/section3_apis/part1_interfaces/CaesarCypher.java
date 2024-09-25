package section3_apis.part1_interfaces;

public class CaesarCypher implements EncryptionEngine {

    private static final int SHIFT = 3; // Define the shift for Caesar cipher

    @Override
    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isUpperCase(character)) {
                // Encrypt uppercase letters
                char encryptedChar = (char) ((character - 'A' - SHIFT + 26) % 26 + 'A');
                encrypted.append(encryptedChar);
            } else if (Character.isLowerCase(character)) {
                // Encrypt lowercase letters
                char encryptedChar = (char) ((character - 'a' - SHIFT + 26) % 26 + 'a');
                encrypted.append(encryptedChar);
            } else {
                // Non-alphabetic characters are not changed
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String encryptedMessage) {
        StringBuilder decrypted = new StringBuilder();

        for (char character : encryptedMessage.toCharArray()) {
            if (Character.isUpperCase(character)) {
                // Decrypt uppercase letters
                char decryptedChar = (char) ((character - 'A' + SHIFT) % 26 + 'A');
                decrypted.append(decryptedChar);
            } else if (Character.isLowerCase(character)) {
                // Decrypt lowercase letters
                char decryptedChar = (char) ((character - 'a' + SHIFT) % 26 + 'a');
                decrypted.append(decryptedChar);
            } else {
                // Non-alphabetic characters are not changed
                decrypted.append(character);
            }
        }

        return decrypted.toString();
    }
}
