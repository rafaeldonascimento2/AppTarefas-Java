package command;

import app.TaskManager;

public class MarkTaskDoneCommand implements Command {
    private TaskManager manager;
    private int index;

    public MarkTaskDoneCommand(TaskManager manager, int index) {
        this.manager = manager;
        this.index = index;
    }

    @Override
    public void execute() {
        manager.markTaskAsDone(index);
    }
}