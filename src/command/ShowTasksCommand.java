package command;

import app.TaskManager;

public class ShowTasksCommand implements Command {
    private TaskManager manager;

    public ShowTasksCommand(TaskManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.showTasks();
    }
}