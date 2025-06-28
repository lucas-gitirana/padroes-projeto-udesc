package command1.view;

import command1.command.*;
import command1.controle.Calculadora;

public class Sistema {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		CommandInvoker inv = new CommandInvoker();
		
		inv.add(new AddCommand(calc, 10));
		inv.execute();

		/*Multiplicando*/
		inv.add(new MultiplyCommand(calc, 23));
		inv.execute();
		
		System.out.println("Final " + calc.getMemoria());

		inv.undo();
		System.out.println("Undo " + calc.getMemoria());

		inv.redo();
		System.out.println("Redo " + calc.getMemoria());
		
		inv.add(new AddCommand(calc, 150));
		inv.add(new SubtrairCommand(calc, 70));
		inv.execute();
		
		System.out.println("Final " + calc.getMemoria());

		inv.undo();
		System.out.println("Undo " + calc.getMemoria());
		inv.undo();
		System.out.println("Undo " + calc.getMemoria());
		
		inv.redo();
		inv.redo();
		inv.imprimir();
		
		Calculadora calc2 = new Calculadora();
		MacroCommand macro = new MacroCommand();
		macro.add(new AddCommand(calc2, 50));
		macro.add(new SubtrairCommand(calc2, 20));
		macro.add(new AddCommand(calc2, 70));
		
		inv.execute(macro);
		System.out.println("Final " + calc2.getMemoria());
		
		inv.undo();
		System.out.println("Undo " + calc2.getMemoria());
		
		inv.redo();
		System.out.println("Redo " + calc2.getMemoria());
	}

}
