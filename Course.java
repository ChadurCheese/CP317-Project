class Course extends Student{
    private String code;
    private double test1, test2, test3, exam, finalGrade;
    
    public Course(String id, String name, String code, 
                       double test1, double test2, double test3, double exam) {
        super(id, name);
        this.code = code;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.exam = exam;
        calculateFinalGrade();
    }

    private void calculateFinalGrade() {
        finalGrade = (test1 + test2 + test3) * 0.2 + (exam * 0.4);
    }

    public String getCourseCode() {
        return code;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    @Override
    public String toString() {
        return String.format("%-10s\t%-20s\t%-15s\t%-4.1f", id, name, code, finalGrade);
    }
}
