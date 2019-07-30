package info.ndakgamers.mhwguide.smallmonsters;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import info.ndakgamers.mhwguide.DatabaseHelper;
import info.ndakgamers.mhwguide.R;
import info.ndakgamers.mhwguide.cursoradapters.LargeMonsterAdapter;

/**
 * Created on 4/4/2018.
 */
public class Small_Monster_Collection extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.small_monster_display, container, false);
        loadApcero();
        return myView;

    }

    private void openDatabase(){
        //Opening Database
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
    }

    private void closeDatabase(){
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        myDbHelper.getReadableDatabase().close();
    }

    private void loadApcero(){
        //Opening Database
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        //Creating our Cursor
        Cursor monsterCursor = myDbHelper.getReadableDatabase().rawQuery("select * from sml_monsters where monsterName like \"Apcero%\"",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.sml_monster_list);

        // Setup cursor adapter using cursor from last step
        LargeMonsterAdapter anjaAdapter = new LargeMonsterAdapter(myView.getContext(), monsterCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(anjaAdapter);

        //Closing the database
        myDbHelper.getReadableDatabase().close();


    }
}