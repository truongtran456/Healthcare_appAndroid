package com.example.dacs3;

import static com.example.dacs3.R.id.listViewOD;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShortsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShortsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String [][] order_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst ;
    Button btn;

    public ShortsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShortsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShortsFragment newInstance(String param1, String param2) {
        ShortsFragment fragment = new ShortsFragment();
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


        Database db = new Database(requireActivity().getApplicationContext(), "healthcare", null, 1);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        ArrayList dbData = db.getOrderData(username);
        order_details = new String[dbData.size()][];

        for (int i = 0; i<order_details.length; i++){
            order_details[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if(strData[7].compareTo("medicine")== 0) {
                order_details[i][3] = "Del:" + strData[4];
            }else {
                order_details[i][3] = "Del:" + strData[4] + " " + strData[5];
            }
            order_details[i][2] = "Rs."+strData[6];
            order_details[i][4] = strData[7];
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shorts, container, false);

        lst = (ListView)view.findViewById(listViewOD);

        list = new ArrayList();
        for (int i = 0; i<order_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this.requireActivity(),list,
                R.layout.dashboard_item_2,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        return view;

    }
}