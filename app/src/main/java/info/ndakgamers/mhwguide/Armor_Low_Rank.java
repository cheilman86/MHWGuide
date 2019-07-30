package info.ndakgamers.mhwguide;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import info.ndakgamers.mhwguide.cursoradapters.ArmorCursorAdapter;

import static android.content.ContentValues.TAG;


public class Armor_Low_Rank extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.armor_low_rank, container, false);
        Log.d(TAG, "Low Rank Armor: Is Starting");

        myDbHelper = DatabaseHelper.getInstance(myView.getContext());

        lowArmorAdapter();

        return myView;

    }

    public void lowArmorAdapter(){
        Log.d(TAG, "Low Rank Armor Adapter: Started");

        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        Cursor armorCursor = null;
        try {
        armorCursor = myDbHelper.getReadableDatabase().rawQuery("select * from armor_sets where (setname NOT LIKE '%Alpha%') AND (setname NOT LIKE '%Beta%')",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.low_rank_list);

        // Setup cursor adapter using cursor from last step
        ArmorCursorAdapter armorAdapter = new ArmorCursorAdapter(myView.getContext(), armorCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(armorAdapter);

        } finally {
            if (armorCursor != null)
                myDbHelper.close();
        }
    }

}
