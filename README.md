
# Student Grade Processing System

A Java-based command-line application for processing and calculating student grades from course data files.

## 📋 Basic Description

This application reads student information and course grades from text files, processes the data to calculate weighted grades and GPAs, and outputs a formatted report. It demonstrates object-oriented programming principles with separate classes for students, courses, and grade processing logic.

## 👥 Contributors

- **Developer**: Piotr, Ashnivan, Muhammad, Raafay

## 📁 Project Directory Structure

```markdown
CP317-Project/
├── Course.java                    # Course data model class
├── Student.java                   # Student data model class
├── StudentGradeProcessor.java     # Main processing logic
├── CourseFile.txt                # Course/grade data input
├── NameFile.txt                  # Student name data input
├── outputFile.txt                # Generated output file
├── README.md                     # This documentation
└── .gitignore                    # Git ignore file
```

*Compiled `.class` files are generated when the program is compiled.*

## ✨ Features

### 📊 Data Processing
- Reads student data from `NameFile.txt`
- Processes course grades from `CourseFile.txt`
- Calculates weighted final grades
- Generates formatted output in `outputFile.txt`

### 🏗️ Object-Oriented Design
- **Course Class**: Models course data (code, grade, weight)
- **Student Class**: Models student information (name, ID, courses)
- **Processor Class**: Main logic for reading, processing, and writing data

### 📁 File Management
- Simple text file input/output
- Error handling for missing files
- Clean separation of data and logic

### 🎯 Educational Value
- Demonstrates Java file I/O operations
- Shows object-oriented programming principles
- Practical example of data processing algorithms
- Clean code structure suitable for academic projects
