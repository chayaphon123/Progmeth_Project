package ui.camera;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

public class PCamera extends Group {
    public Camera camera;
    public final Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
    public final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
    public final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

    public PCamera() {
        camera = new PerspectiveCamera(false);
        camera.setFarClip(6000);
        camera.setNearClip(0.01);
//        camera.setTranslateZ(-1000);
        camera.getTransforms().addAll(xRotate, yRotate, zRotate);
    }
}

