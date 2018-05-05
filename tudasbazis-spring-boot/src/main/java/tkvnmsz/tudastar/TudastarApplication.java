package tkvnmsz.tudastar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TudastarApplication {
	//ssh -L 4000:Orania:1521 h675753@linux.inf.u-szeged.hu
	
	public static void main(String[] args) {
		SpringApplication.run(TudastarApplication.class, args);
	}
}
