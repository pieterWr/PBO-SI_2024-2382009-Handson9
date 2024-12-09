package services;

import entities.TodoList;
import repositories.TodoListRepository;
import repository.TodoListRepositoryImpl;

public class TodoListServiceImpl implements TodoListService{
    private final TodoListRepositoryImpl todoListRepository;

    public TodoListServiceImpl(final TodoListRepositoryImpl todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList[] getTodoList() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        if (todo.isEmpty() || todo.isBlank()){
            System.out.println("Masukkan todo dengan benar");
            return;
        }
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public Boolean removeTodoList(Integer number) {
        return todoListRepository.remove(number);
    }

    @Override
    public Boolean editTodoList(Integer number, String todo) {
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoList.setId(number);
        return todoListRepository.edit(todoList);
    }
}