package info.ndakgamers.mhwguide;

import android.support.design.widget.AppBarLayout;
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

import info.ndakgamers.mhwguide.largemonsters.Anjanath;
import info.ndakgamers.mhwguide.largemonsters.AzureRath;
import info.ndakgamers.mhwguide.largemonsters.Barroth;
import info.ndakgamers.mhwguide.largemonsters.Bazelgeuse;
import info.ndakgamers.mhwguide.largemonsters.BlkDiablos;
import info.ndakgamers.mhwguide.largemonsters.Deviljho;
import info.ndakgamers.mhwguide.largemonsters.Diablos;
import info.ndakgamers.mhwguide.largemonsters.Dodogama;
import info.ndakgamers.mhwguide.largemonsters.GreatGirros;
import info.ndakgamers.mhwguide.largemonsters.GreatJagras;
import info.ndakgamers.mhwguide.largemonsters.Jyuratodus;
import info.ndakgamers.mhwguide.largemonsters.Kirin;
import info.ndakgamers.mhwguide.largemonsters.KuluYaKu;
import info.ndakgamers.mhwguide.largemonsters.KulveTaroth;
import info.ndakgamers.mhwguide.largemonsters.Kushala;
import info.ndakgamers.mhwguide.largemonsters.Lavasioth;
import info.ndakgamers.mhwguide.largemonsters.Legiana;
import info.ndakgamers.mhwguide.largemonsters.Nergigante;
import info.ndakgamers.mhwguide.largemonsters.Odogaron;
import info.ndakgamers.mhwguide.largemonsters.Paolumu;
import info.ndakgamers.mhwguide.largemonsters.PinkRathian;
import info.ndakgamers.mhwguide.largemonsters.Pukei;
import info.ndakgamers.mhwguide.largemonsters.Radobaan;
import info.ndakgamers.mhwguide.largemonsters.Rathalos;
import info.ndakgamers.mhwguide.largemonsters.Rathian;
import info.ndakgamers.mhwguide.largemonsters.Teostra;
import info.ndakgamers.mhwguide.largemonsters.TobiKadachi;
import info.ndakgamers.mhwguide.largemonsters.Tzitzi;
import info.ndakgamers.mhwguide.largemonsters.Uragaan;
import info.ndakgamers.mhwguide.largemonsters.VaalHazak;
import info.ndakgamers.mhwguide.largemonsters.Xenojiva;
import info.ndakgamers.mhwguide.largemonsters.ZorahMag;


