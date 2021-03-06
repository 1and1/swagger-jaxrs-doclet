package com.carma.swagger.doclet.apidocs;

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

import static com.carma.swagger.doclet.apidocs.FixtureLoader.loadFixture;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IssueDEVMMAIC1204Test {

    private Recorder recorderMock;
    private DocletOptions docletOptions;

    @Before
    public void setUp() {
        this.recorderMock = mock(Recorder.class);
        //this.recorderMock = new ObjectMapperRecorder(null, null, null, null);
        String[][] additionalParams = {
               // {"-d", "."}
        };
        this.docletOptions = DocletOptions.parse(additionalParams);
        this.docletOptions.setRecorder(this.recorderMock).setIncludeSwaggerUi(false);
    }

    @Test
    public void testStart() throws IOException {
        final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.issueDEVMMAIC1204");
        Assert.assertNotNull(rootDoc);
        boolean result = new JaxRsAnnotationParser(this.docletOptions, rootDoc).run();
        Assert.assertTrue(result);
        final ApiDeclaration apiDeclaration = loadFixture("/fixtures/issueDEVMMAIC1204/vegetables.json", ApiDeclaration.class);
        verify(this.recorderMock).record(any(File.class), eq(apiDeclaration));
    }
}
