package info.ndakgamers.mhwguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.ndakgamers.mhwguide.WeaponTrees.GreatSwordTree;


public class Weapons extends Fragment implements View.OnClickListener{

    View myView;
    Button wep1,wep2,wep3,wep4,wep5,wep6,wep7,wep8, wep9,wep10,wep11,wep12,wep13,wep14,wep15;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.weapons, container, false);

        wep1 = (Button) myView.findViewById(R.id.greatSword_btn);
        wep2 = (Button) myView.findViewById(R.id.longSword_btn);
        wep3 = (Button) myView.findViewById(R.id.dualBlades_btn);
        wep4 = (Button) myView.findViewById(R.id.swordnShield_btn);
        wep5 = (Button) myView.findViewById(R.id.hammer_btn);
        wep6 = (Button) myView.findViewById(R.id.huntingHorn_btn);
        wep7 = (Button) myView.findViewById(R.id.lance_btn);
        wep8 = (Button) myView.findViewById(R.id.gunlance_btn);
        wep9 = (Button) myView.findViewById(R.id.switchAxe_btn);
        wep10 = (Button) myView.findViewById(R.id.chargeBlade_btn);
        wep11 = (Button) myView.findViewById(R.id.insectGlaive_btn);
        wep12 = (Button) myView.findViewById(R.id.lightBowGun_btn);
        wep13 = (Button) myView.findViewById(R.id.heavyBowGun_btn);
        wep14 = (Button) myView.findViewById(R.id.bow_btn);
        wep15 = (Button) myView.findViewById(R.id.kinsect_btn);

        wep1.setOnClickListener(this);
        wep2.setOnClickListener(this);
        wep3.setOnClickListener(this);
        wep4.setOnClickListener(this);
        wep5.setOnClickListener(this);
        wep6.setOnClickListener(this);
        wep7.setOnClickListener(this);
        wep8.setOnClickListener(this);
        wep9.setOnClickListener(this);
        wep10.setOnClickListener(this);
        wep11.setOnClickListener(this);
        wep12.setOnClickListener(this);
        wep13.setOnClickListener(this);
        wep14.setOnClickListener(this);
        wep15.setOnClickListener(this);

        Drawable drawable = getResources().getDrawable(R.drawable.gs_rank1_2);
        drawable.setBounds(0, 0, (int)(drawable.getIntrinsicWidth()*.50),
                (int)(drawable.getIntrinsicHeight()*.50));
        ScaleDrawable sD = new ScaleDrawable(drawable,0,1,1);

        return myView;
    }

    Fragment fragment = null;

    @Override
    public void onClick(View view) {

        String title = getString(R.string.app_label);

        switch(view.getId()) {
            case R.id.greatSword_btn:
                fragment = new GreatSwordTree();
                title = "Weapons: Great Swords";
                break;

            case R.id.longSword_btn:
                fragment = new ItemFragment();
                title = "Weapons: Test Page";
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, fragment.getTag())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        }

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }
}
