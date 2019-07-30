package info.ndakgamers.mhwguide.cursoradapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import info.ndakgamers.mhwguide.R;

/**
 * Created on 3/26/2018.
 */

public class WeaponTreeAdapter extends CursorAdapter {

    ImageView weaponImage,elementImage;
    LinearLayout masterLayer,sectionLayer;

    public WeaponTreeAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.wep_tree_view_adapter, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Setting our Image IDs
        weaponImage = (ImageView) view.findViewById(R.id.iv_rank_pic);
        elementImage = (ImageView) view.findViewById(R.id.iv_element);

        // Setting our Layout IDs
        masterLayer = (LinearLayout) view.findViewById(R.id.ll_master_layout);
        sectionLayer = (LinearLayout) view.findViewById(R.id.wep_layout_item);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) sectionLayer.getLayoutParams();

        // Find fields to populate in inflated template
        TextView tvWepName = (TextView) view.findViewById(R.id.weapon_title);
        TextView tvTree = (TextView) view.findViewById(R.id.tv_Tree);
        TextView tvAtk = (TextView) view.findViewById(R.id.tv_Atk);
        TextView tvAff = (TextView) view.findViewById(R.id.tv_Affinity);
        TextView tvSlot = (TextView) view.findViewById(R.id.tv_Slots);
        TextView tvElder = (TextView) view.findViewById(R.id.tv_Elder);
        TextView tvElem = (TextView) view.findViewById(R.id.tv_Element);
//        TextView tvRank8 = (TextView) view.findViewById(R.id.rank8_pos);

        // Extract properties from cursor
        String name = cursor.getString(1);
        int attack = cursor.getInt(2);
        String element = cursor.getString(3);
//        String sharpness = cursor.getString(4);
        String slots = cursor.getString(5);
        int affinity = cursor.getInt(6);
        String elderseal = cursor.getString(7);
        String parenttree = cursor.getString(9);

        // Shifting our Layout sections
        if (name.contains("White")){
            layoutParams.setMargins(20,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank1_2);
        } else if (name.contains("Yellow")) {
            layoutParams.setMargins(35,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank3);
        } else if (name.contains("Green")) {
            layoutParams.setMargins(50,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank4);
        } else if (name.contains("Light Blue")) {
            layoutParams.setMargins(65,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank5);
        } else if (name.contains("Blue")) {
            layoutParams.setMargins(80,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank6);
        } else if (name.contains("Purple")) {
            layoutParams.setMargins(95,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank7);
        } else if (name.contains("Orange")) {
            layoutParams.setMargins(110,0,0,15);
            weaponImage.setImageResource(R.drawable.gs_rank8);
        }
        sectionLayer.setLayoutParams(layoutParams);

        // Removing color from name
        name = name.replace("White","");
        name = name.replace("Yellow","");
        name = name.replace("Green","");
        name = name.replace("Light Blue","");
        name = name.replace("Blue","");
        name = name.replace("Purple","");
        name = name.replace("Orange","");

        // Setting Element Images

        if (element.contains("Dragon")){
            elementImage.setImageResource(R.drawable.element_dragon);
        } else if (element.contains("Ice")){
            elementImage.setImageResource(R.drawable.element_ice);
        } else if (element.contains("Water")){
            elementImage.setImageResource(R.drawable.element_water);
        } else if (element.contains("Fire")){
            elementImage.setImageResource(R.drawable.element_fire);
        } else if (element.contains("Thunder")){
            elementImage.setImageResource(R.drawable.element_thunder);
        } else if (element.contains("Blast")){
            elementImage.setImageResource(R.drawable.status_blast);
        } else if (element.contains("Poison")){
        elementImage.setImageResource(R.drawable.status_poison);
        } else if (element.contains("Sleep")){
            elementImage.setImageResource(R.drawable.status_sleep);
        } else if (element.contains("Paralysis")) {
            elementImage.setImageResource(R.drawable.status_paralyze);
        } else {
            elementImage.setImageResource(0);
        }


        // Removing status from element
        element = element.replace("Dragon","");
        element = element.replace("Ice","");
        element = element.replace("Water","");
        element = element.replace("Fire","");
        element = element.replace("Thunder","");
        element = element.replace("Blast","");
        element = element.replace("Poison","");
        element = element.replace("Sleep","");
        element = element.replace("Paralysis","");


        // Creating new lines for separate values in the string
        parenttree = parenttree.replace("_"," ");
        slots = slots.replace("-"," - ");
        slots = slots.replace("1"," 1 ");
        slots = slots.replace("2"," 2 ");


        // Populate fields with extracted properties
        tvWepName.setText(name);
        tvTree.setText(String.valueOf(parenttree));
        tvAtk.setText("Attack:   " + String.valueOf(attack));
        tvAff.setText("Affinity:   " + String.valueOf(affinity));
        tvSlot.setText("Slots:   " + String.valueOf(slots));
        tvElder.setText("Elderseal:    " + String.valueOf(elderseal));
        tvElem.setText(String.valueOf(element));


    }

}
