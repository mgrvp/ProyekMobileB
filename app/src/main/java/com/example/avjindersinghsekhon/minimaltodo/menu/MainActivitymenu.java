package com.example.avjindersinghsekhon.minimaltodo.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.example.avjindersinghsekhon.minimaltodo.pesanan.Main2Activity;
import com.example.avjindersinghsekhon.minimaltodo.pesanan.TambahKontakActivity;


public class MainActivitymenu extends AppCompatActivity {
    private Button btnmenupesanan;
    private Button btnreminder;
    private Button btnPesan;


    @Override
    protected void onCreate(Bundle savedInstanceState)     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        this.initComponents();
    }

    private void initComponents()     {
        this.btnmenupesanan = (Button) this.findViewById(R.id.btnMenuPesanan);
        this.btnreminder = (Button) this.findViewById(R.id.Reminder);
        this.btnPesan = (Button) this.findViewById(R.id.btnPesan);

    }

    public void button_onClick(View view)     {
        Button b = (Button) view;

        if(b == this.btnmenupesanan){
            this.openMain2Activity();
        }else if(b == this.btnreminder){
            this.openMain6Activity();
        }else if(b == this.btnPesan){
            this.openTambahKontakActivity();
        }
    }

    private void openTambahKontakActivity() {
        Intent i = new Intent(this, TambahKontakActivity.class);
        this.startActivity(i);
    }

    private void openMain2Activity()     {
        Intent i = new Intent(this, Main2Activity.class);
        this.startActivity(i);
    }
    private void openMain6Activity()     {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }
}


