import java.util.*;

public class StudentRepo {

    private final Map<String, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student save(Student student) {
        students.put(student.id(), student);
        return student;
    }

    public Student findById(String id) {
        Student student = students.get(id);
        if (student == null) {
            throw new NoSuchElementException("No student found with ID: " + id);
        }
        return student;
    }
    public Optional<Student> findStudentById(String id) {
        return Optional.ofNullable(students.get(id));
    }
}
