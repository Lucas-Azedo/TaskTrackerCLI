public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        String command = args[0];

        switch(command){
            case "add":
                manager.add(args[1]);
                break;


            default:
                System.out.println("Unknown Command");
        }


    }
}