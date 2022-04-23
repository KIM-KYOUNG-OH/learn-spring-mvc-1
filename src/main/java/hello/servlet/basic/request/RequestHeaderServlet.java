package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printRequest(request, response);
        printHeaderUtil(request, response);
    }

    private void printHeaderUtil(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("[header 편의 조회]");
        System.out.println("serverName: " + request.getServerName());
        System.out.println("serverPort: " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("local = " + locale));
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("ContentType : " + request.getContentType());
        System.out.println("ContentLength : " + request.getContentLength());
        System.out.println("CharacterEncoding : " + request.getCharacterEncoding());

    }

    private void printRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(" Headers start");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + request.getHeader(headerName)));
        System.out.println(" Headers end");
    }
}
