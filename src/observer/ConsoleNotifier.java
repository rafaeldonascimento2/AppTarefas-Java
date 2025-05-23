package observer;

import model.Task;

public class ConsoleNotifier implements Observer {
    @Override
    public void update(Task task) {
        System.out.println("Nova tarefa adicionada: " + task.getTitle());
    }
}