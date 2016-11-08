package com.grupolts.ccbenavides.testmaterial;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout refresh;
    ListView lstPlanetas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addToast();

        refresh = (SwipeRefreshLayout) findViewById(R.id.idRefresh);
        lstPlanetas = (ListView) findViewById(R.id.lista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstPlanetas.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }

    public void refreshData() {
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstPlanetas.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        refresh.setRefreshing(false);
    }
    public void addToast() {
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mesagge),Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mesagge), Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.textAction) , new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "Click en snackbar");
                            }
                        })
                        //.setActionTextColor(getResources().getColor(R.color.colorPrimary)) si queremos cambiar color texto
                        .show();
            }
        });
    }
}
