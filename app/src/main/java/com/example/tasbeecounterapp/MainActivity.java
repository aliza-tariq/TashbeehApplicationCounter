package com.example.tasbeecounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tashbeeh1,tashbeeh2,tashbeeh3,tashbeeh4,textShow;
    private TextView reciteSt1,reciteSt2,reciteSt3,reciteSt4;
    private Button btn1,btn2,btn3,btn4,btnShow;
    private DbHelper db=new DbHelper(MainActivity.this);

    List<Tashbee> studentList = new ArrayList<>();

    List<Tashbee> stdList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tashbeeh1=findViewById(R.id.tashbeeh1);
        tashbeeh2=findViewById(R.id.tashbeeh2);
        tashbeeh3=findViewById(R.id.tashbeeh3);
        tashbeeh4=findViewById(R.id.tashbeeh4);

        reciteSt1=findViewById(R.id.tashbeehr1);
        reciteSt2=findViewById(R.id.tashbeehr2);
        reciteSt3=findViewById(R.id.tashbeehr3);
        reciteSt4=findViewById(R.id.tashbeehr4);

        btn1=findViewById(R.id.reciteBtn1);
        btn2=findViewById(R.id.Recite2);

        btn3=findViewById(R.id.Recite3);
        btn4=findViewById(R.id.Recite4);

        btnShow=findViewById(R.id.btnShow);
        textShow=findViewById(R.id.textShow);


        Tashbee tasbee1=new  Tashbee("2023-02-06",0,0,0,0);
        tashbeeh1.setText("0");
        tashbeeh2.setText("0");
        tashbeeh3.setText("0");
        tashbeeh4.setText("0");

        if(tasbee1.getTashbeeh1()>0)
            reciteSt1.setText("Recite Today");
        else
            reciteSt1.setText("Not Recite Today");

        if(tasbee1.getTashbeeh2()>0)
            reciteSt2.setText("Recite Today");
        else
            reciteSt2.setText("Not Recite Today");

        if(tasbee1.getTashbeeh3()>0)
            reciteSt3.setText("Recite Today");
        else
            reciteSt3.setText("Not Recite Today");

        if(tasbee1.getTashbeeh4()>0)
            reciteSt4.setText("Recite Today");
        else
            reciteSt4.setText("Not Recite Today");



        try {
            //Toast.makeText(MainActivity.this, f0.toString(), Toast.LENGTH_SHORT).show();

            DbHelper dbHelper = new DbHelper(MainActivity.this);
            dbHelper.addTashbeeCount(tasbee1);
            //  tasbee.setTashbeeh4(1);
            //dbHelper.updateTashbee(tasbee);
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Error Ocuur", Toast.LENGTH_SHORT).show();
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasbee1.setTashbeeh1(tasbee1.getTashbeeh1()+1);
                tashbeeh1.setText(String.valueOf(tasbee1.getTashbeeh1()));
                if(tasbee1.getTashbeeh1()>0)
                    reciteSt1.setText("Recite Today");
                else
                    reciteSt1.setText("Not Recite Today");
                db.updateTashbee(tasbee1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasbee1.setTashbeeh2(tasbee1.getTashbeeh2()+1);
                tashbeeh2.setText(String.valueOf(tasbee1.getTashbeeh2()));

                if(tasbee1.getTashbeeh2()>0)
                    reciteSt2.setText("Recite Today");
                else
                    reciteSt2.setText("Not Recite Today");
                db.updateTashbee(tasbee1);

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasbee1.setTashbeeh3(tasbee1.getTashbeeh3()+1);
                tashbeeh3.setText(String.valueOf(tasbee1.getTashbeeh3()));

                if(tasbee1.getTashbeeh3()>0)
                    reciteSt3.setText("Recite Today");
                else
                    reciteSt3.setText("Not Recite Today");
                db.updateTashbee(tasbee1);

            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasbee1.setTashbeeh4(tasbee1.getTashbeeh4()+1);
                tashbeeh4.setText(String.valueOf(tasbee1.getTashbeeh4()));
                if(tasbee1.getTashbeeh4()>0)
                    reciteSt4.setText("Recite Today");
                else
                    reciteSt4.setText("Not Recite Today");
                db.updateTashbee(tasbee1);

            }

        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Tashbee> arr=db.getAllResults();
                String str1="";
                for(int i=0;i<arr.size();i++)
                {
                    str1=str1+"Date : "+arr.get(i).getDate()+"Tasbee1 : "+
                            arr.get(i).getTashbeeh1()+" Tasbee2 : "+arr.get(i).getTashbeeh2()+
                           "Tasbee3" +arr.get(i).getTashbeeh3()+
                            "Tasbee4"+arr.get(i).getTashbeeh4()+"\n\n";
                }
                textShow.setText(str1);
            }
        });

        //  studentList.addAll(Arrays.asList(new Tashbee[]{f0,f1,f2,f3,f4}));


       /* try {
            LearningModel learningModel;
            System.out.println("Learning Model = ?");

            Toast.makeText(MainActivity.this, f0.toString(), Toast.LENGTH_SHORT).show();
            DbHelper dbHelper = new DbHelper(MainActivity.this);
            dbHelper.addStudent(f0);
            dbHelper.addStudent(f1);
            dbHelper.addStudent(f2);
            dbHelper.addStudent(f3);
            dbHelper.addStudent(f4);

        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }*/




    }
}