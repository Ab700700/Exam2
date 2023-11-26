package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    List<Student> students= new ArrayList<>();

    public List<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(String id , Student student){
       for(int i = 0 ; i<students.size();i++){
           if(students.get(i).getID().equals(id)){
               students.set(i,student);
               return true;
           }
       }
       return false;
    }

    public boolean deleteStudent(String id ){
        for(int i = 0; i<students.size();i++){
            if(students.get(i).getID().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String name){
        for(Student s: students){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
}
