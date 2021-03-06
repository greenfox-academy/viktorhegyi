package com.greenfox.controller;

import com.greenfox.model.AppandA;
import com.greenfox.model.Array;
import com.greenfox.model.DoUntil;
import com.greenfox.model.Greeter;
import com.greenfox.model.Log;
import com.greenfox.model.OutPutNumber;
import com.greenfox.model.ReturnArray;
import com.greenfox.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Viktor on 2017-05-10.
 */
@RestController
public class MainRestController {

  @Autowired
  Repository repository;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public String handleMissingInput(MissingServletRequestParameterException e) {
    return "error: " + "Please provide an " + e.getParameterName() + "!";
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    return "error:" + "Please provide a number!";
  }

  @GetMapping(value = "/doubling")
  public OutPutNumber doubling(@RequestParam(value="input") int input) {
    OutPutNumber outPutNumber = new OutPutNumber(input, input*2);
    repository.save(new Log("doubling", "input=" + input));
    return outPutNumber;
  }

  @GetMapping(value = "/greeter")
  public Greeter greeter (@RequestParam(value="name") String name,
                            @RequestParam(value="title") String title) {
    Greeter greeter = new Greeter(name, title);
    repository.save(new Log("greeter", "name=" + name + " title=" + title));

    return greeter;
  }

  @GetMapping(value = "/appenda/{appendable}")
  public AppandA appendA (@PathVariable(value = "appendable") String appendable) {
    AppandA appandA = new AppandA(appendable);
    repository.save(new Log("appenda", "appendable=" + appendable));

    return appandA;
  }

  @PostMapping(value = "/dountil/{what}")
  public DoUntil doUntil (@RequestBody DoUntil doUntil, @PathVariable(value = "what") String what) {
    if( what.equals("sum")) {
      doUntil.sum();
      repository.save(new Log("dountil/sum", "until="));
    } else if ( what.equals("factor")) {
      repository.save(new Log("dountil/factor", "until="));
      doUntil.factor();
    }

    return doUntil;
  }

  @PostMapping(value = "/arrays")
  public ReturnArray array (@RequestBody Array array) {
    if(array.whatGetter().equals("double")) {
      repository.save(new Log("arrays", "until="));
      return array.doubble();
    } else {
      array.multiply();
      repository.save(new Log("arrays", "until="));
      array.sum();
      repository.save(new Log("arrays", "until="));
    }
    return array;
  }

}
