package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherService {

    List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers(){
        return  teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(String id , Teacher teacher){
        for(int i = 0 ; i<teachers.size();i++){
            if(teachers.get(i).getID().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id ){
        for(int i = 0 ; i<teachers.size();i++){
            if(teachers.get(i).getID().equals(id)){
                teachers.remove(teachers.get(i));
                return true;
            }
        }
        return false;
    }

    public Teacher search(String id){
        for(Teacher t : teachers){
            if(t.getID().equals(id)) return t;
        }
        return null;
    }
}
