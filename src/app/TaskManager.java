package app;

import model.Task;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removida = tasks.remove(index);
            System.out.println("Tarefa removida: " + removida.getTitle());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setConcluida(true);
            System.out.println("Tarefa marcada como concluída: " + task.getTitle());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void showTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + " - " + tasks.get(i));
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task task) {
        for (Observer obs : observers) {
            obs.update(task);
        }
    }
}