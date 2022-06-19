package SpringMVC.servlet.web.frontController.v2.controller;

import SpringMVC.servlet.domain.member.Member;
import SpringMVC.servlet.domain.member.MemberRepository;
import SpringMVC.servlet.web.frontController.MyView;
import SpringMVC.servlet.web.frontController.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository=MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        int age=Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username, age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.(사실은 model아님)
        request.setAttribute("member", member);//request의 임시 저장소(map)가 있으므로 이를 사용

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
