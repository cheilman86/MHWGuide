package info.ndakgamers.mhwguide;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created on 4/27/2018.
 */

class SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView name, location, value;
    Cursor mCursor;
    Context mContext;
    DatabaseHelper dbhelper;

    public SearchViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_itemName);
        location = itemView.findViewById(R.id.tv_itemLocation);
        value = itemView.findViewById(R.id.tv_rarityValue);
    }

    public void bindCursor(Cursor cursor){

    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Items> itemsList;

    public SearchAdapter(Context context, List<Items> lvitems) {
        this.context = context;
        this.itemsList = lvitems;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.search_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.name.setText(itemsList.get(position).getMaterials(null).getInt(R.id.search_name));
        holder.location.setText(itemsList.get(position).getMaterials(null).getInt(R.id.search_summary));

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
