import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.ArrayList;

public class BuggyJavaCode {
    
    // --- Hardcoded Credentials (Security Issue) ---
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";  // Hardcoded password

    // --- Unused Variables (Code Smell) ---
    private static int unusedVar1 = 42;
    private static String unusedVar2 = "I am never used";

    // --- Duplicate Code Example (Code Smell) ---
    public static int duplicateFunction1() {
        int x = 10, y = 20;
        return x + y;
    }

    public static int duplicateFunction2() {
        int x = 10, y = 20;
        return x + y;
    }

    // --- SQL Injection (Security Issue) ---
    public static void unsafeQuery(String userInput) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE name = '" + userInput + "'"; // SQL Injection risk
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- Infinite Loop (Bug) ---
    public static void infiniteLoop() {
        while (true) {
            // Never terminates
        }
    }

    // --- Mutable Static Variable (Bug) ---
    private static ArrayList<String> mutableList = new ArrayList<>();

    public static void mutableBug() {
        mutableList.add("Buggy");
    }

    // --- Uncaught Exception (Bug) ---
    public static void exceptionBug() {
        try {
            int result = 1 / 0;  // Division by zero
        } catch (NullPointerException e) {  // Catching wrong exception type
            System.out.println("NullPointerException occurred!");
        }
    }

    // --- Use of eval() equivalent (Security Issue) ---
    public static void evalSecurityIssue(String command) {
        try {
            Runtime.getRuntime().exec(command); // Dangerous execution
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- Logging Sensitive Information (Security Issue) ---
    public static void logSensitive() {
        System.out.println("Logging password: " + PASSWORD); // Exposing sensitive data
    }

    // --- Large Cyclomatic Complexity (Code Smell) ---
    public static void complexFunction(int x) {
        if (x > 0) {
            if (x % 2 == 0) {
                if (x % 3 == 0) {
                    if (x % 5 == 0) {
                        System.out.println("Multiple conditions met");
                    }
                }
            }
        }
    }

    // --- Insecure Randomness (Security Issue) ---
    public static int insecureRandom() {
        Random random = new Random();
        return random.nextInt(100);  // Should use SecureRandom for security-sensitive operations
    }

    // --- Dead Code (Code Smell) ---
    public static void deadCode() {
        return;
        // This line will never execute
        System.out.println("Dead code");
    }

    // --- Memory Leak (Bug) ---
    public static void memoryLeak() {
        ArrayList<String> largeList = new ArrayList<>();
        while (true) {
            largeList.add("leak"); // Unbounded memory growth
        }
    }

    public static void main(String[] args) {
        System.out.println("Executing buggy Java code...");
        exceptionBug();
        unsafeQuery("admin' OR '1'='1");  // SQL Injection Example
        evalSecurityIssue("ls");  // Dangerous command execution
        infiniteLoop();  // Causes program to hang
    }
}
