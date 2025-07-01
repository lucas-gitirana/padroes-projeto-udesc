package command2V2.command;

public interface Command {
	
	void execute();
	
	void undo();
	
	void redo();

}
