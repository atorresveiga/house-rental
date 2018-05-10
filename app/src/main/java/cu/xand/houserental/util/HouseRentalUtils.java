package cu.xand.houserental.util;

import cu.xand.houserental.data.FilterElement;
import java.util.ArrayList;

public class HouseRentalUtils {

  public static FilterElement[] getPropertyTypes() {
    FilterElement[] filterElements = new FilterElement[4];
    filterElements[0] = new FilterElement(1, "Entire apartment");
    filterElements[1] = new FilterElement(2, "Studios");
    filterElements[2] = new FilterElement(3, "Rooms");
    filterElements[3] = new FilterElement(4, "Student residence");
    return filterElements;
  }

  public static FilterElement[] getRoomsNumbers() {
    FilterElement[] filterElements = new FilterElement[6];
    filterElements[0] = new FilterElement(1, "0");
    filterElements[1] = new FilterElement(2, "1");
    filterElements[2] = new FilterElement(3, "2");
    filterElements[3] = new FilterElement(4, "3");
    filterElements[4] = new FilterElement(5, "4");
    filterElements[5] = new FilterElement(5, "4+");
    return filterElements;
  }

  public static FilterElement[] getFeatures() {
    FilterElement[] filterElements = new FilterElement[13];
    filterElements[0] = new FilterElement(1, "En-suite room");
    filterElements[1] = new FilterElement(2, "Balcony");
    filterElements[2] = new FilterElement(3, "Parking");
    filterElements[3] = new FilterElement(4, "Pool");
    filterElements[4] = new FilterElement(5, "Exterior");
    filterElements[5] = new FilterElement(6, "Oven");
    filterElements[6] = new FilterElement(7, "Washing machine");
    filterElements[7] = new FilterElement(8, "Heating");
    filterElements[8] = new FilterElement(9, "Air Conditioning");
    filterElements[9] = new FilterElement(10, "With desk");
    filterElements[10] = new FilterElement(11, "Elevator");
    filterElements[11] = new FilterElement(12, "Dryer");
    filterElements[12] = new FilterElement(13, "Dishwasher");
    return filterElements;
  }

}
