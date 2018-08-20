package com.example.nguyentheson.module21_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text_result=(TextView)findViewById(R.id.text_result);
        final EditText text_numberA=(EditText) findViewById(R.id.text_numberA);
        final EditText text_numberB=(EditText) findViewById(R.id.text_numberB);
        final Button btn_plus=(Button) findViewById(R.id.btn_plus);
        final Button btn_minus=(Button) findViewById(R.id.btn_minus);
        final Button btn_mutil=(Button) findViewById(R.id.btn_mutil);
        final Button btn_divide=(Button) findViewById(R.id.btn_divide);
        final Button btn_calGCD=(Button) findViewById(R.id.btn_calGCD);
        final Button btn_exit=(Button)findViewById(R.id.btn_exit);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValid()){
                    text_result.setText("Dữ liệu nhập không hợp lệ!");
                    return;
                }
                int result=Integer.parseInt(text_numberA.getText().toString())+Integer.parseInt(text_numberB.getText().toString());
                text_result.setText(result+"");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValid()){
                    text_result.setText(R.string.error_invalidInput);
                    return;
                }
                int result=Integer.parseInt(text_numberA.getText().toString())-Integer.parseInt(text_numberB.getText().toString());
                text_result.setText(result+"");
            }
        });
        btn_mutil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValid()){
                    text_result.setText("Dữ liệu nhập không hợp lệ!");
                    return;
                }
                int result=Integer.parseInt(text_numberA.getText().toString())*Integer.parseInt(text_numberB.getText().toString());
                text_result.setText(result+"");
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValid()){
                    text_result.setText("Dữ liệu nhập không hợp lệ!");
                    return;
                }
                double result=Integer.parseInt(text_numberA.getText().toString())*1.0/Integer.parseInt(text_numberB.getText().toString());
                text_result.setText(result+"");
            }
        });
        btn_calGCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValid()){
                    text_result.setText("Dữ liệu nhập không hợp lệ!");
                    return;
                }
                int a=Integer.parseInt(text_numberA.getText().toString());
                int b=Integer.parseInt(text_numberB.getText().toString());
                int result=findGCD(a,b);
                text_result.setText(result+"");
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
    private boolean checkValid(){
        final EditText text_numberA=(EditText) findViewById(R.id.text_numberA);
        final EditText text_numberB=(EditText) findViewById(R.id.text_numberB);
        try {
            Integer.parseInt(text_numberA.getText().toString());
            Integer.parseInt(text_numberB.getText().toString());
        } catch (Exception e){
            return false;
        }
        return true;
    }
    private int findGCD(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        if (a==0 ||b==0)
            return a+b;
        while (a!=b)
        {
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;
    }

}
