package jam.workplace.service;

import jam.workplace.dao.StudentDao;
import jam.workplace.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentsService {
    @Autowired
    @Qualifier("manas")
    private StudentDao studentDao;


    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
    public Student getStudentByID(int id) {
        return studentDao.getStudentByID(id);
    }
    public void removeStudentByID(int id) {
         studentDao.removeStudentByID(id);
    }
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }
}
