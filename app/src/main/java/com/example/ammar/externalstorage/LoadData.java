package com.example.ammar.externalstorage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ammar on 4/15/17.
 */

public class LoadData extends AppCompatActivity {

    EditText editText;

    String data;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaddata);
        editText = (EditText) findViewById(R.id.edittext);
    }

    public void ReadData(View view){
        switch (view.getId()){
            case R.id.button1:
                File folder = getCacheDir();
                File file = new File(folder, "data1");
                data = Read(file);
                if (){
                    editText.setText(data);
                } else{

                }
                editText.setText("No data was Found");
                break;
            case R.id.button2:
                File folder2 = getExternalCacheDir();
                File file2 = new File(folder2, "data2");
                data = Read(file2);
                if (){
                    editText.setText(data);
                } else{

                }
                editText.setText("No data was Found");
                break;
            case R.id.button3:
                File folder3 = getExternalFilesDir("MyDirectory");
                File file3 = new File(folder3, "data3");
                data = Read(file3);
                if (){
                    editText.setText(data);
                } else{

                }
                editText.setText("No data was Found");
                break;
            case R.id.button4:
                File folder4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                File file4 = new File(folder4, "data4");
                data = Read(file4);
                if (){
                    editText.setText(data);
                } else{

                }
                editText.setText("No data was Found");
                break;
            case R.id.button5:
                break;
        }
    }

    private String Read(File myfile){

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(myfile);
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1){
                    buffer.append((char)read);
            }
            return buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  null;
    }
}
