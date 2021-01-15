package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategory{
    private String jdbcURL="jdbc:mysql://localhost:3306/ManagerProduct?useSSL=false";
    private String jdbcUserName="root";
    private String jdbcPassword="Tuan@1993";

    private static final String SELECT_ALL_CATEGORY="select*from category";
    public CategoryDao(){};
    protected Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertCategory(Category category) {

    }

    @Override
    public Category selectCategory(int id) {
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categorys=new ArrayList<>();

        try(Connection connection=getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CATEGORY);){
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int  idCategory=rs.getInt("idCategory");
                String nameCategory=rs.getString("nameCategory");
                categorys.add(new Category(idCategory,nameCategory));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categorys;
    }


    @Override
    public boolean deleteCategory(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        return false;
    }
}
