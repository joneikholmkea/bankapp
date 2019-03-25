package com.example.bankapp.controller;

import com.example.bankapp.model.AjaxResponseBody;
import com.example.bankapp.model.GoldenCow;
import com.example.bankapp.model.SearchCriteria;
import com.example.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody SearchCriteria s, Errors errors){
        System.out.println("getSearch kaldt");
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            ajaxResponseBody.setMsg(errors.getAllErrors().get(0).getDefaultMessage());

            return ResponseEntity.badRequest().body(ajaxResponseBody);

        }
        List<GoldenCow> searchResult = userService.findCows(s.getUsername());
        if(searchResult.size() == 0){
            ajaxResponseBody.setMsg("user not found");
        }else {
            ajaxResponseBody.setMsg("user(s) found");
            ajaxResponseBody.setResult(searchResult);
        }

        return ResponseEntity.ok(ajaxResponseBody);
    }

    public static void myMethod(){

    }
}


//        GoldenCow cow = userService.findCow(s.getUsername());
//        if(cow==null){
//            ajaxResponseBody.setMsg("user not found");
//
//        }else{
//            ajaxResponseBody.setMsg("user found");
//            ajaxResponseBody.setCow(cow);
//        }
//        if(s.getUsername().length()==0){
//            ajaxResponseBody.setMsg("Enter at least one char");
//            return ResponseEntity.badRequest().body(ajaxResponseBody);
//        }
