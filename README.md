# Task Tracker CLI

Um gerenciador de tarefas simples em Java via linha de comando.  
Permite adicionar, listar, atualizar, deletar e alterar o status de tarefas com persistência em arquivo.

## 🛠️ Tecnologias usadas

- Java 11+
- Orientação a Objetos
- Persistência em arquivo (`tasks.txt`)
- CLI (linha de comando)

## 📦 Compilação

```bash
javac -d bin src/*.java
▶️ Execução
bash
Copy
Edit
java -cp bin Main <comando> [argumentos]

📚 Comandos disponíveis
Comando	Uso exemplo	Descrição
add	java -cp bin Main add "Estudar Java"	Adiciona uma nova tarefa
list	java -cp bin Main list	Lista todas as tarefas
list <status>	java -cp bin Main list done	Lista tarefas filtradas por status
update	java -cp bin Main update 3 "Novo nome da tarefa"	Atualiza o nome de uma tarefa
delete	java -cp bin Main delete 2	Deleta uma tarefa pelo ID
mark-in-progress	java -cp bin Main mark-in-progress 1	Marca a tarefa como "in progress"
mark-done	java -cp bin Main mark-done 1	Marca a tarefa como "done"

📁 Armazenamento
As tarefas são salvas automaticamente no arquivo tasks.txt no mesmo diretório do programa.
Cada linha representa uma tarefa no formato:

bash
Copy
Edit
id;descrição;status

📌 Status possíveis das tarefas
todo
in progress
done

📆 Datas
As tarefas exibem data e hora de criação e de última atualização no formato dd/MM/yyyy HH:mm.

📄 Exemplo de saída
bash
Copy
Edit
ID: 1 | Name: Estudar Java | Status: done | Last Updated: 19/05/2025 20:13 | Created: 19/05/2025 19:40
