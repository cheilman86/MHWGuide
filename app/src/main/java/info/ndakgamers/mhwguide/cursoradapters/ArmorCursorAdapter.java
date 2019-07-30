package info.ndakgamers.mhwguide.cursoradapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import info.ndakgamers.mhwguide.R;


public class ArmorCursorAdapter extends CursorAdapter{

    public ArmorCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.armor_view_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvSetName = (TextView) view.findViewById(R.id.tv_SetName);
        TextView tvSlots = (TextView) view.findViewById(R.id.tv_slots);
        TextView tvDefense = (TextView) view.findViewById(R.id.tv_defense);
        TextView tvFire = (TextView) view.findViewById(R.id.tv_fire_def);
        TextView tvWater = (TextView) view.findViewById(R.id.tv_water_def);
        TextView tvThunder = (TextView) view.findViewById(R.id.tv_thunder_def);
        TextView tvIce = (TextView) view.findViewById(R.id.tv_ice_def);
        TextView tvDragon = (TextView) view.findViewById(R.id.tv_dragon_def);
        TextView tvSetBonus = (TextView) view.findViewById(R.id.tv_set_bonus);

        // Extract properties from cursor
        String setName = cursor.getString(1);
        int defense = cursor.getInt(2);
        String slots = cursor.getString(3);
        int fire = cursor.getInt(4);
        int water = cursor.getInt(5);
        int thunder = cursor.getInt(6);
        int ice = cursor.getInt(7);
        int dragon = cursor.getInt(8);
        String setBonus = cursor.getString(9);


        // Populate fields with extracted properties
        tvSetName.setText(setName);
        tvDefense.setText(String.valueOf(defense));
        tvSlots.setText(String.valueOf(slots));
        tvFire.setText(String.valueOf(fire));
        tvWater.setText(String.valueOf(water));
        tvThunder.setText(String.valueOf(thunder));
        tvIce.setText(String.valueOf(ice));
        tvDragon.setText(String.valueOf(dragon));
        tvSetBonus.setText(setBonus);

    }
}
