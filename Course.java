/**
 * Represents a student's course enrollment with grade calculations.
 * Extends the base Student class to include course-specific grade information.
 * 
 * @author Peter Mazur, Ashvinan Sivasambu, Raafay Qureshi, Muhammad Mutto
 * @version 1.0
 * @see Student
 */
class Course extends Student{
    private String code;
    private double test1, test2, test3, exam, finalGrade;
    
    /**
     * Constructs a Course record with grade components.
     * 
     * @param id     Student ID (inherited from Student)
     * @param name   Student name (inherited from Student)
     * @param code   Course identification code
     * @param test1  First test score (0-100)
     * @param test2  Second test score (0-100)
     * @param test3  Third test score (0-100)
     * @param exam   Final exam score (0-100)
     * @throws IllegalArgumentException if any grade is outside 0-100 range
     */
    public Course(String id, String name, String code, 
                       double test1, double test2, double test3, double exam) {
        super(id, name);
        this.code = code;
        this.test1 = validateGrade(test1);
        this.test2 = validateGrade(test2);
        this.test3 = validateGrade(test3);
        this.exam = validateGrade(exam);
        calculateFinalGrade();
    }

    /**
     * Validates that a grade is within acceptable range.
     * 
     * @param grade The grade to validate
     * @return The validated grade
     * @throws IllegalArgumentException if grade is outside 0-100 range
     */
    private double validateGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        return grade;
    }

    /**
     * Calculates the final grade using the formula:
     * (test1 + test2 + test3) * 0.2 + (exam * 0.4)
     * Automatically called during construction.
     */
    private void calculateFinalGrade() {
        finalGrade = (test1 + test2 + test3) * 0.2 + (exam * 0.4);
    }

    /**
     * Gets the course code.
     * 
     * @return The course identification code
     */
    public String getCourseCode() {
        return code;
    }

    /**
     * Gets the calculated final grade.
     * 
     * @return Final grade weighted according to course formula
     */
    public double getFinalGrade() {
        return finalGrade;
    }

    /**
     * Formats the course record.
     */
    @Override
    public String toString() {
        return String.format("%-10s\t%-20s\t%-15s\t%-4.1f", id, name, code, finalGrade);
    }
}
