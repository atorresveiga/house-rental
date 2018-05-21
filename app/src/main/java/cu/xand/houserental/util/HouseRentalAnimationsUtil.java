package cu.xand.houserental.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import cu.xand.houserental.R;

public class HouseRentalAnimationsUtil {

  /**
   * This method converts dp unit to equivalent pixels, depending on device density.
   *
   * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
   * @param context Context to get resources and device specific display metrics
   * @return A float value to represent px equivalent to dp depending on device density
   */
  public static float convertDpToPixel(float dp, Context context) {
    Resources resources = context.getResources();
    DisplayMetrics metrics = resources.getDisplayMetrics();
    float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    return px;
  }

  /**
   * This method converts device specific pixels to density independent pixels.
   *
   * @param px A value in px (pixels) unit. Which we need to convert into db
   * @param context Context to get resources and device specific display metrics
   * @return A float value to represent dp equivalent to px value
   */
  public static float convertPixelsToDp(float px, Context context) {
    Resources resources = context.getResources();
    DisplayMetrics metrics = resources.getDisplayMetrics();
    float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    return dp;
  }

  public static float filterButtonTranslationDistance(Context context) {

    float marginBottom = context.getResources().getDimension(R.dimen.button_bottom_margin);
    float buttonSize = convertDpToPixel(60, context);

    return marginBottom + buttonSize;
  }

  public static float filterListsTranslationDistance(Context context) {

    float marginLabel = context.getResources().getDimension(R.dimen.filter_card_label_margin);
    return marginLabel;
  }

  public static AnimatorSet filterAnimation(View filter, View propertyRecyclerView,
      View roomsRecyclerView, View featuresRecyclerView, View rulesRecyclerView) {

    ObjectAnimator filterSlideUp =
        ObjectAnimator.ofFloat(filter, "translationY", 0).setDuration(400);
    filterSlideUp.setStartDelay(200);

    ObjectAnimator propertySlideUp =
        ObjectAnimator.ofFloat(propertyRecyclerView, "translationY", 0);
    ObjectAnimator roomsSlideUp = ObjectAnimator.ofFloat(roomsRecyclerView, "translationY", 0);
    ObjectAnimator featuresSlideUp =
        ObjectAnimator.ofFloat(featuresRecyclerView, "translationY", 0);
    ObjectAnimator rulesSlideUp = ObjectAnimator.ofFloat(rulesRecyclerView, "translationY", 0);

    ValueAnimator propertyFadeAnim = ObjectAnimator.ofFloat(propertyRecyclerView, "alpha", 0f, 1f);
    ValueAnimator roomsFadeAnim = ObjectAnimator.ofFloat(roomsRecyclerView, "alpha", 0f, 1f);
    ValueAnimator featuresFadeAnim = ObjectAnimator.ofFloat(featuresRecyclerView, "alpha", 0f, 1f);
    ValueAnimator rulesFadeAnim = ObjectAnimator.ofFloat(rulesRecyclerView, "alpha", 0f, 1f);

    AnimatorSet listsAnimation = new AnimatorSet();
    listsAnimation.setDuration(300)
        .playTogether(propertySlideUp, roomsSlideUp, featuresSlideUp, rulesSlideUp,
            propertyFadeAnim, roomsFadeAnim, featuresFadeAnim, rulesFadeAnim);
    listsAnimation.setStartDelay(200);

    AnimatorSet filterWindowAnimation = new AnimatorSet();
    filterWindowAnimation.playTogether(listsAnimation, filterSlideUp);
    filterWindowAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

    return filterWindowAnimation;
  }
}
