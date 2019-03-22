package com.fces.controller;

import com.fces.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

//    @PostMapping("/all")
//    @ResponseBody
//    public Result allClazz() {
//        return clazzService.getAllClazz();
//    }
}
