package fixtures.jsonview;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fixtures.jsonview.Person.DetailedPersonView;
import fixtures.jsonview.Person.DetailedPersonView2;
import fixtures.jsonview.Person.DetailedPersonView3;
import fixtures.jsonview.Person.SimplePersonView;
import fixtures.jsonview.Person.SimplePersonView2;

/**
 * The PersonResource represents a variant of the jackson jsonview example from http://jira.codehaus.org/browse/JACKSON-578
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
@Path("/person/")
@Produces({ MediaType.APPLICATION_JSON })
public class PersonResource {

	@GET
	@com.fasterxml.jackson.annotation.JsonView(SimplePersonView.class)
	public Collection<Person> getAll() {
		Person person = new Person();
		person.setName("conor");
		person.setAddress("conor-address");
		person.setAge(35);
		Collection<Person> res = new ArrayList<Person>();
		res.add(person);
		return res;
	}

	/**
	 * @responseType java.util.Collection<fixtures.jsonview.Person>
	 */
	@Path("/getAll2")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(SimplePersonView.class)
	public Response getAll2() {
		Person person = new Person();
		person.setName("conor");
		person.setAddress("conor-address");
		person.setAge(35);
		Collection<Person> res = new ArrayList<Person>();
		res.add(person);
		return Response.ok(res).build();
	}

	@Path("/{name}")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(DetailedPersonView.class)
	public Person getPerson(@PathParam(value = "name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(name + "-address");
		person.setAge(35);
		return person;
	}

	@Path("/{name}/2")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(SimplePersonView2.class)
	public Person getPerson2(@PathParam(value = "name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(name + "-address");
		person.setAge(35);
		return person;
	}

	@Path("/{name}/3")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(DetailedPersonView2.class)
	public Person getPerson3(@PathParam(value = "name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(name + "-address");
		person.setAge(35);
		return person;
	}

	@Path("/{name}/4")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(DetailedPersonView3.class)
	public Person getPerson4(@PathParam(value = "name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(name + "-address");
		person.setAge(35);
		return person;
	}

	/**
	 * @responseType fixtures.jsonview.Person
	 */
	@Path("/{name}/5")
	@GET
	@com.fasterxml.jackson.annotation.JsonView(DetailedPersonView3.class)
	public Response getPerson5(@PathParam(value = "name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(name + "-address");
		person.setAge(35);
		return Response.ok(person).build();
	}

	@POST
	public void createPerson(@com.fasterxml.jackson.annotation.JsonView(SimplePersonView.class) Person person) {
		// noop
	}

}
