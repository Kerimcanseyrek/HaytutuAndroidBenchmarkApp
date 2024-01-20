package com.example.haytutu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.os.AsyncTask;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;


public class CpuActivity extends AppCompatActivity {
    TextView textElapsed;
    TextView textHeader;
    TextView textScore;
    CpuTest cpuTest;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);


        textElapsed = (TextView) findViewById(R.id.cpuTestElapsed);
        textHeader = (TextView) findViewById(R.id.cpuTestHeader);
        textScore  = (TextView) findViewById(R.id.cpuTestScore);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textElapsed.setVisibility(View.INVISIBLE);
        textHeader.setText("BENCHMARK IS RUNNING");
        textScore.setVisibility(View.INVISIBLE);
        new BenchmarkTask().execute();
    }

    private class BenchmarkTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            // Perform some long-running task here and return the result
            cpuTest = new CpuTest();
            cpuTest.getCpuCalculationWithTimePI();
            cpuTest.getCpuCalculationWithTimeSort();
            long result = cpuTest.GetTimeElapsedPI();
            long result2 = cpuTest.GetTimeElapsedSort();

            return Long.toString(result + result2);
        }

        @Override
        protected void onPostExecute(String result)
        {
            textHeader.setText("RESULT IS CALCULATED");
            textScore.setVisibility(View.VISIBLE);
            textElapsed.setVisibility(View.VISIBLE);
            textElapsed.setText(textElapsed.getText() + " " + result);

            textScore.setText(textScore.getText() + " 85 " );
            progressBar.setVisibility(View.GONE);
        }
    }
}