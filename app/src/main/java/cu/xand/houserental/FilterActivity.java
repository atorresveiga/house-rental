package cu.xand.houserental;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import cu.xand.houserental.data.Characteristics;
import cu.xand.houserental.util.HouseRentalAnimationsUtil;
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

  Button filter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_filter);
    fullScreenWindow();
    createPropertyFilter();
    createRoomsFilter();
    createFeaturesFilter();
    createRulesFilter();
    setupFilter();
    calculations();
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

  private void setupFilter() {
    filter = findViewById(R.id.bt_filter);
    filter.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent availableHousesIntent = new Intent(FilterActivity.this, MainActivity.class);
        startActivity(availableHousesIntent);
      }
    });
  }

  @Override protected void onResume() {
    super.onResume();
    animateFilter();
  }

  @Override protected void onStop() {
    super.onStop();
    initialState();
  }

  private void fullScreenWindow() {
    getWindow().getDecorView()
        .setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
  }

  AnimatorSet filterWindowAnimation;
  float listTranslation;
  float filterTranslation;

  private void calculations() {
    listTranslation = HouseRentalAnimationsUtil.filterListsTranslationDistance(this);
    filterTranslation = HouseRentalAnimationsUtil.filterButtonTranslationDistance(this);
    filterWindowAnimation =
        HouseRentalAnimationsUtil.filterAnimation(filter, propertyRecyclerView, roomsRecyclerView,
            featuresRecyclerView, rulesRecyclerView);
    initialState();
  }

  private void initialState() {
    if (filterWindowAnimation.isRunning()) filterWindowAnimation.cancel();
    filter.setTranslationY(filterTranslation);
    featuresRecyclerView.setTranslationY(listTranslation);
    propertyRecyclerView.setTranslationY(listTranslation);
    roomsRecyclerView.setTranslationY(listTranslation);
    rulesRecyclerView.setTranslationY(listTranslation);
    featuresRecyclerView.setAlpha(0);
    propertyRecyclerView.setAlpha(0);
    roomsRecyclerView.setAlpha(0);
    rulesRecyclerView.setAlpha(0);
  }

  private void animateFilter() {
    filterWindowAnimation.start();
  }

  @Override public void onFilterChange(Characteristics element) {

  }
}
