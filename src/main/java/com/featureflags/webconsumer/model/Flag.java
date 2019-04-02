package com.featureflags.webconsumer.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Flag {

    @NotNull
    private String name;

    @NotNull
    @Max(value = Integer.MAX_VALUE, message = "Value cannot exceed the MAXVALUE for given number of regions")
    private int value;

    private int[] valueBits;

    public Flag(){}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.setValueBits(this.calculateValueBits(value));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getValueBits() {
        return valueBits;
    }

    public void setValueBits(int[] valueBits) {
        this.valueBits = valueBits;
    }

    private int[] calculateValueBits(int value){
        int container[] = new int[5];
        int n = value;
        int i = 4;   // setting this to 5 as there are 5 regions
        while (n > 0 && i >= 0){
            container[i] = n % 2;
            n /= 2;
            i -= 1;
        }
        return container;
    }
}
