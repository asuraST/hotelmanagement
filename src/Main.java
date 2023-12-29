import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args){
        // Day 1 12/17
        // Take options as sout
        String str = "Please select your preferred choice" + "\n" +
                "1. Register Account" + "\n" +
                "2. Book Reservation" + "\n" +
                "3. Generate Bill" + "\n" +
                "4. Feedback";

        System.out.println(str);
        // Day 2 12/29
        // option as user i/p
        Scanner scObj = new Scanner(System.in);
        System.out.print("Please select an option: ");
        Integer option = scObj.nextInt();


        if(option == 1){
            // Requirement states that I should create a folder
            File folder = new File("C:\\Users\\candy\\OneDrive\\Desktop\\HotelManagement\\JSON");
            folder.mkdirs();
            // Random number generated to use in JSON
            Random rand = new Random();
            int randomNumber = rand.nextInt();
            // firstName, phoneNumber,emailId and address to be taken as user i/p
            System.out.print("Enter first name: ");
            String firstName = scObj.next();
            System.out.print("Enter phone number: ");
            String phoneNumber = scObj.next();
            System.out.print("Enter email id: ");
            String emailId = scObj.next();
            System.out.print("Enter address: ");
            String address = scObj.next();

            // JSON object- crazy, be careful with the class
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("FirstName", firstName);
            jsonObject.put("PhoneNumber", phoneNumber);
            jsonObject.put("EmailId", emailId);
            jsonObject.put("Address", address);

            // Create the filename
            String fileName = "ACC_" + randomNumber + ".json";
            // Write to JSON file :)
            try (FileWriter fileWriter = new FileWriter(new File(folder, fileName))) {
                fileWriter.write(jsonObject.toJSONString());
                System.out.println("Account Registration information written to " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
