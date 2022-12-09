package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result,solution;
    MaterialButton buttonc,buttonbracketopen,bracketclose;
    MaterialButton buttondivide,buttonplus,buttonmultiply,buttonminus,buttondot,buttonequals,buttonA;
    MaterialButton button9,button8,button7,button6,button5,button4,button3,button2,button1,button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solution=findViewById(R.id.solution);
        result=findViewById(R.id.result_tv);
        assignID(buttonc,R.id.button_c);
        assignID(buttonbracketopen,R.id.button_open_bracket);
        assignID(bracketclose,R.id.button_close_bracket);
        assignID(buttondivide,R.id.button_division);
        assignID(buttonplus,R.id.button_plus);
        assignID(buttonmultiply,R.id.button_multiply);
        assignID(buttonminus,R.id.button_minus);
        assignID(buttondot,R.id.button_dot);
        assignID(buttonequals,R.id.button_equal);
        assignID(buttonA,R.id.button_AC);
        assignID(button9,R.id.button_9);
        assignID(button8,R.id.button_8);
        assignID(button7,R.id.button_7);
        assignID(button6,R.id.button_6);
        assignID(button5,R.id.button_5);
        assignID(button4,R.id.button_4);
        assignID(button3,R.id.button_3);
        assignID(button2,R.id.button_2);
        assignID(button1,R.id.button_1);
        assignID(button0,R.id.button_0);




    }
    void assignID(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
    MaterialButton button= (MaterialButton) view;
    String button_text=button.getText().toString();
    String Datatocollect = solution.getText().toString();


    if(button_text.equals("A")){
            solution.setText("");
            result.setText("0");
            return ;

    }
        if(button_text.equals("=")){
            solution.setText(result.getText());

            return  ;
        }
        if(button_text.equals("C")){
            Datatocollect= Datatocollect.substring(0,Datatocollect.length()-1);
        }
        else{
            Datatocollect= Datatocollect+button_text;
        }
        solution.setText(Datatocollect);
        String finalresult = getresult(Datatocollect);
        if(!finalresult.equals("err")){
            result.setText(finalresult);
        }
    }
    String getresult(String data){
        try{
            Context context =Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalresult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();

            if(finalresult.endsWith(".0")){
                finalresult=finalresult.replace(".0","");
            } return finalresult;
        }
        catch(Exception e)
        { return "err";

    }
}}