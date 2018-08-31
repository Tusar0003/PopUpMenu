package com.example.no0ne.popuomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPopupMenu();
    }

    public void setPopupMenu() {

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of popup menu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);

                //Inflate the Popup usinf xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //Registering popup with OnmenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(MainActivity.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

                //Showing popup menu
                popup.show();
            }
        });
    }
}
