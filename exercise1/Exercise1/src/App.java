import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner loginScanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username_from_input = loginScanner.nextLine();

        System.out.print("Enter your password: ");
        String password_from_input = loginScanner.nextLine();

        User me = new User(username_from_input, password_from_input);

        File myfile = new File("accounts.txt");

        // if (myfile.exists()) {
        //     System.out.println("File Exists");
        // }

        Scanner fileScanner = new Scanner(myfile);

        boolean accExists = false;
        while (fileScanner.hasNextLine()) {
            String filedata = fileScanner.nextLine();
            String username_from_file = filedata.split(",")[0];
            String password_from_file = filedata.split(",")[1];
            if (username_from_input.equals(username_from_file) && password_from_input.equals(password_from_file)) {
                accExists = true;
                System.out.println("Login successful!, Hello " + me.getUsername());
                break;
            }
        }

        if (accExists == false) {
            System.out.println("Login failed");
        }

        loginScanner.close();
        fileScanner.close();
    }
}
