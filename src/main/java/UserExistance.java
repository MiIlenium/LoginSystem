public class UserExistance {
    boolean ifExits;

    public boolean UserExistance(String key) {
        return ifExits;
    }

    public boolean IfUserExits(String key) {
        ifExits = ReadFile.HashMapFromTextFile().containsKey(key);
        return ifExits;
    }
}
