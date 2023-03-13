package com.example.ex01.controller;

import com.example.ex01.domain.PersonVO;
import com.example.ex01.domain.MemberVO;
import com.example.ex01.domain.ProductVO;
import com.example.ex01.domain.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public String ex01(){
        log.info("ex01..............");
        return "ex01";
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02..............");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request){
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(@ModelAttribute("name") String name/*, Model model*/){
//        model.addAttribute("name", name);
        log.info(name);
    }


    //    이름, 나이, 성별 받고 출력
    @GetMapping("ex05")
    public void ex05(MemberVO memberVO){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
    }

    /*@GetMapping("ex06")
    public void ex06(MemberVO memberVO, @RequestParam("address") String city){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
        log.info("사는 도시 : " + city);
    }*/

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, @ModelAttribute("address") String city){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
        log.info(city);
    }


 /*   @GetMapping("task01")
    public void task01(String name, int age) {
        log.info(name);
        log.info(String.valueOf(age));
    }*/

    /*    @GetMapping("task02")
    public void task02(String name, int age, String gender) {
        log.info(name);
        log.info(String.valueOf(age));
        log.info(gender);
    }*/


    @GetMapping("person01")
    public void person01(PersonVO personVO) {
        log.info(personVO.getName());
        log.info(String.valueOf(personVO.getAge()));
    }

    @GetMapping("person02")
    public void person02(PersonVO personVO) {
        log.info(personVO.getName());
        log.info(String.valueOf(personVO.getAge()));
        log.info(personVO.getGender());
    }

//        [실습 1]

//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.

    @GetMapping("task01")
    public void task01() {;}

  /*  @GetMapping("task01result")
    public void task01result(String name, int price, int stock, String brand) {
        log.info("상품명 : " + name);
        log.info("상품가격 : " + price + "원");
        log.info("상품재고 : " + stock + "개");
        log.info("브랜드 : " + brand);
    }*/

    @GetMapping("task01result")
    public void task01result(ProductVO productVO){
        log.info(productVO.getProductName());
    }



//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력

    @GetMapping("task02")
    public void task02(){;}

    @GetMapping("task02result")
    public void task02result(TaskVO taskVO, Model model){
        int total = 0;
        int avg = 0;
        total = taskVO.getEng() + taskVO.getKor() + taskVO.getMath();
        avg = total / 3;
        model.addAttribute("total",total);
        model.addAttribute("avg",avg);

    }



//    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력

    @GetMapping("login")
    public void login(){;};

    @GetMapping("task03")
    public String task03(String id, String pw){
       /* switch (id){
            case "admin" :
                return "/ex/admin";
            case "user" :
                return "/ex/user";
            default:
                return "/ex/login";
        }*/

        if(id.equals("admin")){
            return "/ex/admin";
        }else if(id.equals("user")) {
            return "/ex/user";
        }else {
            return "ex/login";
        }
    }


    /*@PostMapping("task03")
    public String task03(String id, String pw){
        switch (id){
            case "admin" :
                return "/ex/admin";
            case "user" :
                return "/ex/user";
            default:
                return "/ex/login";
        }
    }*/

//    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html



}
