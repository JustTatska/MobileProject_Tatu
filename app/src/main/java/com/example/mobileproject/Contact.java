package com.example.mobileproject;

public class Contact {
    private final String name;
    private final String phone;
    private final String email;
    private final int imageResId;

    public Contact(String name, String phone, String email, int imageResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.imageResId = imageResId;
    }

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

