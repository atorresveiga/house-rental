package cu.xand.houserental.util;

import cu.xand.houserental.data.Characteristics;
import cu.xand.houserental.data.House;

public class HouseRentalUtils {



  public static Characteristics[] getPropertyTypes() {
    Characteristics[] characteristics = new Characteristics[4];
    characteristics[0] = new Characteristics(1, "Entire apartment");
    characteristics[1] = new Characteristics(2, "Studios");
    characteristics[2] = new Characteristics(3, "Rooms");
    characteristics[3] = new Characteristics(4, "Student residence");
    return characteristics;
  }

  public static Characteristics[] getRoomsNumbers() {
    Characteristics[] characteristics = new Characteristics[6];
    characteristics[0] = new Characteristics(1, "0");
    characteristics[1] = new Characteristics(2, "1");
    characteristics[2] = new Characteristics(3, "2");
    characteristics[3] = new Characteristics(4, "3");
    characteristics[4] = new Characteristics(5, "4");
    characteristics[5] = new Characteristics(5, "4+");
    return characteristics;
  }

  public static Characteristics[] getFeatures() {
    Characteristics[] characteristics = new Characteristics[13];
    characteristics[0] = new Characteristics(1, "En-suite room");
    characteristics[1] = new Characteristics(2, "Balcony");
    characteristics[2] = new Characteristics(3, "Parking");
    characteristics[3] = new Characteristics(4, "Pool");
    characteristics[4] = new Characteristics(5, "Exterior");
    characteristics[5] = new Characteristics(6, "Oven");
    characteristics[6] = new Characteristics(7, "Washing machine");
    characteristics[7] = new Characteristics(8, "Heating");
    characteristics[8] = new Characteristics(9, "Air Conditioning");
    characteristics[9] = new Characteristics(10, "With desk");
    characteristics[10] = new Characteristics(11, "Elevator");
    characteristics[11] = new Characteristics(12, "Dryer");
    characteristics[12] = new Characteristics(13, "Dishwasher");
    return characteristics;
  }

  public static House[] getAvailableHouses() {
    House[] houses = new House[12];
    for (int i = 0; i < 12; i++) {
      houses[i] = getHouse();
    }

    return houses;
  }

  public static House getHouse() {
    House result = new House(1, "", 450.50, "Penthouse Belgrano con vista al mar",
        "Esta el la descripcion del apartamento, es un apartamento muy bonito con vista al mar y pelicanos",
        165, 4, "Entire apartment", new Characteristics[] {
        new Characteristics(1, "En-suite room"), new Characteristics(2, "Balcony"),
        new Characteristics(9, "Air Conditioning")
    }, new Characteristics[] {
        new Characteristics(1, "En-suite room"), new Characteristics(2, "Balcony"),
        new Characteristics(9, "Air Conditioning")
    });

    return result;
  }

  public static String fortmatCharacteristicsToStringList(Characteristics[] characteristics) {
    StringBuilder sb = new StringBuilder();

    for (Characteristics item : characteristics) {
      sb.append(item.getName()).append("     ");
    }

    return sb.toString();
  }
}
