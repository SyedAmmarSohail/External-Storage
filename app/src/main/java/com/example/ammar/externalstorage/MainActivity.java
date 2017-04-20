package com.example.ammar.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edittext);

    }

    public void SaveData(View view){
        switch (view.getId()){
            case R.id.button1:
                data = editText.getText().toString();
                File folder=getCacheDir();
                File file = new File(folder, "data1");
                WriteData(file, data);
                break;
            case R.id.button2:
                data = editText.getText().toString();
                File folder2=getExternalCacheDir();
                File file2 = new File(folder2, "data2");
                WriteData(file2, data);
                break;
            case R.id.button3:
                data = editText.getText().toString();
                File folder3=getExternalFilesDir("MyDirectory");
                File file3 = new File(folder3, "data3");
                WriteData(file3, data);
                break;

            case R.id.button4:
                data = editText.getText().toString();
                File folder4= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                File file4 = new File(folder4, "data4");
                WriteData(file4, data);
                break;
            case R.id.button5:
                break;
        }
    }

    private void WriteData(File file, String data){
        FileOutputStream fileoutputStream = null;
        try {
            fileoutputStream  = new FileOutputStream(file);
            fileoutputStream.write(data.getBytes());
            message(data + " was Successfully insert into " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            message(e.toString());
        } catch (IOException e) {
            message(e.toString());
        } finally {
            if(fileoutputStream!= null) {
                try {
                    fileoutputStream.close();
                } catch (IOException e) {
                    message(e.toString());
                }
            }
        }
    }

    private void message(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
