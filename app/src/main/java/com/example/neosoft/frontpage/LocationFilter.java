package com.example.neosoft.frontpage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class LocationFilter extends AppCompatActivity {

    EditText editText;
    ListView listView;
    ListViewAdapter adapter;
    String[] Name;
    ArrayList<PeopleName> nameArrayList = new ArrayList<PeopleName>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_filter);
        //Creating Filter or Search for Listview
        //GOOD

        //Create string array
        Name = new String[]{"Clipcodes Android", "Youtube Clipcodes", "Android Developers", "Michael Monney",
                "Alana Komre", "Simmon Pentol", "Mahathir Gresik", "Android Studio", "Create Filter Listview",
                "Ellie Camaro", "Youtube Android", "Blogger Clipcodes", "Cool ListView", "Mahathir Ujungpangkah"};
        //Listview
        listView = (ListView)findViewById(R.id.list);


        //Set Data
        for (int i = 0; i < Name.length; i++){
            PeopleName PN = new PeopleName(Name[i]);
            nameArrayList.add(PN);
        }
        //The custom adapter
        adapter = new ListViewAdapter(this, nameArrayList);

        //Listview
        listView.setAdapter(adapter);

        //Edittext
        editText = (EditText)findViewById(R.id.Edt);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter
                String who = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.myFilter(who);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
