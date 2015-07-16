package com.carma.swagger.doclet.apidocs;

import static com.carma.swagger.doclet.apidocs.FixtureLoader.loadFixture;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.carma.swagger.doclet.DocletOptions;
import com.carma.swagger.doclet.Recorder;
import com.carma.swagger.doclet.model.ApiDeclaration;
import com.carma.swagger.doclet.model.ResourceListing;
import com.carma.swagger.doclet.parser.JaxRsAnnotationParser;
import com.sun.javadoc.RootDoc;

/**
 * The CrossClassResourceListingTest represents a test of ordering and descriptions for cross class
 * resources
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
public class CrossClassResourceListingTest {

	private Recorder recorderMock;
	private DocletOptions options;

	@Before
	public void setup() {
		this.recorderMock = mock(Recorder.class);
		this.options = new DocletOptions().setRecorder(this.recorderMock).setIncludeSwaggerUi(false);

	}

	@Test
	public void testDefaultOrder() throws IOException {

		this.options.getResourceDescriptionTags().clear();
		this.options.getResourcePriorityTags().clear();
		this.options.setSortResourcesByPath(false);
		this.options.setSortResourcesByPriority(false);

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.crossclassresourcelisting");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ResourceListing expectedListing = loadFixture("/fixtures/crossclassresourcelisting/service.json", ResourceListing.class);
		verify(this.recorderMock).record(any(File.class), eq(expectedListing));

		ArgumentCaptor<ApiDeclaration> apis = ArgumentCaptor.forClass(ApiDeclaration.class);
		verify(this.recorderMock, times(3)).record(any(File.class), apis.capture());

		final ApiDeclaration api1 = loadFixture("/fixtures/crossclassresourcelisting/a.json", ApiDeclaration.class);
		final ApiDeclaration api2 = loadFixture("/fixtures/crossclassresourcelisting/b.json", ApiDeclaration.class);
		final ApiDeclaration api3 = loadFixture("/fixtures/crossclassresourcelisting/c.json", ApiDeclaration.class);

		List<ApiDeclaration> capturedApis = apis.getAllValues();
		assertEquals(api1, capturedApis.get(0));
		assertEquals(api2, capturedApis.get(1));
		assertEquals(api3, capturedApis.get(2));

	}

	@Test
	public void testPriorityOrder() throws IOException {

		this.options.getResourceDescriptionTags().add("resourceDescription");
		this.options.getResourcePriorityTags().add("resourcePriority");
		this.options.getResourcePriorityTags().add("priority");
		this.options.setSortResourcesByPath(false);
		this.options.setSortResourcesByPriority(true);

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.crossclassresourcelisting");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ResourceListing expectedListing = loadFixture("/fixtures/crossclassresourcelisting/service2.json", ResourceListing.class);
		verify(this.recorderMock).record(any(File.class), eq(expectedListing));

	}

	@Test
	public void testPathOrder() throws IOException {

		this.options.getResourceDescriptionTags().add("resourceDescription");
		this.options.getResourcePriorityTags().add("resourcePriority");
		this.options.setSortResourcesByPath(true);
		this.options.setSortResourcesByPriority(false);

		final RootDoc rootDoc = RootDocLoader.fromPath("src/test/resources", "fixtures.crossclassresourcelisting");
		new JaxRsAnnotationParser(this.options, rootDoc).run();

		final ResourceListing expectedListing = loadFixture("/fixtures/crossclassresourcelisting/service3.json", ResourceListing.class);
		verify(this.recorderMock).record(any(File.class), eq(expectedListing));

	}

}
