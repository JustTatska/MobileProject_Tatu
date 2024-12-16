package com.example.mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

// A custom adapter for displaying the contact list view
public class ContactAdapter extends ArrayAdapter<Contacts> {

    // Constructor for the contact adapter
    public ContactAdapter(@NonNull Context context, @NonNull List<Contacts> contacts) {
        super(context, 0, contacts);
    }

    // Provides a view for an adapter's data at the specified position
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_contact, parent, false);
        }

        // Gets the contact data at the current position
        Contacts contact = getItem(position);

        // Finds views within the list item layout
        TextView nameTextView = convertView.findViewById(R.id.contact_name);
        TextView phoneTextView = convertView.findViewById(R.id.contact_phone);
        TextView emailTextView = convertView.findViewById(R.id.contact_email);
        ImageView imageView = convertView.findViewById(R.id.contact_image);

        // Populates the views with contact data
        assert contact != null;
        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhone());
        emailTextView.setText(contact.getEmail());
        imageView.setImageResource(contact.getImageResId());

        return convertView;
    }
}

