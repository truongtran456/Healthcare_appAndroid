package com.example.dacs3;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String [][] packages =
            {
                    {"Ckdmyrept Tab. 500mg", "Healthcare Shop", "", "", "53"},
                    {"Neoamiyu", "Healthcare Shop", "", "", "116"},
                    {"Piperacillin/ Tazobactam Kabi 4g/0,5g", "Healthcare Shop", "", "", "105"},
                    {"Abiraterone acetate", "Healthcare Shop", "", "", "50"},
                    {"Vokalia", "Healthcare Shop", "", "", "100"},
                    {"Benzylpenicillin sodium Inj", "Healthcare Shop", "", "", "150"},
            };
    private String[] package_details ={
            "Ckdmyrept Tab. 500mg\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
            "Neoamiyu 500mg\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
            "Piperacillin/ Tazobactam Kabi 4g/0,5g\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
            "Abiraterone acetate\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
            "Vokalia\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
            "Benzylpenicillin sodium Inj\n" +
                    "L-Isoleucine; L-Leucine; L-Lysine acetat; L-Methionine\n" +
                    "Piperacilin, Tazobactam\n" +
                    "Recombinant human insulin - 100IU/ml (30% solube insulin & 70% isophane insulin)\n" +
                    "Rabeprazole Sodium; Ornidazole; Clarithromycin\n" +
                    "Flunarizine (dưới dạng Flunarizine HCl) 5mg\n" +
                    "Calci (dưới dạng Calci carbonat 1,25g) 500mg; Vitamin D3 125IU",
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    AppCompatImageView backBM, btnGoToCart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        backBM = findViewById(R.id.backBM);
        btnGoToCart = findViewById(R.id.imageLTCartmedicine);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        backBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, MainActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.dashboard_item_3,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text4", packages[i][1]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}