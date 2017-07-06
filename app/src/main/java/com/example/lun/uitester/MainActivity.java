package com.example.lun.uitester;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.textSize;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
    }

    public void onCheck(View view){
        boolean isChecked = ((CheckBox)view).isChecked();

        if(isChecked)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.big_text_size));
        else
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.normal_text_size));
    }

    public void onRadioCheck(View view){

        boolean isChecked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.bold:
                if(isChecked)
                    textView.setTypeface(null, Typeface.BOLD);
                break;

            case R.id.italic:
                if(isChecked)
                    textView.setTypeface(null, Typeface.ITALIC);
                break;

            case R.id.underline:
                if(isChecked)
                    textView.setTypeface(null, Typeface.BOLD_ITALIC);
        }

    }
}
