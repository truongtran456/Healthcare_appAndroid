package com.example.dacs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages=
            {
                    {"Pakage 1: Full Body Checkup","Hue Hospital","7-9am","999"},
                    {"Pakage 2: Blood Glucozo Fasting","Cho Ray Hospital","7-9am","266"},
                    {"Pakage 3: COVID-19 Antibody - IgG","Da Nang Hospital","7-9am","432"},
                    {"Pakage 4: Thyroid Check","Hue","13-15pm","332"},
                    {"Pakage 5: Immunity Check","Hue Hospital","15-17pm","334"},
                    {"Pakage 6: Immunity Check","Hue Hospital","15-17pm","334"},
            };

    private String[] package_details={
            "Blood Glucozo Fasting\n"+
                    "Complete Hemorgam\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n"+
                    "Ldg Lactate Dehydrogadsd, Serum\n" +
                    "Lipid Profite\n" +
                    "Liver Function TRest",
            "Blood Glucose Fasting",
            "COVID-19 Antibody - IgG",
            "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitien)",
            "Complete Hemorgam\n"+
                    "Iron Studies\n" +
                    "Kidney Function Test\n"+
                    "Ldg Lactate Dehydrogadsd, Serum\n" +
                    "Lipid Profite\n" +
                    "Liver Function TRest",
            "Immunity Check\n"+
                    "Iron Studies\n" +
                    "Kidney Function Test\n"+
                    "Ldg Lactate Dehydrogadsd, Serum\n" +
                    "Lipid Profite\n" +
                    "Liver Function TRest"
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ImageView btnGoToCart;

    ImageView back;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.imageLTCart);
        back=findViewById(R.id.backLT);
        listView=findViewById(R.id.listViewBM);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, MainActivity.class));

            }
        });

        list= new ArrayList();
        for(int i=0 ; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", "Cost:"+ packages[i][3]+"$");
            list.add(item);
        }

        sa= new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages[i][1]);
                it.putExtra("text3", package_details[i]);
                it.putExtra("text4", packages[i][3]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}