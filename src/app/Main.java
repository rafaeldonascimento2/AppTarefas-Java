package app;

import model.Task;
import observer.ConsoleNotifier;
import utils.DatabaseConnection;
import command.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getInstance(); // Singleton

        TaskManager manager = new TaskManager();
        manager.addObserver(new ConsoleNotifier());

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Prioridade (1 = alta, 2 = média, 3 = baixa): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Prazo (formato: dd-MM-yyyy): ");
                    String dataStr = scanner.nextLine();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate localDate = LocalDate.parse(dataStr, formatter);
                        Date prazo = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Task nova = new Task(titulo, prioridade, prazo);
                        manager.addTask(nova);
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                    }
                    break;
                case 2:
                    Command listar = new ShowTasksCommand(manager);
                    listar.execute();
                    break;
                case 3:
                    System.out.println("Tarefas disponíveis:");
                    new ShowTasksCommand(manager).execute();
                    System.out.print("Digite o índice da tarefa a concluir: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    Command concluir = new MarkTaskDoneCommand(manager, idx);
                    concluir.execute();
                    break;
                case 4:
                    System.out.println("Tarefas disponíveis:");
                    new ShowTasksCommand(manager).execute();
                    System.out.print("Digite o índice da tarefa a remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    Command remover = new RemoveTaskCommand(manager, idRemover);
                    remover.execute();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}