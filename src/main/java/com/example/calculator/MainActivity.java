package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private EditText display;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);  //edittext e tıklayınca telefon klavyesi çıkmasını engelliyor

    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (display.getText().toString().equals("")){
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);

        }else{
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos+1);
        }

    }

    public void zeroF(View view){
        updateText("0");
    }
    public void oneF(View view){
        updateText("1");

    }
    public void twoF(View view){
        updateText("2");

    }
    public void threeF(View view){
        updateText("3");

    }
    public void fourF(View view){
        updateText("4");

    }
    public void fiveF(View view){
        updateText("5");

    }
    public void sixF(View view){
        updateText("6");

    }
    public void sevenF(View view){
        updateText("7");

    }
    public void eightF(View view){
        updateText("8");

    }
    public void nineF(View view){
        updateText("9");

    }
    public void clearF(View view){
        display.setText("");

    }
    public void multiplyF(View view){
        updateText("*");

    }
    public void addF(View view){
        updateText("+");

    }
    public void substractF(View view){
        updateText("-");

    }
    public void divideF(View view){
        updateText("/");

    }
    public void parF(View view){
        int cursorPos = display.getSelectionStart();
        int open = 0,close=0;
        int textLen = display.getText().toString().length();

        for(int i=0;i<cursorPos;i++){
            if (display.getText().toString().substring(i,i+1).equals("(")){
                open+=1;
            }
            if (display.getText().toString().substring(i,i+1).equals(")")){
                close+=1;
            }}
        if (open== close || display.getText().toString().substring(textLen-1 , textLen).equals("(")){
            updateText("(");
        }
        else if (close < open && !display.getText().toString().substring(textLen-1 , textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos+1);

    }
    public void expF(View view){
        updateText("^");

    }
    public void plusMinusF(View view){
        updateText("0");

    }
    public void decimalF(View view){
        updateText(".");

    }
    public void equalF(View view){

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void backF(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1 , cursorPos ,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }


    }

}