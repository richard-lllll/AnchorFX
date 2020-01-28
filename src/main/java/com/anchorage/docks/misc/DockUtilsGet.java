package com.anchorage.docks.misc;

import java.util.ArrayList;
import java.util.List;

import com.anchorage.docks.containers.subcontainers.DockSplitterContainer;
import com.anchorage.docks.containers.subcontainers.DockTabberContainer;
import com.anchorage.docks.node.DockNode;
import com.anchorage.docks.stations.DockStation;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 * Util class to retrieve the content of stations/containers
 * 
 * @author richard-lllll
 */
public class DockUtilsGet {

	/**
	 * Find the dock container in the station
	 */
	public static DockTabberContainer getSubcontainerTabber(DockStation station) {
		ObservableList<Node> children = station.getChildren();

		for (Node node : children) {
			if (node instanceof DockTabberContainer) {
				DockTabberContainer dockContainer = (DockTabberContainer) node;

				return dockContainer;
			}
		}

		return null;
	}

	/**
	 * Find a splitter in the station
	 */
	public static DockSplitterContainer getSubcontainerSplitter(DockStation station) {
		ObservableList<Node> children = station.getChildren();

		for (Node node : children) {
			if (node instanceof DockSplitterContainer) {
				DockSplitterContainer splitter = (DockSplitterContainer) node;
				return splitter;
			}
		}

		return null;
	}

	/**
	 * Get all dock nodes in tabber
	 */
	public static List<DockNode> getTabContents(DockTabberContainer dockContainer) {
		List<DockNode> dockNodes = new ArrayList<DockNode>();

		ObservableList<Tab> tabs = dockContainer.getTabs();

		for (Tab tab : tabs) {
			dockNodes.add((DockNode) tab.getContent());
		}

		return dockNodes;
	}
}
