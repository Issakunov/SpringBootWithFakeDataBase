package jam.workplace.controller;

import jam.workplace.entity.Student;
import jam.workplace.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentByID(@PathVariable("id") int id) {
        return studentsService.getStudentByID(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeStudentByID(@PathVariable("id") int id) {
         studentsService.removeStudentByID(id);
         /* I couldn't return a message that the student was deleted from the list,
         but, in my point of view it could return the message and delete the student as well */
    }
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student) {
        studentsService.updateStudent(student);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {
        studentsService.insertStudent(student);
    }
}
