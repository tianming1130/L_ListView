package com.sun.l_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSimpleAdapter,btnBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSimpleAdapter=(Button)findViewById(R.id.btn_simple_adapter);
        btnBaseAdapter=(Button)findViewById(R.id.btn_base_adapter);

        btnSimpleAdapter.setOnClickListener(this);
        btnBaseAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_simple_adapter:
                startActivity(new Intent(MainActivity.this,SimpleAdapterActivity.class));
                break;
            case R.id.btn_base_adapter:
                startActivity(new Intent(MainActivity.this,BaseAdapterActivity.class));
                break;
        }
    }
}
