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

import info.ndakgamers.mhwguide.cursoradapters.CharmsAdapter;
import info.ndakgamers.mhwguide.cursoradapters.MaterialItemAdapter;

/**
 * Created by cheilman on 2/20/2018.
 */

public class Charms extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.charms, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        materialAdapter();
        return myView;

    }

    private void materialAdapter() {
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        Cursor materialCursor = null;
        try {
        materialCursor = myDbHelper.getReadableDatabase().rawQuery("select * from charms", null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.charmsList);

        // Setup cursor adapter using cursor from last step
        CharmsAdapter charms = new CharmsAdapter(myView.getContext(), materialCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(charms);

        } finally {
            if (materialCursor != null)
                myDbHelper.close();
        }
    }
}
