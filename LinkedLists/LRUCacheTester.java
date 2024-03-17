package LinkedLists;

import java.io.IOException;
import java.util.*;

public class LRUCacheTester {

    // Helper function to generate random queries
    private static String generateQuery(int maxKey, int maxValue) {
        Random rand = new Random();
        int queryType = rand.nextInt(2); // 0 for SET, 1 for GET
        int key = rand.nextInt(maxKey) + 1; // Key range from 1 to maxKey

        if (queryType == 0) { // SET query
            int value = rand.nextInt(maxValue) + 1; // Value range from 1 to maxValue
            return "SET " + key + " " + value;
        } else { // GET query
            return "GET " + key;
        }
    }

    // Function to generate test cases
    private static List<String> generateTestCases(int numTestCases, int maxKey, int maxValue, int numQueries) {
        List<String> testCases = new ArrayList<>();
        for (int i = 0; i < numTestCases; i++) {
            StringBuilder testCase = new StringBuilder();
            testCase.append(maxKey).append("\n");
            testCase.append(numQueries).append("\n");
            for (int j = 0; j < numQueries; j++) {
                testCase.append(generateQuery(maxKey, maxValue)).append(" ");
            }
            testCases.add(testCase.toString());
        }
        return testCases;
    }

    // Function to verify result of test cases
    private static boolean verifyResults(String input, String expectedOutput) throws IOException {
        StringBuilder actualOutput = new StringBuilder();
        LRUDesign.main(input.split("\n"));
        Scanner scanner = new Scanner(input);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int capacity = scanner.nextInt();
            int queries = scanner.nextInt();
            LRUCache cache = new LRUCache(capacity);

            for (int i = 0; i < queries; i++) {
                String queryType = scanner.next();
                int key = scanner.nextInt();

                if (queryType.equals("SET")) {
                    int value = scanner.nextInt();
                    cache.set(key, value);
                } else if (queryType.equals("GET")) {
                    actualOutput.append(cache.get(key)).append(" ");
                }
            }
            actualOutput.append("\n");
        }
        scanner.close();

        return actualOutput.toString().trim().equals(expectedOutput.trim());
    }

    public static void main(String[] args) throws IOException {
        int numTestCases = 300;
        int maxKey = 10; // Maximum key value for test cases
        int maxValue = 20; // Maximum value for test cases
        int numQueries = 10; // Number of queries per test case

        List<String> testCases = generateTestCases(numTestCases, maxKey, maxValue, numQueries);

        for (int i = 0; i < numTestCases; i++) {
            String input = testCases.get(i);
            String expectedOutput = LRUDesignHelper.getExpectedOutput(input);
            boolean result = verifyResults(input, expectedOutput);
            System.out.println("Test Case " + (i + 1) + ": " + (result ? "Passed" : "Failed"));
        }
    }
}

class LRUDesignHelper {

    public static String getExpectedOutput(String input) {
        StringBuilder expectedOutput = new StringBuilder();
        Scanner scanner = new Scanner(input);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int capacity = scanner.nextInt();
            int queries = scanner.nextInt();
            LRUCache cache = new LRUCache(capacity);

            for (int i = 0; i < queries; i++) {
                String queryType = scanner.next();
                int key = scanner.nextInt();

                if (queryType.equals("SET")) {
                    int value = scanner.nextInt();
                    cache.set(key, value);
                } else if (queryType.equals("GET")) {
                    expectedOutput.append(cache.get(key)).append(" ");
                }
            }
            expectedOutput.append("\n");
        }
        scanner.close();

        return expectedOutput.toString().trim();
    }
}
