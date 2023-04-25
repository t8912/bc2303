//public class HellowworldOperations {

  //String greeting();

  
//}
import org.springframework


public interface HelloworldOperations {
  @GetMapping(value = "/greeting")
  String sayHello();
}
