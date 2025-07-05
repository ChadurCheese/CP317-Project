// Put projects details and names here

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* need to add error handling for no files */


public class StudentGradeProcessor {

    // Method puts student name & ID into hashmap 
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

    public static void writeOutputFile(String filename, ArrayList<Course> courseRecords) throws IOException {
            // Sort records by student ID
            courseRecords.sort(Comparator.comparing(Course::getId));
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                // header
                writer.printf("%-10s\t%-20s\t%-15s\t%-4s\n", "Student ID", "Student Name", "Course Code", "Final Grade");
                
                // Write each record
                for (Course record : courseRecords) {
                    writer.println(record);
                }
            }
        }

    public static void main(String[] args) {

        final String nameFile = "NameFile.txt";
        final String courseFile = "CourseFile.txt";
        HashMap<String, String> studentNames = new HashMap<String, String>(); // unique names and id
        ArrayList<Course> courseRecords = new ArrayList<Course>();
        
        try {
            // Read input files
            readNameFile(nameFile, studentNames);
            readCourseFile(courseFile, studentNames, courseRecords);
            
            // Process and write output
            writeOutputFile("outputFile.txt", courseRecords); // change name later
            
            System.out.println("Process completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}