# Assignment 3 - Bridge Pattern

**Student:** Zhumabay Aikyn  
**Group:** SE-2523  
**Topic:** C - Reports  
**GitHub Repository:** YOUR_GITHUB_LINK  
**Base Commit:** YOUR_BASE_COMMIT_HASH  

## Project Description

This project demonstrates the Bridge design pattern using reports and different formatting methods.

There are two independent parts in the project:

- Report types
- Formatter types

The report classes calculate the report data, and the formatter classes control how the result is displayed.

The Bridge pattern allows reports and formatters to change independently.

## Class Roles

| Role | Class | Source |
|---|---|---|
| Abstraction | Report | src/Report.java |
| A1 | AttendanceReport | src/AttendanceReport.java |
| A2 | GradeReport | src/GradeReport.java |
| Implementor | Formatter | src/Formatter.java |
| I1 | TextFormatter | src/TextFormatter.java |
| I2 | HtmlFormatter | src/HtmlFormatter.java |
| I3 | MarkdownFormatter | src/MarkdownFormatter.java |
| Client | Main | src/Main.java |

## Bridge Structure

The `Report` class stores a reference to the `Formatter` interface:

```java
private Formatter formatter;
```

The formatter is passed through the constructor.

The main operation is:

```java
execute()
```

The formatter can be changed at runtime using:

```java
setImplementation(...)
```

This connection between `Report` and `Formatter` is the Bridge.

## Report Data

`AttendanceReport` uses:

- Attended sessions: 3
- Total sessions: 4
- Result: 75%

`GradeReport` uses:

- Grades: 70, 80, 90
- Average: 80

## Demo Checks

The program runs seven checks.

### T1

AttendanceReport with TextFormatter

Expected result:

```text
Attendance Report: 3/4 sessions attended (75%)
```

### T2

AttendanceReport with HtmlFormatter

Expected result:

```text
<h1>Attendance Report</h1><p>3/4 sessions attended (75%)</p>
```

### T3

GradeReport with TextFormatter

Expected result:

```text
Grade Report: average of 70, 80, 90 = 80
```

### T4

GradeReport with HtmlFormatter

Expected result:

```text
<h1>Grade Report</h1><p>average of 70, 80, 90 = 80</p>
```

### T5

The same AttendanceReport object first uses TextFormatter and then changes to HtmlFormatter.

The check confirms:

```text
sameObject=true
stateUnchanged=true
```

The report ID and attendance data stay the same. Only the formatter changes.

### T6

AttendanceReport with MarkdownFormatter

Expected result:

```text
# Attendance Report

3/4 sessions attended (75%)
```

### T7

GradeReport with MarkdownFormatter

Expected result:

```text
# Grade Report

average of 70, 80, 90 = 80
```

The final demo result should be:

```text
SUMMARY: 7/7 PASS
```

## Important Code Locations

Bridge field:

```text
src/Report.java
```

Main operation `execute()`:

```text
src/Report.java
```

Runtime implementation change `setImplementation(...)`:

```text
src/Report.java
```

Runtime switch check T5:

```text
src/Main.java
```

## Build and Run

The project uses JDK 17.

Compile the project:

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

Run the demo:

```bash
java -cp out Main --demo
```

The program runs all checks automatically without user input.

## Extension

The first version of the project used:

- TextFormatter
- HtmlFormatter

After the base version was completed and committed, `MarkdownFormatter` was added as the third implementation.

For the extension, the existing Report classes, Formatter interface, TextFormatter, and HtmlFormatter were not changed.

Only the new `MarkdownFormatter` class and the demonstration in `Main` were added.

This shows that a new implementation can be added without changing the existing Bridge structure.

## Bridge and Adapter

Bridge separates two parts of a program that should be able to change independently.

In this project, report types and formatting types are separated.

For example, the same `AttendanceReport` can work with TextFormatter, HtmlFormatter, or MarkdownFormatter.

Adapter has a different purpose. Adapter is used when existing classes have incompatible interfaces and need to work together.

Bridge is used to separate independent parts of the program, while Adapter is used to connect incompatible existing interfaces.

## Project Structure

```text
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
```
