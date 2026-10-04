# Assignment 3 - Bridge Pattern

Student: Zhumabay Aikyn  
Group: SE-2523  
Topic: C - Reports  
GitHub Repository: YOUR_GITHUB_LINK  
Base Commit: YOUR_BASE_COMMIT_HASH  

## About Project

This project demonstrates the Bridge design pattern.

There are two parts:

- Reports
- Formatters

The report calculates the data, and the formatter decides how the result looks.

## Classes

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

## Bridge

`Report` stores a `Formatter` object.

The main method is:

```java
execute()
