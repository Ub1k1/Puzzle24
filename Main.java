package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] order = {1, 2, 3, 4};
        int[] house = {2, 3, 8, 9};

        Puzzle24 p24 = new Puzzle24(order);
        Puzzle24 p23 = new Puzzle24(house);

        System.out.println(p24.solve());
        System.out.println(p23.solve());
    }
}
