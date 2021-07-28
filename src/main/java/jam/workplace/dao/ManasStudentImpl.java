package jam.workplace.dao;

import jam.workplace.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("manas")
public class ManasStudentImpl implements StudentDao {
    private static final Map<Integer, Student> students;

    static
    {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Olivia", "Singer"));
                put(2, new Student(2, "Ariana", "Dencer"));
                put(3, new Student(3,"Sharapova", "Tennis Player"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentByID(int id) {
//        Student student = new Student();
        return students.get(id);
    }

    @Override
    public void removeStudentByID(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student st1 = students.get(student.getId());
        st1.setName(student.getName());
        st1.setCourse(student.getCourse());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
