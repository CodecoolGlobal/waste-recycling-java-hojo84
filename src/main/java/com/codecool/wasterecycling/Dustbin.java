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
                String[] houseWasteArr = new String[getHouseWasteCount()];
                String[] paperArr = new String[getPaperCount()];
                String[] plasticArr = new String[getPlasticCount()];
                int sizeHouseWasteArr = 0, sizePaperArr = 0, sizePlasticArr = 0;
                for (int i = 0; i < getSize(); i++) {
                        if (garbageArray[i] instanceof PaperGarbage) {
                                paperArr[sizePaperArr++] = garbageArray[i].getName();
                        } else if (garbageArray[i] instanceof PlasticGarbage) {
                                plasticArr[sizePlasticArr++] = garbageArray[i].getName();
                        } else {
                                houseWasteArr[sizeHouseWasteArr++]=garbageArray[i].getName();
                        }
                }
                final StringBuilder sb = new StringBuilder(getColor() + " Dustbin! ");
                sb.append("House waste content: "+ getHouseWasteCount() +" item(s) ");
                for (int i = 0; i < houseWasteArr.length; i++) {
                        sb.append(houseWasteArr[i]).append(" nr.").append(i+1).append(" ");
                }
                sb.append("Paper content: "+ getPaperCount() +" item(s) ");
                for (int i = 0; i < paperArr.length; i++) {
                        sb.append(paperArr[i]).append(" nr.").append(i+1).append(" ");
                }
                sb.append("Plastic content: "+ getPlasticCount() +" item(s) ");
                for (int i = 0; i < plasticArr.length; i++) {
                        sb.append(plasticArr[i]).append(" nr.").append(i+1).append(" ");
                }
                return sb.toString();
        }

        public int getHouseWasteCount() {
                return getSize() - (getPaperCount() + getPlasticCount());
        }

        public int getPaperCount() {
                int counter = 0;
                for (int i = 0; i < getSize(); i++) {
                        if (garbageArray[i] instanceof PaperGarbage) counter++;
                }
                return counter;
        }

        public int getPlasticCount() {
                int counter = 0;
                for (int i = 0; i < getSize(); i++) {
                        if (garbageArray[i] instanceof PlasticGarbage) counter++;
                }
                return counter;
        }
}
