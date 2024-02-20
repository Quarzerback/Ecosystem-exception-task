import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void testFindStudentById() {
        // Arrange
        StudentService studentService = new StudentService();
        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();
        Student savedStudent = studentService.addNewStudent(newStudent);

        // Act & Assert
        // Verify that finding an existing student returns the correct student
        assertEquals(savedStudent, studentService.findStudentById(savedStudent.id()));

        // Verify that finding a non-existing student throws a NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> studentService.findStudentById("nonexistentId"));
    }
}