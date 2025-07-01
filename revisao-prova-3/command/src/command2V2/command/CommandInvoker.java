package command2V2.command;

import command2.command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

	private List<command2.command.Command> imediatos = new ArrayList<>();
	
	private List<command2.command.Command> todos = new ArrayList<>();
	
	private List<command2.command.Command> undo = new ArrayList<>();
	
	public void add(command2.command.Command comm) {
		imediatos.add(comm);
	}
	
	public void execute() {
		
		
		for (command2.command.Command comm:imediatos) {
			comm.execute();
			todos.add(comm);
		}
		
		imediatos.clear();
		
	}
	
	public void undo() {
	
		command2.command.Command comm = todos.remove(todos.size()-1);
		comm.undo();
		undo.add(comm);
		
	}
	
	
	public void redo() {
		
		command2.command.Command comm = undo.remove(undo.size()-1);
		comm.redo();
		todos.add(comm);
		
	}

	public void imprimir() {
		
		System.out.println("Log :");
		for (command2.command.Command comm:todos) {
			System.out.println(" " + comm);
		}
		
	}
	
	public void execute(Command comm) {
		comm.execute();
		todos.add(comm);
	}
}
