package info.ndakgamers.mhwguide.search;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

import info.ndakgamers.mhwguide.DatabaseHelper;
import info.ndakgamers.mhwguide.Home;
import info.ndakgamers.mhwguide.R;
import info.ndakgamers.mhwguide.cursoradapters.MaterialItemAdapter;

/**
 * Created on 4/30/2018.
 */
public class SearchableItems extends AppCompatActivity{

    private TextView mTextView;
    private ListView mListView;
    private DatabaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_fragment);

        dbHelper = DatabaseHelper.getInstance(this);

        mListView = findViewById(R.id.search_list);
        mTextView = findViewById(R.id.search_text);
    }

    @Override
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
            Intent itemIntent = new Intent(this, SearchableItems.class);
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
            ListView lvItems = (ListView) findViewById(R.id.search_list);
            MaterialItemAdapter materials = new MaterialItemAdapter(this, materialCursor);
            lvItems.setAdapter(materials);
        } finally {
            if (materialCursor != null)
                dbHelper.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                onSearchRequested();
                return true;
            default:
                return false;
        }
    }
}
