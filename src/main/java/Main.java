import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println("Student saved: " + savedStudent);

        // Find student by ID
        String studentId = savedStudent.id();

        try {
            Student foundStudent = studentService.findStudentById(studentId);
            System.out.println("Found student: " + foundStudent);
        } catch (NoSuchElementException e) {
            System.out.println("Student not found");
        }
    }
}
