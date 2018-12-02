package com.co.yepes.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompareTheTriplets {
	
	static int aliceScore;
	static int bobScore;
	
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	aliceScore = 0;
    	bobScore = 0;
    	IntStream.range(0, a.size()).forEach(i -> checkBiggerScore(a.get(i), b.get(i)));
    	
    	return Arrays.asList(aliceScore, bobScore);
    	
    }
    
    public static void checkBiggerScore(int scoreA, int scoreB) {
    	if(scoreA > scoreB) {
    		aliceScore++;
    	}else {
    		if (scoreA < scoreB ) {
    			bobScore++;
    		}
    	}
    	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testassets\\CompareTheTriplets.txt"));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
