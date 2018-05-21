package cu.xand.houserental.data;

public class Characteristics {
  int id;
  String name;
  boolean active;

  public Characteristics(int id, String name) {
    this.id = id;
    this.name = name;
    this.active = false;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
