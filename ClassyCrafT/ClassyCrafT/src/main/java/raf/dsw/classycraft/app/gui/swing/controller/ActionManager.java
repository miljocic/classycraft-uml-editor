package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.state.StateMouseManager;
import raf.dsw.classycraft.app.state.controller.*;

@Getter
@Setter

public class ActionManager {

    private ExitAction exitAction;
    private NewAction newAction;
    private AboutUsAction aboutUsAction;
    private DeleteAction deleteAction;
    private AuthorAction authorAction;
    private MyMouseListener myMouseListener;
    private AddStateAction addStateAction;
    private EditStateAction editStateAction;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private MoveElementStateAction moveElementStateAction;
    private SelectStateAction selectStateAction;

    private StateMouseManager stateMouseManager;
    private ConnectStateAction connectStateAction;

    private ZoomIn zoomInAction;
    private ZoomOut zoomOutAction;

    private UndoAction undoAction;
    private RedoAction redoAction;

    private OpenAction openAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private ExportAsImageAction exportAction;
    private ExportCodeAction exportCodeAction;

    private SaveTemplateAction saveTemplateAction;
    private LoadTemplateAction loadTemplateAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {

        exitAction = new ExitAction();
        newAction = new NewAction();
        aboutUsAction = new AboutUsAction();
        deleteAction = new DeleteAction();
        authorAction = new AuthorAction();
        myMouseListener = new MyMouseListener();

        addStateAction = new AddStateAction();
        editStateAction = new EditStateAction();
        deleteStateAction = new DeleteStateAction();
        moveStateAction = new MoveStateAction();
        moveElementStateAction = new MoveElementStateAction();
        selectStateAction = new SelectStateAction();
        stateMouseManager = new StateMouseManager();
        connectStateAction = new ConnectStateAction();

        zoomInAction = new ZoomIn();
        zoomOutAction = new ZoomOut();

        undoAction = new UndoAction();
        redoAction = new RedoAction();

        openAction = new OpenAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        exportAction = new ExportAsImageAction();
        exportCodeAction = new ExportCodeAction();

        saveTemplateAction = new SaveTemplateAction();
        loadTemplateAction = new LoadTemplateAction();


    }

}



