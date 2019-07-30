package info.ndakgamers.mhwguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;


import java.util.ArrayList;

public class Items_Recycler extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    View myView;
    DatabaseHelper myDbHelper;

    private OnFragmentInteractionListener mListener;

    public Items_Recycler() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Items_Recycler newInstance(String param1, String param2) {
        Items_Recycler fragment = new Items_Recycler();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_items_recycler, container, false);
        myDbHelper = DatabaseHelper.getInstance(myView.getContext());
        return myView;

        ArrayList<recycler_Item> recyclerList = new ArrayList<>();
        recyclerList.add(new recycler_Item(R.drawable.bow_rank1_2, "This Bow is Neat", "Cool"));

        mRecyclerView = myView.findViewById(R.id.rv_items);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(myView.getContext());
        mAdapter = new RecyclerAdapter(recyclerList);

        }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
