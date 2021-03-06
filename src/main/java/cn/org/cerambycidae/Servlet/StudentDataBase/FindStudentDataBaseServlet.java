package cn.org.cerambycidae.Servlet.StudentDataBase;

import cn.org.cerambycidae.pojo.StudentInfo;
import cn.org.cerambycidae.service.Impl.StudentInfoServiceImpl;
import cn.org.cerambycidae.service.StudentInfoService;
import cn.org.cerambycidae.util.DataBaseUtil.FindStudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/DataBaseStudent/FindStudentDataBase"})
public class FindStudentDataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        //得到查询响应数据
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String major = request.getParameter("major");
        //数据处理，数据库连接方面，用来响应消息
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        List<StudentInfo> students = studentInfoService.selectByExample(FindStudentInfo.Conversion(name,age,major));
        request.getSession().setAttribute("students",students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
