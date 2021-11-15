package origami_editor.editor.canvas;

import javax.inject.Inject;
import javax.inject.Singleton;
import origami_editor.editor.MouseMode;

@Singleton
public class MouseHandlerLengthenCreaseSameColor extends MouseHandlerLengthenCrease {
    @Inject
    public MouseHandlerLengthenCreaseSameColor() {
    }

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.LENGTHEN_CREASE_SAME_COLOR_70;
    }
}
