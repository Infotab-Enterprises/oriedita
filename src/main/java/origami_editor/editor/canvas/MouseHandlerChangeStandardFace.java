package origami_editor.editor.canvas;

import origami.crease_pattern.element.Point;
import origami_editor.editor.App;
import origami_editor.editor.MouseMode;
import origami.folding.FoldedFigure;
import origami_editor.editor.drawing.FoldedFigure_Drawer;

public class MouseHandlerChangeStandardFace extends BaseMouseHandler {
    private final App app;
    private final CreasePattern_Worker d;

    public MouseHandlerChangeStandardFace(App app, CreasePattern_Worker d) {
        this.app = app;
        this.d = d;
    }

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.CHANGE_STANDARD_FACE_103;
    }

    @Override
    public void mouseMoved(Point p0) {

    }

    @Override
    public void mousePressed(Point p0) {

    }

    @Override
    public void mouseDragged(Point p0) {

    }

    @Override
    public void mouseReleased(Point p0) {

        FoldedFigure_Drawer selectedFigure = (FoldedFigure_Drawer) app.foldedFiguresList.getSelectedItem();

        if (selectedFigure != null) {
            Point p = new Point();
            p.set(d.camera.TV2object(p0));
            int oldStartingFaceId = selectedFigure.foldedFigure.cp_worker1.getStartingFaceId();

            int newStartingFaceId = selectedFigure.foldedFigure.cp_worker1.get().inside(p);

            if (newStartingFaceId <= 0) return;

            selectedFigure.foldedFigure.cp_worker1.setStartingFaceId(newStartingFaceId);

            System.out.println("kijyunmen_id = " + newStartingFaceId);
            if (selectedFigure.foldedFigure.ct_worker.face_rating != null) {//20180227追加
                System.out.println(
                        "OZ.js.nbox.get_jyunjyo = " + selectedFigure.foldedFigure.ct_worker.nbox.getSequence(newStartingFaceId) + " , rating = " +
                                selectedFigure.foldedFigure.ct_worker.nbox.getWeight(selectedFigure.foldedFigure.ct_worker.nbox.getSequence(newStartingFaceId))

                );

            }
            if ((newStartingFaceId != oldStartingFaceId) && (selectedFigure.foldedFigure.estimationStep != FoldedFigure.EstimationStep.STEP_0)) {
                selectedFigure.foldedFigure.estimationStep = FoldedFigure.EstimationStep.STEP_1;
            }
        }
    }
}
