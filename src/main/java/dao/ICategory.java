package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategory{
    public void insertCategory(Category category);
    public Category selectCategory(int id);
    public List<Category> selectAllCategory();
    public boolean deleteCategory(int id) throws SQLException;
    public boolean updateCategory(Category category) throws SQLException;
}
