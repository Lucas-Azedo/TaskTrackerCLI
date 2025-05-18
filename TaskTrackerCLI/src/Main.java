public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        String command = args[0];

        switch(command){
            case "add":
                manager.add(args[1]);
                break;

            case "update":
                manager.update(Integer.parseInt(args[1]), args[2]);
                break;

            case "delete":
                manager.delete(Integer.parseInt(args[1]));
                break;

            case "mark-in-progress":
                manager.markProgress(Integer.parseInt(args[1]));
                break;

            case "mark-done":
                manager.markDone(Integer.parseInt(args[1]));
                break;

            case "list":
                if(args[1].isEmpty()) {
                    manager.list();
                }
                else{
                    manager.listByStatus(args[1]);
                }
                break;


            default:
                System.out.println("Unknown Command");
        }


    }
}