package com.example.dacs3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager2 moviesViewPager = (ViewPager2) view.findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));





        LinearLayout labTest =  view.findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LabTestActivity.class);
                startActivity(i);
            }
        });

        LinearLayout cardMedicine =  view.findViewById(R.id.cardMedicine);
        cardMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), BuyMedicineActivity.class);
                startActivity(i);
            }
        });
        LinearLayout cardFindDoctor =  view.findViewById(R.id.cardFindDoctor);
        cardFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FindDoctorActivity.class);
                startActivity(i);
            }
        });

        ConstraintLayout Advice = view.findViewById(R.id.Advice);
        Advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HealthArticlesActivity.class);
                startActivity(i);
            }
        });



//        final Button btn = (Button) view.findViewById(R.id.button2);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                buttonClicked(view);
//            }
//        });

        return view;
    }
    //    public void buttonClicked(View view){
//
//    }

    public List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        Movie card1 = new Movie();
        card1.poster = R.drawable.card1;
        card1.name = "Effective medical examination";
        card1.category="Modern equipment";
        card1.releaseDate="December 22, 2023";
        card1.rating= 4.6f;
        movies.add(card1);


        Movie card3 = new Movie();
        card3.poster = R.drawable.card3;
        card3.name = "Prevention is better than cure";
        card3.category="Safe treatment - fast";
        card3.releaseDate="December 22, 2023";
        card3.rating= 4.6f;
        movies.add(card3);

        Movie card4 = new Movie();
        card4.poster = R.drawable.card4;
        card4.name = "Improve health - improve life";
        card4.category="Quality medical staff";
        card4.releaseDate="December 22, 2023";
        card4.rating= 4.6f;
        movies.add(card4);

        Movie card2 = new Movie();
        card2.poster = R.drawable.card2;
        card2.name = "Improve understanding";
        card2.category="More latest news";
        card2.releaseDate="December 22, 2023";
        card2.rating= 4.6f;
        movies.add(card2);


        return movies;



    }

}