package com.example.homework5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Double firstNum;
    Double secondnum;
    Double res;
    String operation;
    TextView textView;
    ActionSend send;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.FC_text_view);


    }

    public void pressButton(View view) {
        switch (view.getId()) {
            case R.id.FC_button_0:
                textView.append("0");
                break;
            case R.id.FC_button_1:
                textView.append("1");
                break;
            case R.id.FC_button_2:
                textView.append("2");
                break;
            case R.id.FC_button_3:
                textView.append("3");
                break;
            case R.id.FC_button_4:
                textView.append("4");
                break;
            case R.id.FC_button_5:
                textView.append("5");
                break;
            case R.id.FC_button_6:
                textView.append("6");
                break;
            case R.id.FC_button_7:
                textView.append("7");
                break;
            case R.id.FC_button_8:
                textView.append("8");
                break;
            case R.id.FC_button_9:
                textView.append("9");
                break;
            case R.id.FC_button_point:
                textView.append(".");
                break;
            case R.id.FC_button_cline:
                textView.setText("");


        }
    }

    public void pressOperation(View view) {
        switch (view.getId()) {
            case R.id.FC_button_addition:
                operation="+";
                firstNum = Double.valueOf(textView.getText().toString());
                Log.d("pop", "Plus " + firstNum);
                textView.setText("+");
                break;
            case R.id.FC_button_subtraction:
                operation="-";
                firstNum = Double.valueOf(textView.getText().toString());
                textView.setText("-");
                break;
            case R.id.FC_button_multipl:
                operation="X";
                firstNum = Double.valueOf(textView.getText().toString());
                textView.setText("X");
                break;

            case R.id.FC_button_division:
                operation="/";
                firstNum = Double.valueOf(textView.getText().toString());
                textView.setText("/");
                break;
            case R.id.FC_button_equal:
                if (operation != null) {
                    String next = textView.getText().toString().replace(firstNum + operation + "", "");
                    secondnum = Double.valueOf(next);
                    Log.d("pop", "Ravno " + secondnum);

                    switch (operation) {
                        case "+":
                            res = firstNum + secondnum;
                            Log.d("pop","Плюс " + res);
                            textView.setText(res + "");

                            break;
                        case "-":
                            res = firstNum - secondnum;
                            textView.setText(res + "");
                            break;
                        case "X":
                            res = firstNum * secondnum;
                            textView.setText(res + "");
                            break;
                        case "/":
                            if (firstNum != 0 || secondnum != 0) {
                                res = firstNum / secondnum;
                                textView.setText(res + "");
                            } else textView.setText("На ноль делить нельзя");
                            break;

                        default:

                    }
                }


        }
    }


    public void chengeFragmentCalc(View view) {
        FragmentManager  manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,new ButtonFragment());
        transaction.commit();
    }

    public void chengeFragmentHistori(View view) {
        FragmentManager  manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,new ResultFragment());
        transaction.commit();
    }

    public void sendResult(View view) {
        String text = textView.getText().toString();
        send.send(text);
    }
    public  void  sendValue(ActionSend actionSend){
        this.send = actionSend;
    }
}
