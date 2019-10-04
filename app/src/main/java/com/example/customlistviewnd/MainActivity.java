package com.example.customlistviewnd;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        listView = findViewById(R.id.listview);

        int[] imageArray = {R.drawable.word,
                R.drawable.excel,
                R.drawable.powerpoint,
                R.drawable.outlook};

        String[] nameList = {"Word","Excel","PowerPoint","Outlook"};

        String[] descriptionList = {"Editeur de texte",
                "Tableur",
                "Logiciel de présentation",
                "Client de courrier électronique" };

        Adapter_list list = new Adapter_list(this, imageArray, nameList, descriptionList);
        listView.setAdapter(list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i == 0)
                {
                    Toast.makeText(MainActivity.this, "Word", Toast.LENGTH_SHORT).show();
                }
                else if (i == 1)
                {
                    Toast.makeText(MainActivity.this, "Excel", Toast.LENGTH_SHORT).show();
                }
                else if (i == 2)
                {
                    Toast.makeText(MainActivity.this, "PowerPoint", Toast.LENGTH_SHORT).show();
                }
                else if (i == 3)
                {
                    Toast.makeText(MainActivity.this, "Outlook", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Try Again !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection item");

                if(position == 0)
                {
                    builder.setMessage("Votre choix : Word");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 1)
                {
                    builder.setMessage("Votre choix : Excel");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 2)
                {
                    builder.setMessage("Votre choix : PowerPoint");
                    Log.e("tag" , "position " + position);
                }
                else if (position == 3)
                {
                    builder.setMessage("Votre choix : Outlook");
                    Log.e("tag" , "position " + position);
                }
                else
                {
                    builder.setMessage("Try Again !!");
                    Log.e("tag" , "position " + position);
                }

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {

                    }
                });

                AlertDialog alert11 = builder.create();
                alert11.show();

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
