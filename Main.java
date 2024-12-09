import config.Database;
import repositories.TodoListRepositoryDbImpl;
import repositories.TodoListRepository;
import repository.TodoListRepositoryImpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView; // Fixed typo


public class Main {
    public static <TodoListRepository> void main(String[] args) {
        Database database = new Database("dbPieter", "root", "", "Localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);


        TodoListService todoListService = new TodoListServiceImpl((TodoListRepositoryImpl) todoListRepository);


        TodoListView todoListView = (TodoListView) new TodoListTerminalView(todoListService);

        todoListView.run();
    }
}