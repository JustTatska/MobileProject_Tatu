package com.example.mobileproject;


// Class representing a contact
public class Contacts {
    private final String name;
    private final String phone;
    private final String email;
    private final int imageResId;


    // Constructor to initialize a contact with the given details
    public Contacts(String name, String phone, String email, int imageResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.imageResId = imageResId;
    }

    // Get functions to each detail variable
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getImageResId() {
        return imageResId;
    }
}

