package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private String jdbcURL="jdbc:mysql://localhost:3306/ManagerProduct?useSSL=false";
    private String jdbcUserName="root";
    private String jdbcPassword="Tuan@1993";

    private static final String SELECT_ALL_Product ="select*from products";
    private static final String INSERT_PRODUCT     ="insert into products(nameProduct,priceProduct," +
                                                                     "quantityProduct,color,descriptionProduct," +
                                                                      "idCategory) value (?,?,?,?,?,?)";

    private static final String UPDATE_PRODUCT    ="update products set nameProduct=?" +
                                                   ",priceProduct=?,quantityProduct=?, color=?" +
                                                   ",descriptionProduct=?, idCategory=? where id=?  ";
    private static final String SELECT_Product_ID ="select*from products where id=?";
    private static final String DELETE_PRODUCT_ID ="delete from products where id=?";
    private static final String SEARCH_PRODUCT_NAME="select*from products where nameProduct like ?";




    public ProductDao(){};
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
    public void insertProduct(Product product) {
        try(Connection connection =getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_PRODUCT)){
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setLong(2,product.getPriceProduct());
            preparedStatement.setInt(3,product.getQuantityProduct());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescriptionProduct());
            preparedStatement.setInt(6,product.getIdCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product=null;
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_Product_ID);){
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                int id1 =rs.getInt("id");
                String nameProduct=rs.getString("nameProduct");
                long priceProduct=Long.parseLong(rs.getString("priceProduct"));
                int quantityProduct=rs.getInt("quantityProduct");
                String color=rs.getString("color");
                String descriptionProduct=rs.getString("descriptionProduct");
                int idCategory=rs.getInt("idCategory");
                product=new Product(id1,nameProduct,priceProduct,quantityProduct,color,descriptionProduct,idCategory);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products=new ArrayList<>();

            try(Connection connection=getConnection();
                PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_Product);){
                ResultSet rs=preparedStatement.executeQuery();
                while (rs.next()){
                    int id =rs.getInt("id");
                    String nameProduct=rs.getString("nameProduct");
                    long priceProduct=Long.parseLong(rs.getString("priceProduct"));
                    int quantityProduct=rs.getInt("quantityProduct");
                    String color=rs.getString("color");
                    String descriptionProduct=rs.getString("descriptionProduct");
                    int idCategory=rs.getInt("idCategory");
                    products.add(new Product(id,nameProduct,priceProduct,quantityProduct,color,descriptionProduct,idCategory));
                }
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rs=false;
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_PRODUCT_ID);){
            preparedStatement.setInt(1, id);
             rs= preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            printSQLException(e);
        }
        return rs;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean rs=false;
        try(Connection connection =getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_PRODUCT)){
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setLong(2,product.getPriceProduct());
            preparedStatement.setInt(3,product.getQuantityProduct());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescriptionProduct());
            preparedStatement.setInt(6,product.getIdCategory());
            preparedStatement.setInt(7,product.getId());
            System.out.println(preparedStatement);
            rs=preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            printSQLException(e);
        }
        return rs;
    }

    public List<Product> searchProduct(String name){
        List<Product> products=new ArrayList<>();
        try(Connection connection=getConnection();
           PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_PRODUCT_NAME);){
            preparedStatement.setString(1, "%" +name+"%");
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String nameProduct=rs.getString("nameProduct");
                long priceProduct=Long.parseLong(rs.getString("priceProduct"));
                int quantityProduct=rs.getInt("quantityProduct");
                String color=rs.getString("color");
                String descriptionProduct=rs.getString("descriptionProduct");
                int idCategory=rs.getInt("idCategory");
                products.add(new Product(id,nameProduct,priceProduct,quantityProduct,color,descriptionProduct,idCategory));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }
    private void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if (e instanceof  SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLSate: "+((SQLException)e).getSQLState());
                System.err.println("Error Code: "+((SQLException)e).getErrorCode());
                System.err.println("Message:"+e.getMessage());
                Throwable t=ex.getCause();
                while (t!=null){
                    System.out.println("Cause"+t);
                    t=t.getCause();
                }
            }
        }
    }
}