public class Large_Monsters extends Fragment
        implements View.OnClickListener {

    View myView;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
            b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.large_monsters, container, false);

        b1 = (Button) myView.findViewById(R.id.anjabtn);
        b2 = (Button) myView.findViewById(R.id.barrbtn);
        b3 = (Button) myView.findViewById(R.id.bazebtn);
        b4 = (Button) myView.findViewById(R.id.devbtn);
        b5 = (Button) myView.findViewById(R.id.diabbtn);
        b6 = (Button) myView.findViewById(R.id.blkdiabbtn);
        b7 = (Button) myView.findViewById(R.id.dogobtn);
        b8 = (Button) myView.findViewById(R.id.girrosbtn);
        b9 = (Button) myView.findViewById(R.id.jargasbtn);
        b10 = (Button) myView.findViewById(R.id.jyurbtn);
        b11 = (Button) myView.findViewById(R.id.krinbtn);
        b12 = (Button) myView.findViewById(R.id.kulubtn);
        b13 = (Button) myView.findViewById(R.id.kushbtn);
        b14 = (Button) myView.findViewById(R.id.lavabtn);
        b15 = (Button) myView.findViewById(R.id.legbtn);
        b16 = (Button) myView.findViewById(R.id.odogbtn);
        b17 = (Button) myView.findViewById(R.id.nergbtn);
        b18 = (Button) myView.findViewById(R.id.paolubtn);
        b19 = (Button) myView.findViewById(R.id.pukeibtn);
        b20 = (Button) myView.findViewById(R.id.radobtn);
        b21 = (Button) myView.findViewById(R.id.rathobtn);
        b22 = (Button) myView.findViewById(R.id.azrathobtn);
        b23 = (Button) myView.findViewById(R.id.rathibtn);
        b24 = (Button) myView.findViewById(R.id.pnkrathibtn);
        b25 = (Button) myView.findViewById(R.id.tesotrabtn);
        b26 = (Button) myView.findViewById(R.id.tobibtn);
        b27 = (Button) myView.findViewById(R.id.tzitzibtn);
        b28 = (Button) myView.findViewById(R.id.uragbtn);
        b29 = (Button) myView.findViewById(R.id.vaalbtn);
        b30 = (Button) myView.findViewById(R.id.xenobtn);
        b31 = (Button) myView.findViewById(R.id.zorahbtn);
        b32 = (Button) myView.findViewById(R.id.kulvebtn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);
        b17.setOnClickListener(this);
        b18.setOnClickListener(this);
        b19.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b24.setOnClickListener(this);
        b25.setOnClickListener(this);
        b26.setOnClickListener(this);
        b27.setOnClickListener(this);
        b28.setOnClickListener(this);
        b29.setOnClickListener(this);
        b30.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);


        return myView;
    }

    Fragment fragment = null;

    @Override
    public void onClick(View v) {

        String title = getString(R.string.app_label);

        if (v == b1) {
            fragment = new Anjanath();
            title = "Large Monsters: Anjanath";

        } else if (v == b2) {
            fragment = new Barroth();
            title = "Large Monsters: Barroth";

        } else if (v == b3) {
            fragment = new Bazelgeuse();
            title = "Large Monsters: Bazelgeuse";

        } else if (v == b4) {
            fragment = new Deviljho();
            title = "Large Monsters: Deviljho";

        } else if (v == b5) {
            fragment =  new Diablos();
            title = "Large Monsters: Diablos";

        } else if (v == b6) {
            fragment =  new BlkDiablos();
            title = "Large Monsters: Black Diablos";

        } else if (v == b7) {
            fragment =  new Dodogama();
            title = "Large Monsters: Dodogama";

        } else if (v == b8) {
            fragment = new GreatGirros();
            title = "Large Monsters: Great Girros";

        } else if (v == b9) {
            fragment = new GreatJagras();
            title = "Large Monsters: Great Jagras";

        } else if (v == b10) {
            fragment = new Jyuratodus();
            title = "Large Monsters: Jyuratodus";

        } else if (v == b11) {
            fragment = new Kirin();
            title = "Large Monsters: Kirin";

        } else if (v == b12) {
            fragment = new KuluYaKu();
            title = "Large Monsters: Kulu-Ya-Ku";

        } else if (v == b13) {
            fragment =  new Kushala();
            title = "Large Monsters: Kushala Daora";

        } else if (v == b14) {
            fragment =  new Lavasioth();
            title = "Large Monsters: Lavasioth";

        } else if (v == b15) {
            fragment =  new Legiana();
            title = "Large Monsters: Legiana";

        } else if (v == b16) {
            fragment =  new Odogaron();
            title = "Large Monsters: Odogaron";

        } else if (v == b17) {
            fragment =  new Nergigante();
            title = "Large Monsters: Nergigante";

        } else if (v == b18) {
            fragment =  new Paolumu();
            title = "Large Monsters: Paolumu";

        } else if (v == b19) {
            fragment =  new Pukei();
            title = "Large Monsters: Pukei-Pukei";

        } else if (v == b20) {
            fragment =  new Radobaan();
            title = "Large Monsters: Radobaan";

        } else if (v == b21) {
            fragment =  new Rathalos();
            title = "Large Monsters: Rathalos";

        } else if (v == b22) {
            fragment =  new AzureRath();
            title = "Large Monsters: Azure Rathalos";

        } else if (v == b23) {
            fragment =  new Rathian();
            title = "Large Monsters: Rathian";

        } else if (v == b24) {
            fragment =  new PinkRathian();
            title = "Large Monsters: Pink Rathian";

        } else if (v == b25) {
            fragment =  new Teostra();
            title = "Large Monsters: Teostra";

        } else if (v == b26) {
            fragment =  new TobiKadachi();
            title = "Large Monsters: Tobi-Kadachi";

        } else if (v == b27) {
            fragment =  new Tzitzi();
            title = "Large Monsters: Tzitzi-Ya-Ku";

        } else if (v == b28) {
            fragment =  new Uragaan();
            title = "Large Monsters: Uragaan";

        } else if (v == b29) {
            fragment =  new VaalHazak();
            title = "Large Monsters: Vaal Hazak";

        } else if (v == b30) {
            fragment = new Xenojiva();
            title = "Large Monsters: Xeno'jiva";

        } else if (v == b31) {
            fragment = new ZorahMag();
            title = "Large Monsters: Zorah Magdaros";

        } else if (v == b32) {
            fragment = new KulveTaroth();
            title = "Large Monsters: Kulve Taroth";
        }


        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, fragment.getTag())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        }

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);

    }



}
