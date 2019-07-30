package info.ndakgamers.mhwguide.cursoradapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import info.ndakgamers.mhwguide.R;

/**
 * Created on 3/26/2018.
 */

public class PalicoCursorAdapter extends CursorAdapter {
    public PalicoCursorAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.palico_view_template, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvsetName = (TextView) view.findViewById(R.id.tvpalico1);
        TextView tvDefense = (TextView) view.findViewById(R.id.tvpalico2);
        TextView tvFire = (TextView) view.findViewById(R.id.tvpalico3);
        TextView tvWater = (TextView) view.findViewById(R.id.tvpalico4);
        TextView tvThunder = (TextView) view.findViewById(R.id.tvpalico5);
        TextView tvIce = (TextView) view.findViewById(R.id.tvpalico6);
        TextView tvDragon = (TextView) view.findViewById(R.id.tvpalico7);


        // Extract properties from cursor
        String setName = cursor.getString(1);
        int defense = cursor.getInt(2);
        int fire = cursor.getInt(3);
        int water = cursor.getInt(4);
        int thunder = cursor.getInt(5);
        int ice = cursor.getInt(6);
        int dragon = cursor.getInt(7);

        // Populate fields with extracted properties
        tvsetName.setText(setName);
        tvDefense.setText(String.valueOf(defense));
        tvFire.setText(String.valueOf(fire));
        tvWater.setText(String.valueOf(water));
        tvThunder.setText(String.valueOf(thunder));
        tvIce.setText(String.valueOf(ice));
        tvDragon.setText(String.valueOf(dragon));
    }
}
