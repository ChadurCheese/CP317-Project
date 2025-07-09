/**
 * Abstract base class representing a student's information.
 * Serves as the parent class for student records.
 * 
 * @author Peter Mazur, Ashvinan Sivasambu, Raafay Qureshi, Muhammad Mutto
 * @version 1.0
 * @see Course
 */
abstract class Student {
    /**
     * Protected fields to allow direct access by subclasses while maintaining encapsulation
     */
    protected String name, id;

    /**
     * Constructs a Student record with mandatory identification.
     * 
     * @param id   Unique identifier (cannot be null)
     * @param name Full legal name of the student (cannot be null)
     * @throws IllegalArgumentException if id or name are null
     */
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the student's name.
     * 
     * @return Full name as String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the student's unique identifier.
     * 
     * @return ID as String
     */
    public String getId() {
        return this.id;
    }

    
    /**
     * Abstract method forcing subclasses to implement string representation.
     * 
     * @return Formatted student information
     * @implNote Implementing classes should include:
     *           - Consistent column widths
     *           - Field separation
     */
    public abstract String toString();

}
