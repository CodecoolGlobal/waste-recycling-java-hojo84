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

        public void throwOutGarbage(Garbage garbage) throws DustbinContentException {
                short CAPACITY_MODIFIER = 2;
                boolean isAllowedGarbage = true;
                if (garbage instanceof PlasticGarbage) {
                        PlasticGarbage plastic = (PlasticGarbage) garbage;
                        if (!plastic.isClean()) isAllowedGarbage = false;
                }
                if (garbage instanceof PaperGarbage) {
                        PaperGarbage paper = (PaperGarbage) garbage;
                        if (!paper.isSqueezed()) isAllowedGarbage = false;
                }
                if (isAllowedGarbage) {
                        if (size + 1 > getCapacity())
                                this.garbageArray = Arrays.copyOf(garbageArray, garbageArray.length * CAPACITY_MODIFIER);
                        garbageArray[size++] = garbage;
                } else {
                        throw new DustbinContentException("Garbage type is not permitted");
                }
        }

        public void emptyContents() {
                this.garbageArray = new Garbage[10];
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("Dustbin");
                sb.append(Arrays.toString(garbageArray));
                return sb.toString();
        }
}
