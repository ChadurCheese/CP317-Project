@echo off
title Student Grade Processor

echo ================================
echo    Student Grade Processor
echo ================================
echo.

REM Check if compilation is needed
if not exist "StudentGradeProcessor.class" (
    echo Compiling source files...
    javac Course.java Student.java StudentGradeProcessor.java
    
    if errorlevel 1 (
        echo ERROR: Compilation failed!
        pause
        exit /b 1
    )
    echo Compilation successful!
)

REM Check for required files
if not exist "NameFile.txt" (
    echo ERROR: Missing NameFile.txt
    pause
    exit /b 1
)

if not exist "CourseFile.txt" (
    echo ERROR: Missing CourseFile.txt
    pause
    exit /b 1
)

REM Run the program
echo Processing grades...
echo ------------------------------
java StudentGradeProcessor

if errorlevel 1 (
    echo ERROR: Program failed!
) else (
    echo.
    echo SUCCESS: Grade processing complete!
    
    if exist "outputFile.txt" (
        echo Output written to: outputFile.txt
    )
)

echo ------------------------------
pause