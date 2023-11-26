package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sms/teacher")
@RequiredArgsConstructor
public class TeacherController {

    final private TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable String id , Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        if(teacherService.updateTeacher(id,teacher)){
            return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        if(teacherService.deleteTeacher(id)){
            return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity search(@PathVariable String id){
        Teacher t = teacherService.search(id);
        if(t==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

}
