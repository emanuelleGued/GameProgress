package org.example.gameprogress.caretaker;

import org.example.gameprogress.model.GameMemento;

import java.util.Stack;

public class GameCaretaker {
    private Stack<GameMemento> history = new Stack<>();

    public void save(GameMemento memento) {
        history.push(memento);
    }

    public GameMemento restore() {
        return history.isEmpty() ? null : history.pop();
    }
}
