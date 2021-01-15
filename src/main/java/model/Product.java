package model;

public class Product {
///id int primary key auto_increment,
//    nameProduct varchar(100) not null,
//    priceProduct bigint not null,
//    quantityProduct int not null,
//    descriptionProduct text,
//    idCategory int not null,
//    FOREIGN KEY (idCategory) REFERENCES category(idCategory)/
    private int id;
    private String nameProduct;
    private long priceProduct;
    private int quantityProduct;
    private String color;
    private int idCategory;
    private String descriptionProduct;



    public Product(int id, String nameProduct, long priceProduct, int quantityProduct, String color, int idCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.color = color;
        this.idCategory = idCategory;
    }

    public Product(){};

    public Product(int id, String nameProduct, long priceProduct, int quantityProduct, String color, String descriptionProduct, int idCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.color = color;
        this.descriptionProduct = descriptionProduct;
        this.idCategory = idCategory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
