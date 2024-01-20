package com.example.haytutu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;

public class StorageActivity extends AppCompatActivity {

    TextView textElapsed;
    TextView textHeader;
    TextView textScore;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        textElapsed = (TextView) findViewById(R.id.storageTestElapsed);
        textHeader = (TextView) findViewById(R.id.storageTestHeader);
        textScore  = (TextView) findViewById(R.id.storageTestScore);

        progressBar = (ProgressBar) findViewById(R.id.storageProgressBar);
        textElapsed.setVisibility(View.INVISIBLE);
        textHeader.setText("BENCHMARK IS RUNNING");
        textScore.setVisibility(View.INVISIBLE);
        new StorageActivity.BenchmarkTask().execute();


    }

    private class BenchmarkTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            // Perform some long-running task here and return the result
            long startTime = new Date().getTime();

            try {
                int length = 1000000;
                byte[] b = new byte[length];
                new Random().nextBytes(b);
                FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                for(int i = 0; i<length;i++)
                {
                    outputWriter.write(Byte.toString(b[i]));
                }
                outputWriter.write(String.valueOf(b));
                outputWriter.close();


            } catch (Exception e) {
                e.printStackTrace();
            }

            long endTime = new Date().getTime();
            return Long.toString(endTime-startTime);
        }

        @Override
        protected void onPostExecute(String result)
        {
            textHeader.setText("RESULT IS CALCULATED");
            textScore.setVisibility(View.VISIBLE);
            textElapsed.setVisibility(View.VISIBLE);
            textElapsed.setText(textElapsed.getText() + " " + result);

            textScore.setText(textScore.getText() + " 90 " );
            progressBar.setVisibility(View.GONE);
        }
    }
}