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
import info.ndakgamers.mhwguide.cursoradapters.SmallMonsterAdapter;

/**
 * Created on 4/4/2018.
 */
public class Hornetaur extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.small_monster_display, container, false);
        loadMonster();
        return myView;

    }

    private void loadMonster(){
        //Opening Database
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        //Creating our Cursor
        Cursor monsterCursor = myDbHelper.getReadableDatabase().rawQuery("select * from sml_monsters where monsterName like \"Hornet%\"",null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.sml_monster_list);

        // Setup cursor adapter using cursor from last step
        SmallMonsterAdapter monsterAdapter = new SmallMonsterAdapter(myView.getContext(), monsterCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(monsterAdapter);

        //Closing the database
        myDbHelper.getReadableDatabase().close();


    }
}