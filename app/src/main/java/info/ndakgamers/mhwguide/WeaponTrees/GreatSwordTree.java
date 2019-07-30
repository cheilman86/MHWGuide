package info.ndakgamers.mhwguide.WeaponTrees;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import info.ndakgamers.mhwguide.DatabaseHelper;
import info.ndakgamers.mhwguide.R;
import info.ndakgamers.mhwguide.cursoradapters.WeaponTreeAdapter;

/**
 * Created on 4/8/2018.
 */

public class GreatSwordTree extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.weapons_trees, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        loadGreatSwords();
        return myView;

    }

    private void loadGreatSwords(){
        //Opening Database
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        //Creating our Cursor then closing our Cursor
        Cursor wepCursor = null;
        try {
            wepCursor = myDbHelper.getReadableDatabase().rawQuery("select * from GreatSwordTree", null);
            ListView lvItems = (ListView) myView.findViewById(R.id.wep_tree_list);
            GreatSwordAdapter wepAdapter = new GreatSwordAdapter(myView.getContext(), wepCursor);
            lvItems.setAdapter(wepAdapter);
        } finally {
            if (wepCursor != null)
                myDbHelper.close();
        }
    }

}