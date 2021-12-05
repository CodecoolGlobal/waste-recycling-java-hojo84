package com.codecool.wasterecycling;

import java.util.Arrays;

public class Main {

        public static void main(String[] args) {
                Dustbin dustbin = new Dustbin("red");

                Garbage garbage1 = new PaperGarbage("tax return", false);
                Garbage garbage2 = new PaperGarbage("cartoon box", true);
                Garbage garbage3 = new PaperGarbage("paper packaging", true);
                Garbage garbage4 = new PlasticGarbage("bread bags", true);
                Garbage garbage5 = new PlasticGarbage("juice box", false);
                Garbage garbage6 = new PlasticGarbage("baby food container", false);
                Garbage garbage7 = new Garbage("Rotten tomato");

                try {
                        dustbin.throwOutGarbage(garbage1);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage2);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage3);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage4);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage5);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage6);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }
                try {
                        dustbin.throwOutGarbage(garbage7);
                } catch (DustbinContentException e) {
                        e.printStackTrace();
                }

                dustbin.displayContents();

                System.out.println("Number of paper garbage: " + dustbin.getPaperCount());
                System.out.println("Number of plastic garbage: " + dustbin.getPlasticCount());
                System.out.println("Number of house waste garbage: " + dustbin.getHouseWasteCount());

                dustbin.emptyContents();
                System.out.println(dustbin);
        }
}
