package com.mat.app3.transference.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mat.app3.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResportJobsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResportJobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResportJobsFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public ResportJobsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ResportJobsFragment newInstance() {
        ResportJobsFragment fragment = new ResportJobsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    static View root;
    static RecyclerView flpa_rView;
   // static RViewAdapterTransferListTrabajadores adapter;

    //private PageViewModel pageViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_report_jobs, container, false);

        return root;
    }

    static String TAG = ResportJobsFragment.class.getSimpleName();
    @Override
    public void onStart() {
        super.onStart();
        /*
        Log.d(TAG,"onStart");
        flpa_rView = getView().findViewById(R.id.flpa_rView);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.get().observe(this, new Observer<List<TareoDetalleVO>>() {
            @Override
            public void onChanged(List<TareoDetalleVO> tareoDetalleVOList) {
                Log.d(TAG,"tamaaño "+tareoDetalleVOList.size());
                adapter = new RViewAdapterTransferListTrabajadores(getContext(),tareoDetalleVOList);
                new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(flpa_rView);
                flpa_rView.setAdapter(adapter);
            }
        });
*/
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

