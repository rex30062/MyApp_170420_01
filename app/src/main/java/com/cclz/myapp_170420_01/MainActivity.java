package com.cclz.myapp_170420_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    File myFile;
    EditText ed;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFile=new File(getFilesDir() + File.separator + "mydata.txt");
        ed=(EditText) findViewById(R.id.editText);
        tv=(TextView) findViewById(R.id.textView2);
    }
    public void clickWrite(View v){
        try {
            FileWriter fw=new FileWriter(myFile);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(ed.getText().toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickRead(View v){
        try {
            FileReader fr=new FileReader(myFile);
            BufferedReader br=new BufferedReader(fr);
            String str=br.readLine();
            tv.setText(str);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
