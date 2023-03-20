package ma.ecom;

import ma.ecom.controllers.IProductControler;
import ma.ecom.controllers.ProductControler;
import ma.ecom.entities.Product;
import ma.ecom.repositories.ProductRepository;
import ma.ecom.repositories.impl.ProductRepositoryImpl;
import ma.ecom.services.ProductService;
import ma.ecom.services.imlp.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class ProjectJee_App {

    static IProductControler productControler;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //test1();
        //test2();
        test3();
    }

    private static Boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
           return false;
        }
    }
    public static void test1(){

        var repository = new ProductRepositoryImpl();
        var service = new ProductServiceImpl();
        var controller = new ProductControler();

        service.setProductRepository(repository);
        controller.setProductService(service);

        String rep = "";
        do {
            try {
                String in = "";
                while (true){
                    System.out.println("Find product by ID");
                    System.out.println("Enter product ID : ");
                    in = input.nextLine();
                    if (isNumber(in))
                        break;
                    System.out.println("Invalid input");
                }

                long id = Long.parseLong(in);

                Product product = controller.findProductById(id);
                System.out.println(product.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to quit (Yes / No)");
            rep = input.nextLine();

        } while (!rep.equalsIgnoreCase("Yes"));

        System.out.println("Good bye");
    }

    public static void test2() throws Exception {

        String repositoryClass;
        String serviceClass;
        String controllerClass;

        Properties properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("config.properties");

        if(propertiesFile == null) throw new Exception("Config file not exist");
        else
        {
            try
            {
                properties.load(propertiesFile);

                repositoryClass = properties.getProperty("REPOSITORY");
                System.out.println(repositoryClass);

                serviceClass = properties.getProperty("SERVICE");
                System.out.println(serviceClass);

                controllerClass = properties.getProperty("CONTROLLER");
                System.out.println(controllerClass);

                propertiesFile.close();
            }
            catch (IOException e)
            {
                throw new Exception("problem loading configuration file properties");
            }
            finally {
                properties.clear();
            }
        }
        try
        {
            Class cREPOSITORY = Class.forName(repositoryClass);
            Class cSERVICE = Class.forName(serviceClass);
            Class cCONTROLLER = Class.forName(controllerClass);

            var repo = (ProductRepository)cREPOSITORY.getDeclaredConstructor().newInstance();
            var service = (ProductService)cSERVICE.getDeclaredConstructor().newInstance();
            productControler = (IProductControler) cCONTROLLER.getDeclaredConstructor().newInstance();

            Method setRepo = cSERVICE.getMethod("setProductRepository", ProductRepository.class);
            setRepo.invoke(service, repo);

            Method setService = cCONTROLLER.getMethod("setProductService", ProductService.class);
            setService.invoke(productControler, service);

            Product product = productControler.findProductById(1L);
            System.out.println(product.toString());

        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public static void test3() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        productControler = (IProductControler) context.getBean("controller");

        Product product = productControler.findProductById(1L);
        System.out.println(product.toString());
    }
}
