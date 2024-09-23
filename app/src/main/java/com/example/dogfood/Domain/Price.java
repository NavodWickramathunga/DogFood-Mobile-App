package com.example.dogfood.Domain;

public class Price {
    private int Id;         // Represents the unique identifier for the price (optional, based on your use case)
    private String Value;   // Represents the price as a string (e.g., "$10.00" or "10.00")

    // Default constructor (needed for Firebase and other serialization)
    public Price() {
    }

    // Override the toString method to return the price value when displaying it in UI components
    @Override
    public String toString() {
        return Value;
    }

    // Getter and setter for the price ID
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    // Getter and setter for the price value
    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
