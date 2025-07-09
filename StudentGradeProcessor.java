/**
 * Student Grade Processor Application
 * 
 * Reads student names and course grades from input files,
 * calculates final grades, and generates a sorted report.
 * 
 * Contributors: Peter Mazur, Ashvinan Sivasambu, Raafay Qureshi, Muhammad Mutto
 * Date: 07/11/2025
 * Version: 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class StudentGradeProcessor {

    /**
     * Reads student names and IDs from a text file into a HashMap
     * 
     * @param filename      Path to the input file containing student names
     * @param studentNames  HashMap to store student IDs (key) and names (value)
     * @throws IOException  If there's an error reading the file
     */
    public static void readNameFile(String filename, HashMap<String,String> studentNames) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String studentId = parts[0].trim();
                    String studentName = parts[1].trim();
                    studentNames.put(studentId, studentName);
                }
            }
        }
    }

    /**
     * Reads course information and grades from a text file
     * 
     * @param filename       Path to the input file containing course grades
     * @param studentNames   HashMap containing student ID-name mappings
     * @param courseRecords  ArrayList to store processed Course objects
     * @throws IOException   If there's an error reading the file
     */
    public static void readCourseFile(String filename, HashMap<String,String> studentNames, ArrayList<Course> courseRecords) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String studentId = parts[0].trim();
                    String studentName = studentNames.getOrDefault(studentId, "Unknown");
                    String courseCode = parts[1].trim();
                    
                    try {
                        double test1 = Double.parseDouble(parts[2].trim());
                        double test2 = Double.parseDouble(parts[3].trim());
                        double test3 = Double.parseDouble(parts[4].trim());
                        double finalExam = Double.parseDouble(parts[5].trim());
                        
                        Course record = new Course(studentId, studentName, 
                                courseCode, test1, test2, test3, finalExam);
                        courseRecords.add(record);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in line: " + line);
                    }
                }
            }
        }
    }

    /**
     * Writes the processed course records to an output file
     * 
     * @param filename       Path to the output file to generate
     * @param courseRecords  ArrayList of Course objects to output
     * @throws IOException   If there's an error writing the file
     */
    public static void writeOutputFile(String filename, ArrayList<Course> courseRecords) throws IOException {
            // Sort records by student ID
            courseRecords.sort(Comparator.comparing(Course::getId));
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                // Header
                writer.printf("%-10s\t%-20s\t%-15s\t%-4s\n", "Student ID", "Student Name", "Course Code", "Final Grade");
                
                // Write each record
                for (Course record : courseRecords) {
                    writer.println(record);
                }
            }
        }

        /**
     * Main program entry point
     */
    public static void main(String[] args) {

        final String nameFile = "NameFile.txt";
        final String courseFile = "CourseFile.txt";
        final String outputFile = "OutputFile.txt";

        // Data structures
        HashMap<String, String> studentNames = new HashMap<String, String>();
        ArrayList<Course> courseRecords = new ArrayList<Course>();
        
        try {
            readNameFile(nameFile, studentNames);
            readCourseFile(courseFile, studentNames, courseRecords);
            writeOutputFile(outputFile, courseRecords);
            
            System.out.println("Process completed successfully.");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}