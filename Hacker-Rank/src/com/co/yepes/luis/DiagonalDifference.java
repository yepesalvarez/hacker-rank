package com.co.yepes.luis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DiagonalDifference {
	
	// Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
    	
    int priDiagSum = IntStream.range(0, arr[0].length)
    					.map(pos -> arr[pos][pos]).sum();
    int secDiagSum = IntStream.range(0, arr[0].length).map(i -> 
						IntStream.range(0, arr[0].length)
							.filter(j -> (j + i) == arr[0].length - 1)
							.map(pos -> arr[i][pos])
							.findFirst().getAsInt())
    					.sum();    				 
    						
    return Math.abs(priDiagSum - secDiagSum);
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testassets\\DiagonalDifference.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
