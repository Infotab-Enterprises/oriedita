package oriedita.editor.export;

import fold.io.CreasePatternReader;
import fold.io.CreasePatternWriter;
import fold.model.Edge;
import fold.model.FoldEdgeAssignment;
import fold.model.FoldFile;
import org.tinylog.Logger;
import oriedita.editor.save.OrieditaFoldFile;
import oriedita.editor.save.Save;
import oriedita.editor.save.SaveProvider;
import origami.crease_pattern.LineSegmentSet;
import origami.crease_pattern.element.LineColor;
import origami.crease_pattern.element.LineSegment;
import origami.crease_pattern.element.Point;

import java.io.*;
import java.util.StringTokenizer;

public class Cp {

    public static void exportFile(Save save, File file) {

        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw); OutputStream os = new FileOutputStream(file)) {
            CreasePatternWriter creasePatternWriter = new CreasePatternWriter(os);
            creasePatternWriter.write(new Fold().toFoldSave(save, new LineSegmentSet()));
        } catch (IOException | InterruptedException e) {
            Logger.error(e, "Error exporting cp file");
        }
    }

    public static Save importFile(InputStream is) throws IOException {
        Save save = SaveProvider.createInstance();

        CreasePatternReader creasePatternReader = new CreasePatternReader(is);

        FoldFile foldFile = creasePatternReader.read();

        for (Edge edge : foldFile.getRootFrame().getEdges()) {
            save.addLineSegment(new LineSegment(new Point(edge.getStart().getX(), edge.getStart().getY()), new Point(edge.getEnd().getX(), edge.getEnd().getY()), Fold.getColor(edge.getAssignment())));
        }

        return save;
    }

    public static Save importFile(File mem) throws IOException {
        try (FileInputStream is = new FileInputStream(mem)) {
            return importFile(is);
        }
    }
}
