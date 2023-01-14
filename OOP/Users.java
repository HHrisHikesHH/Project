import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;

public class Users {

  private String name;
  private String location;
  Scanner sc = new Scanner(System.in);
  //     Movies[] m = new Movies[9];
  //      m[0] = new Movies("Batman1", 158, 4.5, "India");
  //      m[1] = new Movies("Batman2", 148, 3.9, "India");
  //      m[2] = new Movies("Batman3", 120, 3.2);
  //      m[3] = new Movies("Batman4", 110, 5.0);
  //      m[4] = new Movies("Batman5", 188, 4.8, "Pune");
  //      m[5] = new Movies("Batman6", 160, 2.6, "Pune");
  //      m[6] = new Movies("Batman7", 148, 3.1, "Mumbai");
  //      m[7] = new Movies("Batman8", 151, 2.4, "Mumbai");
  //      m[8] = new Movies("Batman9", 158, 2.8);

  Movies m1 = new Movies("Batman1", 158, 4.5, "India");
  Movies m2 = new Movies("Batman2", 148, 3.9, "India");
  Movies m3 = new Movies("Batman3", 120, 3.2);
  Movies m4 = new Movies("Batman4", 110, 5.0);
  Movies m5 = new Movies("Batman5", 188, 4.8, "Pune");
  Movies m6 = new Movies("Batman6", 160, 2.6, "Pune");
  Movies m7 = new Movies("Batman7", 148, 3.1, "Mumbai");
  Movies m8 = new Movies("Batman8", 151, 2.4, "Mumbai");
  Movies m9 = new Movies("Batman9", 158, 2.8);

  public Users() {}

  public Users(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void displayContent() {
    System.out.println(
      "*********Currently you are viewing free content in " +
      this.location +
      " *********"
    );
    movieList();
  }

  public void movieList() {
    System.out.println(
      "Movies List" + "\n" + m6.getName() + " " + m8.getName()
    );
    if (this.location.equals("Pune")) {
      watchingMovie(m6);
    }

    if (this.location.equals("Mumbai")) {
      watchingMovie(m8);
    }
  }

  public void watchingMovie(Movies m) {
    System.out.println(
      "*********Enjoy your free movie " + m.getName() + " *********"
    );
    String space = " ";
    int idx = 0;
    int len = m.getLen();
    while (idx++ < len) {
      if (idx - 1 == len * 25 / 100) {
        advertisement();
      } else if (idx == len * 50 / 100) {
        advertisement();
      } else if (idx == len * 75 / 100) {
        advertisement();
      } else if (idx == len) {
        advertisement();
      }
      space += " ";
      System.out.print("-");
    }
    System.out.println("*********Movie completed 100%*********");
  }

  int i = 1;

  public void advertisement() {
    System.out.println("This is ADD " + i++);
  }
}

class RegUsers extends Users {

  private long phone;
  private String location;

  public RegUsers() {}

  public RegUsers(long phone) {
    this.phone = phone;
    this.location = "India";
  }

  public RegUsers(long phone, String location) {
    this.phone = phone;
    this.location = location;
  }

  public void premiumMovieOfTheday() {
    System.out.println(
      "*********You are viewing Premium movie of the day*********"
    );
    System.out.println("*********Enjoy " + m4.getName() + " *********");
    watchingMovie(m4);
  }

  @Override
  public void movieList() {
    System.out.println(
      "********* " +
      m1.getName() +
      " " +
      m6.getName() +
      " " +
      m2.getName() +
      " *********"
    );
    System.out.println(
      "*********Which one do you want to watch now 1,2,or 3*********"
    );
    int choice = sc.nextInt();
    if (choice == 1) {
      watchingMovie(m6);
    } else if (choice == 2) {
      watchingMovie(m2);
    } else watchingMovie(m1);
  }

  @Override
  public void displayContent() {
    premiumMovieOfTheday();
    System.out.println(
      "*********You are viewing free content in " + this.location + " *********"
    );
    movieList();
  }

  @Override
  public void watchingMovie(Movies m) {
    System.out.println(
      "*********Enjoy your movie " + m.getName() + " *********"
    );
    String space = " ";
    int idx = 0;
    int len = m.getLen();
    while (idx++ < len) {
      if (idx == len * 50 / 100) {
        advertisement();
      } else if (idx == len) {
        advertisement();
      }
      space += " ";
      System.out.print("-");
    }
    System.out.println("*********Movie completed 100%*********");
  }

  int i = 1;

  @Override
  public void advertisement() {
    System.out.println("This is ADD " + i++);
  }
}

class SubscribedUser extends RegUsers {

  private String regKey = "YouRock123";
  private String location;

  public String getLocation() {
    return location;
  }

  public SubscribedUser(String regKey) {
    if (this.regKey.equals(regKey)) {
      System.out.println("*********Verified!!!  Enjoy the movies*********");
      this.location = "World";
    } else {
      System.out.println(
        "*********Something went wrong plz try again*********"
      );
      return;
    }
  }

  public SubscribedUser(String regKey, String location) {
    if (this.regKey.equals(regKey)) {
      System.out.println("*********Verified!!!  Enjoy the movies*********");
      this.location = location;
    } else {
      System.out.println(
        "*********Something went wrong plz try again*********"
      );
      return;
    }
  }

  @Override
  public void movieList() {
    System.out.println("*********MovieList*********");
    System.out.println(
      m1.getName() +
      " " +
      m2.getName() +
      " " +
      m3.getName() +
      " " +
      m4.getName() +
      " " +
      m5.getName() +
      " " +
      m6.getName() +
      " " +
      m7.getName() +
      " " +
      m8.getName()
    );
    System.out.println(
      "*********Which one do you want to watch now 1,2,3,4,5,6,7 or 8*********"
    );
    int choice = sc.nextInt();
    if (choice == 1) {
      watchingMovie(m1);
    } else if (choice == 2) {
      watchingMovie(m2);
    } else if (choice == 3) {
      watchingMovie(m3);
    } else if (choice == 4) {
      watchingMovie(m4);
    } else if (choice == 5) {
      watchingMovie(m5);
    } else if (choice == 6) {
      watchingMovie(m6);
    } else if (choice == 7) {
      watchingMovie(m7);
    } else watchingMovie(m8);
  }

  @Override
  public void displayContent() {
    System.out.println(
      "*********You are viewing Premium content in " +
      this.location +
      " *********"
    );
    movieList();
  }

  @Override
  public void watchingMovie(Movies m) {
    int idx = 0;
    int len = m.getLen();
    while (idx++ < len) {
      System.out.print("-");
    }
    System.out.println("*********Movie completed 100%*********");
  }

  @Override
  public void advertisement() {
    System.out.println(" ");
  }
}
