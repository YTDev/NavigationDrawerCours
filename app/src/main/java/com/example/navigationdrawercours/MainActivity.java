package com.example.navigationdrawercours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout myD;
    ActionBarDrawerToggle myT;
    NavigationView navigationView;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myD=findViewById(R.id.myDrawer);
        navigationView=findViewById(R.id.navigationView);
        txt=findViewById(R.id.txtTest);
        myT=new ActionBarDrawerToggle(this,myD,R.string.open,R.string.close);
        myD.addDrawerListener(myT);
        myT.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.act1:
                        txt.setText("Action1");
                        break;
                    case R.id.act2:
                        txt.setText("Action2");
                        break;
                    case R.id.act3:
                        txt.setText("Action3");
                        break;
                    case R.id.act4:
                        finish();
                        break;
                }
                myD.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myT.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
