package Entity;
import org.springframework.data.annotation.Id;

public class Resource {
	
	@Id
	private int Id;
	
	private String resourceName;
	
	private  int resourceCode;

}
