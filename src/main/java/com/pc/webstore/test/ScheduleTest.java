/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pc.webstore.test;

import com.pc.webstore.daoimpl.CategoryDaoImpl;
import com.pc.webstore.dto.Category;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pc
 */
@Stateless
public class ScheduleTest {
    
    @Autowired
    CategoryDaoImpl categoryDaoImpl;
    
    private List<Category> categorys;
    
    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
    public void test(){
//        categorys = new ArrayList<>();
//        categorys = categoryDaoImpl.categories();
//        System.out.println(categorys);
//        categorys.clear();
        System.out.println(new Date());
    }
    
}
