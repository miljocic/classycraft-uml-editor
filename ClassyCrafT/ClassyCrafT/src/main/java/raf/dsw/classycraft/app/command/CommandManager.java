package raf.dsw.classycraft.app.command;


import raf.dsw.classycraft.app.core.ApplicationFramework;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<>();
    private int pointer = 0;

    public void addCommand(AbstractCommand command) {
        while (pointer < commands.size()) {
            commands.remove(pointer);
        }
        commands.add(command);
        doCommand();

    }

    public void doCommand() {
        if (pointer < commands.size()) {
            commands.get(pointer++).doCommand();
            ApplicationFramework.getInstance().getGui().enableUndo();
        }
        if (pointer == commands.size()) {
            ApplicationFramework.getInstance().getGui().disableRedo();

        }
    }

    public void undoCommand() {
        if (pointer > 0) {
            ApplicationFramework.getInstance().getGui().enableRedo();
            commands.get(--pointer).undoCommand();
        }
        if (pointer == 0) {
            ApplicationFramework.getInstance().getGui().disableUndo();
        }
    }

}
