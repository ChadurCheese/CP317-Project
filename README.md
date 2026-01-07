Student Grade Processor - CP317 Project
📋 Project Overview

A Java-based application for processing student grades and course information, developed as part of the CP317 course at Wilfrid Laurier University.

📁 Repository Structure

├── StudentGradeProcessor.java    # Main application class
├── StudentGradeProcessor.class   # Compiled main class
├── Student.java                  # Student entity class
├── Student.class                 # Compiled Student class
├── Course.java                   # Course entity class
├── Course.class                  # Compiled Course class
├── CourseFile.txt                # Sample course data file
├── NameFile.txt                  # Sample student data file
├── outputFile.txt                # Generated output file
└── .gitignore                    # Git ignore rules

🛠️ Setup Instructions
Prerequisites

    Java Development Kit (JDK) 8 or higher

    Command-line terminal or IDE (Eclipse/IntelliJ/VSCode)

# Run the main application
java StudentGradeProcessor

📊 Core Components
1. StudentGradeProcessor.java

The main driver class that coordinates:

    Reading input files (CourseFile.txt, NameFile.txt)

    Processing student and course data

    Generating output (outputFile.txt)

    Test case execution and validation

2. Student.java

Represents a student with properties like:

    Student ID

    Name

    Course enrollments

    Test scores and grades

    Methods for grade calculations

3. Course.java

Manages course information including:

    Course code and title

    Test score management

    Validation methods for student performance

    Data persistence operations

📝 File Descriptions
File	Purpose	Format
CourseFile.txt	Contains course information	Text-based structured data
NameFile.txt	Contains student information	Text-based structured data
outputFile.txt	Generated output with processed results	Formatted text output
.gitignore	Specifies files to ignore in version control	Git configuration
🧪 Testing

The application includes test cases within StudentGradeProcessor.java to validate:

    File reading/writing operations

    Grade calculation logic

    Data integrity checks

    Edge case handling

👥 Development Team

    Piotr (@ChadurCheese) - Repository owner

    Ashvinan Sivasambu (@Ashvinan19)

    @gameflame

📈 Project Statistics

    Language: Java (100%)

    Commits: 19 total

    Last Updated: January 8, 2026

    Contributors: 3

🔄 Version Control

The project uses Git with the following .gitignore configuration to exclude compiled .class files and IDE-specific files from version control.
🤝 Contributing

As this is a course project, contributions are limited to the development team. For questions or issues, please contact the repository maintainers.
📚 Academic Context

This project was developed for CP317 at Wilfrid Laurier University, demonstrating object-oriented programming principles, file I/O operations, and data processing in Java.
