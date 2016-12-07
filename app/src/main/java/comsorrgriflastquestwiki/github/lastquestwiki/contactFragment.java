package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
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
        subjectTxt = (EditText) view.findViewById(R.id.subjectTxtField);
        bodyTxt = (EditText) view.findViewById(R.id.bodyTxtField);

        //init the buttons
        Button sendBtn = (Button) view.findViewById(R.id.emailButton);
        Button addContactBtn = (Button) view.findViewById(R.id.contactButton);
        Button websiteBtn = (Button) view.findViewById(R.id.websiteButton);
        Button mapBtn = (Button) view.findViewById(R.id.mapButton);

        //create an action when send email button is clicked
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from the subject field and body field
                String subject = subjectTxt.getText().toString();
                String body = bodyTxt.getText().toString();

                //if the subject field is empty shake the text field
                if(subject.equals("")) subjectTxt.startAnimation(shake);
                //if the body field is empty shake the body field
                else if(body.equals("")) bodyTxt.startAnimation(shake);
                else
                {
                    //send the email
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"LastQuestWikiTeam@LastQuestWiki.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, body);
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    else{
                        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                "No installed software to complete the task", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }


            }
        });

        //create an action when add contact button is clicked
        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.NAME, "Last Quest Wiki Team");
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "lastquestwiki@lastquestwiki.com");
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, "+1(888)-888-8888");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
                else{
                    Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                            "No installed software to complete the task", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        //create an action when visit website button is clicked
        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri website = Uri.parse("https://www.lastquestwiki.com");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(website);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No installed software to complete the task", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        //create an action when view on map button is clicked
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geoLocation = Uri.parse("geo:0,0?q=42.248013,-83.0185792(Last Quest Wiki HQ)");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
                else{
                    Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "No installed software to complete the task", Snackbar.LENGTH_SHORT);
                    snackbar.show();
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
