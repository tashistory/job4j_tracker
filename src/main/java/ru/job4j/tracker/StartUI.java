package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.sql.SQLException;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

   /* public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(output),
                new DeleteAction(output), new EditAction(output), new ShowAction(output),
                new FindActionById(output), new FindActionByName(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    } */
   public static void main(String[] args) {
       Output output = new ConsoleOutput();
       Input input = new ValidateInput(
               output, new ConsoleInput()
       );
       try (Store tracker = new MemTracker()) {
           List<UserAction> actions = List.of(
                   new CreateAction(output),
                   new EditAction(output),
                   new DeleteAction(output),
                   new ShowAction(output),
                   new FindActionById(output),
                   new FindActionByName(output),
                   new ExitAction(),
                   new CreateManyItems(output),
                   new DeleteAllItems(output)

           );
           new StartUI(output).init(input, tracker, actions);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
