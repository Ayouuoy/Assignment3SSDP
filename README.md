# Assignment 3 - Bridge Pattern

Student: Zhumabay Aikyn  
Group: SE-2523  
Topic: C - Reports  
GitHub Repository: YOUR_GITHUB_LINK  
Base Commit: YOUR_BASE_COMMIT_HASH  

## Project Description

This project demonstrates the Bridge design pattern.

The program has two independent parts:

- Report types
- Report formatting types

The report classes calculate the data, while formatter classes decide how the result is displayed.

## Structure

| Role | Class |
|---|---|
| Abstraction | Report |
| A1 | AttendanceReport |
| A2 | GradeReport |
| Implementor | Formatter |
| I1 | TextFormatter |
| I2 | HtmlFormatter |
| I3 | MarkdownFormatter |
| Client | Main |

## Bridge Connection

The `Report` class stores a reference to the `Formatter` interface.

```java
private Formatter formatter;

The formatter is provided through the constructor.
The main operation is:
execute()

The implementation can be changed at runtime using:
setImplementation(...)

This allows the same report object to use different formatters.
Report Data
AttendanceReport uses:
3 attended sessions out of 4
Result: 75%

GradeReport uses:
Grades: 70, 80, 90
Average: 80

Demo Tests
The program runs seven checks.
T1 - AttendanceReport + TextFormatter
T2 - AttendanceReport + HtmlFormatter
T3 - GradeReport + TextFormatter
T4 - GradeReport + HtmlFormatter
T5 - Change TextFormatter to HtmlFormatter on the same AttendanceReport object
T6 - AttendanceReport + MarkdownFormatter
T7 - GradeReport + MarkdownFormatter

T5 also checks that:
sameObject = true
stateUnchanged = true

The report object stays the same, but its formatter changes.
Build and Run
Compile the project:
javac --release 17 -encoding UTF-8 -d out "@sources.txt"

Run the demo:
java -cp out Main --demo

Expected final result:
SUMMARY: 7/7 PASS

Extension
The first version of the project contains:
TextFormatter
HtmlFormatter

After the base commit, MarkdownFormatter was added.
The existing report classes and formatter interface were not changed.
This demonstrates that a new implementation can be added without changing the existing Bridge structure.
Bridge vs Adapter
Bridge separates two parts of a program so they can change independently.
In this project:
Reports <-> Formatters

Adapter has a different purpose. It is used to make incompatible existing classes work together.
Bridge is designed before or during development to separate independent hierarchies.
Project Files
src/
    Main.java
    Report.java
    AttendanceReport.java
    GradeReport.java
    Formatter.java
    TextFormatter.java
    HtmlFormatter.java
    MarkdownFormatter.java

sources.txt
README.md
report.pdf
demo-output.txt
extension.diff
