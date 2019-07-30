package info.ndakgamers.mhwguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.ndakgamers.mhwguide.smallmonsters.Apceros;
import info.ndakgamers.mhwguide.smallmonsters.Aptonoth;
import info.ndakgamers.mhwguide.smallmonsters.Barnos;
import info.ndakgamers.mhwguide.smallmonsters.Gajau;
import info.ndakgamers.mhwguide.smallmonsters.Gastodon;
import info.ndakgamers.mhwguide.smallmonsters.Girros;
import info.ndakgamers.mhwguide.smallmonsters.Hornetaur;
import info.ndakgamers.mhwguide.smallmonsters.Jagras;
import info.ndakgamers.mhwguide.smallmonsters.Kelbi;
import info.ndakgamers.mhwguide.smallmonsters.Kestodon;
import info.ndakgamers.mhwguide.smallmonsters.Mernos;
import info.ndakgamers.mhwguide.smallmonsters.Mosswine;
import info.ndakgamers.mhwguide.smallmonsters.Noios;
import info.ndakgamers.mhwguide.smallmonsters.Raphinos;
import info.ndakgamers.mhwguide.smallmonsters.Shamos;
import info.ndakgamers.mhwguide.smallmonsters.Vespoid;


public class Small_Monsters extends Fragment implements View.OnClickListener {

    View myView;
    Button bb1, bb2, bb3, bb4, bb5, bb6, bb7, bb8, bb9, bb10, bb11, bb12, bb13, bb14, bb15, bb16;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.small_monsters, container, false);

        //Setting buttons
        bb1 = (Button) myView.findViewById(R.id.Apcerosbtn);
        bb2 = (Button) myView.findViewById(R.id.Aptonothbtn);
        bb3 = (Button) myView.findViewById(R.id.Barnosbtn);
        bb4 = (Button) myView.findViewById(R.id.Gajaubtn);
        bb5 = (Button) myView.findViewById(R.id.Gastodonbtn);
        bb6 = (Button) myView.findViewById(R.id.Girrosbtn);
        bb7 = (Button) myView.findViewById(R.id.Hornetaurbtn);
        bb8 = (Button) myView.findViewById(R.id.Jagrasbtn);
        bb9 = (Button) myView.findViewById(R.id.Kelbibtn);
        bb10 = (Button) myView.findViewById(R.id.Kestodonbtn);
        bb11 = (Button) myView.findViewById(R.id.Mernosbtn);
        bb12 = (Button) myView.findViewById(R.id.Mosswinebtn);
        bb13 = (Button) myView.findViewById(R.id.Noiosbtn);
        bb14 = (Button) myView.findViewById(R.id.Raphinosbtn);
        bb15 = (Button) myView.findViewById(R.id.Shamosbtn);
        bb16 = (Button) myView.findViewById(R.id.Vespoidbtn);

        //Setting OnClick
        bb1.setOnClickListener(this);
        bb2.setOnClickListener(this);
        bb3.setOnClickListener(this);
        bb4.setOnClickListener(this);
        bb5.setOnClickListener(this);
        bb6.setOnClickListener(this);
        bb7.setOnClickListener(this);
        bb8.setOnClickListener(this);
        bb9.setOnClickListener(this);
        bb10.setOnClickListener(this);
        bb11.setOnClickListener(this);
        bb12.setOnClickListener(this);
        bb13.setOnClickListener(this);
        bb14.setOnClickListener(this);
        bb15.setOnClickListener(this);
        bb16.setOnClickListener(this);

        return myView;
    }

    Fragment fragment = null;

    @Override
    public void onClick(View v) {

        String title = getString(R.string.app_label);

        if (v == bb1) {
            fragment = new Apceros();
            title = "Small Monsters: Apceros";

        } else if (v == bb2) {
            fragment = new Aptonoth();
            title = "Small Monsters: Aptonoth";

        } else if (v == bb3) {
            fragment = new Barnos();
            title = "Small Monsters: Barnos";

        } else if (v == bb4) {
            fragment = new Gajau();
            title = "Small Monsters: Gajau";

        } else if (v == bb5) {
            fragment = new Gastodon();
            title = "Small Monsters: Gastodon";

        } else if (v == bb6) {
            fragment = new Girros();
            title = "Small Monsters: Girros";

        } else if (v == bb7) {
            fragment = new Hornetaur();
            title = "Small Monsters: Hornetaur";

        } else if (v == bb8) {
            fragment = new Jagras();
            title = "Small Monsters: Jagras";

        } else if (v == bb9) {
            fragment = new Kelbi();
            title = "Small Monsters: Kelbi";

        } else if (v == bb10) {
            fragment = new Kestodon();
            title = "Small Monsters: Kestodon";

        } else if (v == bb11) {
            fragment = new Mernos();
            title = "Small Monsters: Mernos";

        } else if (v == bb12) {
            fragment = new Mosswine();
            title = "Small Monsters: Mosswine";

        } else if (v == bb13) {
            fragment = new Noios();
            title = "Small Monsters: Noios";

        } else if (v == bb14) {
            fragment = new Raphinos();
            title = "Small Monsters: Raphinos";

        } else if (v == bb15) {
            fragment = new Shamos();
            title = "Small Monsters: Shamos";

        } else if (v == bb16) {
            fragment = new Vespoid();
            title = "Small Monsters: Vespoid";

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
