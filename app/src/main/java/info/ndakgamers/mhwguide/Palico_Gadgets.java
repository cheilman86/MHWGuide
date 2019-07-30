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
import info.ndakgamers.mhwguide.cursoradapters.PalicoGadgetCursorAdapter;
import info.ndakgamers.mhwguide.cursoradapters.PalicoWepCursorAdapter;

/**
 * Created on 4/2/2018.
 */

public class Palico_Gadgets extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.palico_weapons, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        palicoGadgets();
        return myView;

    }

    private void palicoGadgets(){

        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Cursor gadgetCursor = null;
        try {
            gadgetCursor = myDbHelper.getReadableDatabase().rawQuery("select * from palico_gadgets",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.palico_wep_list);

        // Setup cursor adapter using cursor from last step
        PalicoGadgetCursorAdapter palicoAdapter = new PalicoGadgetCursorAdapter(myView.getContext(), gadgetCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(palicoAdapter);

        } finally {
            if (gadgetCursor != null)
                myDbHelper.close();
        }

    }

}
