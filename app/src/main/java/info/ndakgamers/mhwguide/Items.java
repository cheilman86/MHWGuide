package info.ndakgamers.mhwguide;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import info.ndakgamers.mhwguide.cursoradapters.MaterialItemAdapter;
import info.ndakgamers.mhwguide.cursoradapters.MaterialSearchAdapter;


public class Items extends Fragment {

    View myView;
    Cursor cursor;
    Context mContext;
    MaterialSearchAdapter itemAdapter;
    ListView listView;
    private DatabaseHelper dbHelper;
    private final static String TAG= Items.class.getName().toString();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.items, container, false);
        dbHelper = new DatabaseHelper(myView.getContext());
        mContext = getActivity();
        itemAdapter = new MaterialSearchAdapter(myView.getContext(), cursor);
        listView = (ListView) myView.findViewById(R.id.materialsList);
        listView.setAdapter(itemAdapter);

        materialAdapter();

        return myView;
    }




    public Cursor getMaterials(String search) {
        Log.d(TAG, "getMaterials: Started");
        dbHelper.openDataBase();
        Cursor materialCursor = dbHelper.getReadableDatabase().rawQuery("select * from materials", null);
        ListView lvItems = (ListView) myView.findViewById(R.id.materialsList);
        MaterialItemAdapter materials = new MaterialItemAdapter(myView.getContext(), materialCursor);
        lvItems.setAdapter(materials);
        dbHelper.close();


        return cursor;
    }

    private void materialAdapter() {           // This displays the initial list in the background
        Log.d(TAG, "materialAdapter");

        try {
            dbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Cursor materialCursor = dbHelper.getReadableDatabase().rawQuery("select * from materials", null);
        // Find ListView to populate
        ListView lvItems = (ListView) myView.findViewById(R.id.materialsList);
        // Setup cursor adapter using cursor from last step
        MaterialItemAdapter materials = new MaterialItemAdapter(myView.getContext(), materialCursor);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(materials);
        dbHelper.getReadableDatabase().close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d(TAG, "onCreateOptionsMenu");
        //inflate search
        inflater.inflate(R.menu.search_menu, menu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setIconifiedByDefault(false);


//        inflater.inflate(R.menu.search_menu, menu);
//        final MenuItem searchItem = menu.findItem(R.id.action_search);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//
//            SearchView mSearch = (SearchView) searchItem.getActionView();
//            mSearch.setIconified(true);
//
//            SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
//            mSearch.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.d(TAG, "onQueryTextSubmit");
                    cursor = getMaterials(s);
                    if (cursor == null) {
                        Toast.makeText(mContext, "No records found!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(mContext, cursor.getCount() + " records found!", Toast.LENGTH_LONG).show();
                    }
                    itemAdapter.swapCursor(cursor);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange");
                    cursor = getMaterials(s);
                    if (cursor!=null){
                        itemAdapter.swapCursor(cursor);
                    }

                    return false;
                }
            });
        }
    }

    protected void onNewIntent(Intent intent) {
        // Because this activity has set launchMode="singleTop", the system calls this method
        // to deliver the intent if this activity is currently the foreground activity when
        // invoked again (when the user executes a search from this activity, we don't create
        // a new instance of this activity, so the system delivers the search intent here)
        handleIntent(intent);
    }


    private void handleIntent(Intent intent) {
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            // handles a click on a search suggestion; launches activity to show word
            Intent itemIntent = new Intent(getContext(), Home.class);
            itemIntent.setData(intent.getData());
            startActivity(itemIntent);
        } else if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            // handles a search query
            String query = intent.getStringExtra(SearchManager.QUERY);
            showResults(query);
        }
    }

    /**
     * Searches the dictionary and displays results for the given query.
     * @param query The search query
     */

    private void showResults(String query) {

        Cursor materialCursor = null;
        try {
            materialCursor = dbHelper.getReadableDatabase().rawQuery("select * from materials", null);
            ListView lvItems = (ListView) myView.findViewById(R.id.search_list);
            MaterialItemAdapter materials = new MaterialItemAdapter(getContext(), materialCursor);
            lvItems.setAdapter(materials);
        } finally {
            if (materialCursor != null)
                dbHelper.close();
        }
    }

}
