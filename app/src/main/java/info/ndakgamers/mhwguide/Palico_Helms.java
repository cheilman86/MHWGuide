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

import info.ndakgamers.mhwguide.cursoradapters.PalicoCursorAdapter;
import info.ndakgamers.mhwguide.cursoradapters.PalicoWepCursorAdapter;

/**
 * Created on 4/2/2018.
 */

public class Palico_Helms extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.palico_weapons, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        palicoHelms();
        return myView;

    }

    private void palicoHelms(){
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Cursor helmCursor = null;
        try {
            helmCursor = myDbHelper.getReadableDatabase().rawQuery("select * from palico_helms",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.palico_wep_list);

        // Setup cursor adapter using cursor from last step
        PalicoCursorAdapter palicoAdapter = new PalicoCursorAdapter(myView.getContext(), helmCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(palicoAdapter);

        } finally {
            if (helmCursor != null)
                myDbHelper.close();
        }

    }

}
