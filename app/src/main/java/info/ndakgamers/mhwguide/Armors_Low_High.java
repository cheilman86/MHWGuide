package info.ndakgamers.mhwguide;

import android.support.design.widget.TabLayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;


public class Armors_Low_High extends Fragment{

    View myView;
    DatabaseHelper dbHelper;
    Armor_Low_Rank armor_low_rank;
    Armor_High_Rank armor_high_rank;
    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.armors, container, false);
        Log.d(TAG, "Armor OnCreateView: Is Starting");

        sectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());
        dbHelper = new DatabaseHelper(myView.getContext());
        dbHelper.openDataBase();
        mViewPager = (ViewPager) myView.findViewById(R.id.viewPager);
        setupViewPager(mViewPager);
        dbHelper.close();

        TabLayout tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //armor_high_rank.highArmorAdapter();  <----- Here I attempted to call the Methods from the 'sub' fragments
        //armor_low_rank.lowArmorAdapter();

        return myView;

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
            adapter.addFragment(new Armor_Low_Rank(), "Low Rank");
            adapter.addFragment(new Armor_High_Rank(), "High Rank");
            viewPager.setAdapter(adapter);
    }


}
