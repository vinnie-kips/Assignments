public class Student {
    private String name;
    private int grade1, grade2, grade3;
    private double average;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    public int getGrade3() {
        return grade3;
    }

    public void setGrade3(int grade3) {
        this.grade3 = grade3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
//calculate the avg of the grades
    public double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }
}