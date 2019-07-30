package info.ndakgamers.mhwguide.largemonsters;

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
import info.ndakgamers.mhwguide.cursoradapters.LargeMonsterItemAdapter;


public class Anjanath extends Fragment {

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

    private void loadMonster(){
        //Opening Database
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        //Creating our Cursor then closing our Cursor
        Cursor monsterCursor = null;
        try {
            monsterCursor = myDbHelper.getReadableDatabase().rawQuery("select * from large_monsters where monsterName like \"Anjana%\"", null);
            ListView lvItems = (ListView) myView.findViewById(R.id.large_monster_list);
            LargeMonsterAdapter anjaAdapter = new LargeMonsterAdapter(myView.getContext(), monsterCursor);
            lvItems.setAdapter(anjaAdapter);
        } finally {
            if (monsterCursor != null)
                myDbHelper.close();
        }
    }

    private void loadMonsterItems(){
        Cursor monsterItemCursor = null;
        try {
            myDbHelper.openDataBase();
            monsterItemCursor = myDbHelper.getReadableDatabase().rawQuery("select * from materials where (materialname like 'Anjana%') " +
                    "or (materialname like 'flame sac') " +
                    "or (materialname like 'inferno sac')", null);
            ListView lvItems = (ListView) myView.findViewById(R.id.monster_item_list);
            LargeMonsterItemAdapter itemAdapter = new LargeMonsterItemAdapter(myView.getContext(), monsterItemCursor);
            lvItems.setAdapter(itemAdapter);
        } finally {
            if (monsterItemCursor != null)
                myDbHelper.close();
        }
    }



}

