package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link racesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link racesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class racesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentManager fm;


    private OnFragmentInteractionListener mListener;

    public racesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment racesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static racesFragment newInstance(String param1, String param2) {
        racesFragment fragment = new racesFragment();
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
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_races, container, false);

        //init imageviews
        ImageView human = (ImageView) view.findViewById(R.id.humanImg);
        ImageView elf = (ImageView) view.findViewById(R.id.elfImg);
        ImageView dwarf = (ImageView) view.findViewById(R.id.dwarfImg);
        ImageView hobbit = (ImageView) view.findViewById(R.id.hobbitImg);

        //init fragment manager
        fm = getActivity().getSupportFragmentManager();

        /**
         * Event handler when the image of the human is
         * clicked the human fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.3
         */
        human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new humanFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the elf is
         * clicked the elf fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.1
         */
        elf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new elfFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the dwarf is
         * clicked the dwarf fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.1
         */
        dwarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new dwarfFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });
        /**
         * Event handler when the image of the hobbit is
         * clicked the hobbit fragment opens
         *
         * @author Griffin Sorrentino
         * @version 1.1
         */
        hobbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                ft.replace(R.id.mainFrame, new hobbitFragment());
                ft.addToBackStack("");
                ft.commit();
            }
        });


        return view;

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
