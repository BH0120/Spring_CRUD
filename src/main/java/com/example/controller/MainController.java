package com.example.controller;

import com.example.dto.DTOBoard;
import com.example.dto.DTOUser;


import com.example.service.ServiceBoard;
import com.example.service.ServiceUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    ServiceUser _serviceUser;

    @Autowired
    ServiceBoard _serviceBoard;

//    @GetMapping("hello")
//    public String Hello(Model m) {
//        m.addAttribute("value", "Hello World");
//        return "template";
//    }
//
//    //getTest의 형태로 내가 path에 넣은 id값을 다시 불러와서 html에 표출
//    @GetMapping("getTest/{id}")
//    @ResponseBody
//    public String GetTest(@PathVariable int id ) {
//        return String.valueOf(id);
//    }
//
//    //바디에 요청하고 return param으로 내가 post한 내용을 웹에 출력
//    @PostMapping("postTest")
//    @ResponseBody
//    public String PostTest(@RequestBody String param) {
//        return param;
//    }
//
//    //DTOUser에서 가져와서 받아옴
//    @PostMapping("/dtoTest")
//    @ResponseBody
//    public String DTOTest(DTOUser user) {
//
//        System.out.println(user.UserName);
//        System.out.println(user.UserAge);
//
//        userRepo.save(user.ToEntity());
//
////        userRepo.findUserData();
//
//        return user.toString();
//    }
    @GetMapping("/Home")
    public String LoginHome(HttpSession session, Model m) {
        if(session.getAttribute("LoginOK") == "Already") {
            m.addAttribute("tableList", _serviceUser.GetAllUser());
            return "MyPage";
        }else {
            return "Login";
        }
    }

    @GetMapping("/MakeDummy")
    public String makeDummy() {
        for(int i=1; i<10;i++){
            DTOUser user = new DTOUser();
            user.UserAge = String.valueOf(i);
            user.UserName = String.valueOf(i);
            _serviceUser.Join(user);
        }
        return "Login";
    }

    @GetMapping("/ChangePWD")
    public String ChangePWD(HttpSession session) {
        if(session.getAttribute("LoginOK") == "Already") {
            return "Update";
        }else {
            session.invalidate();
            return "Login";
        }
    }

    @GetMapping("/LogOUT")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Login";
    }


    //Query미사용 save방식사용 업데이트
    @GetMapping("PassChange/{id}/{pass}/{rePass}")
    public String userPassChange(
            @PathVariable String id,
            @PathVariable String pass,
            @PathVariable String rePass)
    {
        _serviceUser.RePass(id, pass, rePass);
        return "Login";
    }


    @PostMapping("/Register")
    public String userRegister(DTOUser user, HttpSession session) {

        _serviceUser.Join(user);
        return "Login";
    }


    @PostMapping("/Login")
    public String userLogin(DTOUser user, Model m, HttpSession session) {

        if(session.getAttribute("LoginOK") == "Already"){
            m.addAttribute("tableList", _serviceUser.GetAllUser());
            return "write";

        } else {

            boolean b = _serviceUser.Login(user);

            if (b) {
                session.setAttribute("LoginOK", "Already");
                m.addAttribute("tableList", _serviceUser.GetAllUser());
                return "MyPage";
            } else {
                return "Login";
            }
        }
    }

    @PostMapping("/Update")
    public String userUpdate(DTOUser user,@RequestParam("newPwd") String newPwd, Model m, HttpSession session) {

        System.out.println("-------------RUN UPDATE-------------");

        if(_serviceUser.UpdatePWD(user, newPwd)){
            System.out.println("!!!!!!!!!!!!!TURE!!!!!!!!!!!!!!!!!");
            m.addAttribute("tableList", _serviceUser.GetAllUser());
            session.invalidate();
            System.out.println("--------------END UPDATE---------------");
            return "Login";
        }else {
            System.out.println("--------------FAIL UPDATE---------------");
            return "Update";
        }

    }

    @GetMapping("/write")
    public String writeBoard(HttpSession session, Model m) {
        if(session.getAttribute("LoginOK") == "Already") {
            return "write";
        }else {
            session.invalidate();
            return "Login";
        }
    }

    @PostMapping("/writeBoard")
    public String userWriteBoard(DTOBoard board, Model m, HttpSession session) {
        _serviceBoard.Write(board);
        m.addAttribute("boardList", _serviceBoard.GetAllBoard());
        return "Board";
    }

    @GetMapping("/userQuit/{id}/{pass}")
    public String userQuit(@PathVariable String id, @PathVariable String pass, HttpSession session) {
        _serviceUser.Quit(id,pass);
        session.invalidate();
        return "Login";
    }



//
//
//
//    //DTOUser에서 가져와서 받아옴
//    @GetMapping("/dtoGet/{name}")
//    @ResponseBody
//    public String DTOGetTest(@PathVariable String name) {
//        //findUserData에 name을 전송
////        List<EntityUser> list = userRepo.findUserData(name);
//        List<EntityUser> list = userRepo.findUserDataNative(name);
//        if(list.isEmpty()) {
//            return "USER NOT FOUND";
//        }else {
//            return list.get(0).getUserName();
//        }
//
//    }
//
//
//    //DTOUser에서 가져와서 받아옴
//    @GetMapping("/dtoDeleteTest/{id}")
//    @ResponseBody
//    public String DTODeleteTest(@PathVariable int id) {
//
//        userRepo.deleteById(id);
//        return "";
//    }
//
//    @GetMapping("/example/{id}")
//    public ResponseEntity<String> getExampleById(@PathVariable Long id) {
//        if (id == 1) {
//            return ResponseEntity.ok("Example with ID 1 Found");
//        }else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Example not Found");
//        }
//    }


}