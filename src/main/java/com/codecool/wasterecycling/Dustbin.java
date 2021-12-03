package com.codecool.wasterecycling;

import java.util.Arrays;

public class Dustbin {

        private final String color;
        private Garbage[] garbageArray;
        private int size = 0;


        public Dustbin(String color) {
                this.color = color;
                this.garbageArray = new Garbage[10];
        }

        public String getColor() {
                return color;
        }

        private int getCapacity() {
                return garbageArray.length;
        }

        private int getSize() {
                return size;
        }

        public void throwOutGarbage(Garbage garbage) {
                short CAPACITY_MODIFIER = 2;
                if (size + 1 > getCapacity())
                        this.garbageArray = Arrays.copyOf(garbageArray, garbageArray.length * CAPACITY_MODIFIER);
                garbageArray[size++] = garbage;
        }

        public void emptyContents() {
                this.garbageArray = new Garbage[10];
        }
}
