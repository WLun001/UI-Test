package com.example.lun.uitester;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkbox;
    private RadioButton radioBold;
    private RadioButton radioItalic;
    private RadioButton radioBoldItalic;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        checkbox = (CheckBox) findViewById(R.id.check_big);
        radioBold = (RadioButton) findViewById(R.id.bold);
        radioItalic = (RadioButton) findViewById(R.id.italic);
        radioBoldItalic = (RadioButton) findViewById(R.id.bold_italic);
        btnNext = (Button) findViewById(R.id.btn_next);


        Switch switchHideAll = (Switch) findViewById(R.id.switch_hide_all);
        switchHideAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    textView.setVisibility(View.INVISIBLE);
                    checkbox.setVisibility(View.INVISIBLE);
                    radioBold.setVisibility(View.INVISIBLE);
                    radioItalic.setVisibility(View.INVISIBLE);
                    radioBoldItalic.setVisibility(View.INVISIBLE);
                    btnNext.setVisibility(View.INVISIBLE);
                }
                else {
                    textView.setVisibility(View.VISIBLE);
                    checkbox.setVisibility(View.VISIBLE);
                    radioBold.setVisibility(View.VISIBLE);
                    radioItalic.setVisibility(View.VISIBLE);
                    radioBoldItalic.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                }
            }
        });
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

            case R.id.bold_italic:
                if(isChecked)
                    textView.setTypeface(null, Typeface.BOLD_ITALIC);
        }
    }

    public void onButtonCLick(View view){
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }
}
