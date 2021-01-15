package controller;

import dao.ProductDao;
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
    public void init(){
        productDao=new ProductDao();
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
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/productList.jsp");
        dispatcher.forward(request,response);
    }
}
