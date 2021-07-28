package jam.workplace.dao;

import jam.workplace.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("dao")
public class StudentDaoImpl implements StudentDao {
    private static final Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Atabek", "PeakSoft(Junior Developer)"));
                put(2, new Student(2, "Nurperi", "PeakSoft(Java1)"));
                put(3, new Student(3, "Ruslan", "PeakSoft(Java2)"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }
    @Override
    public Student getStudentByID(int id) {
        return students.get(id);
    }
    @Override
    public void removeStudentByID(int id) {
        students.remove(id);
//        return "Student " + students.get(id).getName() + " is deleted from the list";
    }
    @Override
    public void updateStudent(Student student) {
        Student st1 = students.get(student.getId());
        st1.setCourse(student.getCourse());
        st1.setName(student.getName());
        students.put(student.getId(), student);
    }
    @Override
    public void insertStudent(Student student)   {
        students.put(student.getId(), student);
    }
}
