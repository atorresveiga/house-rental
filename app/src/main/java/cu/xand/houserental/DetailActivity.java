package cu.xand.houserental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import cu.xand.houserental.data.House;
import cu.xand.houserental.util.HouseRentalUtils;

public class DetailActivity extends AppCompatActivity {

  TextView tv_price;
  TextView tv_title;
  TextView tv_rooms;
  TextView tv_size;
  TextView tv_type;
  TextView tv_description;
  TextView tv_features;
  TextView tv_rules;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    tv_price = findViewById(R.id.tv_price);
    tv_title = findViewById(R.id.tv_house_title);
    tv_rooms = findViewById(R.id.tv_rooms);
    tv_size = findViewById(R.id.tv_size);
    tv_type = findViewById(R.id.tv_type);
    tv_description = findViewById(R.id.tv_description);
    tv_features = findViewById(R.id.tv_features);
    tv_rules = findViewById(R.id.tv_rules);

    setHouse();
  }

  private void setHouse() {
    final House house = HouseRentalUtils.getHouse();

    tv_price.setText(getString(R.string.price, String.valueOf(house.getPrice())));
    tv_title.setText(house.getTitle());
    tv_rooms.setText(getString(R.string.rooms, house.getRooms()));
    tv_size.setText(getString(R.string.size, String.valueOf(house.getSize())));
    tv_type.setText(house.getType());

    tv_description.setText(house.getDescription());

    tv_features.setText(HouseRentalUtils.fortmatCharacteristicsToStringList(house.getFeatures()));
    tv_rules.setText(HouseRentalUtils.fortmatCharacteristicsToStringList(house.getRules()));
  }
}
