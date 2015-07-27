package com.carma.swagger.doclet.apidocs;

import static com.carma.swagger.doclet.apidocs.FixtureLoader.loadFixture;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.carma.swagger.doclet.DocletOptions;
import com.carma.swagger.doclet.Recorder;
import com.carma.swagger.doclet.model.ApiDeclaration;
import com.carma.swagger.doclet.parser.JaxRsAnnotationParser;
import com.sun.javadoc.RootDoc;

@SuppressWarnings("javadoc")
public class MultipleParamsTest {

	private Recorder recorderMock;
	private DocletOptions options;

	@Before
	public void setup() {
		this.recorderMock = mock(Recorder.class);
		this.options = new DocletOptions().setRecorder(this.recorderMock).setIncludeSwaggerUi(false);
	}

	@Test
	public void testStart() throws IOException {
		this.options.setExcludeDeprecatedOperations(true);
		this.options.setExcludeDeprecatedParams(true);
		this.options.setExcludeDeprecatedFields(true);

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.multipleparams");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ApiDeclaration api = loadFixture("/fixtures/multipleparams/multipleparams.json", ApiDeclaration.class);
		verify(this.recorderMock).record(any(File.class), eq(api));
	}

	@Test
	public void testAdditionalHeaderParams() throws IOException {
		this.options.getAdditionalHeaderParams().add("x-whatever");
		this.options.getAdditionalHeaderParams().add("X-UI-APP=client/1.2.3");

		this.options.setExcludeDeprecatedOperations(true);
		this.options.setExcludeDeprecatedParams(true);
		this.options.setExcludeDeprecatedFields(true);

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.multipleparams");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ApiDeclaration api = loadFixture("/fixtures/multipleparams/addedmultipleparams.json", ApiDeclaration.class);
		verify(this.recorderMock).record(any(File.class), eq(api));
	}

}
