package cu.xand.houserental;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cu.xand.houserental.data.House;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder> {

  final House[] houses;
  final Context context;
  final HouseClickListener houseClickListener;

  public HouseAdapter(Context context, House[] houses, HouseClickListener houseClickListener) {
    this.houses = houses;
    this.context = context;
    this.houseClickListener = houseClickListener;
  }

  @Override public HouseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.list_item_house, parent, false);
    final HouseViewHolder viewHolder = new HouseViewHolder(view);
    viewHolder.houseView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        int pos = viewHolder.getAdapterPosition();
        houseClickListener.onHouseClick(houses[pos]);
      }
    });
    return viewHolder;
  }

  @Override public void onBindViewHolder(HouseViewHolder holder, int position) {
    final House house = houses[position];
    holder.tv_price.setText(context.getString(R.string.price, String.valueOf(house.getPrice())));
    holder.tv_title.setText(house.getTitle());
    holder.tv_rooms.setText(context.getString(R.string.rooms, house.getRooms()));
    holder.tv_size.setText(context.getString(R.string.size, String.valueOf(house.getSize())));
    holder.tv_type.setText(house.getType());
  }

  @Override public int getItemCount() {
    return houses != null ? houses.length : 0;
  }

  interface HouseClickListener {
    void onHouseClick(House house);
  }

  class HouseViewHolder extends RecyclerView.ViewHolder {

    final View houseView;
    final TextView tv_price;
    final TextView tv_title;
    final TextView tv_rooms;
    final TextView tv_size;
    final TextView tv_type;

    public HouseViewHolder(View itemView) {
      super(itemView);
      houseView = itemView.findViewById(R.id.cl_house_view);
      tv_price = itemView.findViewById(R.id.tv_price);
      tv_title = itemView.findViewById(R.id.tv_house_title);
      tv_rooms = itemView.findViewById(R.id.tv_rooms);
      tv_size = itemView.findViewById(R.id.tv_size);
      tv_type = itemView.findViewById(R.id.tv_type);
    }
  }
}
