package week2;

public class q4 {
    public String normalizeCode(String raw) {
        String trimmedCode = raw.trim();
        if (trimmedCode.length() < 3) {
            return trimmedCode;
        }

        return trimmedCode.substring(0, 3).toUpperCase() + trimmedCode.substring(3);
    }

    public String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }

        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append('[')
                .append(code.substring(0, 3))
                .append("] YEAR: ")
                .append(code.substring(3, 7))
                .append(" | CATALOG: ")
                .append(code.substring(7));
        return formattedCode.toString();
    }
}
