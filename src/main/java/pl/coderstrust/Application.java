package pl.coderstrust;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
      ApplicationContext ctx =  SpringApplication.run(Application.class, args);

    System.out.println("BEANS: ");
    String [] beans = ctx.getBeanDefinitionNames();

    Arrays.sort(beans);
    for (String beanName : beans) {
      System.out.println(beanName);
    }
  }
}