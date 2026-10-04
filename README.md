# Assignment 3 - Bridge Pattern

## About Project

This project demonstrates the Bridge design pattern.

The project has two parts:

- Reports
- Formatters

Reports calculate the data, and formatters decide how the result is displayed.

## Classes

Abstraction: Report
A1: AttendanceReport
A2: GradeReport

Implementor: Formatter
I1: TextFormatter
I2: HtmlFormatter
I3: MarkdownFormatter

Client: Main

## Bridge

The Report class stores a Formatter object.

Main operation:
execute()

The formatter can be changed using:
setImplementation(...)

T5 shows that the formatter can be changed on the same report object.

## Demo Tests

T1 - AttendanceReport + TextFormatter
T2 - AttendanceReport + HtmlFormatter
T3 - GradeReport + TextFormatter
T4 - GradeReport + HtmlFormatter
T5 - Change TextFormatter to HtmlFormatter on the same object
T6 - AttendanceReport + MarkdownFormatter
T7 - GradeReport + MarkdownFormatter

Expected final result:

SUMMARY: 7/7 PASS

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

The first version used TextFormatter and HtmlFormatter.

After the base commit, MarkdownFormatter was added.

The existing Report classes and Formatter interface were not changed.

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
demo-output.txt
extension.diff
```
