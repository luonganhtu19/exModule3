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
import java.io.IOException;
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
                break;
            default:
                listProduct(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void listProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList=productDao.selectAllProduct();
        request.setAttribute("listProduct",productList);
        List<Category> categoryList=categoryDao.selectAllCategory();
        request.setAttribute("listCategory",categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/productList.jsp");
        dispatcher.forward(request,response);
    }
}
