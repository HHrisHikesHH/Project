import java.io.*;
import java.util.*;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println(
      "Welcome!!" + "\n" + "To explore movies plz enter the following details"
    );
    System.out.println("Please enter your name");
    String name = sc.next();
    System.out.println("And your Location"); //Enter Location Pune/Mumbai case Sensitive
    String location = sc.next();
    Users u1 = new Users(name, location);
    u1.displayContent();
    System.out.println(
      "Do you want to watch Premium Movie of the day? press Y to watch"
    );
    char choice = sc.next().charAt(0);
    if (choice == 'y' || choice == 'Y') {
      System.out.println("Please Provide your Phone Num");
      long phone = sc.nextLong();
      u1 = new RegUsers(phone);
      u1.displayContent();
    } else return;

    System.out.println(
      "Hey " +
      name +
      " You have become registered would you like to watch our other movies? press Y to watch"
    );
    choice = sc.next().charAt(0);
    if (choice == 'y' || choice == 'Y') {
      System.out.println("Plz make a payment, if done press Y");
      choice = sc.next().charAt(0);
      if (choice == 'y' || choice == 'Y') {
        System.out.println(
          "YouRock123" + "-" + "This is your regCode plz enter to verify"
        );
        String RegNum = sc.next();
        u1 = new SubscribedUser(RegNum);
        SubscribedUser s1 = (SubscribedUser) u1;
        if (s1.getLocation() != null) {
          u1.displayContent();
        }
      } else return;
    } else return;
  }
}
