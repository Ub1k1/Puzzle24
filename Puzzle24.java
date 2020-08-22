package com.company;

import java.util.*;

public class Puzzle24 {
    private int[] input;
    private Stack<String> Ops;

    public Puzzle24(int[] array){
        Ops = new Stack<>();
        input = array;
    }

    private boolean solve(int n){
        System.out.printf("n = %d", n);
        System.out.println(Arrays.toString(input));
        if (n == 1){
            if (input[0] == 24){
                return true;
            }else{
                return false;
            }
        }
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                int a = input[i];
                int b = input[j];
                input[j] = input[n-1];

                input[i] = a + b;
                Ops.push(String.format("%d + %d = %d", a, b, a+b));
                if (solve(n-1)){
                    return true;
                }
                Ops.pop();

                int bigger, smaller;
                bigger = a>=b? a : b;
                smaller = a<b? a : b;
                input[i] = bigger - smaller;
                Ops.push(String.format("%d - %d = %d", bigger, smaller, bigger - smaller));
                if (solve(n-1)){
                    return true;
                }
                Ops.pop();

                input[i] = a*b;
                Ops.push(String.format("%d * %d = %d", a, b, a*b));
                if (solve(n-1)){
                    return true;
                }
                Ops.pop();

                if (smaller != 0 && bigger % smaller == 0){
                    input[i] = bigger / smaller;
                    Ops.push(String.format("%d / %d = %d", bigger, smaller, bigger/smaller));
                    if (solve(n-1)){
                        return true;
                    }
                    Ops.pop();
                }

                input[i] = a;
                input[j] = b;
            }
        }
        return false;
    }

    public String solve() {
        if (solve(4)){
            return Ops.toString();
        }
        return null;
    }
}
