import java.util.HashMap;

public class ValidateUser {
    HashMap<String, String> mapToCheck;
    ReadFile readFile = new ReadFile();

    public ValidateUser(HashMap<String, String> hashMap) {
        mapToCheck = hashMap;
    }

    public boolean validateUserName(String key){
        boolean isValid;
        if(readFile.HashMapFromTextFile().containsKey(key)){
            isValid = true;
        }else{
            isValid = false;
        }
        return isValid;
    }
    public boolean validateUserPassword(String key, String password){
        boolean isValid;
        if(readFile.HashMapFromTextFile().get(key).equals(password)){
            isValid = true;
        }else{
            isValid = false;
        }
        return isValid;
    }
}
