package com.greenfox.controller;

import com.greenfox.model.Greeter;
import com.greenfox.model.OutPutNumber;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Viktor on 2017-05-10.
 */
@RestController
public class MainRestController {

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public String handleMissingInput() {
    return "error: " + "Please provide an input!";
  }

  @GetMapping(value = "/doubling")
  public OutPutNumber doubling(@RequestParam(value="input") int input) {
    OutPutNumber outPutNumber = new OutPutNumber(input, input*2);
    return outPutNumber;
  }

  @GetMapping(value = "/greeter")
  public Greeter greeter (@RequestParam(value="name") String name,
                            @RequestParam(value="title") String title) {
    return new Greeter(name, title);
  }
}