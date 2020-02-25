package DataHelper;

public class DataHelper {

    private DataHelper() {}

    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerificationCode getCorrectVerificationCode() {
        return new VerificationCode("12345");
    }

    public static Card getCard_0001() {
        return new Card("5559 0000 0000 0001");
    }

    public static Card getCard_0002() {
        return new Card("5559 0000 0000 0002");
    }

    public static String getNumberFromString(String originalStr, String subStrStart, String subStrEnd) {
        int startIndex = originalStr.indexOf(subStrStart) + subStrStart.length() + 1;
        int endIndex = originalStr.indexOf(subStrEnd) - 1;
        return originalStr.substring(startIndex, endIndex).trim();
    }

    public static class AuthInfo {
        private String login;
        private String password;
        AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }
        public String getLogin() {
            return this.login;
        }
        public String getPassword() {
            return this.password;
        }
    }

    public static class VerificationCode {
        private String code;
        VerificationCode(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    public static class Card{
        private String number;
        Card(String number) {
            this.number = number;
        }
        public String getNumber() {
            return number;
        }
    }
}