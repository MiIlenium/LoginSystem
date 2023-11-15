import java.util.HashMap;

public class ValidateUser {
    HashMap<String, String> mapToCheck;
    //ReadFile readFile = new ReadFile();
    boolean isValid;
    public ValidateUser(HashMap<String, String> hashMap) {
        mapToCheck = hashMap;
    }

    public boolean validateUserName(String key){
        isValid = ReadFile.HashMapFromTextFile().containsKey(key);
        return isValid;
    }
    public boolean validateUserPassword(String key, String password){
        isValid = ReadFile.HashMapFromTextFile().get(key).equals(password);
        return isValid;

    }
}
