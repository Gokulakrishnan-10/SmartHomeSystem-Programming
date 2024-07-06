import java.util.ArrayList;
import java.util.List;

// Memento class to store the state of the text editor
class Memento {
    private final String textContent;

    public Memento(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }
}

// Originator class representing the text editor
class TextEditor {
    private String textContent;

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    // Save the current text content to a Memento
    public Memento save() {
        return new Memento(textContent);
    }

    // Restore the text content from a Memento
    public void restore(Memento memento) {
        textContent = memento.getTextContent();
    }
}

// Caretaker class managing the editor's mementos for undo functionality
class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    public void saveMemento(Memento memento) {
        history.add(memento);
    }

    public Memento getMemento(int index) {
        if (index >= 0 && index < history.size()) {
            return history.get(index);
        }
        return null;
    }
}


public class MementoPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        // Set initial text content
        editor.setTextContent("Hello, World!");
        caretaker.saveMemento(editor.save());

        // Modify text content
        editor.setTextContent("Hello, Memento Pattern!");
        caretaker.saveMemento(editor.save());

        // Output current text content
        System.out.println("Current Text Content: " + editor.getTextContent());

        // Perform undo operation
        Memento previousState = caretaker.getMemento(0);
        if (previousState != null) {
            editor.restore(previousState);
        }

        // Output text content after undo
        System.out.println("Text Content After Undo: " + editor.getTextContent());
    }
}

