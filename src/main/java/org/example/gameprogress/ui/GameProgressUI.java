package org.example.gameprogress.ui;

import org.example.gameprogress.caretaker.GameCaretaker;
import org.example.gameprogress.model.GameMemento;
import org.example.gameprogress.model.GameProgress;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProgressUI {
    private GameProgress gameProgress;
    private GameCaretaker caretaker = new GameCaretaker();
    private JTextArea displayArea;
    private JTextField worldField, levelField, energyField, skillsField;

    public GameProgressUI() {
        gameProgress = new GameProgress("Terra", 1, 100, Arrays.asList("Chute", "Soco"));

        JFrame frame = new JFrame("Game Progress");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        inputPanel.add(new JLabel("Mundo:"));
        worldField = new JTextField(gameProgress.getWorld());
        inputPanel.add(worldField);

        inputPanel.add(new JLabel("Nível:"));
        levelField = new JTextField(String.valueOf(gameProgress.getLevel()));
        inputPanel.add(levelField);

        inputPanel.add(new JLabel("Energia:"));
        energyField = new JTextField(String.valueOf(gameProgress.getEnergy()));
        inputPanel.add(energyField);

        inputPanel.add(new JLabel("Habilidades (separadas por vírgula):"));
        skillsField = new JTextField(String.join(", ", gameProgress.getSkills()));
        inputPanel.add(skillsField);

        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Salvar");
        JButton restoreButton = new JButton("Restaurar");

        saveButton.addActionListener(e -> saveProgress());
        restoreButton.addActionListener(e -> restoreProgress());

        buttonPanel.add(saveButton);
        buttonPanel.add(restoreButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        updateDisplay("Jogo iniciado!");
        frame.setVisible(true);
    }

    private void saveProgress() {
        try {
            String world = worldField.getText();
            int level = Integer.parseInt(levelField.getText());
            int energy = Integer.parseInt(energyField.getText());
            List<String> skills = new ArrayList<>(Arrays.asList(skillsField.getText().split(",")));

            gameProgress = new GameProgress(world, level, energy, skills);
            caretaker.save(gameProgress.save());
            updateDisplay("Progresso salvo!");
        } catch (NumberFormatException e) {
            updateDisplay("Erro: Verifique os valores inseridos!");
        }
    }

    private void restoreProgress() {
        GameMemento restored = caretaker.restore();
        if (restored != null) {
            gameProgress.restore(restored);
            worldField.setText(gameProgress.getWorld());
            levelField.setText(String.valueOf(gameProgress.getLevel()));
            energyField.setText(String.valueOf(gameProgress.getEnergy()));
            skillsField.setText(String.join(", ", gameProgress.getSkills()));
            updateDisplay("Progresso restaurado!");
        } else {
            updateDisplay("Nenhum progresso salvo!");
        }
    }

    private void updateDisplay(String message) {
        displayArea.setText(message + "\n" + gameProgress);
    }
}
