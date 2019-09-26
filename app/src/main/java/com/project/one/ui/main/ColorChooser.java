package com.project.one.ui.main;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.project.one.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ColorChooser.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ColorChooser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorChooser extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnFragmentInteractionListener mListener;

    public ColorChooser(){
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ColorChooser.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorChooser newInstance(){
        ColorChooser fragment = new ColorChooser();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static CharSequence getTitle(){
        return "Random color chooser";
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_chooser, container, false);
        view.findViewById(R.id.buttonRandomize).setOnClickListener(v -> {
            // Create a random number within range of color values in hex, store as string
            String hexString = Integer.toHexString(new Random().nextInt(0xFFFFFF));
            //If string isn't long enough because integer value too small, add 0s until enough preceding 0s for six hex digits
            while(hexString.length() < 6){
                hexString = "0" + hexString;
            }
            // Append a hashtag because Android needs it
            hexString = "#" + hexString;
            // Set the color
            ((EditText) view.findViewById(R.id.textToRandomize))
                    .setTextColor(Color.parseColor(hexString));
            // Toast the color as required
            Toast.makeText(getActivity().getApplicationContext(), hexString, Toast.LENGTH_LONG)
                 .show();
        });
        
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri){
        if(mListener != null){
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach(){
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
    public interface OnFragmentInteractionListener{
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
