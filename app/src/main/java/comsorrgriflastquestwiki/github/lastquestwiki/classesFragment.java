package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
=======
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
>>>>>>> 51e7cacbfa4a20d7714f542ec223c6d3dd1a3de1


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link classesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link classesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class classesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

<<<<<<< HEAD
=======
    private FragmentManager fm;

>>>>>>> 51e7cacbfa4a20d7714f542ec223c6d3dd1a3de1
    private OnFragmentInteractionListener mListener;

    public classesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment classesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static classesFragment newInstance(String param1, String param2) {
        classesFragment fragment = new classesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classes, container, false);
=======

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_classes, container, false);

        //init imageviews
        ImageView barbarian = (ImageView) view.findViewById(R.id.barbarianImg);
        ImageView archer = (ImageView) view.findViewById(R.id.archerImg);
        ImageView wizard = (ImageView) view.findViewById(R.id.wizardImg);
        ImageView fighter = (ImageView) view.findViewById(R.id.fighterImg);

        //init fragment manager
        fm = getActivity().getSupportFragmentManager();

        /**
         * Event handler when the image of the barbarian is
         * clicked the barbarian fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.0
         */
        barbarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new barbarianFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the archer is
         * clicked the archer fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.0
         */
        archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new archerFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the wizard is
         * clicked the wizard fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.0
         */
        wizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new wizardFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the fighter is
         * clicked the fighter fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.0
         */
        fighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new fighterFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });


        return view;
>>>>>>> 51e7cacbfa4a20d7714f542ec223c6d3dd1a3de1
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
