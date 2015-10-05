package com.carma.swagger.doclet.apidocs;

import static com.carma.swagger.doclet.apidocs.FixtureLoader.loadFixture;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.carma.swagger.doclet.DocletOptions;
import com.carma.swagger.doclet.Recorder;
import com.carma.swagger.doclet.model.ResourceListing;
import com.carma.swagger.doclet.parser.JaxRsAnnotationParser;
import com.sun.javadoc.RootDoc;

/**
 * The CarmaTest represents a test that runs against a copy of the carma api client.
 * It is intended only for carma developers so is ignored in the committed version.
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
public class CarmaTest {

	private Recorder recorderMock;
	private DocletOptions options;

	@Before
	public void setup() {
		this.recorderMock = mock(Recorder.class);
		this.options = new DocletOptions().setRecorder(this.recorderMock).setIncludeSwaggerUi(false);
		this.options.setSortResourcesByPath(false);
		this.options.setSortResourcesByPriority(true);
	}

	// this is only for carma developers
	// as it requires the carma api client to be copied into the local src/test/resources
	@Ignore
	@Test
	public void testStart() throws IOException {

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "com.avego.carma.api.client");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ResourceListing expectedListing = loadFixture("/fixtures/carma/service.json", ResourceListing.class);
		verify(this.recorderMock).record(any(File.class), eq(expectedListing));

	}
}
