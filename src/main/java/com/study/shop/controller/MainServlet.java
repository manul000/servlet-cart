package com.study.shop.controller;

import com.study.shop.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    private Map<Integer, Product> catalog() {
        return (Map<Integer, Product>) getServletContext().getAttribute("catalog");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        HttpSession session = req.getSession();
        synchronized (session) {
            if (session.getAttribute("cart") == null)
                session.setAttribute("cart", new LinkedHashMap<Integer, Integer>());
        }
        req.setAttribute("products", catalog().values());
        req.getRequestDispatcher("/WEB-INF/shop.jsp").forward(req, res);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = catalog().get(id);
            if (product == null) {
                res.sendError(404);
                return;
            }
            HttpSession session = req.getSession();
            synchronized (session) {
                if (session.getAttribute("cart") == null)
                    session.setAttribute("cart", new LinkedHashMap<Integer, Integer>());
                if (!product.reserve()) {
                    res.sendError(409, "Товар закончился");
                    return;
                }
                ((Map<Integer, Integer>) session.getAttribute("cart")).merge(id, 1, Integer::sum);
            }
            res.sendRedirect(req.getContextPath() + "/shop");
        } catch (NumberFormatException e) {
            res.sendError(400, "Некорректный id");
        }
    }
}
