package ui.camera;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

public class PCamera extends PerspectiveCamera {
    public final Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
    public final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
    public final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

    public PCamera() {
        PerspectiveCamera _camera = new PerspectiveCamera(false);
        _camera.isFixedEyeAtCameraZero();
        _camera.setFarClip(6000);
        _camera.setNearClip(0.01);
        _camera.getTransforms().addAll(xRotate, yRotate, zRotate);
    }
}

