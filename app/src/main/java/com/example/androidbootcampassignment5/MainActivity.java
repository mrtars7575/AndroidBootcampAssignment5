package com.example.androidbootcampassignment5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {


    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

    }


    public void anyButton(View view){


        if (view.getId() == R.id.clear) {
           display.setText("");
        }else if (view.getId() == R.id.one){
            updateDisplay("1");
        }else if (view.getId() == R.id.two){
            updateDisplay("2");
        } else if (view.getId() == R.id.three){
            updateDisplay("3");
        } else if (view.getId() == R.id.four){
            updateDisplay("4");
        } else if (view.getId() == R.id.five){
            updateDisplay("5");
        }else if (view.getId() == R.id.six){
            updateDisplay("6");
        }else if (view.getId() == R.id.seven){
            updateDisplay("7");
        }else if (view.getId() == R.id.eight){
            updateDisplay("8");
        }else if (view.getId() == R.id.nine){
            updateDisplay("9");
        }else if (view.getId() == R.id.zero){
            updateDisplay("0");
        }else if (view.getId() == R.id.delete){
            backSpace();
        }else if (view.getId() == R.id.plus){
            updateDisplay("+");
        } else if (view.getId() == R.id.equal) {
            calculateTheResult();
        }else if (view.getId() == R.id.dot){
            updateDisplay(".");
        }else{
            System.out.println("There is/are problem");
        }
    }

    public void calculateTheResult(){
        String textDisplay = display.getText().toString();
        Expression exp = new Expression(textDisplay);
        String result = String.valueOf(exp.calculate());

        if (!result.equals("NaN")){
            display.setText(result);
            display.setSelection(result.length());
        }else{
            System.out.println("incorrect entry");
        }

    }

    public void backSpace(){
        int cursorPos = display.getSelectionStart();
        if (cursorPos>0){
            String oldDisplay = display.getText().toString();
            String leftSideOfDisplay = oldDisplay.substring(0,cursorPos - 1);
            String rightSideOfDisplay = oldDisplay.substring(cursorPos);
            String newText = leftSideOfDisplay  +  rightSideOfDisplay;
            display.setText(newText);
            display.setSelection(cursorPos -1 );
        }
    }

    public void updateDisplay(String addCharForDisplay){
        int cursorPos = display.getSelectionStart();

        if (display.getText().toString().equals("")){
            display.setText(addCharForDisplay);
        }else{
            String oldDisplay = display.getText().toString();
            String leftSideOfDisplay = oldDisplay.substring(0,cursorPos);
            String rightSideOfDisplay = oldDisplay.substring(cursorPos);
            String newText = leftSideOfDisplay + addCharForDisplay +  rightSideOfDisplay;
            display.setText(newText);
        }
        display.setSelection(cursorPos+1);
    }
}