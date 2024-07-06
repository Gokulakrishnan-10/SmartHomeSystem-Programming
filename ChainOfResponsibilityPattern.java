interface SupportHandler {
    void setNextHandler(SupportHandler handler);
    void handleRequest(Request request);
}

class Request {
    private int level;
    private int number; // Request number field

    public Request(int level, int number) {
        this.level = level;
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public int getNumber() {
        return number;
    }
}

class Level1Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == 1) {
            System.out.println("Level 1 Support handling request " + request.getNumber() + ".");
        } else if (nextHandler != null) {
            System.out.println("Skipping request " + request.getNumber() + " at Level 1 Support.");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available to handle the request.");
        }
    }
}

class Level2Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == 2) {
            System.out.println("Level 2 Support handling request " + request.getNumber() + ".");
        } else if (nextHandler != null) {
            System.out.println("Skipping request " + request.getNumber() + " at Level 2 Support.");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available to handle the request.");
        }
    }
}

class Level3Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getLevel() == 3) {
            System.out.println("Level 3 Support handling request " + request.getNumber() + ".");
        } else if (nextHandler != null) {
            System.out.println("Passing request " + request.getNumber() + " to Level 1 Support.");
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available to handle the request.");
        }
    }
}

public class ChainOfResponsibilityPattern{
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        level3.setNextHandler(level1); // Added to complete the circular chain

        Request request1 = new Request(1, 1);
        Request request2 = new Request(2, 2);
        Request request3 = new Request(3, 3);
        

        level1.handleRequest(request1);
        level1.handleRequest(request2);
        level1.handleRequest(request3);
      
    }
}
