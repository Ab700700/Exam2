package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sms/student")
@RequiredArgsConstructor
public class StudentsController {

    final private StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid Student student,Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        if(studentService.updateStudent(id,student)){
            return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        if(studentService.deleteStudent(id)){
            return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity search(@PathVariable String name){
        Student s = studentService.searchStudent(name);
        if(s==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }




}
