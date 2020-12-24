package com.plaso.dao;

import com.plaso.bean.Student;

public interface StudentDao {

    public Student findByName(String name);

    public Student findById(int id);

}
