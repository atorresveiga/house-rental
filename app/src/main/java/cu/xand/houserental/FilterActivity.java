package cu.xand.houserental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import android.view.WindowManager;
import cu.xand.houserental.data.FilterElement;
import cu.xand.houserental.util.HouseRentalUtils;

public class FilterActivity extends AppCompatActivity implements FilterAdapter.FilterListener {

  FilterAdapter propertyFilterAdapter;
  RecyclerView propertyRecyclerView;

  FilterAdapter roomsFilterAdapter;
  RecyclerView roomsRecyclerView;

  FilterAdapter featuresFilterAdapter;
  RecyclerView featuresRecyclerView;

  FilterAdapter rulesFilterAdapter;
  RecyclerView rulesRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_filter);
    createPropertyFilter();
    createRoomsFilter();
    createFeaturesFilter();
    createRulesFilter();
    //fullScreenWindow();
  }

  private void createPropertyFilter() {
    propertyFilterAdapter = new FilterAdapter(this, HouseRentalUtils.getPropertyTypes(), this);
    propertyRecyclerView = findViewById(R.id.rv_property_type);
    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    propertyRecyclerView.setLayoutManager(layoutManager);
    propertyRecyclerView.setAdapter(propertyFilterAdapter);
    propertyRecyclerView.setHasFixedSize(true);
  }

  private void createRoomsFilter() {
    roomsFilterAdapter = new FilterAdapter(this, HouseRentalUtils.getRoomsNumbers(), this);
    roomsRecyclerView = findViewById(R.id.rv_number_of_rooms);
    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    roomsRecyclerView.setLayoutManager(layoutManager);
    roomsRecyclerView.setAdapter(roomsFilterAdapter);
    roomsRecyclerView.setHasFixedSize(true);
  }

  private void createFeaturesFilter() {
    featuresFilterAdapter = new FilterAdapter(this, HouseRentalUtils.getFeatures(), this);
    featuresRecyclerView = findViewById(R.id.rv_features);
    RecyclerView.LayoutManager layoutManager =
        new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
    featuresRecyclerView.setLayoutManager(layoutManager);
    featuresRecyclerView.setAdapter(featuresFilterAdapter);
    featuresRecyclerView.setHasFixedSize(true);
  }

  private void createRulesFilter() {
    rulesFilterAdapter = new FilterAdapter(this, HouseRentalUtils.getFeatures(), this);
    rulesRecyclerView = findViewById(R.id.rv_rules);
    RecyclerView.LayoutManager layoutManager =
        new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
    rulesRecyclerView.setLayoutManager(layoutManager);
    rulesRecyclerView.setAdapter(rulesFilterAdapter);
    rulesRecyclerView.setHasFixedSize(true);
  }

  private void fullScreenWindow() {
    Window w = getWindow(); // in Activity's onCreate() for instance
    w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
  }

  @Override public void onFilterChange(FilterElement element) {

  }
}
