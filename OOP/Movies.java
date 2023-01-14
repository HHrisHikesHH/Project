public class Movies {

  private String name;
  private int len;
  private double rating;
  private String location;

  public String getName() {
    return name;
  }

  public int getLen() {
    return len;
  }

  public double getRating() {
    return rating;
  }

  public String getLocation() {
    return location;
  }

  public Movies(String name, int len, double rating) {
    this.name = name;
    this.len = len;
    this.rating = rating;
    this.location = "world";
  }

  public Movies(String name, int len, double rating, String location) {
    this.name = name;
    this.len = len;
    this.rating = rating;
    this.location = location;
  }
}
