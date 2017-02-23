package view;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller"})
//@ComponentScan({"model"})
public class SampleController {
   /* @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }*/
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
