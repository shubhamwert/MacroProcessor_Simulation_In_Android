package com.stechapps.macroprocessorbyshubham;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String macro;
    private String macroName;
    private String MDT;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        macro = getString(R.string.print);
        macroName = "print";
        MDT = "Print \t \t  \t \t 2\n";
        TextView tv=findViewById(R.id.macro_defination);
        tv.setText(" print &len &msg \n \t"+macro);
    }

    public void Generate(View view) {
        EditText ed1, ed2, ed3, ed4, ed5, ed6;
        TextView tv = findViewById(R.id.MDT);
        tv.setText(MDT);
        ed1 = findViewById(R.id.ed_ins_1);
        ed2 = findViewById(R.id.ed_ins_2);
        ed3 = findViewById(R.id.ed_ins_3);
        ed4 = findViewById(R.id.ed_ins_4);
        ed5 = findViewById(R.id.ed_ins_5);
        ed6 = findViewById(R.id.ed_ins_6);
        if (!ed1.getText().toString().isEmpty()) {
            AddLine(ed1.getText().toString().split(" ")[0], ed1.getText().toString().split(" ")[1], ed1.getText().toString().split(" ")[2]);
            AddApt(ed1.getText().toString().split(" ")[0], ed1.getText().toString().split(" ")[1], ed1.getText().toString().split(" ")[2]);
            updateCode(ed1.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
            i++;
        }
        if (!ed2.getText().toString().isEmpty()) {
            AddLine(ed2.getText().toString().split(" ")[0], ed2.getText().toString().split(" ")[1], ed2.getText().toString().split(" ")[2]);
            AddApt(ed2.getText().toString().split(" ")[0], ed2.getText().toString().split(" ")[1], ed2.getText().toString().split(" ")[2]);
            updateCode(ed2.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
            i++;

        }
        if (!ed3.getText().toString().isEmpty()){
            AddApt(ed3.getText().toString().split(" ")[0], ed3.getText().toString().split(" ")[1], ed3.getText().toString().split(" ")[2]);

        AddLine(ed3.getText().toString().split(" ")[0], ed3.getText().toString().split(" ")[1], ed3.getText().toString().split(" ")[2]);
            updateCode(ed3.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
            i++;
    }
    if (!ed4.getText().toString().isEmpty()) {
        AddApt(ed4.getText().toString().split(" ")[0], ed4.getText().toString().split(" ")[1], ed4.getText().toString().split(" ")[2]);

        AddLine(ed4.getText().toString().split(" ")[0], ed4.getText().toString().split(" ")[1], ed4.getText().toString().split(" ")[2]);
        updateCode(ed4.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
        i++;
    }
    if (!ed5.getText().toString().isEmpty()) {
        AddApt(ed5.getText().toString().split(" ")[0], ed5.getText().toString().split(" ")[1], ed5.getText().toString().split(" ")[2]);

        AddLine(ed5.getText().toString().split(" ")[0], ed5.getText().toString().split(" ")[1], ed5.getText().toString().split(" ")[2]);
        updateCode(ed5.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
        i++;
    }
    if (!ed6.getText().toString().isEmpty()) {
            AddApt(ed6.getText().toString().split(" ")[0], ed6.getText().toString().split(" ")[1], ed6.getText().toString().split(" ")[2]);

            AddLine(ed6.getText().toString().split(" ")[0], ed6.getText().toString().split(" ")[1], ed6.getText().toString().split(" ")[2]);
        updateCode(ed6.getText().toString().split(" ")[0],"#"+i,"#"+(i+1));
        i++;
    }

    }

    private void updateCode(String s, String s1, String s2) {
        TextView tv1 = new TextView(MainActivity.this);
        if (s.equals(macroName)) {
            String s3 = macro;
            s3 = s3.replaceAll("msg", s2);
            s3 = s3.replaceAll("len", s1);
            tv1.setText(s3);
            LinearLayout ll = findViewById(R.id.Updated_Code);
            ll.addView(tv1);
            tv1.requestFocus();


        }

    }

    private void AddApt(String s, String s1, String s2) {
        TextView tv1 = new TextView(MainActivity.this);
        if (s.equals(macroName)) {
            i++;
            tv1.setText(String.format(" %d\t || msg || %s\n %d\t || len || %s",i,s2, i+1, s1));
            LinearLayout ll = findViewById(R.id.APT_table);
            ll.addView(tv1);
            tv1.requestFocus();

        }

    }


    private void AddLine(String s, String s1, String s2) {
        TextView tv1 = new TextView(MainActivity.this);
        if (s.equals(macroName)) {
            String s3 = macro;
            s3 = s3.replaceAll("msg", s2);
            s3 = s3.replaceAll("len", s1);
            tv1.setText(s3);


        } else {
            tv1.setText(String.format("\t%s\t%s\t%s", s, s1, s2));
        }
        LinearLayout ll = findViewById(R.id.expansion);
        ll.addView(tv1);
        tv1.requestFocus();

    }


}
