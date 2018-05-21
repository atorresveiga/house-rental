package cu.xand.houserental.data;

public class House {
  int id;
  String photo;
  double price;
  String title;
  String description;
  double size;
  int rooms;
  String type;
  Characteristics features[];
  Characteristics rules[];

  public House(int id, String photo, double price, String title, String description, double size,
      int rooms, String type, Characteristics[] features, Characteristics[] rules) {
    this.id = id;
    this.photo = photo;
    this.price = price;
    this.title = title;
    this.description = description;
    this.size = size;
    this.rooms = rooms;
    this.type = type;
    this.features = features;
    this.rules = rules;
  }

  public int getId() {
    return id;
  }

  public String getPhoto() {
    return photo;
  }

  public double getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public double getSize() {
    return size;
  }

  public int getRooms() {
    return rooms;
  }

  public String getType() {
    return type;
  }

  public Characteristics[] getFeatures() {
    return features;
  }

  public Characteristics[] getRules() {
    return rules;
  }
}
