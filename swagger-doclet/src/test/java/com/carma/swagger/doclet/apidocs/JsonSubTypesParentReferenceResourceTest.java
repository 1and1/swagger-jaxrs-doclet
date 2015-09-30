package com.carma.swagger.doclet.apidocs;

import static com.carma.swagger.doclet.apidocs.FixtureLoader.loadFixture;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.carma.swagger.doclet.DocletOptions;
import com.carma.swagger.doclet.ObjectMapperRecorder;
import com.carma.swagger.doclet.Recorder;
import com.carma.swagger.doclet.model.ApiDeclaration;
import com.carma.swagger.doclet.parser.JaxRsAnnotationParser;
import com.sun.javadoc.RootDoc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsonSubTypesParentReferenceResourceTest {

    private Recorder recorderMock;
    private DocletOptions options;

    @Before
    public void setup() {
        this.recorderMock = mock(Recorder.class);
        //this.recorderMock = new ObjectMapperRecorder(null, null, null, null);
        String[][] additionalParams = new String[][]{
                //{"-d", "."}
        };
        this.options = DocletOptions.parse(additionalParams);
        this.options = options.setRecorder(this.recorderMock).setIncludeSwaggerUi(false);
    }

    @Test
    public void testStart() throws IOException {
        final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.jsonsubtypesparentreference");
        Assert.assertNotNull(rootDoc);
        boolean result = new JaxRsAnnotationParser(this.options, rootDoc).run();
        Assert.assertTrue(result);
        final ApiDeclaration api = loadFixture("/fixtures/jsonsubtypesparentreference/node.json", ApiDeclaration.class);
        verify(this.recorderMock).record(any(File.class), eq(api));
    }
}
