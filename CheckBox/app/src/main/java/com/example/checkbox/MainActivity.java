package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText et1;
    RadioGroup rg1,rg2;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    CheckBox ch1,ch2,ch3,ch4,ch5;
    Spinner sp1;
    double Prices[] = {9,11,13,15,17,19,20};
    static  int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etbill);
        rg1 = findViewById(R.id.rgSize);
        rg2 = findViewById(R.id.rgDelivery);
        rb1 = findViewById(R.id.sRD1);
        rb2 = findViewById(R.id.sRD2);
        rb3 = findViewById(R.id.sRD3);
        rb4 = findViewById(R.id.dRD1);
        rb5 = findViewById(R.id.dRD2);
        ch1 = findViewById(R.id.chChicken);
        ch2 = findViewById(R.id.chBeef);
        ch3 = findViewById(R.id.chPappa);
        ch4 = findViewById(R.id.chVeggie);
        ch5 = findViewById(R.id.chDrinks);
        sp1 = findViewById(R.id.spin);

        List<String> types = new ArrayList<>();
        types.add("Neapolitan Pizza");
        types.add("Greek Pizza");
        types.add("California Pizza");
        types.add("Detroit Pizza");
        types.add("Chicago Pizza");
        types.add("St. Louis Pizza");
        types.add("Canadian Pizza");

        //Create an adapter and fill it from the list
        ArrayAdapter PizzaAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,types);
        //make drop down style
        PizzaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with items of adapter
        sp1.setAdapter(PizzaAdapter);
        sp1.setOnItemSelectedListener(this);

        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        ch4.setOnClickListener(this);
        ch5.setOnClickListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {
        i = position;
       Double pr = new Double(Prices[i]);
       et1.setText(pr.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        double price = Double.parseDouble((et1).getText().toString());

        switch(view.getId())
        {
            case R.id.chChicken:
                if(ch1.isChecked())
                {
                    price+=1;
                }
                else
                    price-=1;

            case R.id.chBeef:
                if(ch2.isChecked())
                {
                    price+=1;
                }
                else
                    price-=1;

            case R.id.chPappa:
                if(ch3.isChecked())
                {
                    price+=1;
                }
                else
                    price-=1;

            case R.id.chVeggie:
                if(ch4.isChecked())
                {
                    price+=1;
                }
                else
                    price-=1;

            case R.id.chDrinks:
                if(ch5.isChecked())
                {
                    price+=3;
                }
                else
                    price-=3;
        }

    }
}
