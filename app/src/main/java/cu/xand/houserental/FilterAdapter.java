package cu.xand.houserental;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cu.xand.houserental.data.Characteristics;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

  final Characteristics[] characteristics;
  final FilterListener filterListener;
  final Context context;

  public FilterAdapter(Context context, Characteristics[] characteristics,
      FilterListener filterListener) {
    this.context = context;
    this.characteristics = characteristics;
    this.filterListener = filterListener;
  }

  @Override public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    final View view = layoutInflater.inflate(R.layout.list_item_characteristic, parent, false);
    final FilterViewHolder vh = new FilterViewHolder(view);

    view.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        final int pos = vh.getAdapterPosition();
        final Characteristics element = characteristics[pos];
        element.setActive(!element.isActive());
        filterListener.onFilterChange(element);
        notifyItemChanged(pos);
      }
    });
    return vh;
  }

  @Override public void onBindViewHolder(FilterViewHolder holder, int position) {

    final Characteristics element = characteristics[position];
    holder.tv_filter_element.setText(element.getName());
    holder.tv_filter_element.setBackgroundResource(
        element.isActive() ? R.drawable.filter_element_active : R.drawable.filter_element);
    holder.tv_filter_element.setTextColor(
        element.isActive() ? ContextCompat.getColor(context, R.color.white)
            : ContextCompat.getColor(context, R.color.colorFilterElementText));
  }

  @Override public int getItemCount() {
    return characteristics == null ? 0 : characteristics.length;
  }

  public interface FilterListener {
    void onFilterChange(Characteristics element);
  }

  class FilterViewHolder extends RecyclerView.ViewHolder {

    TextView tv_filter_element;

    public FilterViewHolder(View itemView) {
      super(itemView);
      this.tv_filter_element = (TextView) itemView;
    }
  }
}
