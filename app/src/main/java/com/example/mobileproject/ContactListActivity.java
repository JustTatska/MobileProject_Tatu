package com.example.mobileproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ListView listView = findViewById(R.id.contact_list_view);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alice Smith", "123-456-7890", "alice@example.com", R.drawable.alice));
        contacts.add(new Contact("Bob Johnson", "987-654-3210", "bob@example.com", R.drawable.bob));
        contacts.add(new Contact("Dave Brown", "555-666-7777", "dave@example.com", R.drawable.dave));

        ContactAdapter adapter = new ContactAdapter(this, contacts);
        listView.setAdapter(adapter);
    }
}
