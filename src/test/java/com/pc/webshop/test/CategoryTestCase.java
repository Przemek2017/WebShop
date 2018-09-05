package com.pc.webshop.test;

import com.pc.webstore.dao.CategoryDAO;
import com.pc.webstore.dto.Category;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Przemek
 */
public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;
    private static CategoryDAO categoryDAO;
    private Category category;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.pc.webstore");
        context.refresh();
        categoryDAO = (CategoryDAO) context.getBean("categoryDao");
    }

//    @Test
//    public void addCategoryTest(){
//        category = new Category();
//        category.setName("Laptop");
//        category.setDescription("Lorem ipsum");
//        category.setImageURL("laptop.jpg");
//        assertEquals("Successfully added a category to table", true, categoryDAO.add(category));
//    }
    
//    @Test
//    public void getCategoryById(){
//        category = categoryDAO.get(4);
//        assertEquals("Successfully fetched a single category from table", "Laptop", category.getName());
//    }
    
//    @Test
//    public void updateCategory() {
//        category = categoryDAO.get(4);
//        category.setName("Watches");
//        assertEquals("Successfully updated a single category in the table", true, categoryDAO.update(category));
//    }
    
//    @Test
//    public void deleteCategory() {
//        category = categoryDAO.get(4);
//        assertEquals("Successfully deleted a single category from the table", true, categoryDAO.delete(category));
//    }
    
//    @Test
//    public void getActiveCategories() {
//        assertEquals("Successfully selected all active categories from table", 3, categoryDAO.categories().size());
//    }
    
//    @Test
//    public void CRUDTest() {
//
//        // Add category Laptop
//        category = new Category();
//        category.setName("Laptop");
//        category.setDescription("Lorem ipsum");
//        category.setImageURL("laptop.jpg");
//        assertEquals("Successfully added a category to table", true, categoryDAO.add(category));
//        // Add category Mobile
//        category = new Category();
//        category.setName("Mobile");
//        category.setDescription("Lorem ipsum");
//        category.setImageURL("mobile.jpg");
//        assertEquals("Successfully added a category to table", true, categoryDAO.add(category));
//        
//        // Update category.id = 2
//        category = categoryDAO.get(2);
//        category.setName("Watches");
//        category.setImageURL("watches.jpg");
//        assertEquals("Successfully updated a single category in the table", true, categoryDAO.update(category));
//        
//        // Delete category.id = 2
//        category = categoryDAO.get(2);
//        assertEquals("Successfully deleted a single category from the table", true, categoryDAO.delete(category));
//        
//        // Get active category
//        assertEquals("Successfully selected all active categories from table", 1, categoryDAO.categories().size());
//    }
}
