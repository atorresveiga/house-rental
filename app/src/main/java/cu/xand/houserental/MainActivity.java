package cu.xand.houserental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import cu.xand.houserental.data.House;
import cu.xand.houserental.util.HouseRentalUtils;

public class MainActivity extends AppCompatActivity implements HouseAdapter.HouseClickListener {

  RecyclerView rv_available_houses;
  HouseAdapter houseAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    fullScreenWindow();
    configureAvailableHouses();
  }

  private void configureAvailableHouses() {
    rv_available_houses = findViewById(R.id.rv_available_houses);
    houseAdapter = new HouseAdapter(this, HouseRentalUtils.getAvailableHouses(), this);
    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    rv_available_houses.setLayoutManager(layoutManager);
    rv_available_houses.setAdapter(houseAdapter);
    rv_available_houses.setHasFixedSize(true);
  }

  private void fullScreenWindow() {
    getWindow().getDecorView()
        .setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
  }

  @Override public void onHouseClick(House house) {
    Intent houseDetailsIntent = new Intent(this, DetailActivity.class);
    startActivity(houseDetailsIntent);
  }
}
