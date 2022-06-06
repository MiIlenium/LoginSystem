import java.io.IOException;

public class Registration {
    WriteFile writeFile = new WriteFile();
    String userName, password;
    public Registration(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void writeToFile(String userName, String password) throws IOException {
        writeFile.writeToFile(userName, password);
    }
}
