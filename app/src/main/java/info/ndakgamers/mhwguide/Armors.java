package info.ndakgamers.mhwguide;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import info.ndakgamers.mhwguide.cursoradapters.ArmorCursorAdapter;

/**
 * Created by cheilman on 2/20/2018.
 */

public class Armors extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.armors, container, false);
        armorAdapter();
        return myView;

    }

    private void armorAdapter(){
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Cursor armorCursor = myDbHelper.getReadableDatabase().rawQuery("select * from armor_sets",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.sml_monster_list);

        // Setup cursor adapter using cursor from last step
        ArmorCursorAdapter armorAdapter = new ArmorCursorAdapter(myView.getContext(), armorCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(armorAdapter);

        myDbHelper.getReadableDatabase().close();

    }

}
