package command;

import app.TaskManager;

public class RemoveTaskCommand implements Command {
    private TaskManager manager;
    private int index;

    public RemoveTaskCommand(TaskManager manager, int index) {
        this.manager = manager;
        this.index = index;
    }

    @Override
    public void execute() {
        manager.removeTask(index);
    }
}