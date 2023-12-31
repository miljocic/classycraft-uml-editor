package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.command.commands.MoveSelectedCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class MoveElementState implements State {

	private Point startPoint;
	private HashMap<Interclass, Point> map = new HashMap<>();
	private MoveSelectedCommand moveSelectedCommand;

	@Override
	public void mousePressed(MouseEvent e, DiagramView dV) {
		map.clear();
		startPoint = e.getPoint();
		for (ElementPainter ep : dV.getSelectedPainters()) {
			if (ep.getElement() instanceof Interclass) {
				Interclass interclass = (Interclass) ep.getElement();
				Point location = interclass.getLocation();
				map.put(interclass, new Point(location));
			}
		}
		moveSelectedCommand = new MoveSelectedCommand(dV.getDiagram(), map);
		dV.getDiagram().getCommandManager().addCommand(moveSelectedCommand);
	}

	@Override
	public void mouseReleased(MouseEvent e, DiagramView dV) {
		for (ElementPainter elementPainter : dV.getSelectedPainters()) {
			for (ElementPainter ep : dV.getElementPainters()) {
				if (ep instanceof InterclassPainter && elementPainter instanceof InterclassPainter
						&& !dV.getSelectedPainters().contains(ep) &&
						elementPainter.getShape() != null && ep.getShape() != null &&
						elementPainter.getShape().intersects(ep.getShape().getBounds())) {
					moveSelectedCommand.undoCommand();
					dV.getSelectedPainters().clear();
					dV.repaint();
					return;
				}
			}
		}
		dV.getSelectedPainters().clear();
		dV.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e, DiagramView dV) {
		HashMap<Interclass, Point> help = new HashMap<>();

		Point current = e.getPoint();
		for (ElementPainter elementPainter : dV.getSelectedPainters()) {
			if (elementPainter.getElement() != null && elementPainter.getElement() instanceof Interclass) {
				Interclass interclass = (Interclass) elementPainter.getElement();
				help.put(interclass, new Point((int)
						(map.get(interclass).getX() + (current.getX() - startPoint.getX()) / dV.getScalingFactor()),
						(int) (map.get(interclass).getY() + (current.getY() - startPoint.getY()) / dV.getScalingFactor())));
			}
		}
		for (Interclass i : help.keySet()) {
			moveSelectedCommand.setCurrentPoint(help);
			moveSelectedCommand.doCommand();
		}
		dV.repaint();
	}

}
