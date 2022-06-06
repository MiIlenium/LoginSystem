public class Main {
    public static void main(String[] args) {
        ReadFile rd = new ReadFile();
        LoginPage loginPage = new LoginPage(rd.HashMapFromTextFile());
    }
}
