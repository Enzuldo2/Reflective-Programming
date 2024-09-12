package FrameWork;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FrameWorkLCOO {

    public void LCOO(Class<?> clazz) {
        System.out.println("Inspecting class: " + clazz.getName());
        // Listar todos os métodos da classe
        Method[] methods = clazz.getDeclaredMethods();
        double LCO0 = 0;
        int empty_methods = 0;
        int not_empty_methods = 0;

        for (int i = 0; i < methods.length; i++) {
            Method method1 = methods[i];

            for (int j = i + 1; j < methods.length; j++) {
                Method method2 = methods[j];
                LCO0++;

                String[] method1_attributes = method1.getAnnotation(Atribute.class).value();
                String[] method2_attributes = method2.getAnnotation(Atribute.class).value();

                for (String attribute : method1_attributes) {
                    for (String attribute2 : method2_attributes) {
                        if (attribute.equals(attribute2)) {
                            not_empty_methods++;
                            break;
                        }
                    }
                }
                if (not_empty_methods == 0) {
                    empty_methods++;
                }
                not_empty_methods = 0;
            }


        }

        //Comparando com o Construtor
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors){
            String[] constructor_attributes = constructor.getAnnotation(Atribute.class).value();
            for (Method method : methods) {
                LCO0++;
                String[] method_attributes = method.getAnnotation(Atribute.class).value();
                for (String attribute : constructor_attributes) {
                    for (String attribute2 : method_attributes) {
                        if (attribute.equals(attribute2)) {
                            not_empty_methods++;
                            break;
                        }
                    }
                }
            }
            if (not_empty_methods == 0) {
                empty_methods++;
            }
            not_empty_methods = 0;
        }
        System.out.println("Empty methods: " + empty_methods);
        not_empty_methods = (int) (LCO0 - empty_methods);
        System.out.println("Not empty methods: " + not_empty_methods);
        LCO0 = empty_methods / LCO0;
        System.out.println("LCO0: " + LCO0);
    }

}