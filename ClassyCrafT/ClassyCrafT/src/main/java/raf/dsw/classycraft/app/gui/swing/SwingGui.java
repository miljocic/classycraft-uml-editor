package raf.dsw.classycraft.app.gui.swing;

import raf.dsw.classycraft.app.command.CommandManager;
import raf.dsw.classycraft.app.core.Gui;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.MessageOptionPane;
import raf.dsw.classycraft.app.logg.messages.Message;

public class SwingGui implements Gui {
    private MainFrame mainFrame;
    private CommandManager commandManager;

    public SwingGui() {
    }

    @Override
    public void start() {
        MainFrame mainFrame = MainFrame.getInstance();
        commandManager = new CommandManager();

        disableRedo();
        disableUndo();

        mainFrame.setVisible(true);
    }

    @Override
    public void enableUndo() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);

    }

    @Override
    public void disableUndo() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);

    }

    @Override
    public void enableRedo() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);

    }

    @Override
    public void disableRedo() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);

    }

    @Override
    public void update(Object notification) {
        if (notification instanceof Message) {
            MessageOptionPane messageOptionPane = new MessageOptionPane(mainFrame, (Message) notification);
            messageOptionPane.setVisible(true);
        }
    }
}
