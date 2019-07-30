package info.ndakgamers.mhwguide;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import info.ndakgamers.mhwguide.cursoradapters.PalicoWepCursorAdapter;

/**
 * Created on 4/2/2018.
 */

public class Palico_Weapons extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.palico_weapons, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        palicoWeapons();
        return myView;

    }

    private void palicoWeapons(){

        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Cursor weaponCursor = null;
        try {
            weaponCursor = myDbHelper.getReadableDatabase().rawQuery("select * from palico_weapons",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.palico_wep_list);

        // Setup cursor adapter using cursor from last step
        PalicoWepCursorAdapter wepCursorAdapter = new PalicoWepCursorAdapter(myView.getContext(), weaponCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(wepCursorAdapter);

        } finally {
            if (weaponCursor != null)
                myDbHelper.close();
        }
    }

}
