package com.example.avjindersinghsekhon.minimaltodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avjindersinghsekhon.minimaltodo.entities.Kontak;
import com.example.avjindersinghsekhon.minimaltodo.models.KontakModel;
import com.example.avjindersinghsekhon.minimaltodo.pesanan.DetailKontakActivity;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity {

    // Data
    private KontakModel mKontak;
    private Kontak selectedKontak;

    // Komponen
    private TextView txtNama;
    private TextView txtNomor;

    private Button btnUbah;
    private Button btnHapus;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        this.initData();
        this.initComponents();
    }

    private void initData() {
        this.mKontak = new KontakModel(this);

        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);
        this.selectedKontak = this.mKontak.selectOne(selectedContactId);
    }

    private void initComponents() {
        this.txtNama = (TextView) this.findViewById(R.id.txtNama);
        this.txtNomor = (TextView) this.findViewById(R.id.txtNomor);
        this.btnUbah = (Button) this.findViewById(R.id.btnUbah);
        this.btnHapus = (Button) this.findViewById(R.id.btnHapus);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);

        this.txtNama.setText(this.selectedKontak.getNama());
        this.txtNomor.setText(this.selectedKontak.getNomor());
    }

    public void button_onClick(View view) {
        Button b = (Button) view;

        if (b == this.btnUbah) {
            this.ubahKontak();
        } else if (b == this.btnKembali) {
            this.finish();
        }
    }

    private void ubahKontak() {
        Intent intent = new Intent(this, DetailKontakActivity.class);

        intent.putExtra("selectedContactId", this.selectedKontak.getId());

        this.startActivity(intent);

    }

}
