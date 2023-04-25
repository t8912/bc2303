import org.springframework.web.bind.annotation.ResponseBody;

import com.codewave.demo.controller.HelloworldOperations;

@Controller
@ResponseBody
@RequestMapping(value = "/demo/procatice/api/v1")
public class HelloworldController implements HellowworldOperations {

  @Override
  public String sayHello() {
    return "Hello World";
  }


  
}
