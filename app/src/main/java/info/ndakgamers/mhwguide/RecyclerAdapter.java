package info.ndakgamers.mhwguide;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    private ArrayList<recycler_Item> mRecyclerList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        private Context mContext;
        private Cursor mCursor;
        private boolean mDataValid;
        private int mRowIdColumn;
        private DataSetObserver mDataSetObserver;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.rec_itemImage);
            mTextView1 = itemView.findViewById(R.id.rec_itemLocation);
            mTextView2 = itemView.findViewById(R.id.rec_itemName);
        }
    }

    public RecyclerAdapter(ArrayList<recycler_Item> adapterList) {
        mRecyclerList = adapterList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return (ivh);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        recycler_Item currentItem = mRecyclerList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mRecyclerList.size();
    }

}
