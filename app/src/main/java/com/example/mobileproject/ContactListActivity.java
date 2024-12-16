package com.example.mobileproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// Activity to display a list of contacts using a ListView and a custom adapter
public class ContactListActivity extends AppCompatActivity {

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        // References to the ListView in the layout
        ListView listView = findViewById(R.id.contact_list_view);

        // Creates a list of contact objects
        List<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts("Alice Smith", "123-456-7890", "alice@example.com", R.drawable.alice));
        contacts.add(new Contacts("Bob Johnson", "987-654-3210", "bob@example.com", R.drawable.bob));
        contacts.add(new Contacts("Dave Brown", "555-666-7777", "dave@example.com", R.drawable.dave));

        // Sets up the custom adapter to display the list of contacts
        ContactAdapter adapter = new ContactAdapter(this, contacts);
        listView.setAdapter(adapter);
    }
}
