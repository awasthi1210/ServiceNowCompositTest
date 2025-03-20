import os
import sys
import random
import hashlib
import sqlite3

# --- Hardcoded Credentials (Security Issue) ---
USERNAME = "admin"
PASSWORD = "password123"  # Hardcoded password

# --- Unused Variables (Code Smell) ---
unused_var1 = 42
unused_var2 = "I am never used"

# --- Duplicate Code Example (Code Smell) ---
def duplicate_function_1():
    x = 10
    y = 20
    return x + y

def duplicate_function_2():
    x = 10
    y = 20
    return x + y

# --- SQL Injection (Security Issue) ---
def unsafe_query(user_input):
    conn = sqlite3.connect("database.db")
    cursor = conn.cursor()
    query = "SELECT * FROM users WHERE name = '" + user_input + "'"  # Vulnerable to SQL Injection
    cursor.execute(query)
    return cursor.fetchall()

# --- Infinite Loop (Bug) ---
def infinite_loop():
    while True:
        pass  # Never terminates

# --- Mutable Default Argument (Bug) ---
def mutable_arg_bug(data=[]):
    data.append(1)
    return data

# --- Uncaught Exception (Bug) ---
def exception_bug():
    try:
        return 1 / 0  # Division by zero
    except ValueError:  # Catches wrong exception type
        print("ValueError occurred!")

# --- Unused Import (Code Smell) ---
import json

# --- Use of eval() (Security Issue) ---
def eval_security_issue(user_input):
    return eval(user_input)  # Dangerous function

# --- Logging Sensitive Information (Security Issue) ---
def log_sensitive():
    print(f"Logging password: {PASSWORD}")  # Exposing sensitive data in logs

# --- Large Cyclomatic Complexity (Code Smell) ---
def complex_function(x):
    if x > 0:
        if x % 2 == 0:
            if x % 3 == 0:
                if x % 5 == 0:
                    print("Multiple conditions met")

# --- Insecure Randomness (Security Issue) ---
def insecure_random():
    return random.randint(0, 100)  # Should use `secrets` for security-sensitive operations

# --- Dead Code (Code Smell) ---
def dead_code():
    return
    print("This line will never execute")  # Dead code

# --- Memory Leak (Bug) ---
def memory_leak():
    large_list = []
    while True:
        large_list.append("leak")  # Unbounded memory growth

# --- Main Execution ---
if __name__ == "__main__":
    print("Executing buggy script...")
    exception_bug()
    unsafe_query("admin' OR '1'='1")  # SQL Injection Example
    eval_security_issue("__import__('os').system('ls')")  # Dangerous eval
    infinite_loop()  # Causes program to hang
