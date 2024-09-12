package Exemplo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInspector {

    public static void main(String[] args) {
        // Criar uma instância da classe Person
        Person person = new Person("John", 30);

        // Obter a classe do objeto
        Class<?> personClass = person.getClass();

        // Imprimir o nome da classe
        System.out.println("Class Name: " + personClass.getName());

        // Listar todos os métodos da classe
        Method[] methods = personClass.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(" - " + method.getName());
        }

        // Listar todos os atributos da classe
        Field[] fields = personClass.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println(" - " + field.getName());
        }
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(" - " + constructor.getName());
        }


    }
}
