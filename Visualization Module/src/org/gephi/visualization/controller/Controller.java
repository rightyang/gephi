/*
Copyright 2008-2010 Gephi
Authors : Antonio Patriarca <antoniopatriarca@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.gephi.visualization.controller;


import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import org.gephi.visualization.data.FrameData;
import org.gephi.visualization.model.DataManager;
import org.gephi.visualization.view.Viewer;

/**
 *
 * @author Antonio Patriarca <antoniopatriarca@gmail.com>
 */
public class Controller implements KeyListener, MouseListener {

    final private DataManager dataManager;
    final private Viewer viewer;

    public Controller(DataManager dataManager, Viewer viewer) {
        this.dataManager = dataManager;
        this.viewer = viewer;

        setAsController();
    }

    private void setAsController() {
        dataManager.setController(this);
        viewer.setController(this);
    }

    public void resize(int width, int height) {

    }

    public void beginUpdateFrame() {

    }

    public void endUpdateFrame(FrameData frameData) {

    }

    public void beginRenderFrame() {

    }

    public void endRenderFrame() {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent me) {

    }  
}
