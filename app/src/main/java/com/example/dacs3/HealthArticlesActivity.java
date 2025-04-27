package com.example.dacs3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class HealthArticlesActivity extends AppCompatActivity {

    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
    };

    ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);
        superListView = findViewById(R.id.superListView);
        getSuperHeroes();
    }
    private void getSuperHeroes() {
        Call<List<Results>> call =
                RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call,
                                   Response<List<Results>> response) {
                List<Results> myheroList = response.body();
                String[] oneHeroes = new
                        String[myheroList.size()];
                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }
                superListView.setAdapter(new
                        ArrayAdapter<String>(getApplicationContext(),
                        R.layout.custom_layout, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Results>> call,
                                  Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured",
                        Toast.LENGTH_LONG).show();
            }
        });

        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthArticlesActivity.this, HealthArticlesDetailsActivity.class);
//                it.putExtra("tex1", health_details[i][0]);
                it.putExtra("text2", images[i]);
                startActivity(it);
            }
        });
    }
}
