package FrameWork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class FrameworkClass {

    protected abstract String getMethodName();

    public void inspectClass() {
        try {
            // Obtém o nome do método que será chamado
            String methodName = getMethodName();

            // Obtém a classe do usuário
            Class<?> userClass = this.getClass();

            // Obtém o método da classe do usuário
            Method method = userClass.getDeclaredMethod(methodName);


            // Invoca o método
            method.invoke(this);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
