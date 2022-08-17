package Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@Value("${welcome.msg}")
String msg;
	
	@GetMapping("/")
	public String hellomsg() {
		System.out.println(msg);
		return msg;
	}
}
