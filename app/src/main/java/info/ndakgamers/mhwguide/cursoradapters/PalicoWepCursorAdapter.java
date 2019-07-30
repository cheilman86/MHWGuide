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
 * Created on 4/2/2018.
 */

public class PalicoWepCursorAdapter extends CursorAdapter

    {
    public PalicoWepCursorAdapter(Context context, Cursor cursor){
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
        TextView tvAttack = (TextView) view.findViewById(R.id.tvpalico2);
        TextView tvDmgType = (TextView) view.findViewById(R.id.tvpalico3);
        TextView tvElement = (TextView) view.findViewById(R.id.tvpalico4);
        TextView tvAffinity = (TextView) view.findViewById(R.id.tvpalico5);
        TextView tvElderSeal = (TextView) view.findViewById(R.id.tvpalico6);
        TextView tvDefense = (TextView) view.findViewById(R.id.tvpalico7);


        // Extract properties from cursor
        String setName = cursor.getString(1);
        int attack = cursor.getInt(2);
        int dmgtype = cursor.getInt(3);
        int element = cursor.getInt(4);
        int affinity = cursor.getInt(5);
        int elder = cursor.getInt(6);
        int defense = cursor.getInt(7);

        // Populate fields with extracted properties
        tvsetName.setText(setName);
        tvAttack.setText(String.valueOf(attack));
        tvDmgType.setText(String.valueOf(dmgtype));
        tvElement.setText(String.valueOf(element));
        tvAffinity.setText(String.valueOf(affinity));
        tvElderSeal.setText(String.valueOf(elder));
        tvDefense.setText(String.valueOf(defense));
    }
    }