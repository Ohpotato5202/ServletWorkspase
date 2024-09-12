package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do") // 디폴트매핑
public class DispatcherServlet extends HttpServlet {
   
   /*
    *    DispatcherServlet
    *  - 스프링 프레임워크에서 관리하는 단 하나뿐인 서블릿
    *  - 클라이언트의 "모든"요청을 가장 먼저 받은 후, 적절한 핸들러(Controller)를 찾아서 요청을 Dispatch(위임)
    *    하고 최종적으로 응답 내용을 반환해주는 역할을 한다. 
    *  - 클라이언트의 어떤 url이든 다 받기위해 urlPattern을 / 로 정의함
    *  
    *  DispatcherServlet의 핵심 구성요소 
    *  
    *  1. HandlerMapping
    *   - urlPattern과 그게 매칭되는 핸들러(Controller)의 정보를 담고있는 객체 
    *     ex) /student/insertStudent -> InsertStudentController
    *           /student/insertStudentMap -> InsertStudentMapController
    *   - Servlet객체가 초기화 될 때 등록 가능한 핸들러 정보들을 읽어들인 후 urlPattern과 핸들러를 key:value형태로 보관.
    *   
    *  2. ViewResolver
    *   - 핸들러의 반환값(viewName)을 기반으로 클라이언트에게 응답할 view페이지를 선택하는 객체
    *     ex)컨트롤럴에서 "notice/list"를 반환하면 "/WEB-INF/views/"+viewName+".jsp
    * */
   private static final long serialVersionUID = 1L;
   private Map<String, AbstractController> handlerMapping = new HashMap<>();

    @Override
    public void init() throws ServletException {
       
       Properties prop = new Properties();
       
       String fileName = DispatcherServlet.class
                                      .getResource("/resources/handlerMapping-info.properties")
                                      .getPath();
       try {
         prop.load(new FileReader(fileName));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
       
       //key(url-pattern) :value(Controller)
       Set<String> keys = prop.stringPropertyNames();
       
       for(String key : keys) {
          String value = prop.getProperty(key); //url패턴을 처리할 수 있는 클래스명
          //Controller 객체화
          
          //Class 객체 : 해당 클래스의 구성정보(생성자, 메서드, 필드 등등..)를 모두 가진 객체 
          Class clazz;
         try {
            clazz = Class.forName(value);
            
          Constructor con = clazz.getDeclaredConstructor();//기본 생성자 
          con.setAccessible(true);
          AbstractController controller = (AbstractController) con.newInstance();//객체 생성 
          handlerMapping.put(key, controller);
          
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (NoSuchMethodException e) {
            e.printStackTrace();
         } catch (SecurityException e) {
            e.printStackTrace();
         } catch (InstantiationException e) {
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            e.printStackTrace();
         } catch (IllegalArgumentException e) {
            e.printStackTrace();
         } catch (InvocationTargetException e) {
            e.printStackTrace();
         }

       }
       System.out.println("init::"+ handlerMapping);
       
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		try {
			// 클라이언트의 요청주소 가져오기
			String uri = request.getRequestURI(); // "/mybatis/student/insertStudent"
			int beginIndex = request.getContextPath().length();
			String url = uri.substring(beginIndex); // "/student/insertStudent"

			// url과 매핑되는 controller객체 호출
			AbstractController controller = handlerMapping.get(url);
			if (controller == null) {
				System.out.println(url + "에 해당하는 controller가 없습니다.");
			}

			String method = request.getMethod(); // GET/POST
			String viewName = null;

			switch (method) {
			case "GET":
				viewName = controller.doGet(request, response);
				break;
			case "POST":
				viewName = controller.doPost(request, response);
				break;
			}

			// viewResolver가 처리하는 내용(jsp forwading 쪽은 redirect처리)
			if (viewName != null) {
				if (viewName.startsWith("redirect:")) {
					// redirect
					String location = request.getContextPath() + viewName.replace("redirect:", "");
					response.sendRedirect(location);
				} else {
					final String prefix = "/WEB-INF/views/";
					final String suffix = ".jsp";
					request.getRequestDispatcher(prefix + viewName + suffix).forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
