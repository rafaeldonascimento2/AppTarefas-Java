# Aplicativo de Tarefas (ToDo List)

Gabriel Carvalheiro Ruela - 837871
Marcele Eduarda Mrofka Rufino - 838703
Maria Carolina de Souza B. - 838467
Guilherme belotti machado luiz- 838820
Rafael do Nascimento- 838776
Isa Marostegan Bertocco- 838824

## 📌 Tema escolhido

Desenvolvimento de um aplicativo de tarefas simples (ToDo List), que permite ao usuário:
- Adicionar tarefas com título, prioridade e prazo
- Listar tarefas
- Marcar tarefas como concluídas
- Remover tarefas

Este projeto tem como objetivo simular um sistema real de controle de tarefas, aplicando **três padrões de projeto** de forma contextualizada.

-Singleton
-Observer
-Command

## 🏗️ Arquitetura Geral

O projeto é estruturado da seguinte forma:
(Layered Architecture)
```
src/
├── app/           → Lógica principal da aplicação (Main, TaskManager)
├── model/         → Modelo de dados (Task)
├── observer/      → Padrão Observer (Observer, ConsoleNotifier)
├── command/       → Padrão Command (Command, ShowTasksCommand, etc.)
├── utils/         → Padrão Singleton (DatabaseConnection)
```
---

## 🧩 Padrões de Projeto Aplicados

### ✅ Singleton
- **Classe:** `DatabaseConnection`
- **Finalidade:** simula o gerenciamento de uma instância única de conexão com banco de dados.
- **Onde:** chamado no início do `Main.java` para reforçar a centralização do recurso.

### ✅ Observer
- **Classe:** `Observer` (interface), `ConsoleNotifier` (implementação)
- **Finalidade:** notificar automaticamente quando uma nova tarefa é adicionada.
- **Onde:** `TaskManager` chama `notifyObservers()` ao adicionar tarefas.

### ✅ Command
- **Interfaces e classes:** `Command`, `ShowTasksCommand`, `MarkTaskDoneCommand`, `RemoveTaskCommand`
- **Finalidade:** encapsular as ações do menu principal em objetos reutilizáveis.
- **Onde:** no `Main.java`, as opções do menu chamam `.execute()` nos comandos ao invés de lógica direta.

---

## 📐 Diagrama de Classes (UML simplificado)

![image](https://github.com/user-attachments/assets/ffbcf2f8-1714-41d7-8ed8-16de46b2fc81)


## ✅ Considerações Finais


O desenvolvimento deste projeto teve como principal objetivo a aplicação prática de padrões de projeto em um sistema funcional,  
de forma coerente, compreensível e contextualizada.  

A escolha por um aplicativo de tarefas (ToDo List) foi motivada por sua simplicidade estrutural,  
mas com potencial de demonstrar conceitos profundos de orientação a objetos,  
como modularização, encapsulamento de responsabilidades e baixo acoplamento.  

A implementação dos padrões foi cuidadosamente planejada para que cada um deles não apenas existisse no código,  
mas cumprisse um papel real dentro da lógica do sistema.  

Além dos padrões em si, a organização do projeto seguiu o modelo de Arquitetura em Camadas (Layered Architecture),  
separando a lógica de domínio, regras de negócio e interação com o usuário em pacotes distintos.  

Isso confere ao sistema uma estrutura clara, escalável e de fácil entendimento,  
mesmo para outros desenvolvedores que venham a analisá-lo posteriormente.

---
