package com.example.dacs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_detail1=
            {
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5year", "Mobile No: 0994222939", "50"},
                    {"Doctor name: Xenia Tryphena", "Hospital Address: Hue", "EXP:2year", "Mobile No: 0994222939", "10"},
                    {"Doctor name: Acacia", "Hospital Address: Ho Chi Minh", "EXP:1year", "Mobile No: 0994222939", "70"},
                    {"Doctor name: Veronica Verity", "Hospital Address: Ha Noi", "EXP:3year", "Mobile No: 0994222939", "25"},
                    {"Doctor name: Verity Ula", "Hospital Address: Da Nang", "EXP:5year", "Mobile No: 0994222939", "50"},
                    {"Doctor name: Tryphena Winifred", "Hospital Address: Ha Long", "EXP:8year", "Mobile No: 0994222939", "70"},
                    {"Doctor name: Verity Xenia", "Hospital Address: Quang Tri", "EXP:9year", "Mobile No: 0994222939", "40"},

            };
    private String[][] doctor_detail2=
            {
                    {"Doctor name: z", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: adsad", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Adsa", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: dsadf", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: fsd", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: fds", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: fdsf", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},

            };
    private String[][] doctor_detail3=
            {
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},

            };
    private String[][] doctor_detail4=
            {
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},

            };
    private String[][] doctor_detail5=
            {
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},

            };
    private String[][] doctor_detail6=
            {
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},
                    {"Doctor name: Ajiti Saste", "Hospital Address: Pimpri", "EXP:5yes", "Mobile No: 0994222939", "680"},

            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        ImageView DTDeatailsback = findViewById(R.id.DTDeatailsback);

        tv= findViewById(R.id.textViewDDTitle);
        Intent it= getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_detail1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_detail2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_detail3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_detail4;
        else
        if(title.compareTo("Cardiologist")==0)
            doctor_details = doctor_detail5;
        else
            doctor_details = doctor_detail6;
        DTDeatailsback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0; i< doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5",doctor_details[1][4]+"$");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.dashboard_item_1,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst =findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][2]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][1]);
                it.putExtra("text6", doctor_details[i][4]);

                startActivity(it);
            }
        });
    }
}