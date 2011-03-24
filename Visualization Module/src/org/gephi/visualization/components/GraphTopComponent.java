/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.visualization.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.logging.Logger;
import org.gephi.visualization.controller.Controller;
import org.gephi.visualization.model.DataManager;
import org.gephi.visualization.view.Viewer;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.gephi.visualization.components//Graph//EN",
autostore = false)
public final class GraphTopComponent extends TopComponent {

    private static GraphTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "GraphTopComponent";

    private final Viewer viewer;
    private final DataManager dataManager;
    private final Controller controller;

    public GraphTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(GraphTopComponent.class, "CTL_GraphTopComponent"));
        setToolTipText(NbBundle.getMessage(GraphTopComponent.class, "HINT_GraphTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

        this.dataManager = new DataManager(33);
        this.viewer = new Viewer();
        this.controller = new Controller(this.dataManager, this.viewer);
        
        final Component canvas = viewer.getCanvas();

        WindowManager.getDefault().invokeWhenUIReady(new Runnable() {

            @Override
            public void run() {
                open();
                requestActive();
                add(canvas, BorderLayout.CENTER);
                canvas.setVisible(true);
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Component comp = evt.getComponent();
        this.viewer.updateSize(comp.getX(), comp.getY(), comp.getWidth(), comp.getHeight());
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized GraphTopComponent getDefault() {
        if (instance == null) {
            instance = new GraphTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the GraphTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized GraphTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(GraphTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof GraphTopComponent) {
            return (GraphTopComponent) win;
        }
        Logger.getLogger(GraphTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    protected void componentShowing() {
        super.componentShowing();
        this.validateTree();

        this.dataManager.start();
        this.viewer.start();
    }

    @Override
    protected void componentHidden() {
        super.componentHidden();

        this.dataManager.stop();
        this.viewer.stop();
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        this.dataManager.stop();
        this.viewer.stop();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
}
