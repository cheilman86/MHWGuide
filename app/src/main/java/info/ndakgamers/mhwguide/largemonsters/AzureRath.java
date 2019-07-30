package info.ndakgamers.mhwguide.largemonsters;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import info.ndakgamers.mhwguide.DatabaseHelper;
import info.ndakgamers.mhwguide.R;
import info.ndakgamers.mhwguide.cursoradapters.LargeMonsterAdapter;
import info.ndakgamers.mhwguide.cursoradapters.LargeMonsterItemAdapter;

/**
 * Created by cheilman on 2/21/2018.
 */

public class AzureRath extends Fragment {

    View myView;
    DatabaseHelper myDbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.large_monster_display, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        // Loading Monster Info
        loadMonster();
        // Loading Monster Items
        loadMonsterItems();

        return myView;

    }

    private void loadMonster() {
        //Opening Database
        DatabaseHelper myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        //Creating our Cursor
        Cursor monsterCursor = myDbHelper.getReadableDatabase().rawQuery("select * from large_monsters where monsterName like \"Azure%\"", null);

        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.large_monster_list);

        // Setup cursor adapter using cursor from last step
        LargeMonsterAdapter monsterAdapter = new LargeMonsterAdapter(myView.getContext(), monsterCursor);

        // Attach cursor adapter to the ListView
        lvItems.setAdapter(monsterAdapter);

        //Closing the database
        myDbHelper.getReadableDatabase().close();
    }

    private void loadMonsterItems(){
        myDbHelper.openDataBase();
        Cursor monsterItemCursor = myDbHelper.getReadableDatabase().rawQuery("select * from materials where (materialname like 'Azure%') or (materialname like 'Rathalos Ruby') or (materialname like 'Rathalos Plate') or (materialname like 'Rathalos Medulla') or (materialname like 'Monster Hardbone') or (materialname like 'inferno sac')",null);
        ListView lvItems = (ListView) myView.findViewById(R.id.monster_item_list);
        LargeMonsterItemAdapter itemAdapter = new LargeMonsterItemAdapter(myView.getContext(), monsterItemCursor);
        lvItems.setAdapter(itemAdapter);
        myDbHelper.getReadableDatabase().close();
    }
}