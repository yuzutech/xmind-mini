package org.xmind;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.jupiter.api.Test;
import org.xmind.core.ISheet;
import org.xmind.core.ITopic;
import org.xmind.core.internal.dom.SheetImpl;
import org.xmind.core.internal.dom.WorkbookImpl;
import org.xmind.core.io.ByteArrayStorage;
import org.xmind.core.util.DOMUtils;
import org.xmind.ui.internal.MindMapUIPlugin;
import org.xmind.ui.internal.editor.DefaultMindMapPreviewGenerator;
import org.xmind.ui.internal.editor.LocalFileWorkbookRefFactory;
import org.xmind.ui.internal.editor.PreLoadedWorkbookRef;
import org.xmind.ui.internal.editor.URLWorkbookRef;
import org.xmind.ui.internal.exports.vector.svg.SVGExporter;
import org.xmind.ui.internal.mindmap.MindMapViewer;
import org.xmind.ui.internal.wizards.WorkbookImporter;
import org.xmind.ui.mindmap.IWorkbookRef;
import org.xmind.ui.mindmap.IWorkbookRefFactory;
import org.xmind.ui.mindmap.MindMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SvgConverterTest {

  @Test
  public void test() throws InvocationTargetException, IOException, InterruptedException {
    Display display = Display.getDefault();
    DefaultMindMapPreviewGenerator defaultMindMapPreviewGenerator = new DefaultMindMapPreviewGenerator(display);


    /*
    ITopic topic = workbook.createTopic();
    topic.setTitleText("Kroki");
    DialogSettings settings = new DialogSettings("");
    List<ISheet> sheets = workbook.getSheets();
    for (ISheet sheet : sheets) {
      MindMapViewer mindMapViewer = new MindMapViewer();
      MindMap mindMap = new MindMap(sheet, topic);
      ITopic topic1 = workbook.createTopic();
      topic1.setTitleText("convert");
      mindMap.getCentralTopic().add(topic1);
      mindMapViewer.setMindMap(mindMap);


      sheet.setTitleText("Hello");
      ITopic rootTopic = sheet.getRootTopic();
      rootTopic.setTitleText("Kroki");
      ITopic topic2 = workbook.createTopic();
      topic2.setTitleText("Convert");
      rootTopic.add(topic2);


      SVGExporter svgExporter = new SVGExporter(sheet, topic, "test.svg", mindMapViewer, settings);
      svgExporter.init();
      svgExporter.start(display, new Shell());
      svgExporter.end();
    }
    */
    WorkbookImpl workbook = new WorkbookImpl(DOMUtils.createDocument(), new ByteArrayStorage());
    ITopic topic = workbook.createTopic();
    topic.setTitleText("Kroki");

    SheetImpl primarySheet = workbook.getPrimarySheet();
    primarySheet.setTitleText("Hello");
    ITopic rootTopic = primarySheet.getRootTopic();
    rootTopic.setTitleText("Kroki");
    ITopic topic1 = workbook.createTopic();
    topic1.setTitleText("Convert");
    topic1.setStyleId("%blue");
    rootTopic.add(topic1);

    ITopic topic2 = workbook.createTopic();
    topic2.setTitleText("Images");
    rootTopic.add(topic2);

    primarySheet.setStyleId("2");

    URI workbookURI = Paths.get("src/test/resources/travel-plan.xmt").toUri();
    URLWorkbookRef urlWorkbookRef = URLWorkbookRef.create(workbookURI, "");
    urlWorkbookRef.open(null);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    defaultMindMapPreviewGenerator.generateMindMapPreview(urlWorkbookRef,    urlWorkbookRef.getWorkbook().getPrimarySheet(), output, null);
    System.out.println(new String(output.toByteArray()));
    Files.write(Paths.get("result.png"), output.toByteArray());
  }
}
