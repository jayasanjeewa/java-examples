package com.example.reference;

import java.lang.ref.WeakReference;

public class WeakStrongReference {
    ReferenceCheck ref = new ReferenceCheck();

    public static void main(String[] args) {
        WeakStrongReference weakStrongReference = new WeakStrongReference();
        weakStrongReference.ref.printName();

    }

    private class ReferenceCheck {
        WeakReference<String> name = new WeakReference<String>("test");
        private  void printName() {
            System.out.println("name: "+ name.get());
        }
    }
}
