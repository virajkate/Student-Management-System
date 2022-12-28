package com.codewala.StudentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  //telling the java application--->this class contain API endpoints
public class StudentController {
    HashMap<Integer,Student> studentDb = new HashMap<>();


@PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){

        int key = student.id;
        //Add it to the studentDb
        studentDb.put(key,student);

        return "Successfully added";

    }

@GetMapping("get_student_by_id")
    public Student getStudentById(@RequestParam("id")Integer id){
         return studentDb.get(id);
    }
    @GetMapping("get_by_path/{id}")
    public Student getByPath(@RequestParam("id")Integer id){
      Student student=studentDb.get(id);
      return student;
    }
    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name")String searchName){
    //iterate over hashmap
        for(Student s: studentDb.values()){
            if(s.name.equals(searchName)){
                return s;
            }
        }
        return null;
    }
@PutMapping("/update_student")
    public Student updateStudent(@RequestBody() Student student) {
    //get the key
    int key = student.id;
    studentDb.put(key, student);
    return student;
}
@DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id")Integer id){
    studentDb.remove(id);
    return "the student has been successfully deleted";
}
}

