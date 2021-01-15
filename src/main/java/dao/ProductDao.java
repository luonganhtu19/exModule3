package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private String jdbcURL="jdbc:mysql://localhost:3306/game_magiccard?useSSL=false";
    private String jdbcUserName="root";
    private String jdbcPassword="Tuan@1993";

    private static final String SELECT_ALL_Product="select*from products inner join category on products.idCategory=category.idCategory";
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

    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }
//    create table products(
//            id int primary key auto_increment,
//            nameProduct varchar(100) not null,
//    priceProduct bigint not null,
//    quantityProduct int not null,
//    descriptionProduct varchar(255),
//    idCategory int not null,
//    FOREIGN KEY (idCategory) REFERENCES category(idCategory)
//            );
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
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }
}
