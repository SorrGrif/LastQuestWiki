package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link faqFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link faqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class faqFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView faqFragmentTextView;
    ListView list;

    private OnFragmentInteractionListener mListener;

    public faqFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment faqFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static faqFragment newInstance(String param1, String param2) {
        faqFragment fragment = new faqFragment();
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
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        faqFragmentTextView = (TextView) view.findViewById(R.id.questions);
        list = (ListView) view.findViewById(R.id.answers);
        final ArrayList<FaqItem> FaqItemList = new ArrayList<>();
        FaqItemList.add(new FaqItem("Move to the right and spin 180 degrees", "How do i open the door in raid III?"));
        FaqItemList.add(new FaqItem("Go to the menu option and choose weapons.", "How do I equip my weapons?"));
        FaqItemList.add(new FaqItem("Go to the main menu and choose the option classes", "How do I change classes?"));
        FaqItemList.add(new FaqItem("Yes you can!", "Can I change my name?"));


        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, FaqItemList);
        CustomAdapter adapter1 = new CustomAdapter(getContext(), FaqItemList);
        list.setAdapter(adapter1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               FaqItem item = (FaqItem) list.getItemAtPosition(position);
                faqFragmentTextView.setText(item.getQuestion());
            }
        });

        return view;




    }

    public class CustomAdapter extends ArrayAdapter<FaqItem>{
        public CustomAdapter(Context context, ArrayList<FaqItem> items){
            super(context, 0, items);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            FaqItem item = getItem(position);

            // If the current item in the list doesn't have a view, give it a view
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.answer);
            name.setText(item.getAnswer());
            return convertView;
        }
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
