package command3.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TesteReflection {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("command3.reflection.Cliente");
		
		Constructor<?> constr = clazz.getConstructor();
		Object cliente1 = constr.newInstance();
		
		Method setNome = clazz.getMethod("setNome", String.class);
		setNome.invoke(cliente1, "UM NOME");
		
		Method getNome = clazz.getMethod("getNome");
		System.out.println(getNome.invoke(cliente1));
		
		Constructor<?> constr2 = clazz.getConstructor(String.class);
		Object cliente2 = constr2.newInstance("OUTRO NOME");
		
		System.out.println(getNome.invoke(cliente2));
		
		Field nome = clazz.getDeclaredField("nome");
		nome.setAccessible(true);
		System.out.println(nome.get(cliente1));
		nome.set(cliente1, "TESTE");
		System.out.println(nome.get(cliente1));
		
	}

}
