package com.example.ad_list2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt = findViewById(R.id.txt_dis);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Button btn = findViewById(R.id.btn_cal);

        Bundle extras = getIntent().getExtras();
        String op = extras.getString("option");
        txt.setText("Enter Values to perform " + op);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());
                String op = extras.getString("option");
                int res = calculate(n1, n2, op);
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("result", res);
                startActivity(intent);
                finish();
            }
        });
    }

    private int calculate(int num1, int num2, String op){
        switch(op){
            case "Addition" :
                return num1 + num2;
            case "Subtract" :
                return num1 - num2;
            case "Multiplication" :
                return num1 * num2;
            case "Division" :
                if(num2 == 0){
                    return 0;
                } else {
                    return num1/num2;
                }
            default :
                return -1;
        }
    }
}