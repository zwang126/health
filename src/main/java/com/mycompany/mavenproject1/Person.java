/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Administrator
 */
public class Person {
    private String name;
  
    private float xue_tang;
    private int xue_ya_high;
    private int xue_ya_low;

    public Person(String name, float xue_tang, int xue_ya_high, int xue_ya_low) {
        this.name = name;
        
        this.xue_tang = xue_tang;
        this.xue_ya_high = xue_ya_high;
        this.xue_ya_low = xue_ya_low;
    }
    public String getName() {
        return name;
    }

   

    public float getXue_tang() {
        return xue_tang;
    }

    public int getXue_ya_high() {
        return xue_ya_high;
    }

    public int getXue_ya_low() {
        return xue_ya_low;
    }
  
}
