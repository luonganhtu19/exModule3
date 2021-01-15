package controller;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    public void init(){
        productDao=new ProductDao();
        categoryDao=new CategoryDao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateProduct(req,resp);
                break;
            case "delete":
                showDelete(req,resp);
                break;
            case "edit":
                showEditProduct(req,resp);
                break;
            default:
                listProduct(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                resultCreateProduct(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            default:
                break;
        }
    }

    private void listProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList=productDao.selectAllProduct();
        request.setAttribute("listProduct",productList);
        List<Category> categoryList=categoryDao.selectAllCategory();
        request.setAttribute("listCategory",categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/productList.jsp");
        dispatcher.forward(request,response);
    }
    private void showCreateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=categoryDao.selectAllCategory();
        request.setAttribute("listCategory",categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/createProduct.jsp");
        dispatcher.forward(request,response);
    }
    private void resultCreateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Long Price = Long.parseLong(request.getParameter("Price"));
        int Quantity =Integer.parseInt( request.getParameter("Quantity"));
        String Color=request.getParameter("Color");
        String Description=request.getParameter("Description");
        int categoryID=Integer.parseInt(request.getParameter("categoryID"));
        Product newProduct= new Product(name,Price,Quantity,Color,categoryID,Description);
        productDao.insertProduct(newProduct);
        request.setAttribute("message","Success create new account");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        dispatcher.forward(request, response);
    }
    private void showDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=categoryDao.selectAllCategory();
        request.setAttribute("listCategory",categoryList);
        Product product= productDao.selectProduct(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/deleteProduct.jsp");
        dispatcher.forward(request,response);
    };
    private void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
        if (productDao.deleteProduct(id)){
            session.setAttribute("message","success delete product "+productDao.selectProduct(id).getNameProduct());
           List<Product> listProduct = productDao.selectAllProduct();
           request.setAttribute("listProduct", listProduct);
           List<Category> categoryList=categoryDao.selectAllCategory();
           request.setAttribute("listCategory",categoryList);
           RequestDispatcher dispatcher = request.getRequestDispatcher("product/productList.jsp");
           dispatcher.forward(request, response);
        }
    }
    private void showEditProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=categoryDao.selectAllCategory();
        request.setAttribute("listCategory",categoryList);
        Product product= productDao.selectProduct(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/editProduct.jsp");
        dispatcher.forward(request,response);
    }
    private void editProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Long Price = Long.parseLong(request.getParameter("Price"));
        int Quantity =Integer.parseInt( request.getParameter("Quantity"));
        String Color=request.getParameter("Color");
        String Description=request.getParameter("Description");
        int categoryID=Integer.parseInt(request.getParameter("categoryID"));
        Product newProduct= new Product(name,Price,Quantity,Color,categoryID,Description);
            productDao.updateProduct(newProduct);
            request.setAttribute("message","Success  update product");
            request.setAttribute("product",newProduct);
            List<Category> categoryList=categoryDao.selectAllCategory();
            request.setAttribute("listCategory",categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/editProduct.jsp");
            dispatcher.forward(request, response);
    }
}
