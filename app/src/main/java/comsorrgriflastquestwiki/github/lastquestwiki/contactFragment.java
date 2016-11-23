package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contactFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText fromTxt;
    private EditText subjectTxt;
    private EditText bodyTxt;
    private Animation shake;


    private OnFragmentInteractionListener mListener;

    public contactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contactFragment newInstance(String param1, String param2) {
        contactFragment fragment = new contactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        //init the shake anim
        shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);

        //init all textfields from contact form
        fromTxt = (EditText) view.findViewById(R.id.fromTxtField);
        subjectTxt = (EditText) view.findViewById(R.id.subjectTxtField);
        bodyTxt = (EditText) view.findViewById(R.id.bodyTxtField);

        //setting hints for the textfields so end user knows what to enter
        fromTxt.setHint("From");
        subjectTxt.setHint("Subject");
        bodyTxt.setHint("Message");

        //init the send email button
        Button sendBtn = (Button) view.findViewById(R.id.emailButton);

        //create an action when send email button is clicked
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the string entered from the from textfield
                String from = fromTxt.getText().toString();

                //declare booleans hasAt and hasDot to validate it is
                //a valid email address
                //eg. youremail@somesite.com <- valid email
                //    youremailsomesite.com <- not valid
                boolean hasAt = false;
                boolean hasDot = false;

                //substring through the string to find the @ and .
                //and set hasAt and hasDot to true if found
                for(int i = 0; i < from.length(); i++) {
                    if (from.substring(i, i + 1).equals("@")) hasAt = true;
                    if (from.substring(i, i + 1).equals(".")) hasDot = true;
                }

                //if either hasAt or hasDot is false shake the textifeld to notify
                //the email address was incorrect
                if(!hasAt || !hasDot)
                {
                    fromTxt.startAnimation(shake);
                }
                else
                {
                    //get text from the subject field and body field
                    String subject = subjectTxt.getText().toString();
                    String body = bodyTxt.getText().toString();

                    //run the sendEmail function
                    sendEmail(from, subject, body);
                }


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

    private void sendEmail(String from, String subject, String body)
    {
        
    }
}
